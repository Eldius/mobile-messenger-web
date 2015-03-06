package net.eldiosantos.viajabessa.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import net.eldiosantos.viajabessa.repository.MessageRepository;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 06/03/2015.
 */
@Controller
@Path("/json/message")
public class JSONMessageController {

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private Result result;

    @Get("/")
    public void list() {
        result.use(Results.json()).from(messageRepository.listAll()).serialize();
    }
}
