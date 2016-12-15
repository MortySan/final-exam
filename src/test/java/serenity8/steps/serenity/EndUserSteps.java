package serenity8.steps.serenity;

import org.openqa.selenium.By;
import serenity8.pages.WeatherHomepage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    WeatherHomepage weatherHomepage;

    @Step
    public void enters(String capital) {
        weatherHomepage.searchCountry(capital);
    }

    @Step
    public void tempPrint() {
        weatherHomepage.tempPrint();
    }

    @Step
    public void imperialPrint() {
        weatherHomepage.farenheitGet();
    }
    
//
//    @Step
//    public void should_see_definition(String definition) {
//        assertThat(weatherHomepage.getDefinitions(), hasItem(containsString(definition)));
//    }
//
    @Step
    public void is_the_home_page() {
        weatherHomepage.open();
    }

    @Step
    public void flagSelect(String flag) {
        weatherHomepage.selectCountry(flag);
    }
}