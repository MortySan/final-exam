package serenity8.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import serenity8.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the http://www.weather-forecast.com/ home page")
    public void goWeatherHomepage() {
        endUser.is_the_home_page();
    }

    @When("you input $capital name in the search input")
    public void userSearchInput(String capital) {
        endUser.enters(capital);
    }

    @When("proper $country will be selected")
    public void countrySelection(String country){
        endUser.flagSelect(country);
    }

    @Then("Temperature for today will be printed")
    public void temeraturePrint () {
        endUser.tempPrint();
    }

    @Then("Change to F and print")
    public void farPrint() {
        endUser.imperialPrint();

    }

}
