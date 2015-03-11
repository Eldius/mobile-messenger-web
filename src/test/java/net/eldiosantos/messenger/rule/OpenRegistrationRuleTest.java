package net.eldiosantos.messenger.rule;

import net.eldiosantos.messenger.constants.properties.ConfigKeyConstants;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.properties.ServerConfigGetter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenRegistrationRuleTest {

    @Mock
    private ServerConfigGetter serverConfigGetter;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsAllowed() throws Exception {

        final ServerConfig cfg = new ServerConfig();
        cfg.setKey(ConfigKeyConstants.OPEN_REGISTRATION);
        cfg.setValue("true");
        Mockito.when(serverConfigGetter.getOpenRegistrationProperty()).thenReturn(cfg);

        final boolean isAllowed = new OpenRegistrationRule(serverConfigGetter).isAllowed(0);

        assertTrue("It's open!", isAllowed);
    }

    @Test
    public void testIsNotAllowed() throws Exception {

        final ServerConfig cfg = new ServerConfig();
        cfg.setKey(ConfigKeyConstants.OPEN_REGISTRATION);
        cfg.setValue("false");
        Mockito.when(serverConfigGetter.getOpenRegistrationProperty()).thenReturn(cfg);

        final boolean isAllowed = new OpenRegistrationRule(serverConfigGetter).isAllowed(0);

        assertFalse("It isn't open...", isAllowed);
    }

    @Test
    public void testIsAllowedWithoutProperty() throws Exception {

        Mockito.when(serverConfigGetter.getOpenRegistrationProperty()).thenReturn(null);

        final boolean isAllowed = new OpenRegistrationRule(serverConfigGetter).isAllowed(0);

        assertFalse("It isn't open...", isAllowed);
    }
}
