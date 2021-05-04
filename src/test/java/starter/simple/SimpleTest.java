package starter.simple;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import starter.steps.SampleNonWebSteps;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Steps
    public SampleNonWebSteps steps;


    @Test
    @Tag("mytype:myTagName")
    public void testMethod1() {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
    }

    @Test
    public void testMethod2() {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
    }
}
