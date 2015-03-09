package net.eldiosantos.messenger.builder;

import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;

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

        final byte[] hash = hashProvider.binaryHash(string);
        final StringBuffer result = new StringBuffer();

        for (int i=0;i<hash.length;i++) {
            result.append(Integer.toHexString(0xFF & hash[i]));
        }

        return result.toString();
    }
}
