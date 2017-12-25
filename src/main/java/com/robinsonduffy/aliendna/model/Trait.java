package com.robinsonduffy.aliendna.model;

import org.apache.commons.lang3.tuple.ImmutablePair;

public abstract class Trait implements Comparable<Trait> {
    private ImmutablePair<Allele, Allele> alleles;

    public Trait() {
        this.alleles = new ImmutablePair<>(Allele.random(), Allele.random());
    }

    public Trait(Allele left, Allele right) {
        this.alleles = new ImmutablePair<>(left, right);
    }

    public Trait(ImmutablePair<Allele, Allele> alleles) {
        this.alleles = alleles;
    }

    public ImmutablePair<Allele, Allele> getAlleles() {
        return alleles;
    }

    public abstract String getMarker();

    @Override
    public int compareTo(Trait o) {
        return this.getMarker().compareTo(o.getMarker());
    }

    public Trait mergeWith(Trait o) {
        // this performs the actual merging of the two traits creating the new trait following the rules of Mendelian Genetics
        return null;
    }
}
