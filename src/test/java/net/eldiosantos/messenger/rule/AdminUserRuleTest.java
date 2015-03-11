package net.eldiosantos.messenger.rule;

import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.model.auth.UserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminUserRuleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsAllowed() throws Exception {
        final UserSession userSession = new UserSession();

        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("Ghandalf")
                .password("You shall not pass!")
                .build()
                .setEmail("ghandalf@middle.earth.com")
                .setUserType(UserType.ADMIN);

        userSession.setUser(user);

        final boolean isAllowed = new AdminUserRule(userSession).isAllowed(0);

        assertTrue("Validate Ghandalf can pass", isAllowed);

    }

    @Test
    public void testIs_NOT_Allowed() throws Exception {
        final UserSession userSession = new UserSession();

        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("Balrog")
                .password("You shall not pass!")
                .build()
                .setEmail("balrog@middle.earth.com")
                .setUserType(UserType.USER);

        userSession.setUser(user);

        final boolean isAllowed = new AdminUserRule(userSession).isAllowed(0);

        assertFalse("Validate Balrog can not pass", isAllowed);

    }

    @Test
    public void testIsAllowedWithoutUser() throws Exception {
        final UserSession userSession = new UserSession();

        final boolean isAllowed = new AdminUserRule(userSession).isAllowed(0);

        assertFalse("Validate Balrog can not pass", isAllowed);
    }
}
