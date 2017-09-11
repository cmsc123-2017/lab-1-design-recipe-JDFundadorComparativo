import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ItemTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testFareChange() {
    //money, howMany, distance, withDiscount
    Item i = new Item();
    assertEquals(i.fareChange(10, 1, 4, 1), 4.0);
    assertEquals(i.fareChange(21, 3, 5, 0), 0.0);
    assertEquals(i.fareChange(20, 2, 7, 1), 5.0);
    assertEquals(i.fareChange(40, 7, 10, 3), 0.0);
    assertEquals(i.fareChange(35, 5, 4.6, 3), 3.0);
    assertEquals(i.fareChange(100, 1, 10, 0), 90.50);
    assertEquals(i.fareChange(50, 3, 8, 3), 27.50);
  }
  public void testSalePrice1000(){
    Item i = new Item();
    assertEquals(i.salePrice1000(1001.0, 0.10), 900.9);
    assertEquals(i.salePrice1000(2500.0, .50), 1250.0);
    assertEquals(i.salePrice1000(3290.0, .227), 2543.17);
    assertEquals(i.salePrice1000(2.0, 11.11), 2.0);
    assertEquals(i.salePrice1000(1000.01, 0.08), 920.0092);
    assertEquals(i.salePrice1000(999.99, 20), 999.99);
    assertEquals(i.salePrice1000(2017.0, .20), 1613.6);
  
  }
  
}
