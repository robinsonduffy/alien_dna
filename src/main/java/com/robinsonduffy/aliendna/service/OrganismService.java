package com.robinsonduffy.aliendna.service;

import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import com.robinsonduffy.aliendna.repository.OrganismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganismService extends AbstractDataService<AbstractOrganism>{

    @Autowired
    public OrganismService(final OrganismRepository repository) {
        this.repository = repository;
    }
}
