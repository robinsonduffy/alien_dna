package com.robinsonduffy.aliendna.model.phenotype.plant;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.PlantMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class TerminalFlowers extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has flowers on the end of the stems";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(PlantMarkers.FLOWER_POSITION.code(), Allele.RECESSIVE)
        );
    }
}
