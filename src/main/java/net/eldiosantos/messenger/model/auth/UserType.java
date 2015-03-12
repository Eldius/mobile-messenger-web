package net.eldiosantos.messenger.model.auth;

/**
 * Created by Eldius on 06/03/2015.
 */
public enum UserType {
    ADMIN(0)
    , USER(100);

    private final int accessLevel;

    UserType(final int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
}
