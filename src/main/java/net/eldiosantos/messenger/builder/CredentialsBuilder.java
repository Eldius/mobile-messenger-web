package net.eldiosantos.messenger.builder;

import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.hashtools.HashProvider;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 24/02/2015.
 */
public class CredentialsBuilder {

    @Inject
    private HashProvider provider;

    private UserInfo user;

    public CredentialsBuilder() {
        user = new UserInfo();
    }

    public CredentialsBuilder start() {
        user = new UserInfo();
        return this;
    }

    public CredentialsBuilder login(String login) {
        user.setLogin(login);
        return this;
    }

    public CredentialsBuilder password(String password) {
        user.setPassword(provider.hash(password));
        return this;
    }

    public UserInfo build() {
        final UserInfo tmpUser = user;
        return tmpUser;
    }
}
