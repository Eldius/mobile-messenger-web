package net.eldiosantos.messenger.controller;

import br.com.caelum.brutauth.auth.annotations.CustomBrutauthRules;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.model.auth.UserType;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.rule.AdminUserRule;
import net.eldiosantos.messenger.rule.EditUserRule;
import net.eldiosantos.messenger.rule.OpenRegistrationRule;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@Controller
@Path("/user")
public class UserController {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private CredentialsBuilder credentialsBuilder;

    @Inject
    private HashProvider hashProvider;

    @Inject
    private Result result;

    @Path("/")
    @SimpleBrutauthRules({AdminUserRule.class})
    public List<UserInfo>index() {
        return userInfoRepository.listAll();
    }

    @Get("/form/{user.id}")
    @CustomBrutauthRules({EditUserRule.class})
    public UserInfo form(final UserInfo user) {
        return userInfoRepository.getByPk(user.getId());
    }

    @Get("/form")
    @SimpleBrutauthRules({OpenRegistrationRule.class})
    public void form() {

    }

    @CustomBrutauthRules({EditUserRule.class})
    public void save(final UserInfo user) {
        if(user.getId() == null) {
            final UserInfo newUser = credentialsBuilder.start()
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .build()
                    .setEmail(user.getEmail())
                    .setUserType(UserType.USER);
            userInfoRepository.persist(newUser);
            result.redirectTo(this).form();
        } else {
            user.setPassword(hashProvider.hash(user.getPassword()));
            userInfoRepository.persist(user);
            result.redirectTo(this).form(user);
        }
    }

    @Post("/admin")
    @SimpleBrutauthRules({AdminUserRule.class})
    public void setAsAdmin(final Long userId, final Boolean isAdmin) {
        final UserInfo user = userInfoRepository.getByPk(userId);
        user.setUserType(isAdmin?UserType.ADMIN:UserType.USER);
        userInfoRepository.update(user);

        result.use(Results.json()).from("ok").serialize();
    }
}
