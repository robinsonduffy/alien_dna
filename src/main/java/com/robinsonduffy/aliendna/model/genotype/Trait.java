package com.robinsonduffy.aliendna.model.genotype;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Objects;

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

    public Allele getExpression(){
        if (alleles.left.equals(Allele.DOMINANT) || alleles.right.equals(Allele.DOMINANT)) {
            return Allele.DOMINANT;
        } else {
            return Allele.RECESSIVE;
        }
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Trait trait = (Trait) obj;
        return this.toString().equals(trait.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString()) * 37;
    }

    public static Trait fromString(final String traitString) {
        if (StringUtils.isBlank(traitString)) {
            throw new IllegalArgumentException("Invalid String");
        }
        String piece1 = traitString.substring(0, (traitString.length() / 2));
        String piece2 = traitString.substring(traitString.length() / 2);
        if (!StringUtils.equalsIgnoreCase(piece1, piece2)) {
            throw new IllegalArgumentException("Invalid String");
        }
        if (StringUtils.isMixedCase(piece1) || StringUtils.isMixedCase(piece2)) {
            throw new IllegalArgumentException("Invalid String");
        }
        Allele allele1 = StringUtils.isAllUpperCase(piece1) ? Allele.DOMINANT : Allele.RECESSIVE;
        Allele allele2 = StringUtils.isAllUpperCase(piece2) ? Allele.DOMINANT : Allele.RECESSIVE;
        return new Trait(piece1, allele1, allele2);
    }
}
