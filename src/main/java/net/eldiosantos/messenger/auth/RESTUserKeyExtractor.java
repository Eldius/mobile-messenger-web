package net.eldiosantos.messenger.auth;

import br.com.caelum.vraptor.http.MutableRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletRequest;

/**
 * Created by eldio.junior on 10/03/2015.
 */
@RequestScoped
public class RESTUserKeyExtractor {

    public static final String AUTH_TOKEN_HEADER = "auth-token";

    @Inject
    private ServletRequest request;

    @Deprecated
    public RESTUserKeyExtractor() {
    }

    public RESTUserKeyExtractor(ServletRequest request) {
        this.request = request;
    }

    public String extract() {
        return ((MutableRequest) request).getHeader(AUTH_TOKEN_HEADER);
    }
}
