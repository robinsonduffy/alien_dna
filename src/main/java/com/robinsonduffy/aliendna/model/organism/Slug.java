package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.genotype.Sequence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("slug")
public class Slug extends AbstractOrganism {
    Slug() {}

    public Slug(Sequence sequence) {
        super(sequence);
    }
}
