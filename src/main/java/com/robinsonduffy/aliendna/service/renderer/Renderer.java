package com.robinsonduffy.aliendna.service.renderer;

import com.robinsonduffy.aliendna.model.organism.Organism;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface Renderer<T extends Organism> {
    BufferedImage render(T organism) throws IOException;
}
