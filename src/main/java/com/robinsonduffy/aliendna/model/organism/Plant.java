package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.genotype.Sequence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("plant")
public class Plant extends AbstractOrganism {
    Plant() {}

    public Plant(Sequence sequence) {
        super(sequence);
    }
}
