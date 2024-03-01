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
        DateUtil date = new DateUtil(31, 1, 2024, 23, 59, 59);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024, 0, 0, 0);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
	
	@Test
	public void testNominalJanuary() {
        int randDay = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(randDay, 1, 2024, 12, 30, 30);
        System.out.println("Before nominal case increment: " + date);
        date.increment();
        System.out.println("After nominal case increment: " + date);
    }
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024, 0, 0, 1);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(2, date.getDay());
    }
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024, 23, 59, 58);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }
	
	@Test
	public void testIncrementFromDecember15ToDecember16() {
        DateUtil date = new DateUtil(15, 12, 1994, 11, 59, 59);
        System.out.println("Before increment from December 15 to December 16: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(16, date.getDay());
    }
	
	@Test 
	//leap year
	public void testLeapYearFebruary28ShouldIncrementToFebruary29() {
        DateUtil date = new DateUtil(28, 2, 2024, 23, 59, 59);
        System.out.println("Before leap year February 28 increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
        Assert.assertEquals(29, date.getDay());
    }
	
	@Test
	public void testInvalidDateException() {
        new DateUtil(32, 1, 2024, 24, 0, 0);
    }
	
	@Test
	public void testTimeIncrementToNextDay() {
        DateUtil date = new DateUtil(1, 1, 2024, 23, 59, 59);
        System.out.println("Before time increment to next day: " + date);
        date.increment();
        System.out.println("After time increment: " + date);
        Assert.assertEquals(2, date.getDay());
    }

	@Test
	public void testTimeDecrementToPreviousDay() {
        DateUtil date = new DateUtil(2, 1, 2024, 0, 0, 0);
        System.out.println("Before time decrement to previous day: " + date);
        date.decrement();
        System.out.println("After time decrement: " + date);
        Assert.assertEquals(1, date.getDay());
    }
}
