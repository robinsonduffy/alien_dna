package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Sequence;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public abstract class AbstractPhenotype {
    public abstract String getName();
    public abstract String getDetails();
    public abstract List<Pair<String, Allele>> getExpression();

    /*
     * This determines of the phenotype is expressed by the sequence
     * (which may include other traits not related to this phenotype)
     */
    public boolean isExpressed(final Sequence sequence) {
        for (Pair<String, Allele> expression : getExpression()) {
            if (!sequence.getMarkers().contains(expression.getLeft())) {
                return false;
            }
            if (!sequence.getTrait(expression.getLeft()).getExpression().equals(expression.getRight())) {
                return false;
            }
        }
        return true;
    }

    /*
     * This determines of the phenotype is expressed by the sequence
     * (and that no other traits unrelated to this phenotype are included in the sequence)
     */
    public boolean isStrictlyExpressed(final Sequence sequence) {
        if (sequence.getMarkers().size() != getExpression().size()) {
            return false;
        }
        return isExpressed(sequence);
    }
}
