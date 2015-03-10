package net.eldiosantos.messenger.hashtools;

import static org.junit.Assert.*;

public class SHAHashProviderTest {

    private static final byte[] expectedValue = {
            107
            , -17
            , -65
            , -67
            , -17
            , -65
            , -67
            , 115
            , -17
            , -65
            , -67
            , 52
            , -17
            , -65
            , -67
            , -17
            , -65
            , -67
            , 107
            , -17
            , -65
            , -67
            , 78
            , -17
            , -65
            , -67
            , 90
            , 63
            , 87
            , 71
            , -17
            , -65
            , -67
            , -17
            , -65
            , -67
            , -17
            , -65
            , -67
            , 47
            , 29
            , 73
            , -17
            , -65
            , -67
            , 30
            , 82
            , -35
            , -73
            , -17
            , -65
            , -67
            , 91
            , 75
    };


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void testHash() throws Exception {
        final SHAHashProvider shaHashProvider = new SHAHashProvider();

        final String bytes = shaHashProvider.hash("1");
        assertEquals("Validating hash algorithm is right", new String(expectedValue, "utf-8"), bytes);
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void testHashNull() throws Exception {
        final SHAHashProvider shaHashProvider = new SHAHashProvider();
        shaHashProvider.hash(null);
    }
}