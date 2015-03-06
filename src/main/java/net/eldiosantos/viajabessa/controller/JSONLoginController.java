package net.eldiosantos.viajabessa.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.viajabessa.auth.MobileUserAuthenticator;
import net.eldiosantos.viajabessa.auth.UserAuthenticator;
import net.eldiosantos.viajabessa.model.auth.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * Created by eldio.junior on 12/02/2015.
 */
@Path("/json/login")
@Controller
public class JSONLoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private MobileUserAuthenticator authenticator;

    @Inject
    private Result result;

    @Path("/")
    public void form() {

    }

    @Path("/login")
    public void login(final String login, final String pass) {
        result.use(Results.json()).from(authenticator.validate(login, pass)).serialize();
    }

    public void logout() {
        authenticator.invalidate();
        result.use(Results.json()).from("ok").serialize();
    }
}
