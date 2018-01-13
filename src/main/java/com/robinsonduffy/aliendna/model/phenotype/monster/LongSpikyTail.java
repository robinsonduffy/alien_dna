package com.robinsonduffy.aliendna.model.phenotype.monster;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.markers.MonsterMarkers;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class LongSpikyTail extends AbstractPhenotype {
    @Override
    public String getName() {
        return "Long Spiky Tail";
    }

    @Override
    public String getDetails() {
        return "Has a long tail with spikes";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
                new ImmutablePair<>(MonsterMarkers.TAIL.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.TAIL_LENGTH.code(), Allele.DOMINANT),
                new ImmutablePair<>(MonsterMarkers.TAIL_SPIKES.code(), Allele.RECESSIVE)
        );
    }
}
