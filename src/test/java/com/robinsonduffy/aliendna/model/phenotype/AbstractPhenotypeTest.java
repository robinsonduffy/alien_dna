package com.robinsonduffy.aliendna.model.phenotype;

import com.robinsonduffy.aliendna.model.Allele;
import com.robinsonduffy.aliendna.model.Sequence;
import com.robinsonduffy.aliendna.model.Trait;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AbstractPhenotypeTest {
    @DataProvider(name = "isExpressedProvider")
    public static Object[][] isExpressedProvider() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A", Allele.DOMINANT, Allele.DOMINANT));
        sequence1.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence2.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence3 = new Sequence();
        sequence3.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence3.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));
        sequence3.add(new Trait("C"));

        Sequence sequence4 = new Sequence();
        sequence4.add(new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE));
        sequence4.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence5 = new Sequence();
        sequence5.add(new Trait("C", Allele.DOMINANT, Allele.DOMINANT));
        sequence5.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence6 = new Sequence();
        sequence6.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence6.add(new Trait("B", Allele.DOMINANT, Allele.RECESSIVE));

        Sequence sequence7 = new Sequence();
        sequence7.add(new Trait("A", Allele.DOMINANT, Allele.DOMINANT));

        Sequence sequence8 = new Sequence();

        return new Object[][] {
                { sequence1, true },
                { sequence2, true },
                { sequence3, true },
                { sequence4, false },
                { sequence5, false },
                { sequence6, false },
                { sequence7, false },
                { sequence8, false }
        };
    }
    @Test(dataProvider = "isExpressedProvider")
    public void test_isExpressed(Sequence sequence, boolean expectedResult) {
        TestPhenotype testPhenotype = new TestPhenotype();
        assertEquals(testPhenotype.isExpressed(sequence), expectedResult);
    }

    @DataProvider(name = "isExpressedStrictlyProvider")
    public static Object[][] isExpressedStrictlyProvider() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A", Allele.DOMINANT, Allele.DOMINANT));
        sequence1.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence2.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence3 = new Sequence();
        sequence3.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence3.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));
        sequence3.add(new Trait("C"));

        Sequence sequence4 = new Sequence();
        sequence4.add(new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE));
        sequence4.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence5 = new Sequence();
        sequence5.add(new Trait("C", Allele.DOMINANT, Allele.DOMINANT));
        sequence5.add(new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE));

        Sequence sequence6 = new Sequence();
        sequence6.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence6.add(new Trait("B", Allele.DOMINANT, Allele.RECESSIVE));

        Sequence sequence7 = new Sequence();
        sequence7.add(new Trait("A", Allele.DOMINANT, Allele.DOMINANT));

        Sequence sequence8 = new Sequence();

        return new Object[][] {
                { sequence1, true },
                { sequence2, true },
                { sequence3, false },
                { sequence4, false },
                { sequence5, false },
                { sequence6, false },
                { sequence7, false },
                { sequence8, false }
        };
    }
    @Test(dataProvider = "isExpressedStrictlyProvider")
    public void test_isStrictlyExpressed(Sequence sequence, boolean expectedResult) {
        TestPhenotype testPhenotype = new TestPhenotype();
        assertEquals(testPhenotype.isStrictlyExpressed(sequence), expectedResult);
    }

    class TestPhenotype extends AbstractPhenotype {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getDetails() {
            return null;
        }

        @Override
        public List<Pair<String, Allele>> getExpression() {
            return Arrays.asList(
                    new ImmutablePair<>("A", Allele.DOMINANT),
                    new ImmutablePair<>("B", Allele.RECESSIVE)
            );
        }
    }

}