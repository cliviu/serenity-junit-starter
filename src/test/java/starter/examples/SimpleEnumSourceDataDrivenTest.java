package starter.examples;

import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import starter.domain.Books;
import starter.steps.SampleNonWebSteps;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleEnumSourceDataDrivenTest {

    @Steps
    public SampleNonWebSteps steps;


    @ParameterizedTest
    @EnumSource(Books.class)
    public void withEnumSource(Books book) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        assertNotNull(book.value());
    }

    @ParameterizedTest
    @EnumSource(value = Books.class, names = {"BDD_IN_ACTION","SPRING_IN_ACTION"} )
    public void withEnumSourceSelectedBooks(Books book) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        assertNotNull(book.value());
    }

    @ParameterizedTest
    @EnumSource(value = Books.class, mode = EnumSource.Mode.EXCLUDE, names = {"SPRING_IN_ACTION"} )
    public void withEnumSourceExcludedBooks(Books book) {
        steps.stepThatSucceeds();
        steps.anotherStepThatSucceeds();
        assertNotNull(book.value());
    }

}
