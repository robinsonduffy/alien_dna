package com.robinsonduffy.aliendna.model.genotype;

import com.robinsonduffy.aliendna.model.genotype.Allele;
import com.robinsonduffy.aliendna.model.genotype.Sequence;
import com.robinsonduffy.aliendna.model.genotype.Trait;
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

    @Test public void test_fromString() {
        final String testString = "[AA, AAaa, bb]";
        Sequence sequence = Sequence.fromString(testString);

        assertEquals(sequence.toString(), testString);
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

    @Test
    public void test_equals_true() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence1.add(new Trait("B", Allele.DOMINANT, Allele.DOMINANT));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence2.add(new Trait("B", Allele.DOMINANT, Allele.DOMINANT));

        assertTrue(sequence1.equals(sequence2));
    }

    @Test
    public void test_equals_false() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A"));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("B"));

        assertFalse(sequence1.equals(sequence2));
    }

    @Test
    public void test_equals_null() {
        Sequence sequence = new Sequence();
        assertFalse(sequence.equals(null));
    }

    @Test
    public void test_equals_same() {
        Sequence sequence = new Sequence();
        assertTrue(sequence.equals(sequence));
    }

    @Test
    public void test_hashCode_same() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence1.add(new Trait("B", Allele.DOMINANT, Allele.DOMINANT));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("A", Allele.DOMINANT, Allele.RECESSIVE));
        sequence2.add(new Trait("B", Allele.DOMINANT, Allele.DOMINANT));

        assertEquals(sequence1.hashCode(), sequence2.hashCode());
    }

    @Test
    public void test_hashCode_different() {
        Sequence sequence1 = new Sequence();
        sequence1.add(new Trait("A"));
        Sequence sequence2 = new Sequence();
        sequence2.add(new Trait("B"));


        assertNotEquals(sequence1.hashCode(), sequence2.hashCode());
    }

}