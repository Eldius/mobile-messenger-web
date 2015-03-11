package net.eldiosantos.messenger.rule;

import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.builder.CredentialsBuilder;
import net.eldiosantos.messenger.hashtools.SHAHashProvider;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RESTRequestRuleTest {

    @Mock
    private UserInfoRepository userInfoRepository;

    @Mock
    private RESTUserKeyExtractor userKeyExtractor;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsAllowed() throws Exception {

        Mockito.when(userKeyExtractor.extract()).thenReturn("That's a key?");
        final UserInfo user = new CredentialsBuilder(new SHAHashProvider())
                .start()
                .login("whatever")
                .password("1, 2, 3, password")
                .build();

        Mockito.when(userInfoRepository.validateToken("That's a key?")).thenReturn(user);

        final boolean isAllowed = new RESTRequestRule(userInfoRepository, userKeyExtractor).isAllowed(0);

        assertTrue("You can go", isAllowed);
    }

    @Test
    public void testIsNotAllowed() throws Exception {

        Mockito.when(userKeyExtractor.extract()).thenReturn("That's a key?");

        Mockito.when(userInfoRepository.validateToken("That's a key?")).thenReturn(null);

        final boolean isAllowed = new RESTRequestRule(userInfoRepository, userKeyExtractor).isAllowed(0);

        assertFalse("You can go", isAllowed);
    }
}
