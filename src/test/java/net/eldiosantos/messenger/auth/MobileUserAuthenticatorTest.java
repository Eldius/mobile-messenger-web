package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.builder.DeviceKeyBuilder;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import org.jboss.weld.bean.builtin.ee.UserTransactionBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MobileUserAuthenticatorTest {

    @Mock
    private UserAuthenticator userAuthenticator;

    @Mock
    private DeviceKeyBuilder deviceKeyBuilder;

    @Mock
    private UserInfoRepository userInfoRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidate() throws Exception {

        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("user")
                .password("pass")
                .build()
                .setEmail("user@wintermute.com");

        Mockito.when(userAuthenticator.validate("user", "pass")).thenReturn(user);
        Mockito.when(deviceKeyBuilder.build(user)).thenReturn("there and back again");

        final MobileUserAuthenticator mobileUserAuthenticator = new MobileUserAuthenticator(userAuthenticator, deviceKeyBuilder, userInfoRepository);

        final String key = mobileUserAuthenticator.validate("user", "pass");

        assertNotNull("Validating it returned a non null key", key);
        assertEquals("Validating user key was changed", "there and back again", user.getMobileDeviceKey());
    }

    @Test
    public void testInvalidate() throws Exception {
        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("user")
                .password("pass")
                .build()
                .setMobileDeviceKey("there and back again")
                .setEmail("user@wintermute.com");

        Mockito.when(userInfoRepository.validateToken("there and back again")).thenReturn(user);

        final MobileUserAuthenticator mobileUserAuthenticator = new MobileUserAuthenticator(userAuthenticator, deviceKeyBuilder, userInfoRepository);

        mobileUserAuthenticator.invalidate("there and back again");

        assertNull("Validating user object don't have a mobile key anymore", user.getMobileDeviceKey());
    }
}
