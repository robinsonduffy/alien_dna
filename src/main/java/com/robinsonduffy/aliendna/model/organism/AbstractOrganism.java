package com.robinsonduffy.aliendna.model.organism;

import com.robinsonduffy.aliendna.model.HasId;
import com.robinsonduffy.aliendna.model.genotype.Sequence;
import org.hibernate.annotations.Type;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance
@DiscriminatorColumn(name = "organism_type")
@Table(name = "organism")
public class AbstractOrganism implements Organism, HasId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Type(type = "com.robinsonduffy.aliendna.hibernate.SequenceType")
    private Sequence sequence;

    AbstractOrganism() {}

    public AbstractOrganism(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public Sequence getSequence() {
        return sequence;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
