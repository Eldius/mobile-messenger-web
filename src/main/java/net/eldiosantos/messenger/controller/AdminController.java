package net.eldiosantos.messenger.controller;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import net.eldiosantos.messenger.rule.LoggedUserRule;

/**
 * Created by eldio.junior on 23/02/2015.
 */
@Controller
@Path("/admin")
public class AdminController {

    @Path("/")
    @SimpleBrutauthRules({LoggedUserRule.class})
    public void index() {

    }
}
