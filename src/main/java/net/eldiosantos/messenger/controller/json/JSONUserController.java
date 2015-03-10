package net.eldiosantos.messenger.controller.json;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.model.auth.UserInfo;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;

import static br.com.caelum.vraptor.view.Results.*;

/**
 * Created by eldio.junior on 10/03/2015.
 */
@Controller
@Path("/json/user")
public class JSONUserController {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private RESTUserKeyExtractor userKeyExtractor;

    @Inject
    private Result result;

    @Post("/register")
    public void register(final String deviceKey) {
        final UserInfo user = userInfoRepository.validateToken(userKeyExtractor.extract());
        user.setMobileDeviceKey(deviceKey);
        userInfoRepository.update(user);

        result.use(json()).from("ok").serialize();
    }
}
