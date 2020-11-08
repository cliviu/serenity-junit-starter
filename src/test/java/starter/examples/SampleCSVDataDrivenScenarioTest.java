package starter.examples;


import net.serenitybdd.junit5.StepsInjectorTestInstancePostProcessor;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import starter.steps.SampleNonWebSteps;


public class SampleCSVDataDrivenScenarioTest {

    private String name;
    private String age;
    private String address;

    public SampleCSVDataDrivenScenarioTest() {
    }

    /*@Qualifier
    public String getQualifier() {
        return name;
    }

    @Managed(driver="htmlunit")
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "classpath:static-site/index.html")
    public Pages pages;*/

    @Steps
    public SampleNonWebSteps steps;


    @ParameterizedTest(name = "Csv File Data Test {0}")
    @CsvFileSource(resources="/test-data/simple-data.csv",numLinesToSkip = 1)
    public void data_driven_test(String name, int age,String address) {
        System.out.println("data_driven_test: "+ name + " " + age + " " + address);
        steps.stepThatSucceeds();
    }

    @ParameterizedTest(name = "Another Csv File Data Test {0}")
    @CsvFileSource(resources="/test-data/simple-data.csv",numLinesToSkip = 1)
    public void another_data_driven_test(String name, int age,String address) {
        System.out.println("another data_driven_test: "+ name + " " + age + " " + address);
        steps.stepThatSucceeds();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
