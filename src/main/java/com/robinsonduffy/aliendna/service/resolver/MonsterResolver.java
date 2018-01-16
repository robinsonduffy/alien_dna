package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.organism.Monster;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterResolver extends AbstractResolver<Monster> {
    @Autowired
    public MonsterResolver(@Qualifier("MonsterPhenotype") List<Phenotype> phenotypes) {
        super(phenotypes);
    }
}
