package com.robinsonduffy.aliendna.model.genotype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class PunnettSquare {

    private List<Trait> traits;

    public PunnettSquare(final Trait trait1, final Trait trait2) {
        if (trait1 == null || trait2 == null) {
            throw new IllegalArgumentException("Must provide valid traits");
        }
        String marker = trait1.getMarker();
        traits = new ArrayList<>();
        traits.add(new Trait(marker, trait1.getAlleles().left, trait2.getAlleles().left));
        traits.add(new Trait(marker, trait1.getAlleles().right, trait2.getAlleles().left));
        traits.add(new Trait(marker, trait1.getAlleles().left, trait2.getAlleles().right));
        traits.add(new Trait(marker, trait1.getAlleles().right, trait2.getAlleles().right));
        Collections.sort(traits);
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public Trait getRandomTrait(){
        return traits.get(ThreadLocalRandom.current().nextInt(traits.size()));
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
        PunnettSquare punnettSquare = (PunnettSquare) obj;
        return this.toString().equals(punnettSquare.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString()) * 37;
    }
}
