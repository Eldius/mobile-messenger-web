package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.rule.handler.LoggedHandler;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@HandledBy(LoggedHandler.class)
public class LoggedUserRule implements SimpleBrutauthRule {

    @Inject
    private UserSession userSession;

    @Override
    public boolean isAllowed(long accessLevel) {
        return userSession.isLogged();
    }
}
