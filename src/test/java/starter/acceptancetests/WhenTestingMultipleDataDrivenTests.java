package starter.acceptancetests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.testng.SerenityTestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import starter.steps.SampleSteps;

import static org.testng.Assert.assertNotNull;

@SerenityTestNG
public class WhenTestingMultipleDataDrivenTests {

    @Steps
    public SampleSteps steps;

    @Test(dataProvider="stringDataProvider",testName = "Parameterized test using string provider")
    public void withValueSource(String word) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        assertNotNull(word);
    }

    @DataProvider
	public Object[][] stringDataProvider() {
	 return new Object[][] {
	   { "Hello" },
	   { "Test-NG"},
	 };
	}

	@Test(dataProvider="intDataProvider",testName = "Parameterized test using integer provider")
    public void withValueSourceIntegers(int number) {
        steps.stepThatSucceeds();
    }

    @DataProvider
	public Object[][] intDataProvider() {
	 return new Object[][] {
	   { 1 },
	   { 2 },
	   { 3 },
	 };
	}


}
