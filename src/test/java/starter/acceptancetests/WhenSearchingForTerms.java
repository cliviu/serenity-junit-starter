package starter.acceptancetests;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.testng.SerenityTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import starter.actions.navigation.NavigateTo;
import starter.actions.search.LookForInformation;



@SerenityTestNG
public class WhenSearchingForTerms {

    @CastMember
    Actor actor;

    @Test(testName = "Should be able to search for red things", groups = {"redGroup","yellowGroup"})
    void searchForRedThings() {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage(),
                LookForInformation.about("red"),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("red")
        );
    }


    @Test(testName = "Should be able to search for green things",groups = {"greenGroup"})
    void searchForGreenThings() {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage(),
                LookForInformation.about("green"),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("green")
        );
    }
}
