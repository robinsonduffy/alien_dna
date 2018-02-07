package com.robinsonduffy.aliendna.repository;

import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import org.springframework.data.repository.CrudRepository;

public interface OrganismRepository extends CrudRepository<AbstractOrganism, Long>{
}
