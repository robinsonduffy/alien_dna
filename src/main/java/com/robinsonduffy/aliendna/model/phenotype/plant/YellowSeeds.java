package com.robinsonduffy.aliendna.model.phenotype.plant;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.PlantMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class YellowSeeds extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has green seeds";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(PlantMarkers.PEA_COLOR.code(), Allele.DOMINANT)
        );
    }
}
