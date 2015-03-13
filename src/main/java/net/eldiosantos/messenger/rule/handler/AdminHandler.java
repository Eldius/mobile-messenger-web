package net.eldiosantos.messenger.rule.handler;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import net.eldiosantos.messenger.auth.UserSession;
import net.eldiosantos.messenger.controller.IndexController;
import net.eldiosantos.messenger.controller.LoginController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@RequestScoped
public class AdminHandler implements RuleHandler {

    @Inject
    private UserSession session;

    @Inject
    private Result result;

    @Override
    public void handle() {
        if(session.isLogged()) {
            result.redirectTo(IndexController.class).index();
        } else {
            result.redirectTo(LoginController.class).form();
        }
    }
}
