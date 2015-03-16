package net.eldiosantos.messenger.controller.json;

import br.com.caelum.brutauth.auth.annotations.Public;
import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.auth.MobileUserAuthenticator;
import net.eldiosantos.messenger.rule.RESTRequestRule;
import net.eldiosantos.messenger.vo.UserLoginData;

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

    @Post("/login")
    @Public
    @Consumes("application/json")
    public void login(final UserLoginData loginData) {
        result.use(Results.json()).from(authenticator.validate(loginData.getLogin(), loginData.getPass())).serialize();
    }

    public void logout() {
        final String token = ((MutableRequest) request).getHeader("auth-token");
        authenticator.invalidate(token);
        result.use(Results.json()).from("ok").serialize();
    }
}
