package com.robinsonduffy.aliendna.service.resolver;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.organism.AbstractOrganism;
import com.robinsonduffy.aliendna.model.phenotype.AbstractPhenotype;
import com.robinsonduffy.aliendna.model.phenotype.Phenotype;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AbstractResolverTest {

    @Test
    public void test_resolvePhenotypes() {
        Phenotype testPhenotypeA = new TestPhenotypeA();
        Phenotype testPhenotypeB1 = new TestPhenotypeB1();
        Phenotype testPhenotypeB2 = new TestPhenotypeB2();
        final List<Phenotype> phenoTypes = Arrays.asList(testPhenotypeA, testPhenotypeB1, testPhenotypeB2);
        final TestResolver testResolver = new TestResolver(phenoTypes);
        final Sequence testSequence = Sequence.fromString("[Aa,bb]");
        final TestOrganism testOrganism = new TestOrganism(testSequence);

        final List<Phenotype> resolvedPhenotypes = testResolver.resolvePhenotypes(testOrganism);

        assertEquals(resolvedPhenotypes.size(), 2);
        assertTrue(resolvedPhenotypes.containsAll(Arrays.asList(testPhenotypeA, testPhenotypeB2)));
    }

    class TestOrganism extends AbstractOrganism {
        TestOrganism(Sequence sequence) {
            super(sequence);
        }
    }

    class TestResolver extends AbstractResolver<TestOrganism> {
        public TestResolver(List<Phenotype> phenotypes) {
            super(phenotypes);
        }
    }

    class TestPhenotypeA extends AbstractPhenotype {

        @Override
        public String getDetails() {
            return null;
        }

        @Override
        public List<Pair<String, Allele>> getExpression() {
            return Arrays.asList(
                    new ImmutablePair<>("A", Allele.DOMINANT)
            );
        }
    }

    class TestPhenotypeB1 extends AbstractPhenotype {

        @Override
        public String getDetails() {
            return null;
        }

        @Override
        public List<Pair<String, Allele>> getExpression() {
            return Arrays.asList(
                    new ImmutablePair<>("B", Allele.DOMINANT)
            );
        }
    }

    class TestPhenotypeB2 extends AbstractPhenotype {

        @Override
        public String getDetails() {
            return null;
        }

        @Override
        public List<Pair<String, Allele>> getExpression() {
            return Arrays.asList(
                    new ImmutablePair<>("B", Allele.RECESSIVE)
            );
        }
    }
}