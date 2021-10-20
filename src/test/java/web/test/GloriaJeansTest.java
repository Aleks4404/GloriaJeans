package web.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.data.DataHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GloriaJeansTest {
    DataHelper dataHelper = new DataHelper();
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    @DisplayName("Регистрация с помощью Email")
    void registrationViaEmail() {
        driver.get("https://www.gloria-jeans.ru");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys(DataHelper.generateUsersNameInRussian(""));
        driver.findElement(By.cssSelector("div.js-switchable-content.hide--no-hide-height.show.active > div.hide--no-hide-height.js-switchable-content > form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.generateEmail());
        driver.findElement(By.cssSelector("div.js-switchable-content.hide--no-hide-height.show.active > div.hide--no-hide-height.js-switchable-content > form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"password\"]")).sendKeys(DataHelper.generatePassword());
        driver.findElement(By.cssSelector("div.send-form__button-block.send-form__button-block--flex-wrap-wrap > button.js-button-form.press-button")).click();
        driver.findElement(By.cssSelector("div.send-form__button-block.send-form__button-block--flex-wrap-wrap > button.js-button-form.press-button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("p.caption-24.caption--uppercase.caption--bold.margin-bottom-16"));
        driver.findElement(By.cssSelector("p.caption-12.caption--underline.cursor-pointer.js-close-button")).click();
    }

//    @Test // TODO Ввести код из СМС и нажать Enter
//    @DisplayName("Регистрация с помощью номера телефона")
//    public void registrationUsingAPhoneNumber() {
//        driver.get("https://www.gloria-jeans.ru/");
//        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
//        driver.findElement(By.cssSelector("div.header-body__account-button.js-active-pop-up-button.js-change-form-button.js-button-analytics-pop-up-open")).click();
//        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
//        driver.findElement(By.xpath("//div/div[3]/div[2]/div/div[2]/div")).click();
//        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.text-input.margin-bottom-16 > div.wrapper-text-zone.wrapper-text-zone--margin-bottom-0.js-text-zone > input[name=\"cellphone\"]")).sendKeys(DataHelper.generateNamberPhone());
//        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.send-form__button-block > button.press-button.js-phone-test-button")).click();
//        driver.findElement(By.cssSelector("div.hide.js-code-block.hide--no-animate.js-info-text.show > div.text-input.js-code-input > div.wrapper-text-zone.js-text-zone > input[name=\"code\"]")).sendKeys("  ");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.send-form__button-block > button.press-button.js-button-form")).click();
//        driver.findElement(By.cssSelector("div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.generateEmail());
//        driver.findElement(By.cssSelector("button.press-button.js-button-form")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("p.caption-24.caption--uppercase.caption--bold.margin-bottom-16"));
//        driver.findElement(By.cssSelector("p.caption-12.caption--underline.cursor-pointer.js-close-button")).click();
//    }

//    @Test // TODO Ввести код из СМС и нажать Enter
//    @DisplayName("Авторизация с помощью номера телефона")
//    public void authorizationUsinAaPhoneNumber() {
//        driver.get("https://www.gloria-jeans.ru/");
//        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
//        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
//        driver.findElement(By.xpath("//div/div[3]/div/div/div[2]/div")).click();
//        driver.findElement(By.name("cellphone")).click();
//        driver.findElement(By.name("cellphone")).clear();
//        driver.findElement(By.name("cellphone")).sendKeys(DataHelper.generateNamberPhone());
//        driver.findElement(By.cssSelector("button.press-button.js-phone-test-button")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("div.send-form__button-block > button.press-button.js-button-form")).click();
//        driver.findElement(By.cssSelector("span.caption-14.margin-left-8.max-width-115.width-limit-ellipsis.js-customer-name-block")).click();
//  }

    @Test
    @DisplayName("Авторизация с помощью Email")
    public void authorizationByEmail() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.cssSelector("form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.getEmail());
        driver.findElement(By.name("password")).sendKeys(DataHelper.generatePassword());
        driver.findElement(By.cssSelector("div.button-show-password.js-button-show-password")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button.js-button-form.press-button.margin-bottom-16")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8.max-width-115.width-limit-ellipsis.js-customer-name-block")).click();
    }

    @Test
    @DisplayName("Авторизация не зарегестрированной почты")
    public void  shouldLogInWithAInvalidEmail(){
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.cssSelector("form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.generateEmail());
        driver.findElement(By.name("password")).sendKeys(DataHelper.generatePassword());
        driver.findElement(By.cssSelector("button.js-button-form.press-button.margin-bottom-16")).click();
        String expected = "Неверное имя пользователя или пароль.";
        String actual = driver.findElement(By.xpath("//form/p[2]")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация не зарегестрированного номера телефона")
    public void  shouldLogInWithAnInvalidPhoneNumber(){
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div/div[3]/div/div/div[2]/div")).click();
        driver.findElement(By.name("cellphone")).sendKeys(DataHelper.getInvalidePhone());
        driver.findElement(By.cssSelector("button.press-button.js-phone-test-button")).click();
        String expected = "Пользователь с таким номером телефона не зарегистрирован на сайте";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.js-info-text.hide--no-animate.active")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация по Email с пустыми полями")
    public void shouldLogInWithEmptyFields() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.cssSelector("button.js-button-form.press-button.margin-bottom-16")).click();
        String expected = "Некорректный адрес электронной почты.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.active")).getText();
        String expected1 = "Пароль должен быть не менее 6 символов и содержать латинские буквы.";
        String actual1 = driver.findElement(By.cssSelector("div.wrapper-text-zone.wrapper-text-zone--margin-bottom-0.js-text-zone.error > p.text-error.js-text-error.active")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("Авторизация по номеру телефона с пустым полем")
    public void shouldLogInUsingAPhoneNumberWithEmptyFields() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div/div[3]/div/div/div[2]/div")).click();
        driver.findElement(By.cssSelector("button.press-button.js-phone-test-button")).click();
        String expected = "Поле обязательно для заполнения.";
        String actual = driver.findElement(By.xpath("//div[1]/div[3]/form/div[1]/div/p[2]")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Регистрация по Email с пустыми полями")
    public void shouldRegistrationByEmailWithAnEmptyField() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
        driver.findElement(By.cssSelector("div.send-form__button-block.send-form__button-block--flex-wrap-wrap > button.js-button-form.press-button")).click();
        String expected = "Поле обязательно для заполнения.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.active")).getText();
        String expected1 = "Некорректный адрес электронной почты.";
        String actual1 = driver.findElement(By.cssSelector("div.text-error.js-text-error.active")).getText();
        String expected2 = "Пароль должен быть не менее 6 символов и содержать латинские буквы.";
        String actual2 = driver.findElement(By.xpath("//form/div[3]/div/p[2]")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Регистрация по номеру телефона с пустым полем")
    public void shouldRegistrationByPhoneNumberWithAnEmptyField() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div/div[3]/div[2]/div/div[2]/div")).click();
        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.send-form__button-block > button.press-button.js-phone-test-button")).click();
        String expected = "Поле обязательно для заполнения.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.js-info-text.hide--no-animate.active")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Авторизация по Email с невалидными данными")
    public void authorizationByEmailWithInvalidData() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.cssSelector("form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.getInvalideEmail());
        driver.findElement(By.name("password")).sendKeys(DataHelper.generateInvalidePassword());
        driver.findElement(By.cssSelector("div.button-show-password.js-button-show-password")).click();
        String expected = "Некорректный адрес электронной почты.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.active")).getText();
        String expected1 = "Пароль должен быть не менее 6 символов и содержать латинские буквы.";
        String actual1 = driver.findElement(By.cssSelector("div.wrapper-text-zone.wrapper-text-zone--margin-bottom-0.js-text-zone.error > p.text-error.js-text-error.active")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("Авторизация по номеру телефона с невалидными данными")
    public void authorizationByPhoneNumberWithInvalidData() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div/div[3]/div/div/div[2]/div")).click();
        driver.findElement(By.name("cellphone")).click();
        driver.findElement(By.name("cellphone")).clear();
        driver.findElement(By.name("cellphone")).sendKeys(DataHelper.getInvalidePhone1());
        driver.findElement(By.cssSelector("button.press-button.js-phone-test-button")).click();
        String expected = "Формат телефона некорректен.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.js-info-text.hide--no-animate.active")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Регистрация по Email с невалидными данными")
    public void registrationByEmailWithInvalidData() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("span.caption-14.margin-left-8")).click();
        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys(DataHelper.getInvalideUserName());
        driver.findElement(By.cssSelector("div.js-switchable-content.hide--no-hide-height.show.active > div.hide--no-hide-height.js-switchable-content > form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"email\"]")).sendKeys(DataHelper.getInvalideEmail());
        driver.findElement(By.cssSelector("div.js-switchable-content.hide--no-hide-height.show.active > div.hide--no-hide-height.js-switchable-content > form.send-form.js-send-form.js-password-form > div.text-input > div.wrapper-text-zone.js-text-zone > input[name=\"password\"]")).sendKeys(DataHelper.generateInvalidePassword());
        driver.findElement(By.cssSelector("div.send-form__button-block.send-form__button-block--flex-wrap-wrap > button.js-button-form.press-button")).click();
        driver.findElement(By.cssSelector("div.send-form__button-block.send-form__button-block--flex-wrap-wrap > button.js-button-form.press-button")).click();
        String expected = "Поле содержит недопустимые символы.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.active")).getText();
        String expected1 = "Некорректный адрес электронной почты.";
        String actual1 = driver.findElement(By.cssSelector("div.text-error.js-text-error.active")).getText();
        String expected2 = "Пароль должен быть не менее 6 символов и содержать латинские буквы.";
        String actual2 = driver.findElement(By.xpath("//form/div[3]/div/p[2]")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Регистрация по номеру телефа с невалидными данными")
    public void registrationByPhoneNumberWithInvalidData() {
        driver.get("https://www.gloria-jeans.ru/");
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("div.header-body__account-button.js-active-pop-up-button.js-change-form-button.js-button-analytics-pop-up-open")).click();
        driver.findElement(By.xpath("//div[15]/div/div/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div/div[3]/div[2]/div/div[2]/div")).click();
        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.text-input.margin-bottom-16 > div.wrapper-text-zone.wrapper-text-zone--margin-bottom-0.js-text-zone > input[name=\"cellphone\"]")).sendKeys(DataHelper.getInvalidePhone1());
        driver.findElement(By.cssSelector("div.hide--no-hide-height.js-switchable-content.show.active > form.send-form.js-send-form > div.send-form__button-block > button.press-button.js-phone-test-button")).click();
        String expected = "Формат телефона некорректен.";
        String actual = driver.findElement(By.cssSelector("p.text-error.js-text-error.js-info-text.hide--no-animate.active")).getText();
        assertEquals(expected, actual);
    }
}