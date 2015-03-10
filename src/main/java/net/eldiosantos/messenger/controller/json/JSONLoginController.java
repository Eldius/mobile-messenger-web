package net.eldiosantos.messenger.controller.json;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.auth.MobileUserAuthenticator;
import net.eldiosantos.messenger.rule.RESTRequestRule;

import javax.inject.Inject;
import javax.servlet.ServletRequest;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@Path("/json/login")
@Controller
@SimpleBrutauthRules({RESTRequestRule.class})
public class JSONLoginController {

    @Inject
    private MobileUserAuthenticator authenticator;

    @Inject
    private Result result;

    @Inject
    private ServletRequest request;

    @Path("/")
    public void form() {

    }

    @Path("/login")
    @Public
    public void login(final String login, final String pass) {
        result.use(Results.json()).from(authenticator.validate(login, pass)).serialize();
    }

    public void logout() {
        final String token = ((MutableRequest) request).getHeader("auth-token");
        authenticator.invalidate(token);
        result.use(Results.json()).from("ok").serialize();
    }
}
