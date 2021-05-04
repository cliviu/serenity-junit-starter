package starter.junit5;

import net.thucydides.core.annotations.Steps;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import starter.steps.MathWizSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;




@DisplayName("JUnit 5 Nested Example")
public class SampleNestedTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @Steps
    MathWizSteps michael;


    @Nested
    @DisplayName("Tests for the inner class")
    public class InnerClass {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each test method of the A class");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each test method of the A class");
        }

        @Test
        @DisplayName("Example test for method A")
        public void sampleTestForMethodA() {
            Calculator calculator = new Calculator();
            assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
            // Given
            michael.startsWith(1);

            // When
            michael.adds(2);

            // Then
            michael.shouldHave(3);
        }

        @Test
        public void sampleTestForMethodB() {
            Calculator calculator = new Calculator();
            assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
            // Given
            michael.startsWith(1);

            // When
            michael.adds(2);

            // Then
            michael.shouldHave(3);
        }

    }
}