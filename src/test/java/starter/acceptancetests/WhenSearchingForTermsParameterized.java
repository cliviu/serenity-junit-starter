package starter.acceptancetests;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.testng.SerenityTestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import starter.actions.navigation.NavigateTo;
import starter.actions.search.LookForInformation;


@SerenityTestNG
public class WhenSearchingForTermsParameterized {

    @CastMember
    Actor actor;

    @Test(dataProvider="stringDataProvider", testName = " my own test name" )
    public void searchFor(String thing) {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage(),
                LookForInformation.about(thing),
                Ensure.that(TheWebPage.title()).containsIgnoringCase(thing)
        );
        if("red".equals(thing)) {
            throw new RuntimeException("caused exception");
        }
    }


    @DataProvider
    public Object[][] stringDataProvider() {
        return new Object[][] {
                { "green" },
                { "red"},
                { "yellow"}
        };
    }
}
