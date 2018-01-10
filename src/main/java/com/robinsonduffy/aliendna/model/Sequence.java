package com.robinsonduffy.aliendna.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sequence {
    private List<Trait> traits = new ArrayList<>();

    public Sequence() {}

    public List<Trait> getTraits() {
        return traits;
    }

    public void add(Trait trait) {
        traits.forEach((trait1) -> {
            if (trait1.getMarker().equals(trait.getMarker())) {
                throw new IllegalArgumentException("Duplicate trait");
            }
        });
        traits.add(trait);
        Collections.sort(traits);
    }

    public List<String> getMarkers() {
        return this.traits.stream().map(Trait::getMarker).collect(Collectors.toList());
    }

    public Trait getTrait(final String marker) {
        final Optional<Trait> trait = traits.stream().filter(thisTrait -> thisTrait.getMarker().equals(marker)).findFirst();
        return trait.orElseThrow(() -> new IllegalArgumentException("Invalid trait marker"));
    }

    @Override
    public String toString() {
        return traits.toString();
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
        Sequence sequence = (Sequence) obj;
        return this.toString().equals(sequence.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString()) * 37;
    }

    static public Sequence from(Sequence sequence1, Sequence sequence2) {
        if (!sequence1.getMarkers().equals(sequence2.getMarkers())){
            throw new IllegalArgumentException("Sequences are not compatible");
        }
        Sequence newSequence = new Sequence();
        sequence1.getTraits().forEach(trait1 -> {
            newSequence.add(new PunnettSquare(trait1, sequence2.getTrait(trait1.getMarker())).getRandomTrait());
        });
        return newSequence;
    }
}
