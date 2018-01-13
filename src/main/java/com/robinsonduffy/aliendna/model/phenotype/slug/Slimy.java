package com.robinsonduffy.aliendna.model.phenotype.slug;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.SlugMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class Slimy extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Produces slime";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(SlugMarkers.SLIME.code(), Allele.DOMINANT)
        );
    }
}
