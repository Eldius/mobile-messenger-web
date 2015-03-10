package net.eldiosantos.messenger.auth;

import net.eldiosantos.messenger.hashtools.HashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.model.auth.UserType;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.NoResultException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserAuthenticatorTest {

    @Mock
    private UserInfoRepository userInfoRepository;

    private UserSession userSession = new UserSession();

    @Mock
    private HashProvider hashProvider;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidate() throws Exception {
        final String hash = "password's hash";
        final String pass = "pass";
        final String login = "login";

        Mockito.when(hashProvider.hash(pass)).thenReturn(hash);

        final UserInfo user = new UserInfo()
                .setEmail("login@email.com")
                .setId(69L)
                .setUserType(UserType.ADMIN)
                .setLogin(login)
                .setPassword(hash);

        Mockito.when(userInfoRepository.validateLogin(login, hash)).thenReturn(user);

        new UserAuthenticator(userInfoRepository, userSession, hashProvider).validate(login, pass);

        assertEquals("Validating userSession's user values - ID", userSession.getUserId(), Long.valueOf(69));
        assertEquals("Validating userSession's user values - login", userSession.getLogin(), login);
    }

    @Test(expected = NoResultException.class)
    public void testValidateInvalidUser() throws Exception {
        final String hash = "password's hash";
        final String pass = "pass";
        final String login = "login";

        Mockito.when(hashProvider.hash(pass)).thenReturn(hash);

        Mockito.when(userInfoRepository.validateLogin(login, hash)).thenThrow(new NoResultException("BOOOM!!!"));

        new UserAuthenticator(userInfoRepository, userSession, hashProvider).validate(login, pass);
    }

    @Test
    public void testInvalidate() throws Exception {
        final String hash = "password's hash";
        final String login = "login";

        final UserInfo user = new UserInfo()
                .setEmail("login@email.com")
                .setId(69L)
                .setUserType(UserType.ADMIN)
                .setLogin(login)
                .setPassword(hash);

        userSession.setUser(user);

        new UserAuthenticator(userInfoRepository, userSession, hashProvider).invalidate();

        assertNull("There isn't an user in the session", userSession.getUser());
    }

    @Test
    public void testInvalidateWithoutUser() throws Exception {

        new UserAuthenticator(userInfoRepository, userSession, hashProvider).invalidate();

        assertNull("There isn't an user in the session", userSession.getUser());
    }
}