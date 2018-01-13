package com.robinsonduffy.aliendna.model.phenotype.slug;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.markers.SlugMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class NotSlimy extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Does not produce slime";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(SlugMarkers.SLIME.code(), Allele.RECESSIVE)
        );
    }
}