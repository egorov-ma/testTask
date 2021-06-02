package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static logger.CustomLogger.logger;

public class MainPage {

    SelenideElement textInput = $(By.id("text"));

    private String formationPath(int index, String path) {
        return "//li[@data-cid='" + index
                + "']//div[@class='Path Organic-Path path organic__path']//b[text()='" + path + "']";
    }

    @Step("Ввод и поиск текста в поле поиска")
    public void textInput(String text) {
        textInput.click();
        textInput.sendKeys(text, Keys.ENTER);
        logger.info("ok");
    }

    @Step("Поиск необходимой ссылки на заданном количестве первых позиций")
    public void checkSearch(int index, String path) {
        boolean flag = false;
        for (int i = 0; i < index; i++) {
            if ($(byXpath(formationPath(i, path))).isDisplayed()) {
                flag = true;
                takeScreenshot();
                break;
            }
        }
        if (!flag) {
            takeScreenshot();
            Assert.fail("Результат поиска '" + path + "' не дал результатов на заданном количестве первых позиций");
        }
        logger.info("ok");
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {
        return getScreenshotBytes();
    }

    public static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
