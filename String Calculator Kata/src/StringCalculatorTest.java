import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class StringCalculatorTest {
    private StringCalculator sc;

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        sc = new StringCalculator();
    }

    public void emptyString() throws Exception{
        assertEquals(sc.add(""), 0);
    }
   
    public void oneNumber() throws Exception{
        assertEquals(sc.add("1"), 1);
    } 
    
    public void twoNumbers() throws Exception{
        assertEquals(sc.add("1,2"), 3);
    }
    
    public void multipleNumbers() throws Exception{
        assertEquals(sc.add("1,2,3,4"), 10);
    }
    public void addNumbersAndCharacters() throws Exception{
    	assertEquals(sc.add("1,2,a,c"),7);
    }
    @Test(expectedExceptions=Exception.class)
    public void negativeNumberReturnException() throws Exception
    {
    	 assertEquals(sc.add("10,-17,20"), "Negatives are not allowed -17");
    }
    
    public void ignoreNumbersGreaterThan1000() throws Exception {
    	assertEquals(sc.add("10,20,1002"), 30);
    }
    
    @org.testng.annotations.AfterMethod
    public void tearDown() {
        System.out.println("Completed");
    }
}