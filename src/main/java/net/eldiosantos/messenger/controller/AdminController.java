package net.eldiosantos.messenger.controller;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.rule.LoggedUserRule;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by eldio.junior on 23/02/2015.
 */
@Controller
@Path("/admin")
public class AdminController {

    @Inject
    private Result result;

    @Path("/")
    @SimpleBrutauthRules({LoggedUserRule.class})
    public void index() {

    }

    @Post("/save")
    public void saveConfig(List<ServerConfig>configs) {
        result.use(Results.json()).from(configs).serialize();
    }
}
