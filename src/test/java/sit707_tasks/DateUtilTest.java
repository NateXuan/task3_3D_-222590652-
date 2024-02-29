package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222590652";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Wenzong Xuan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("January1ShouldIncrementToJanuary2 >" + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2, date.getDay());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("January1ShouldDecrementToDecember31 >" + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(2023, date.getYear());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	@Test
	public void testIncrementFromDecember15ToDecember16() {
		DateUtil date = new DateUtil(15, 12, 1994);
	    System.out.println("December15houldIncrementToDecember16 >" + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	@Test 
	//leap year
	public void testLeapYearFebruary28ShouldIncrementToFebruary29() {
		DateUtil date = new DateUtil(28, 2, 2024);
	    System.out.println("February28ShouldIncrementToFebruary29 >" + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(29, date.getDay());
	}
	
	@Test
	public void testInvalidYearLowerBoundary() {
	    new DateUtil(1, 1, 1699); 
	}

	@Test
	public void testInvalidYearUpperBoundary() {
	    new DateUtil(31, 12, 2025); 
	}

	@Test
	public void testFebruaryNonLeapYear() {
	    new DateUtil(29, 2, 2023); 
	}
	
	//Apr, Jun, Sep, Nov have date 30.
	@Test
    public void test30DaysMonthsAprilJuneSeptemberNovember30() {
        DateUtil dateApril = new DateUtil(30, 4, 2024);
        Assert.assertEquals("30 April 2024", dateApril.toString());
        DateUtil dateJune = new DateUtil(30, 6, 2024);
        Assert.assertEquals("30 June 2024", dateJune.toString());
        DateUtil dateSeptember = new DateUtil(30, 9, 2024);
        Assert.assertEquals("30 September 2024", dateSeptember.toString());
        DateUtil dateNovember = new DateUtil(30, 11, 2024);
        Assert.assertEquals("30 November 2024", dateNovember.toString());
    }
	
	//Apr, Jun, Sep, Nov haven't date 31.
	@Test
    public void test30DaysMonthsAprilJuneSeptemberNovember31() {
        new DateUtil(31, 4, 2024);
        new DateUtil(31, 6, 2024);
        new DateUtil(31, 9, 2024);
        new DateUtil(31, 11, 2024);
    }
	
	//Jan, Mar, May, Jul, Aug, Oct, Dec have data 31.
	@Test
    public void test31DaysMonthsJanuaryMarchMayJulyAugustOctoberDecember31() {
        DateUtil dateJanuary = new DateUtil(31, 1, 2024);
        Assert.assertEquals("31 January 2024", dateJanuary.toString());
        DateUtil dateMarch = new DateUtil(31, 3, 2024);
        Assert.assertEquals("31 March 2024", dateMarch.toString());
        DateUtil dateMay = new DateUtil(31, 5, 2024);
        Assert.assertEquals("31 May 2024", dateMay.toString());
        DateUtil dateJuly = new DateUtil(31, 7, 2024);
        Assert.assertEquals("31 July 2024", dateJuly.toString());
        DateUtil dateAugust = new DateUtil(31, 8, 2024);
        Assert.assertEquals("31 August 2024", dateAugust.toString());
        DateUtil dateOctober = new DateUtil(31, 10, 2024);
        Assert.assertEquals("31 October 2024", dateOctober.toString());
        DateUtil dateDecember = new DateUtil(31, 12, 2024);
        Assert.assertEquals("31 December 2024", dateDecember.toString());
    }
}
