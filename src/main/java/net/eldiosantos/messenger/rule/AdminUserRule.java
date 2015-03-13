package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.model.auth.UserType;
import net.eldiosantos.messenger.rule.handler.AdminHandler;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@HandledBy(AdminHandler.class)
public class AdminUserRule implements SimpleBrutauthRule {

    @Inject
    private UserSession userSession;

    @Deprecated
    public AdminUserRule() {
    }

    public AdminUserRule(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public boolean isAllowed(long accessLevel) {
        return (userSession.getUser()!=null? UserType.ADMIN.equals(userSession.getUser().getUserType()):false);
    }
}
