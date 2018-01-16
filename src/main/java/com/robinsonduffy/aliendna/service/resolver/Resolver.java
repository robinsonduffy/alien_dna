package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.organism.Organism;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;

import java.util.List;

public interface Resolver<T extends Organism> {
    List<Phenotype> getPossiblePhenotypes();
    List<Phenotype> resolvePhenotypes(T organism);
}
