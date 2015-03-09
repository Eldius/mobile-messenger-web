package net.eldiosantos.messenger.controller;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.*;
import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.model.auth.UserType;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import net.eldiosantos.messenger.rule.LoggedUserRule;
import net.eldiosantos.messenger.rule.OpenregistrationRule;

import javax.inject.Inject;

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

    @Get("/form/{userId}")
    public UserInfo form(final Long userId) {
        return userInfoRepository.getByPk(userId);
    }

    @Get("/form")
    @SimpleBrutauthRules({OpenregistrationRule.class})
    public void form() {

    }

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
            result.redirectTo(this).form(user.getId());
        }
    }
}
