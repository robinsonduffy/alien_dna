package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class NoFangs extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has no visible fangs";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
            new ImmutablePair<>(MonsterMarkers.FANGS.code(), Allele.RECESSIVE)
        );
    }
}
