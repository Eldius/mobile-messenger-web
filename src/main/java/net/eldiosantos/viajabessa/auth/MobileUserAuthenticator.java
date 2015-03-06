package net.eldiosantos.viajabessa.auth;

import net.eldiosantos.viajabessa.builder.DeviceKeyBuilder;
import net.eldiosantos.viajabessa.builder.UserBuilder;
import net.eldiosantos.viajabessa.hashtools.HashProvider;
import net.eldiosantos.viajabessa.model.auth.UserInfo;
import net.eldiosantos.viajabessa.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by Eldius on 03/03/2015.
 */
public class MobileUserAuthenticator {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private UserAuthenticator userAuthenticator;

    @Inject
    private DeviceKeyBuilder deviceKeyBuilder;

    @Inject
    private UserInfoRepository userInfoRepository;

    public String validate(final String login, final String password) {
        UserInfo loggedUser = userAuthenticator.validate(login, password);
        String deviceKey = deviceKeyBuilder.build(loggedUser);
        loggedUser.setMobileDeviceKey(deviceKey);
        userInfoRepository.update(loggedUser);
        return deviceKey;
    }

    public void invalidate() {
        userAuthenticator.invalidate();
    }
}
