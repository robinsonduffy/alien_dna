package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.organism.Plant;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantResolver extends AbstractResolver<Plant> {
    @Autowired
    public PlantResolver(@Qualifier("PlantPhenotype") List<Phenotype> phenotypes) {
        super(phenotypes);
    }
}
