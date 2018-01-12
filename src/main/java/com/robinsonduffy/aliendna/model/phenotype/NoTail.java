package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class NoTail extends AbstractPhenotype{
    @Override
    public String getName() {
        return "No Tail";
    }

    @Override
    public String getDetails() {
        return "Does not have a tail";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
            new ImmutablePair<>(Markers.TAIL, Allele.RECESSIVE)
        );
    }
}
