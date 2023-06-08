package org.example.features.search;

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
public class SearchByKeywordUbbClujDDT {

    private final String invalidInputTooLong = new String(new char[500]).replace('\0', 'a');

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
    public void searching_by_keyword_orar_should_display_the_corresponding_article() {
        paul.is_the_home_page();
        paul.looks_for(getName());
        paul.shouldSeeFirstTitleAfterSearch(getDefinition());
    }

    // Invalid
    @Test
    public void searching_by_keyword_invalid_inputTooLong_should_fail() {
        paul.is_the_home_page();
        paul.looks_for(invalidInputTooLong);
        paul.shouldSeeFirstTitleAfterSearch("Something");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
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