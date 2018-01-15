package com.robinsonduffy.aliendna.model.resolver;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.genotype.markers.MarkersEnum;
import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import com.robinsonduffy.aliendna.model.organism.Organism;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;

import java.util.List;

public interface Resolver<T extends Organism> {
    List<Phenotype> getPossiblePhenotypes();
    List<Phenotype> resolvePhenotypes(T organism);
}
