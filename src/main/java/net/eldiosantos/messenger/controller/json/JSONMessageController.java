package net.eldiosantos.messenger.controller.json;

import br.com.caelum.brutauth.auth.annotations.SimpleBrutauthRules;
import br.com.caelum.vraptor.*;
import static br.com.caelum.vraptor.view.Results.*;

import net.eldiosantos.messenger.rule.RESTRequestRule;
import net.eldiosantos.messenger.service.GetUserMessages;
import net.eldiosantos.messenger.service.SaveMessage;
import net.eldiosantos.messenger.vo.MessageVO;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 06/03/2015.
 */
@Controller
@Path("/json/message")
@SimpleBrutauthRules({RESTRequestRule.class})
public class JSONMessageController {

    @Inject
    private GetUserMessages getUserMessages;

    @Inject
    private SaveMessage saveMessage;

    @Inject
    private Result result;

    @Get("/")
    public void list() {
        result.use(json()).from(getUserMessages.list()).serialize();
    }

    @Get("/messages/{begin}")
    public void list(final Long begin) {
        result.use(json()).from(getUserMessages.list(begin)).serialize();
    }

    @Get("/unread")
    public void listUnread() {
        result.use(json()).from(getUserMessages.listUnreadMessages()).serialize();
    }

    @Consumes("application/json")
    @Post("/send")
    public void send(final MessageVO vo) {
        result.use(json()).from(saveMessage.save(vo)).serialize();
    }
}
