package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("monster")
public class Monster extends AbstractOrganism {

    Monster() {}

    public Monster(Sequence sequence) {
        super(sequence);
    }
}
