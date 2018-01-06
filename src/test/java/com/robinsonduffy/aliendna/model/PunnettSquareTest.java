package com.robinsonduffy.aliendna.model;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class PunnettSquareTest {

    @DataProvider(name = "TraitsProvider")

    public static Object[][] TraitsProvider() {

        return new Object[][] { { "testuser_1", "Test@123",null }, { "testuser_1", "Test@123" ,null}};

    }

    @Test(dataProvider = "TraitsProvider", enabled = false)
    public void test_AABB(Trait trait1, Trait trait2, List<Trait> expectedTraits){
        final PunnettSquare punnettSquare = new PunnettSquare(trait1, trait2);

        //Assert.assertEquals(punnettSquare.getTraits(), expectedTraits);
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