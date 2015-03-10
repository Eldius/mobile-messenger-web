package net.eldiosantos.messenger.auth;

import br.com.caelum.vraptor.http.MutableRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RESTUserKeyExtractorTest {

    @Mock
    private MutableRequest request;

    private RESTUserKeyExtractor userKeyExtractor;

    @Before
    public void setUp() throws Exception {
        userKeyExtractor = new RESTUserKeyExtractor(request);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExtractWithoutKey() throws Exception {
        final String key = userKeyExtractor.extract();

        assertNull("Test without key on request");

        Mockito.verify(request).getHeader(RESTUserKeyExtractor.AUTH_TOKEN_HEADER);
    }

    @Test
    public void testExtract() throws Exception {

        final String userKey = "user access key";
        Mockito.when(request.getHeader(RESTUserKeyExtractor.AUTH_TOKEN_HEADER)).thenReturn(userKey);
        final String key = userKeyExtractor.extract();

        assertEquals("Test with a user key", userKey, key);

        Mockito.verify(request).getHeader(RESTUserKeyExtractor.AUTH_TOKEN_HEADER);
    }
}
