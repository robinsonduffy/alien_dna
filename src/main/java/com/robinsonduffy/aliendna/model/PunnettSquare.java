package com.robinsonduffy.aliendna.model;

import java.util.List;

public class PunnettSquare {

    private List<Trait> traits;

    public PunnettSquare(final Trait trait1, final Trait trait2) {
        if (trait1 == null || trait2 == null) {
            throw new IllegalArgumentException("Must provide valid traits");
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
