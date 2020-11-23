package starter.examples;

import net.serenitybdd.junit5.StepsInjectorTestInstancePostProcessor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.params.provider.EnumSource;
import starter.domain.Books;
import starter.steps.SampleNonWebSteps;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleDataDrivenTest {

    @Steps
    public SampleNonWebSteps steps;

    @ParameterizedTest(name = "run {index} with {arguments}")
    @ValueSource(strings = { "Hello", "JUnit" })
    public void withValueSource(String word) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        assertNotNull(word);
    }

    @ParameterizedTest(name= "test with integers {index}")
    @ValueSource(ints = { 1,2 })
    public void withValueSourceIntegers(int number) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
    }





}
