package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractResolver<T extends AbstractOrganism> implements Resolver<T> {
    private List<Phenotype> phenotypes;

    public AbstractResolver(List<Phenotype> phenotypes) {
        this.phenotypes = phenotypes;
    }

    @Override
    public List<Phenotype> getPossiblePhenotypes() {
        return phenotypes;
    }

    @Override
    public List<Phenotype> resolvePhenotypes(T organism) {
        return phenotypes.stream()
                .filter(phenotype -> phenotype.isExpressed(organism.getSequence()))
                .collect(Collectors.toList());
    }
}
