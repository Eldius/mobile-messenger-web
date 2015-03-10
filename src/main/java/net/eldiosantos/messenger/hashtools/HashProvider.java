package net.eldiosantos.messenger.hashtools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by eldio.junior on 24/02/2015.
 */
public abstract class HashProvider {
    public String hash(final String phrase) {
        try {
            final byte[] digest = binaryHash(phrase);
            return toString(digest);
        } catch (Exception e) {
            throw new IllegalStateException("Error trying to hash a phrase", e);
        }
    }

    public byte[] binaryHash(String phrase) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm());
            return md.digest(phrase.getBytes("utf-8"));
        }catch (Exception e) {
            throw new IllegalArgumentException("Error generating hash", e);
        }
    }

    private String toString(byte[] digest) throws UnsupportedEncodingException {
        return new String(digest, "UTF-8");
    }

    protected abstract String algorithm();
}
