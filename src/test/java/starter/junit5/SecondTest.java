package starter.junit5;

import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import starter.steps.MathWizSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("fast")
public class SecondTest {

    @Steps
    MathWizSteps michael;


    @Test
    @DisplayName("My 2nd JUnit 5 test! 😎")
    void mySecondTest(TestInfo testInfo) {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("My 2nd JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");

        // Given
        michael.startsWith(1);

        // When
        michael.adds(3);

        // Then
        michael.shouldHave(3);

    }
}
