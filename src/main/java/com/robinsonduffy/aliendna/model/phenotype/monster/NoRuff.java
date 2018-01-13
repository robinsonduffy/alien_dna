package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class NoRuff extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has no ruff around the neck";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
            new ImmutablePair<>(MonsterMarkers.RUFF.code(), Allele.RECESSIVE)
        );
    }
}
