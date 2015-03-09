package net.eldiosantos.messenger.rule.handler;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import net.eldiosantos.messenger.controller.LoginController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@RequestScoped
public class LoggedHandler implements RuleHandler {

    @Inject
    private Result result;

    @Override
    public void handle() {
        result.redirectTo(LoginController.class).form();
    }
}
