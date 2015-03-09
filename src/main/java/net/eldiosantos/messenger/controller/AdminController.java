package net.eldiosantos.messenger.controller;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.model.config.ServerConfig;
import net.eldiosantos.messenger.repository.ServerConfigRepository;
import net.eldiosantos.messenger.rule.LoggedUserRule;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eldio.junior on 23/02/2015.
 */
@Controller
@Path("/admin")
public class AdminController {

    @Inject
    private ServerConfigRepository serverConfigRepository;

    @Inject
    private Result result;

    @Path("/")
    @SimpleBrutauthRules({LoggedUserRule.class})
    public void index() {
        final Map<String, ServerConfig>properties = new HashMap<String, ServerConfig>();
        for(ServerConfig cfg: serverConfigRepository.listAll()) {
            properties.put(cfg.getKey(), cfg);
        }
        result.include("properties", properties);
    }

    @Post("/save")
    public void saveConfig(List<ServerConfig>configs) {
        for(ServerConfig cfg: configs) {
            serverConfigRepository.saveOrUpdate(cfg);
        }
        result.redirectTo(this).index();
    }
}
