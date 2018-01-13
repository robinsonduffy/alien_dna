package com.robinsonduffy.aliendna.model.phenotype.slug;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.markers.SlugMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class LongEyeStalks extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has long eye stalks";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(SlugMarkers.EYE_STALKS.code(), Allele.DOMINANT),
                new ImmutablePair<>(SlugMarkers.EYE_STALKS_LENGTH.code(), Allele.DOMINANT)
        );
    }
}
