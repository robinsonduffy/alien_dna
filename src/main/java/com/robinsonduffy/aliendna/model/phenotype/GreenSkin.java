package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class GreenSkin extends AbstractPhenotype{
    @Override
    public String getDetails() {
        return "Has green skin";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(Markers.BLUE, Allele.DOMINANT),
                new ImmutablePair<>(Markers.RED, Allele.RECESSIVE),
                new ImmutablePair<>(Markers.YELLOW, Allele.DOMINANT)
        );
    }
}