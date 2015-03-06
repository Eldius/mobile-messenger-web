package net.eldiosantos.viajabessa.hashtools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by eldio.junior on 24/02/2015.
 */
public abstract class HashProvider {
    public String hash(final String phrase) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm());
            return toString(md.digest(phrase.getBytes()));
        } catch (Exception e) {
            throw new IllegalStateException("Error trying to hash a phrase", e);
        }
    }

    private String toString(byte[] digest) throws UnsupportedEncodingException {
        return new String(digest, "UTF-8");
    }

    protected abstract String algorithm();
}
