package com.robinsonduffy.aliendna.model;

import java.util.concurrent.ThreadLocalRandom;

public enum Allele {
    DOMINANT, RECESSIVE;

    private static final Allele[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static Allele random()  {
        return VALUES[ThreadLocalRandom.current().nextInt(SIZE)];
    }
}
