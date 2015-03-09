package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.model.auth.UserInfo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@SessionScoped
@Named("userSession")
public class UserSession implements Serializable {
    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(final UserInfo user) {
        this.user = user;
    }

    public Boolean isLogged() {
        return this.user != null;
    }

    public void logout() {
        this.user = null;
    }

    public Long getUserId() {
        return user!=null?user.getId():null;
    }

    public String getLogin() {
        return user!=null?user.getLogin():null;
    }
}
