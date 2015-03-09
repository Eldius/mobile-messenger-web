package net.eldiosantos.messenger.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Patch;
import br.com.caelum.vraptor.Path;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by eldio.junior on 09/03/2015.
 */
@Controller
@Path("/user")
public class UserController {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Get("/form/{userId}")
    public UserInfo form(final Long userId) {
        return userInfoRepository.getByPk(userId);
    }

    @Get("/form")
    public void form() {

    }


}
