package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.genotype.markers.MarkersEnum;

import java.lang.reflect.ParameterizedType;
import java.util.EnumSet;
import java.util.Set;

public class AbstractOrganism implements Organism {
    private Sequence sequence;

    public AbstractOrganism(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public Sequence getSequence() {
        return sequence;
    }
}
