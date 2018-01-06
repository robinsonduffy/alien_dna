package com.robinsonduffy.aliendna.model;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

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


}