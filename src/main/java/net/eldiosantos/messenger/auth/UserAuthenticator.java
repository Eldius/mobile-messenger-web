package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;

/**
 * Created by Eldius on 03/03/2015.
 */
public class UserAuthenticator {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private UserSession userSession;

    @Inject
    private HashProvider hashProvider;

    public UserInfo validate(final String login, final String password) {

        final UserInfo userInfo = userInfoRepository.validateLogin(login, hashProvider.hash(password));

        /*
        final UserInfo userInfo = builder
                .login(login)
                .password(password)
                .build();
        */

        userSession.setUser(userInfo);

        return userInfo;
    }

    public void invalidate() {
        userSession.logout();
    }
}
