package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class BlackSkin extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has black skin";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(MonsterMarkers.BLUE.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.RED.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.YELLOW.code(), Allele.DOMINANT)
        );
    }
}
