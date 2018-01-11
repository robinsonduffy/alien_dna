package com.robinsonduffy.aliendna.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TraitTest {

    @DataProvider(name = "toStringProvider")
    public static Object[][] toStringProvider() {

        return new Object[][] {
                { "A", Allele.DOMINANT, Allele.DOMINANT, "AA" },
                { "A", Allele.DOMINANT, Allele.RECESSIVE, "Aa" },
                { "A", Allele.RECESSIVE, Allele.RECESSIVE, "aa" },
                { "A", Allele.RECESSIVE, Allele.DOMINANT, "Aa" },
                { "B", Allele.DOMINANT, Allele.RECESSIVE, "Bb" },
        };

    }
    @Test(dataProvider = "toStringProvider")
    public void test_toString(String marker, Allele allele1, Allele allele2, String expectedResult){
        final Trait trait = new Trait(marker, allele1, allele2);
        assertEquals(trait.toString(), expectedResult);
    }

    @DataProvider(name = "nonAlphaMarkerProvider")
    public static Object[][] nonAlphaMarkerProvider() {
        return new Object[][] {
                {"a1"},
                {"1"},
                {"abcd1"},
                {"a1a"},
                {"1~abs"},
                {"1ab"},
                {null}
        };
    }
    @Test(dataProvider = "nonAlphaMarkerProvider",
            expectedExceptions = {IllegalArgumentException.class})
    public void test_nonAlphaMarker(String marker){
        new Trait(marker);
    }

    @DataProvider(name = "alphaMarkerProvider")
    public static Object[][] alphaMarkerProvider() {
        return new Object[][] {
                {"A", "A"},
                {"a", "A"},
                {"abcd", "ABCD"},
                {"aB", "AB"},
                {"b", "B"}
        };
    }
    @Test(dataProvider = "alphaMarkerProvider")
    public void test_alphaMarker(String marker, String expectedResult){
        final Trait trait = new Trait(marker);
        assertEquals(trait.getMarker(), expectedResult);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void test_nullAlleles(){
        new Trait("A", null);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void test_nullAllele_left(){
        new Trait("A", null, Allele.DOMINANT);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void test_nullAllele_right(){
        new Trait("A", Allele.DOMINANT, null);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void test_nullAllele_both(){
        new Trait("A", null, null);
    }

    @Test
    public void test_equals_true() {
        assertEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                new Trait("A", Allele.RECESSIVE, Allele.DOMINANT));

        assertEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
    }

    @Test
    public void test_equals_false() {
        assertNotEquals(new Trait("A", Allele.DOMINANT, Allele.DOMINANT),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));

        assertNotEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE),
                new Trait("B", Allele.DOMINANT, Allele.RECESSIVE));
    }

    @Test
    public void test_equals_null() {
        Trait trait = new Trait("A");
        assertFalse(trait.equals(null));
    }

    @Test
    public void test_equals_same() {
        Trait trait = new Trait("A");
        assertTrue(trait.equals(trait));
    }

    @Test
    public void test_hashCode_same() {
        assertEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE).hashCode(),
                new Trait("A", Allele.RECESSIVE, Allele.DOMINANT).hashCode());

        assertEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE).hashCode(),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE).hashCode());
    }

    @Test
    public void test_hashCode_different() {
        assertNotEquals(new Trait("A", Allele.DOMINANT, Allele.DOMINANT).hashCode(),
                new Trait("A", Allele.DOMINANT, Allele.RECESSIVE).hashCode());

        assertNotEquals(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE).hashCode(),
                new Trait("B", Allele.DOMINANT, Allele.RECESSIVE).hashCode());
    }

    @DataProvider(name = "getExpressionProvider")
    public static Object[][] getExpressionProvider() {

        return new Object[][] {
                { "A", Allele.DOMINANT, Allele.DOMINANT, Allele.DOMINANT },
                { "A", Allele.DOMINANT, Allele.RECESSIVE, Allele.DOMINANT },
                { "A", Allele.RECESSIVE, Allele.RECESSIVE, Allele.RECESSIVE },
                { "A", Allele.RECESSIVE, Allele.DOMINANT, Allele.DOMINANT },
                { "B", Allele.DOMINANT, Allele.RECESSIVE, Allele.DOMINANT }
        };
    }
    @Test(dataProvider = "getExpressionProvider")
    public void test_getExpression(String marker, Allele allele1, Allele allele2, Allele expectedResult) {
        final Trait trait = new Trait(marker, allele1, allele2);
        assertEquals(trait.getExpression(), expectedResult);
    }

    @DataProvider(name = "fromStringProvider")
    public static Object[][] fromStringProvider() {
        return new Object[][] {
                {"Aa"},
                {"AA"},
                {"aa"},
                {"AAaa"},
                {"ABCabc"}
        };
    }
    @Test(dataProvider = "fromStringProvider")
    public void test_fromString(String traitString) {
        assertEquals(Trait.fromString(traitString).toString(), traitString);
    }

    @DataProvider(name = "fromStringBadProvider")
    public static Object[][] fromStringBadProvider() {
        return new Object[][] {
                {"Ab"},
                {"AAA"},
                {"ABcabc"},
                {" "},
                {" A a"},
                {null},
                {""},
                {"A"}
        };
    }
    @Test(dataProvider = "fromStringBadProvider",
            expectedExceptions = {IllegalArgumentException.class})
    public void test_fromStringBad(String traitString) {
        Trait.fromString(traitString);
    }


}