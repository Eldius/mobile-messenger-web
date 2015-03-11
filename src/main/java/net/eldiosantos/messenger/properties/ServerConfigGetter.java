package net.eldiosantos.messenger.properties;

import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.repository.ServerConfigRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@Named("serverConfigGetter")
public class ServerConfigGetter {

    private final Map<String, ServerConfig>properties = new HashMap<String, ServerConfig>();

    @Inject
    private ServerConfigRepository serverConfigRepository;

    @Deprecated
    public ServerConfigGetter() {
    }

    public ServerConfigGetter(ServerConfigRepository serverConfigRepository) {
        this.serverConfigRepository = serverConfigRepository;
    }

    public ServerConfig getOpenRegistrationProperty() {
        return get("app.config.open_reg");
    }

    public ServerConfig get(final String key){
        ServerConfig cfg = properties.get(key);
        if(cfg==null) {
            cfg = serverConfigRepository.getByPk(key);
            properties.put(key, cfg);
        }
        return cfg;
    }
}
