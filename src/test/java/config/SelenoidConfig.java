package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import static logger.CustomLogger.logger;

public class SelenoidConfig {
    public void createWebDriverInstance(String browser) {
        if (browser.equals("${BROWSER}")) {
            browser = "Chrome";
        }
        if (browser.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    //        Configuration.browserVersion = "89";
        }
        Configuration.browser = browser;
        Configuration.remote = "http://192.168.56.101:4444/wd/hub";
        Configuration.timeout = 30000;
        Configuration.reportsFolder = "target/screenshots";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        Configuration.baseUrl = "";
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
        Configuration.browserCapabilities.setCapability("screenResolution", "1920x1080x24");
        Configuration.browserCapabilities.setCapability("sessionTimeout", "1h");
        Configuration.browserCapabilities.setCapability("enableLog", true);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        logger.info("ok");
    }
}