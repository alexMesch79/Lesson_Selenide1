import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FirstTestInSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        }

    @DisplayName("Проверка, что на странице SoftAssertions есть пример кода для JUnit5")
    @Test
    public void findPageInGitHubWhitCode(){
        Selenide.open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-rightbar").$$("li").last().$("button").click();
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}

