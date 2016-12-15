package serenity8.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www.weather-forecast.com/")
public class WeatherHomepage extends PageObject {

    @FindBy(xpath = "//input[@id='location']")
    public WebElement input;

    @FindBy(xpath = "//div[@id='location_autocomplete']/div/nobr/span[2]")
    public List<WebElement> countryList;

    @FindBy(xpath = "//tr[@class='max-temp-row']/td[1]/span")
    public  WebElement maxTemp;

    @FindBy(xpath = "//tr[@class='min-temp-row']/td[1]/span")
    public WebElement minTemp;

    @FindBy(xpath = "//a[@class='units imperial']")
    public WebElement imperialUnits;


    public void searchCountry (String capital) {
        input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        input.sendKeys(capital);

    }


    public void selectCountry (String country) {
        for (WebElement name : countryList ) {
            System.out.println(name.getText());
            if ( name.getText().contains(country)) {
                name.click();
                break;
            }
        }
    }


    public void tempPrint () {
        System.out.println(maxTemp.getText()+"C - maxTemp");
        System.out.println(minTemp.getText()+"C - minTemp");
    }

    public void farenheitGet() {
        imperialUnits.click();
        System.out.println(maxTemp.getText()+"F - maxTemp");
        System.out.println(minTemp.getText()+"F - minTemp");

    }


//    public void enter_keywords(String keyword) {
//        searchTerms.type(keyword);
//    }

//    public void lookup_terms() {
//        lookupButton.click();
//    }
//
//    public List<String> getDefinitions() {
//        WebElementFacade definitionList = find(By.tagName("ol"));
//        List<WebElement> results = definitionList.findElements(By.tagName("li"));
//        return convert(results, toStrings());
//    }
//
//    private Converter<WebElement, String> toStrings() {
//        return new Converter<WebElement, String>() {
//            public String convert(WebElement from) {
//                return from.getText();
//            }
//        };
//    }
}