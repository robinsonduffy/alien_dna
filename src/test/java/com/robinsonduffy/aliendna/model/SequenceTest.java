package com.robinsonduffy.aliendna.model;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SequenceTest {

    @Test
    public void test_add() {
        Sequence sequence = new Sequence();
        Trait testTrait = new Trait("A");
        sequence.add(testTrait);
        assertTrue(sequence.getTraits().contains(testTrait));
    }

    @Test
    public void test_addDuplicate_Different() {
        Sequence sequence = new Sequence();
        Trait traitA = new Trait("A");
        Trait traitB = new Trait("B");
        sequence.add(traitA);
        sequence.add(traitB);
        assertTrue(sequence.getTraits().contains(traitA));
        assertTrue(sequence.getTraits().contains(traitB));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void test_addDuplicate_Same() {
        Sequence sequence = new Sequence();
        Trait traitA1 = new Trait("A");
        Trait traitA2 = new Trait("A");
        sequence.add(traitA1);
        sequence.add(traitA2);
    }

    @Test
    public void test_toString() {
        Trait traitA = new Trait("A", Allele.DOMINANT, Allele.DOMINANT);
        Trait traitB = new Trait("B", Allele.RECESSIVE, Allele.RECESSIVE);
        Trait traitAA = new Trait("AA", Allele.DOMINANT, Allele.RECESSIVE);
        Sequence sequence = new Sequence();
        sequence.add(traitB);
        sequence.add(traitAA);
        sequence.add(traitA);

        assertEquals(sequence.toString(), "[AA, AAaa, bb]");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void test_from_bad1() {
        Trait traitA = new Trait("A");
        Trait traitB = new Trait("B");
        Sequence sequence1 = new Sequence();
        sequence1.add(traitA);
        Sequence sequence2 = new Sequence();
        sequence2.add(traitB);
        Sequence.from(sequence1, sequence2);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void test_from_bad2() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A"));
        sequence1.add(new Trait("B"));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A"));
        Sequence.from(sequence1, sequence2);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void test_from_bad3() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A"));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A"));
        sequence2.add(new Trait("B"));
        Sequence.from(sequence1, sequence2);
    }

    @Test
    public void test_from_good() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A"));
        sequence1.add(new Trait("B"));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A"));
        sequence2.add(new Trait("B"));
        Sequence sequence = Sequence.from(sequence1, sequence2);
        assertNotNull(sequence);
        assertEquals(sequence.getMarkers().toArray(), new String[] {"A", "B"});
    }

    @Test
    public void test_getMarkers() {
        Sequence sequence = new Sequence();
        sequence.add(new Trait("C"));
        sequence.add(new Trait("A"));
        sequence.add(new Trait("B"));
        assertEquals(sequence.getMarkers().toArray(), new String[] {"A", "B", "C"} );
    }

    @Test
    public void test_getTrait_good() {
        Sequence sequence = new Sequence();
        Trait traitA = new Trait("A");
        Trait traitB = new Trait("B");
        sequence.add(traitA);
        sequence.add(traitB);
        assertEquals(sequence.getTrait("B"), traitB);
        assertEquals(sequence.getTrait("A"), traitA);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void test_getTrait_bad() {
        Sequence sequence = new Sequence();
        Trait traitA = new Trait("A");
        sequence.add(traitA);
        sequence.getTrait("B");
    }
}