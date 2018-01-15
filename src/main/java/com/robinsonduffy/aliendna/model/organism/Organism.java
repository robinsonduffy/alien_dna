package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.genotype.markers.MarkersEnum;
import java.util.Set;

public interface Organism {
    Sequence getSequence();
}
