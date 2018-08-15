package edu.neu.ccs.cs5004.models.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissTest {

  private Miss miss;
  private Miss sameRefMiss;
  private Miss sameStateAsMiss;
  private Miss yetAnotherMiss;
  private Miss nullMiss = null;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    sameRefMiss = new Miss();
    sameStateAsMiss = new Miss();
    yetAnotherMiss = new Miss();
  }

  @Test
  public void equals() {
    Assert.assertTrue(miss.equals(miss)); // reflexivity
    Assert.assertTrue(miss.equals(sameRefMiss)); // trivial condition both reference the same object
    Assert.assertTrue(miss.equals(sameStateAsMiss)); // both objects should have the same state
    Assert.assertTrue(miss.equals(miss)); //symmetry
    Assert.assertEquals(miss.equals(sameStateAsMiss) && sameStateAsMiss.equals(yetAnotherMiss), yetAnotherMiss.equals(miss)); //transitivity
    Assert.assertFalse(miss.equals(nullMiss)); // miss is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(miss.equals(sameRefMiss), miss.hashCode() == sameRefMiss.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(miss.equals(sameStateAsMiss), miss.hashCode() == sameStateAsMiss.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Miss{}", miss.toString());
  }
}