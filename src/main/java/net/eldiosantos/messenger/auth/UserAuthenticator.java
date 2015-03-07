package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.builder.UserBuilder;
import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by Eldius on 03/03/2015.
 */
public class UserAuthenticator {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private UserSession userSession;

    @Inject
    private HashProvider hashProvider;

    @Inject
    private UserBuilder builder;

    public UserInfo validate(final String login, final String password) {

        final UserInfo userInfo = userInfoRepository.validateLogin(login, hashProvider.hash(password));

        /*
        final UserInfo userInfo = builder
                .setLogin(login)
                .setPassword(password)
                .build();
        */

        userSession.setUser(userInfo);

        return userInfo;
    }

    public void invalidate() {
        userSession.logout();
    }
}
