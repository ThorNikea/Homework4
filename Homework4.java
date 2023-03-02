import com.codeborne.selenide.Condition;
import org.junit.Test;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
public class Homework4 {
    @Test
    public void Test1(){
        System.setProperty("selenide.browserSize","1980x1080");
        open("https://ee.ge/");
        $(".btn-register").click();
        $(byText("სწრაფი რეგისტრაცია"));
        $("#firstName").setValue("Tornike").shouldNotBe(Condition.empty);
        $("#lastName").setValue("Gogia").shouldNotBe(Condition.empty);
        $("#email").setValue("tornike.gogia1996@gmail.com").shouldNotBe(Condition.empty);
        $("#password").setValue("Testing").shouldNotBe(Condition.empty);
        $("#confirmPassword").setValue("Testing").shouldNotBe(Condition.empty);
        $("#singup").shouldBe(Condition.enabled);
    }
    @Test
    public void Test2(){
        System.setProperty("selenide.browserSize","1980x1080");
        open("https://ee.ge/");
        $(".btn-register").click();
        $(byText("სწრაფი რეგისტრაცია"));
        $("#singup").shouldBe(Condition.disabled);
        $("#firstName").click();
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#lastName").click();
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible,Duration.ofMillis(10000));
        $("#email").click();
        $("#password").click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").click();
        $("#confirmPassword").click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#confirmPassword").click();
        $("#password").click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
    }
    @Test
    public void Test3(){
        System.setProperty("selenide.browserSize","1980x1080");
        open("https://ee.ge/");
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible,Duration.ofMillis(7000));
        $("#search_list").setValue("notebook");
        $(".search-btn").click();
        $(".d-xs-none",0).click();
        $(".add_to_cart",0).click();
        $(".cart-count").click();
        $(".Collapsible__trigger").shouldBe(Condition.visible);
        $(byText("წაშლა")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible,Duration.ofMillis(7000));
    }
    @Test
    public void Test4 (){
        System.setProperty("selenide.browserSize","1980x1080");
        open("https://ee.ge/");
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible,Duration.ofMillis(7000));
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $("#search_list").setValue("notebook");
        $(".search-btn").click();
        $(".add_to_cart",0).click();
        $(".btn-cart").click();
        $(".save-icon").click();
        $(".price-section").shouldBe(Condition.visible);
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible,Duration.ofMillis(7000));
        $(byText("შენახული ნივთები")).click();
        $(".fa-times").click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
    }
}