package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import test_data.Links;

import static com.codeborne.selenide.Selenide.open;

public class searchInYandex extends BasePage {

    @BeforeMethod(alwaysRun = true)
    public void openMainPage() {
        open(Links.YANDEX_MAIN_PAGE.getUrl());
    }

    @Test
    public void checkYandex() {
        open(Links.YANDEX_MAIN_PAGE.getUrl());
        System.out.println("привет мир!");
    }
}
