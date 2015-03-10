package net.eldiosantos.messenger.rule;

import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;
import net.eldiosantos.messenger.auth.RESTUserKeyExtractor;
import net.eldiosantos.messenger.repository.UserInfoRepository;

import javax.inject.Inject;

/**
 * Created by eldio.junior on 09/03/2015.
 */
public class RESTRequestRule implements SimpleBrutauthRule {

    @Inject
    private UserInfoRepository userInfoRepository;

    @Inject
    private RESTUserKeyExtractor userKeyExtractor;

    @Deprecated
    public RESTRequestRule() {
    }

    public RESTRequestRule(UserInfoRepository userInfoRepository, RESTUserKeyExtractor userKeyExtractor) {
        this.userInfoRepository = userInfoRepository;
        this.userKeyExtractor = userKeyExtractor;
    }

    @Override
    public boolean isAllowed(long accessLevel) {
        final String token = userKeyExtractor.extract();
        return userInfoRepository.validateToken(token) != null;
    }
}
