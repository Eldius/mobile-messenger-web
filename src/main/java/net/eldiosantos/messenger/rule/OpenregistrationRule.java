package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.properties.ServerConfigGetter;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
public class OpenregistrationRule implements SimpleBrutauthRule {

    @Inject
    private ServerConfigGetter serverConfigGetter;

    @Override
    public boolean isAllowed(long accessLevel) {
        final ServerConfig cfg = serverConfigGetter.getOpenRegistrationProperty();
        return Boolean.valueOf(cfg!=null?cfg.getValue():null);
    }
}
