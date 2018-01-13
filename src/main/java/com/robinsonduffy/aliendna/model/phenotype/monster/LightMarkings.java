package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class LightMarkings extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "The markings on the body are light colored";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(MonsterMarkers.MARKINGS.code(), Allele.RECESSIVE),
                new ImmutablePair<>(MonsterMarkers.MARKINGS_COLOR.code(), Allele.DOMINANT)
        );
    }
}
