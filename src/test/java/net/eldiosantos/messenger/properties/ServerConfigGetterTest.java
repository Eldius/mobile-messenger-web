package net.eldiosantos.messenger.properties;

import net.eldiosantos.messenger.constants.properties.ConfigKeyConstants;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.repository.ServerConfigRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ServerConfigGetterTest {

    @Mock
    private ServerConfigRepository serverConfigRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetOpenRegistrationProperty() throws Exception {

        final ServerConfig value = new ServerConfig();
        value.setKey(ConfigKeyConstants.OPEN_REGISTRATION);
        value.setValue("true");

        Mockito.when(serverConfigRepository.getByPk(ConfigKeyConstants.OPEN_REGISTRATION)).thenReturn(value);

        final ServerConfigGetter serverConfigGetter = new ServerConfigGetter(serverConfigRepository);

        final ServerConfig serverConfig = serverConfigGetter.getOpenRegistrationProperty();

        assertTrue("Validating config is true", serverConfig.getBooleanValue());
        assertEquals("Validating it's returning the same object", value, serverConfig);
    }

    @Test
    public void testGetNonExistentProperty() throws Exception {

        final String key = "stupid key value";
        Mockito.when(serverConfigRepository.getByPk(key)).thenReturn(null);

        final ServerConfigGetter serverConfigGetter = new ServerConfigGetter(serverConfigRepository);

        final ServerConfig serverConfig = serverConfigGetter.get(ConfigKeyConstants.OPEN_REGISTRATION);

        assertNull("Validating it's returning the same object", serverConfig);
    }
}
