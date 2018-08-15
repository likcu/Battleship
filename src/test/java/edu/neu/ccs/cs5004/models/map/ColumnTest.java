package edu.neu.ccs.cs5004.models.map;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {

  private Column column1;
  private Column column2;
  private Column column3;
  private Column column4;
  private Column column5;
  private Column column6;
  private Column column7;
  private Column column8;
  private Column column9;
  private Column column10;

  @Before
  public void setUp() throws Exception {
    column1 = Column.A;
    column2 = Column.B;
    column3 = Column.C;
    column4 = Column.D;
    column5 = Column.E;
    column6 = Column.F;
    column7 = Column.G;
    column8 = Column.H;
    column9 = Column.I;
    column10 = Column.J;
  }


  @Test
  public void value() {
    Assert.assertEquals(column1, Column.valueOf("A"));
    Assert.assertEquals(column2, Column.valueOf("B"));
    Assert.assertEquals(column3, Column.valueOf("C"));
    Assert.assertEquals(column4, Column.valueOf("D"));
    Assert.assertEquals(column5, Column.valueOf("E"));
    Assert.assertEquals(column6, Column.valueOf("F"));
    Assert.assertEquals(column7, Column.valueOf("G"));
    Assert.assertEquals(column8, Column.valueOf("H"));
    Assert.assertEquals(column9, Column.valueOf("I"));
    Assert.assertEquals(column10, Column.valueOf("J"));
  }
}