package com.robinsonduffy.aliendna.model.resolver;

import com.robinsonduffy.aliendna.model.organism.Plant;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlantResolver extends AbstractResolver<Plant> {
    @Autowired
    public PlantResolver(@Qualifier("PlantPhenotype") List<Phenotype> phenotypes) {
        super(phenotypes);
    }
}
