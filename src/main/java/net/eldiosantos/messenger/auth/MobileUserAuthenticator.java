package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.builder.DeviceKeyBuilder;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;

/**
 * Created by Eldius on 03/03/2015.
 */
public class MobileUserAuthenticator {

    @Inject
    private UserAuthenticator userAuthenticator;

    @Inject
    private DeviceKeyBuilder deviceKeyBuilder;

    @Inject
    private UserInfoRepository userInfoRepository;

    @Deprecated
    public MobileUserAuthenticator() {
    }

    public MobileUserAuthenticator(UserAuthenticator userAuthenticator, DeviceKeyBuilder deviceKeyBuilder, UserInfoRepository userInfoRepository) {
        this.userAuthenticator = userAuthenticator;
        this.deviceKeyBuilder = deviceKeyBuilder;
        this.userInfoRepository = userInfoRepository;
    }

    public String validate(final String login, final String password) {
        UserInfo loggedUser = userAuthenticator.validate(login, password);
        String deviceKey = deviceKeyBuilder.build(loggedUser);
        loggedUser.setMobileDeviceKey(deviceKey);
        userInfoRepository.update(loggedUser);
        return deviceKey;
    }

    public void invalidate(final String token) {
        UserInfo loggedUser = userInfoRepository.validateToken(token);
        loggedUser.setMobileDeviceKey(null);
        userInfoRepository.update(loggedUser);
    }
}
