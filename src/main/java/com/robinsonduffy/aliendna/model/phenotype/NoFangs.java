package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Markers;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class NoFangs extends AbstractPhenotype{
    @Override
    public String getName() {
        return "No Fangs";
    }

    @Override
    public String getDetails() {
        return "Has no visible fangs";
    }

    @Override
    public List<Pair<String, Allele>> getExpression() {
        return Arrays.asList(
            new ImmutablePair<>(Markers.FANGS, Allele.RECESSIVE)
        );
    }
}