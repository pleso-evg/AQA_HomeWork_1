import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @AfterEach
    void teardown() {
        closeWebDriver();
    }

    @Test
    void successLogin() {
        open("https://niffler.qa.guru/");
        $("[name=username]").setValue("eugene_pl");
        $("[id=password]").setValue("!!!!QQQQ2222");
        $("button[id=login-button]").click();


        $("[id=spendings]").shouldHave(text("History of Spendings"));
    }

    @Test
    void unSuccessLogin() {
        open("https://niffler.qa.guru/");
        $("[name=username]").setValue("eugene_pl");
        $("[id=password]").setValue("!!!!QQQQ222");
        $("button[id=login-button]").click();

        $("[class=form__error]").shouldHave(text("Неверные учетные данные пользователя"));
    }

        @Test
        void successLoginWihtPressEnter() {
            open("https://niffler.qa.guru/");
            $("[name=username]").setValue("eugene_pl");
            $("[id=password]").setValue("!!!!QQQQ222").pressEnter();
    }

        @Test
        void successLogOut() {
            open("https://niffler.qa.guru/");
            $("[name=username]").setValue("eugene_pl");
            $("[id=password]").setValue("!!!!QQQQ2222");
            $("button[id=login-button]").click();
            $("[id=spendings]").shouldHave(text("History of Spendings"));

            $("button[aria-label=Menu]").click();
            $("[role=menu]").$(byText("Sign out")).click();
            $("[role=dialog]").shouldHave(text("Want to logout?"));
            $("button[data-testid=dialog-submit-btn]").click();
            $("[class=header]").shouldHave(text("Log in"));
    }
}
