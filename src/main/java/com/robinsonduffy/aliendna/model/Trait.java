package com.robinsonduffy.aliendna.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class Trait implements Comparable<Trait> {
    private ImmutablePair<Allele, Allele> alleles;
    private String marker;

    public Trait(String marker) {
        this(marker, new ImmutablePair<>(Allele.random(), Allele.random()));
    }

    public Trait(String marker, Allele left, Allele right) {
        this(marker, new ImmutablePair<>(left, right));
    }

    public Trait(String marker, ImmutablePair<Allele, Allele> alleles) {
        if (!StringUtils.isAlpha(marker)) {
            throw new IllegalArgumentException("The marker must be letters");
        }
        this.marker = marker.toUpperCase();
        this.alleles = alleles;
    }

    public ImmutablePair<Allele, Allele> getAlleles() {
        return alleles;
    }

    public String getMarker(){
        return marker;
    };

    @Override
    public int compareTo(Trait o) {
        return this.getMarker().compareTo(o.getMarker());
    }

    @Override
    public String toString() {
        return null;
    }
}
