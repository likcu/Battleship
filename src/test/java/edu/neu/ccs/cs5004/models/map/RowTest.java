package edu.neu.ccs.cs5004.models.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {

  private Row row1;
  private Row row2;
  private Row row3;
  private Row row4;
  private Row row5;
  private Row row6;
  private Row row7;
  private Row row8;
  private Row row9;
  private Row row10;

  @Before
  public void setUp() throws Exception {
    row1 = Row.ONE;
    row2 = Row.TWO;
    row3 = Row.THREE;
    row4 = Row.FOUR;
    row5 = Row.FIVE;
    row6 = Row.SIX;
    row7 = Row.SEVEN;
    row8 = Row.EIGHT;
    row9 = Row.NINE;
    row10 = Row.TEN;
  }


  @Test
  public void value() {
    Assert.assertEquals(row1, Row.valueOf("ONE"));
    Assert.assertEquals(row2, Row.valueOf("TWO"));
    Assert.assertEquals(row3, Row.valueOf("THREE"));
    Assert.assertEquals(row4, Row.valueOf("FOUR"));
    Assert.assertEquals(row5, Row.valueOf("FIVE"));
    Assert.assertEquals(row6, Row.valueOf("SIX"));
    Assert.assertEquals(row7, Row.valueOf("SEVEN"));
    Assert.assertEquals(row8, Row.valueOf("EIGHT"));
    Assert.assertEquals(row9, Row.valueOf("NINE"));
    Assert.assertEquals(row10, Row.valueOf("TEN"));
  }
}