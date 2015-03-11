package net.eldiosantos.messenger.builder;

import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceKeyBuilderTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBuild() throws Exception {

        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("user")
                .password("pass")
                .build()
                .setEmail("user@mailinator.com")
                .setId(171L);

        final String firstKey = new DeviceKeyBuilder(new SHAHashProvider()).build(user);
        final String secundKey = new DeviceKeyBuilder(new SHAHashProvider()).build(user);

        assertEquals("Validating that the same data produces same key", firstKey, secundKey);
    }

    @Test(expected = NullPointerException.class)
    public void testBuildWithNullData() throws Exception {
        new DeviceKeyBuilder(new SHAHashProvider()).build(null);
    }
}