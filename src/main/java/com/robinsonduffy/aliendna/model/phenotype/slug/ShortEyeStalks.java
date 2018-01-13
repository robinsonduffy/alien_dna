package com.robinsonduffy.aliendna.model.phenotype.slug;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.SlugMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ShortEyeStalks extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has short eye stalks";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(SlugMarkers.EYE_STALKS.code(), Allele.DOMINANT),
                new ImmutablePair<>(SlugMarkers.EYE_STALKS_LENGTH.code(), Allele.RECESSIVE)
        );
    }
}
