package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class SmallWings extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has small wings";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(Markers.WINGS, Allele.DOMINANT),
                new ImmutablePair<>(Markers.WING_SIZE, Allele.DOMINANT)
        );
    }
}
