package com.robinsonduffy.aliendna.model.phenotype.plant;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.PlantMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Qualifier("PlantPhenotype")
public class PinkFlowers extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has pink flowers";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(PlantMarkers.FLOWER_COLOR.code(), Allele.DOMINANT)
        );
    }
}
