package org.example.features.select;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.example.steps.serenity.EndUserStepsUbbCluj;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/UbbClujTestData.csv")
public class SelectLanguageUbbClujDDT {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserStepsUbbCluj paul;

    public String name;
    public String definition;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    // Valid
    @Test
    public void select_change_language_should_display_the_corresponding_title_in_en() {
        paul.is_the_home_page();
        paul.changeLanguage();
        paul.shouldSeeMainPageTitle(getDefinition());
    }

    // Invalid
    @Test
    public void select_change_language_invalid_should_display_the_corresponding_title_in_ro_should_fail() {
        paul.is_the_home_page();
        paul.changeLanguage();
        paul.shouldSeeMainPageTitle("Matematică și Informatică – între Eternitate și Efervescență");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}