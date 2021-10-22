package web.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.data.DataThings;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchThingsTest {
    DataThings dataCity = new DataThings();
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("headless");

        driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://www.gloria-jeans.ru");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    @DisplayName("Поиск вещей с помощью поисковой строки")
    public void shouldFindThingsUsingTheSearchBar() {
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.id("js-site-search-input")).click();
        driver.findElement(By.id("js-site-search-input")).sendKeys(DataThings.getThings());
        driver.findElement(By.cssSelector("svg.icon.icon--search.icon--size-20")).click();
        String expected = "РЕЗУЛЬТАТЫ ПОИСКА";
        String actual = driver.findElement(By.xpath("//div/h1")).getText();
        String expected1 = DataThings.getThings();
        String actual1 =driver.findElement(By.cssSelector("span.js-search-text")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("Поиск несуществующей вещей с помощью поисковой строки")
    public void followsANonExistentThingUsingTheSearchBar() {
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.id("js-site-search-input")).click();
        driver.findElement(By.id("js-site-search-input")).sendKeys(DataThings.getInvalideThings());
        driver.findElement(By.cssSelector("svg.icon.icon--search.icon--size-20")).click();
        String expected = "РЕЗУЛЬТАТЫ ПОИСКА";
        String actual = driver.findElement(By.xpath("//div/h1")).getText();
        String expected1 = "НЕТ ТОВАРОВ";
        String actual1 =driver.findElement(By.cssSelector("span.js-main-listing-quantity")).getText();
        String expected2 = "К сожалению, нет товаров, подходящих под ваш запрос.";
        String actual2 =driver.findElement(By.cssSelector("div.text-message-empty-product-list.text-message-empty-product-list--block > p")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Поиск по разным текстовыми символами с помощью поисковой строки")
    public void searchByDifferentTextCharactersUsingTheSearchBar() {
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.id("js-site-search-input")).click();
        driver.findElement(By.id("js-site-search-input")).sendKeys(DataThings.getSpecialСharacters());
        driver.findElement(By.cssSelector("svg.icon.icon--search.icon--size-20")).click();
        String expected = "РЕЗУЛЬТАТЫ ПОИСКА";
        String actual = driver.findElement(By.xpath("//div/h1")).getText();
        String expected1 = "НЕТ ТОВАРОВ";
        String actual1 =driver.findElement(By.cssSelector("span.js-main-listing-quantity")).getText();
        String expected2 = "К сожалению, нет товаров, подходящих под ваш запрос.";
        String actual2 =driver.findElement(By.cssSelector("div.text-message-empty-product-list.text-message-empty-product-list--block > p")).getText();
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Поиск женской одежды по каталогу")
    public void shouldFindWomensSlothesInTheCatalog() {
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//header/div[3]/div[2]/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        driver.findElement(By.linkText("Блузки и рубашки")).click();
        String expected = "ЖЕНСКИЕ БЛУЗКИ И РУБАШКИ";
        String actual = driver.findElement(By.cssSelector("h1.banner-top__caption.banner-top__caption--black")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск мужской одежды по каталогу")
    public void shouldFindMansSlothesInTheCatalog() {
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div[3]/div")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        driver.findElement(By.linkText("Верхняя одежда")).click();
        String expected = "МУЖСКАЯ ВЕРХНЯЯ ОДЕЖДА";
        String actual = driver.findElement(By.xpath("//main/div[2]/div/div/h1")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск одежды для подростков по каталогу и добавление а избранное")
    public void shouldSearcForThingsForTeenagersnTheCatalogAndAddFavorites() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div[4]/div[1]")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        driver.findElement(By.cssSelector("a.kind-people")).click();
        driver.findElement(By.xpath("//li[2]/a/p")).click();
        driver.findElement(By.xpath("//div[2]/div/div/ul/li[7]/a")).click();
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//div[6]/div/div[2]/div[2]/div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[6]/div/div[5]/div[2]/div[2]")).click();
        String expected = "Товар ненадолго добавлен в избранное";
        String actual = driver.findElement(By.cssSelector("div.sizes-pop-up__alert__title")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск одежды для детей по каталогу и добавление а избранное")
    public void searchForClothesForChildrenInTheCatalogAndAddAFavorites() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[2]/div[5]/div")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        jse.executeScript("window.scrollBy(0,1500)");
        driver.findElement(By.linkText("Утеплённая куртка с камуфляжным принтом для мальчика")).click();
        jse.executeScript("window.scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[3]/div[3]/div")).click();
        driver.findElement(By.cssSelector("svg.icon.icon--heart.product-info__wish.js-add-to-wish-button")).click();
        String expected = "ТОВАР НЕНАДОЛГО ДОБАВЛЕН В ИЗБРАННОЕ";
        String actual = driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/div/div/div[3]/div[2]/div[1]")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск одежды для новорожденых по каталогу и добавление в корзину")
    public void searchForClothesForNewbornsInTheCatalogAndAddToTheCart()  {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div[6]/div")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        jse.executeScript("window.scrollBy(0,1200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Бежевое боди с принтом Hello world для малышки")).click();
        jse.executeScript("window.scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.block-size__item.js-size-item")).click();
        driver.findElement(By.cssSelector("button.press-button.js-button-update.js-follow-button.js-big-button-wish.js-product-details-add-to-cart.js-product-details-ref-button")).click();
        String expected = "Товар добавлен в корзину";
        String actual = driver.findElement(By.cssSelector("h2.uk-caption.uk-caption--h3.uk-caption--bold.js-caption-error")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление и удаление товара из избранного")
    public void shouldAddAndRemoveAnItemFromFavorites() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("a.header-menu__source.js-navigation-source-link")).click();
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        jse.executeScript("window.scrollBy(0,300)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.listing-item__wish-block.js-add-to-wish-button")).click();
        driver.findElement(By.xpath("//div[5]/div/div[5]/div[2]/div[4]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Перейти в избранное")).click();
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.cssSelector("svg.icon.icon--heart.js-wish-icon-block.active > use")).click();
    }

    @Test
    @DisplayName("Добавление и удаление товара из корзины")
    public void shouldAddAndRemoveAnItemFromTheCart() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.cssSelector("div.header-menu__source.header-menu__source--hover.js-navigation-source")).click();
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.cssSelector(":nth-child(8) > div > div.listing-item__info > a.listing-item__info-price-wrapper > div.listing-item__info-buy-button.js-listing-add-to-cart > svg.icon.icon--basket")).click();
        driver.findElement(By.xpath("//div[8]/div/div[5]/div[2]/div[4]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.uk-button.js-close")).click();
        jse.executeScript("window.scrollBy(0,-500)");
        driver.findElement(By.cssSelector("svg.icon.icon--basket.header-basket__icon--desktop")).click();
        jse.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.cssSelector("svg.icon.icon--trash > use")).click();
        String expected = "Оформить заказ вы сможете, как только в корзине появится товар, доступный для покупки.";
        String actual = driver.findElement(By.cssSelector("p.order-empty-message.js-empty-message.show")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление в корзину и покупка одежды")
    public void shouldCheckTheAdditionoTheCartAndThePurchaseOfTheProduct(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div[3]/div")).click();
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[8]/div/div[4]/a[1]/div[2]")).click();
        driver.findElement(By.xpath("//div[8]/div/div[5]/div[2]/div[4]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.uk-button.js-close")).click();
        jse.executeScript("window.scrollBy(0,-500)");
        driver.findElement(By.cssSelector("a.header-basket.js-header-minicart")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//div[2]/div[2]/div[3]/a")).click();
        String expected = "Оформление заказа";
        String actual = driver.findElement(By.cssSelector("h1.checkout-title__text")).getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск и покупка одежды")
    public void shouldFindAndBuyClothes(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[text()='Да, верно']")).click();
        driver.findElement(By.xpath("//div[2]/div[5]/div")).click();
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//body/div[2]/div/div/div/p")).click();
        driver.findElement(By.xpath("//div[8]/div/div[4]/a[1]/div[2]")).click();
        driver.findElement(By.xpath("//div[8]/div/div[5]/div[2]/div[4]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[5]/a")).click();
        String expected = "Оформление заказа";
        String actual = driver.findElement(By.cssSelector("h1.checkout-title__text")).getText();
        assertEquals(expected, actual);
    }
}
