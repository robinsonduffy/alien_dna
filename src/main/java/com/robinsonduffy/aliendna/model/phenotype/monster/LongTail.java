package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Qualifier("MonsterPhenotype")
public class LongTail extends AbstractPhenotype {
    @Override
    public String getDetails() {
        return "Has a long tail";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(MonsterMarkers.TAIL.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.TAIL_LENGTH.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.TAIL_SPIKES.code(), Allele.DOMINANT)
        );
    }
}
