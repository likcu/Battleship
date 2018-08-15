package edu.neu.ccs.cs5004.models.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {

  private Hit hit;
  private Hit sameRefHit;
  private Hit sameStateAsHit;
  private Hit yetAnotherHit;
  private Hit nullHit = null;

  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    sameRefHit = new Hit();
    sameStateAsHit = new Hit();
    yetAnotherHit = new Hit();
  }

  @Test
  public void equals() {
    Assert.assertTrue(hit.equals(hit)); // reflexivity
    Assert.assertTrue(hit.equals(sameRefHit)); // trivial condition both reference the same object
    Assert.assertTrue(hit.equals(sameStateAsHit)); // both objects should have the same state
    Assert.assertTrue(hit.equals(hit)); //symmetry
    Assert.assertEquals(hit.equals(sameStateAsHit) && sameStateAsHit.equals(yetAnotherHit), yetAnotherHit.equals(hit)); //transitivity
    Assert.assertFalse(hit.equals(nullHit)); // hit is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(hit.equals(sameRefHit), hit.hashCode() == sameRefHit.hashCode()); //same objects have the same hashCode
    Assert.assertEquals(hit.equals(sameStateAsHit), hit.hashCode() == sameStateAsHit.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Hit{}", hit.toString());
  }
}