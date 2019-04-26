package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;
public class TestAnnotationTest {

    @BeforeSuite
    public void BeforeTestSuiteTest()
    {
        System.out.println("in BeforeSuite");
    }
    @AfterSuite
    public void AfterTestSuiteTest()
    {
        System.out.println("in AfterSuite");

    }

    @BeforeTest
    public void beforeTestingTest()
    {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTestingTest()
    {
        System.out.println("After Test");
    }

    @BeforeMethod
    public void beforeMethodTest()
    {
        System.out.println("Before Method");
    }

    @AfterMethod

    public void afterMethodTest()
    {
        System.out.println("After Method");


    }

    @Test
    public void ATest()
    {
        System.out.println("ATest");
        //assertTrue(false);
    }

    @Test
    public void BTest()
    {
        System.out.println("BTest");
    }
}

