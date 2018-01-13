package com.robinsonduffy.aliendna.model.genotype;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.PunnettSquare;
import com.robinsonduffy.aliendna.model.genotype.Trait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PunnettSquareTest {

    @DataProvider(name = "traitsProvider")

    public static Object[][] traitsProvider() {
        return new Object[][] {
                {
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    "[AA, AA, AA, AA]"
                },
                {
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    "[AA, AA, Aa, Aa]"
                },
                {
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    "[Aa, Aa, Aa, Aa]"
                },
                {
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    "[AA, AA, Aa, Aa]"
                },
                {
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    "[AA, Aa, Aa, aa]"
                },
                {
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    "[Aa, Aa, aa, aa]"
                },
                {
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                    "[Aa, Aa, Aa, Aa]"
                },
                {
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                    "[Aa, Aa, aa, aa]"
                },
                {
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    new Trait("A", Allele.RECESSIVE, Allele.RECESSIVE),
                    "[aa, aa, aa, aa]"
                }
        };

    }
    @Test(dataProvider = "traitsProvider")
    public void test_AABB(Trait trait1, Trait trait2, String expectedTraits){
        final PunnettSquare punnettSquare = new PunnettSquare(trait1, trait2);

        Assert.assertEquals(punnettSquare.toString(), expectedTraits);
    }

    @DataProvider(name = "nullTraitsProvider")
    public static Object[][] nullTraitsProvider() {
        return new Object[][] {
                {null, null},
                {new Trait("A"), null},
                {null, new Trait("A")}
        };
    }
    @Test(dataProvider = "nullTraitsProvider",
            expectedExceptions = {IllegalArgumentException.class})
    public void test_nullTraits(Trait trait1, Trait trait2) {
        new PunnettSquare(trait1, trait2);
    }

    @Test
    public void test_equals_true() {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        PunnettSquare punnettSquare2 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertTrue(punnettSquare1.equals(punnettSquare2));
    }

    @Test
    public void test_equals_same () {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertTrue(punnettSquare1.equals(punnettSquare1));
    }

    @Test
    public void test_equals_null () {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertFalse(punnettSquare1.equals(null));
    }

    @Test
    public void test_equals_false() {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        PunnettSquare punnettSquare2 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertFalse(punnettSquare1.equals(punnettSquare2));
    }

    @Test
    public void test_hashCode_same() {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        PunnettSquare punnettSquare2 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertEquals(punnettSquare1.hashCode(), punnettSquare2.hashCode());
    }

    @Test
    public void test_hashCode_different() {
        PunnettSquare punnettSquare1 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        PunnettSquare punnettSquare2 = new PunnettSquare(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        Assert.assertNotEquals(punnettSquare1.hashCode(), punnettSquare2.hashCode());
    }



}