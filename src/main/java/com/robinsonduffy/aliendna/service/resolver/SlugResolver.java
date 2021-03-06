package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.organism.Slug;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlugResolver extends AbstractResolver<Slug> {
    @Autowired
    public SlugResolver(@Qualifier("SlugPhenotype") List<Phenotype> phenotypes) {
        super(phenotypes);
    }
}
