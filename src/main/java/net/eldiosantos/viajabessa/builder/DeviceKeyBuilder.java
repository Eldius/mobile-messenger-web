package net.eldiosantos.viajabessa.builder;

import net.eldiosantos.viajabessa.hashtools.HashProvider;
import net.eldiosantos.viajabessa.model.auth.UserInfo;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 06/03/2015.
 */
public class DeviceKeyBuilder {

    @Inject
    private HashProvider hashProvider;

    public String build(final UserInfo user) {
        final String string = new StringBuffer()
                .append(user.getEmail())
                .append(user.getLogin())
                .append(user.getRegistrationId())
                .toString();

        return hashProvider.hash(string);
    }
}
