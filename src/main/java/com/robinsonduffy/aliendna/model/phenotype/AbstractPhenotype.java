package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.Sequence;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public abstract class AbstractPhenotype implements Phenotype {
    @Override
    public String getName() {
        return String.join(" ", StringUtils.splitByCharacterTypeCamelCase(this.getClass().getSimpleName()));
    }

    /*
     * This determines if the phenotype is expressed by the sequence
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
     * This determines if the phenotype is expressed by the sequence
     * (and that no other traits unrelated to this phenotype are included in the sequence)
     */
    public boolean isStrictlyExpressed(final Sequence sequence) {
        if (sequence.getMarkers().size() != getExpression().size()) {
            return false;
        }
        return isExpressed(sequence);
    }
}
