package net.eldiosantos.viajabessa.rule;

import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.viajabessa.auth.UserSession;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 12/02/2015.
 */
public class LoggedUserRule implements SimpleBrutauthRule {

    @Inject
    private UserSession userSession;

    @Override
    public boolean isAllowed(long accessLevel) {
        return userSession.isLogged();
    }
}
