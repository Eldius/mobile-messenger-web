package net.eldiosantos.messenger.rule;

import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggedUserRuleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIs_NOT_Allowed() throws Exception {
        final boolean isAllowed = new LoggedUserRule(new UserSession()).isAllowed(0);

        assertFalse("Validating session without a user", isAllowed);
    }

    @Test
    public void testIsAllowed() throws Exception {
        final UserSession userSession = new UserSession();
        userSession.setUser(
                new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("ghandalf")
                .password("you shall not pass")
                .build()
        );
        final boolean isAllowed = new LoggedUserRule(userSession).isAllowed(0);

        assertTrue("Validating session with a user", isAllowed);
    }
}
