package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class Fat extends AbstractPhenotype{
    @Override
    public String getName() {
        return "Fat";
    }

    @Override
    public String getDetails() {
        return "A fat creature";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
            new ImmutablePair<>(Markers.WEIGHT, Allele.DOMINANT)
        );
    }
}
