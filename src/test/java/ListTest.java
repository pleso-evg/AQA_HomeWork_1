import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListTest {
        @Test
        void shoulDisplayListCorrectly() {
            open("https://niffler.qa.guru/");
            $("[name=username]").setValue("eugene_pl");
            $("[id=password]").setValue("!!!!QQQQ2222");
            $("button[id=login-button]").click();
            $("[class*='css-1z0xbew']")
                    .shouldBe(visible)
                    .shouldHave(text("Еда"))
                    .shouldHave(text("77"));


        }
}
