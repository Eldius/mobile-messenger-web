package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.rules.CustomBrutauthRule;
import br.com.caelum.brutauth.reflection.BrutauthValidation;
import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.model.auth.UserType;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
public class EditUserRule implements CustomBrutauthRule {

    @Inject
    private UserSession userSession;

    @BrutauthValidation
    public boolean isAllowed(UserInfo user) {

        // Usuario administrador
        final boolean isAdmin = UserType.ADMIN.equals(userSession.getUser() != null ? userSession.getUser().getUserType() : null);

        // Usuario tentando alterar os proprios dados
        final boolean isSameUser = user.getId() != null ? user.getId().equals(userSession.getUserId()) : false;

        // Criacao de novo usuario
        final boolean isNewUser = (user.getId() == null) && (userSession.getUserId() == null);
        return isAdmin
               || isSameUser
               || isNewUser;
    }
}
