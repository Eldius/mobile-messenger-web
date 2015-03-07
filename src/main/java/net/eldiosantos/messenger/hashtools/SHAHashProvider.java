package net.eldiosantos.messenger.hashtools;

/**
 * Created by eldio.junior on 24/02/2015.
 */
public class SHAHashProvider extends HashProvider{

    @Override
    protected String algorithm() {
        return "SHA-256";
    }
}
