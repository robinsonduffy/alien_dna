package com.robinsonduffy.aliendna.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

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
        if (alleles == null || alleles.getLeft() == null || alleles.getRight() == null) {
            throw new IllegalArgumentException("Must provide valid alleles");
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
        if (this.getMarker().equals(o.getMarker())) {
            return this.toString().compareTo(o.toString());
        } else {
            return this.getMarker().compareTo(o.getMarker());
        }
    }

    @Override
    public String toString() {
        String leftMarker = alleles.left.equals(Allele.DOMINANT) ? marker : marker.toLowerCase();
        String rightMarker = alleles.right.equals(Allele.DOMINANT) ? marker : marker.toLowerCase();

        if (alleles.left.equals(Allele.DOMINANT)) {
            return leftMarker + rightMarker;
        } else {
            return rightMarker + leftMarker;
        }

    }
}
