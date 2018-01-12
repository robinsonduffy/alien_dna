package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class Spots extends AbstractPhenotype{
    @Override
    public String getName() {
        return "Spots";
    }

    @Override
    public String getDetails() {
        return "Has spots on the body";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(Markers.MARKINGS, Allele.RECESSIVE),
                new ImmutablePair<>(Markers.MARKINGS_TYPE, Allele.RECESSIVE)
        );
    }
}
