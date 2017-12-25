package com.robinsonduffy.aliendna.model;

import java.util.Arrays;
import java.util.Random;

public enum Allele {
    DOMINANT, RECESSIVE;

    private static final Allele[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Allele random()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
