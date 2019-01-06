package com.robinsonduffy.aliendna.controller;

import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import com.robinsonduffy.aliendna.model.organism.Monster;
import com.robinsonduffy.aliendna.model.organism.Slug;
import com.robinsonduffy.aliendna.service.OrganismService;
import com.robinsonduffy.aliendna.service.renderer.SlugRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ImageController {
    private SlugRenderer slugRenderer;
    private OrganismService organismService;

    @Autowired
    ImageController(final SlugRenderer slugRenderer, final OrganismService organismService){
        this.slugRenderer = slugRenderer;
        this.organismService = organismService;
    }

    @RequestMapping("/image")
    @ResponseBody
    public void greeting(@RequestParam(value="sequence") final String sequenceString, final HttpServletResponse response) throws IOException {
        Sequence sequence = Sequence.fromString(sequenceString);
        Slug slug = new Slug(sequence);

        AbstractOrganism testThis = organismService.create(new Monster(Sequence.fromString("[AA, AAaa, bb]")));

        final AbstractOrganism test = organismService.getById(1L);

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(slugRenderer.render(slug), "png", os);
        os.flush();
        os.close();
    }
}
