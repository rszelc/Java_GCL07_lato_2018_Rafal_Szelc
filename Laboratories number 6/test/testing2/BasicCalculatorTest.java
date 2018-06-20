/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing2;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Rafał
 */
@RunWith(Parameterized.class)
public class BasicCalculatorTest {
    
    private BasicCalculator basicCalculator;
    @Parameter(0)
    public double m1;
    @Parameter(1)
    public double m2;
    @Parameter(2)
    public double result;
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 2.0 , 4.0, 8.0 }, { 5.0, 3.0, 15.0}, { 11.0, 11.0, 121.0 } };
        return Arrays.asList(data);
    }


	
    @Before
    public void createObject()
    {
		basicCalculator= new BasicCalculator();
		

    }
 
    @After
   public void cleanUp()
   {
   }
 
   @BeforeClass
   public static void setUpClass()
   {
    	System.out.println("Test start");
   }
 
    @AfterClass
    public static void cleanUpClass()
    {
    	System.out.println("End of test");
    }
    
  
   
    @Test
    public void testSum1()
    {
    	assertEquals(25.0,basicCalculator.calculateSum(5,20),0);
    }
    @Test
    public void testSum2()
    {
    	assertNotNull(basicCalculator.calculateSum(5,20));
    }
    @Test
    public void testSum3()
    {
    	assertNotEquals(20.0,basicCalculator.calculateSum(5,20));
    }
   
    @Test
    public void testDifference1()
    {
    	assertEquals(-15.0,basicCalculator.calculateDifference(5,20),0);
    }
    @Test
    public void testDifference2()
    {
    	assertTrue(-18.0<basicCalculator.calculateDifference(5,20));
    }
    @Test
    public void testDifference3()
    {
    	assertNotEquals(-4.0,basicCalculator.calculateDifference(5,20));
    }
    @Test
    public void testMultiplication1()
    {
    	assertEquals(result,basicCalculator.calculateMultiplication(m1,m2),0);
    }
    @Test
    public void testMultiplication2()
    {
    	assertFalse(1000.0<basicCalculator.calculateDifference(m1,m2));
    }
    @Test
    public void testMultiplication3()
    {
    	
    	assertNotEquals(70.0,basicCalculator.calculateMultiplication(m1,m2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivision1()
    {
    	assertEquals(4.0,basicCalculator.calculateDivision(20,0),0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivision2()
    {
    	assertFalse(5.0<basicCalculator.calculateDivision(20,0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivision3()
    {
    	assertTrue(4.0==basicCalculator.calculateDivision(20,0));
    }
    @Test
    public void testPow1()
    {
    	assertEquals(8.0,basicCalculator.calculatePow(2,3),0);
    }
    @Test
    public void testPow2()
    {
    	assertTrue(8.0==basicCalculator.calculatePow(2,3));
    }
    @Test
    public void testPow3()
    {
    	assertNotEquals(7.0,basicCalculator.calculatePow(2,3));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSqrt1()
    {
    	
    	assertEquals(2.0,basicCalculator.calculateSqrt(-4), 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSqrt2()
    {
    	
    	assertNotEquals(3.0,basicCalculator.calculateSqrt(-4));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSqrt3()
    {
    	
    	assertFalse(4.0==basicCalculator.calculateSqrt(-4));
    }
    
    
}
