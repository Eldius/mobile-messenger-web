package net.eldiosantos.messenger.controller.json;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.messenger.repository.MessageRepository;
import net.eldiosantos.messenger.rule.RESTRequestRule;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 06/03/2015.
 */
@Controller
@Path("/json/message")
@SimpleBrutauthRules({RESTRequestRule.class})
public class JSONMessageController {

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private Result result;

    @Get("/")
    public void list() {
        result.use(Results.json()).from(messageRepository.listAll()).serialize();
    }

    @Get("/messages/{begin}")
    public void list(final Long begin) {
        result.use(Results.json()).from(messageRepository.getFrom(begin)).serialize();
    }

}
