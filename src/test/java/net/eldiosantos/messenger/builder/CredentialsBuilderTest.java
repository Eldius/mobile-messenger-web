package net.eldiosantos.messenger.builder;

import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class CredentialsBuilderTest {

    @Test
    public void testBuild() throws Exception {

        final CredentialsBuilder builder = new CredentialsBuilder(new SHAHashProvider());
        final UserInfo user = builder
                .start()
                .login("user")
                .password("it's a strong password")
                .build();

        assertEquals("Validating user login with build", "user", user.getLogin());
    }

    @Test
    public void testBuildWithoutData() throws Exception {

        final CredentialsBuilder builder = new CredentialsBuilder(new SHAHashProvider());
        final UserInfo user = builder.build();

        assertNull("Validating build without data", user);
    }
}