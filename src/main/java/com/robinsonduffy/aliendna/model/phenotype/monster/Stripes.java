package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class Stripes extends AbstractPhenotype {
    @Override
    public String getName() {
        return "Stripes";
    }

    @Override
    public String getDetails() {
        return "Has stripes on the body";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(Markers.MARKINGS, Allele.RECESSIVE),
                new ImmutablePair<>(Markers.MARKINGS_TYPE, Allele.DOMINANT)
        );
    }
}
