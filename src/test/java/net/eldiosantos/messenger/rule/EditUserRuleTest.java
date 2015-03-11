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

public class EditUserRuleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdminIsAllowed() throws Exception {
        final UserSession userSession = new UserSession();
        final UserInfo editor = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("editor")
                .password("pass")
                .build()
                .setUserType(UserType.ADMIN);
        userSession.setUser(editor);
        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("edited")
                .password("pass")
                .build()
                .setUserType(UserType.ADMIN);

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertTrue("Yes, an admin user can edit anyone", isAllowed);
    }

    @Test
    public void testYouIsAllowed() throws Exception {
        final UserSession userSession = new UserSession();
        final UserInfo editor = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("anyone")
                .password("pass")
                .build()
                .setId(1L)
                .setUserType(UserType.USER);
        userSession.setUser(editor);
        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("anyone")
                .password("pass")
                .build()
                .setId(1L)
                .setUserType(UserType.ADMIN);

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertTrue("Yes, a logged user can edit yourself", isAllowed);
    }

    @Test
    public void testYouIsNotAllowed() throws Exception {
        final UserSession userSession = new UserSession();
        final UserInfo editor = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("editor")
                .password("pass")
                .build()
                .setId(1L)
                .setUserType(UserType.USER);
        userSession.setUser(editor);
        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("edited")
                .password("pass")
                .build()
                .setId(2L)
                .setUserType(UserType.USER);

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertFalse("No, an user can't edit another user", isAllowed);
    }

    @Test
    public void testAnnonymousIsAllowedToCreateNewAccount() throws Exception {
        final UserSession userSession = new UserSession();
        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("edited")
                .password("pass")
                .build()
                .setEmail("edited@mailinator.com");

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertTrue("Yes, an annonymous can create a new user", isAllowed);
    }

    @Test
    public void testAnnonymousIsNotAllowedToEditAnotherUser() throws Exception {
        final UserSession userSession = new UserSession();
        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("edited")
                .password("pass")
                .build()
                .setId(1L)
                .setEmail("edited@mailinator.com");

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertFalse("No, an annonymous user can't edit another user user", isAllowed);
    }

    @Test
    public void testYouIsAllowedToCreateAnotherUser() throws Exception {
        final UserSession userSession = new UserSession();

        final UserInfo editor = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("editor")
                .password("pass")
                .build()
                .setId(1L)
                .setUserType(UserType.USER);
        userSession.setUser(editor);

        final UserInfo edited = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("edited")
                .password("pass")
                .build()
                .setEmail("edited@mailinator.com");

        final boolean isAllowed = new EditUserRule(userSession).isAllowed(edited);

        assertTrue("Ok, a logged user can create another user", isAllowed);
    }
}
