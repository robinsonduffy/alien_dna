package com.robinsonduffy.aliendna.model.phenotype.slug;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.SlugMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Qualifier("SlugPhenotype")
public class NoEyeStalks extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Does not have eye stalks";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(SlugMarkers.EYE_STALKS.code(), Allele.RECESSIVE)
        );
    }
}
