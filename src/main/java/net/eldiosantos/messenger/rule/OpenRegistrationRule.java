package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.properties.ServerConfigGetter;
import net.eldiosantos.messenger.rule.handler.OpenRegistrationHandler;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@HandledBy(OpenRegistrationHandler.class)
public class OpenRegistrationRule implements SimpleBrutauthRule {

    @Inject
    private ServerConfigGetter serverConfigGetter;

    @Override
    public boolean isAllowed(long accessLevel) {
        final ServerConfig cfg = serverConfigGetter.getOpenRegistrationProperty();
        return Boolean.valueOf(cfg!=null?cfg.getValue():null);
    }
}
