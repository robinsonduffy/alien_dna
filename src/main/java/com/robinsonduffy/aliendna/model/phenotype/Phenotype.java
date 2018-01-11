package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Sequence;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface Phenotype {
    public String getName();
    public String getDetails();
    public List<Pair<String, Allele>> getExpression();

    public boolean isExpressed(final Sequence sequence);
    public boolean isStrictlyExpressed(final Sequence sequence);
}
