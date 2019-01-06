package com.robinsonduffy.aliendna.service.renderer;

import com.robinsonduffy.aliendna.model.organism.Slug;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import com.robinsonduffy.aliendna.service.resolver.SlugResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Service
public class SlugRenderer implements Renderer<Slug> {
    private SlugResolver slugResolver;

    @Autowired
    SlugRenderer(SlugResolver slugResolver) {
        this.slugResolver = slugResolver;
    }

    @Override
    public BufferedImage render(Slug slug) throws IOException {
        List<Phenotype> phenotypes = slugResolver.resolvePhenotypes(slug);

        BufferedImage bufferedImage = new BufferedImage(600,600, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        new ClassPathResource("paperdolls/red_circle.png").getFile();
        graphics.drawImage(ImageIO.read(new ClassPathResource("paperdolls/red_circle.png").getFile()), 0,0, null);
        graphics.drawImage(ImageIO.read(new ClassPathResource("paperdolls/blue_square.png").getFile()), 100,100, null);
        graphics.dispose();
        return bufferedImage;
    }
}
