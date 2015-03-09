package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import br.com.caelum.vraptor.http.MutableRequest;
import net.eldiosantos.messenger.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletRequest;

/**
 * Created by eldio.junior on 09/03/2015.
 */
public class RESTRequestRule implements SimpleBrutauthRule {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private ServletRequest request;

    @Override
    public boolean isAllowed(long accessLevel) {
        logger.debug("request: " + request);
        final String token = ((MutableRequest) request).getHeader("auth-token");
        return userInfoRepository.validateToken(token) != null;
    }
}
