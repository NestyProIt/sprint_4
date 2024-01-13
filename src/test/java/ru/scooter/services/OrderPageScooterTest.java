package ru.scooter.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertTrue;


public class OrderPageScooterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test//переход к форме заказа через кнопку "Заказать" на главной странице в хедере,
    // заполнение только обязательных полей в форме заказа:
    // Имя, Фамилия, Адрес, Станция метро, Телефон, Когда привезти самок, Срок аренды
    public void getOrderPageScooterInHeader() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickOrderButtonInHeader();

        //создать объект страницы оформления заказа
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.setUsername("Иванушка");//
        orderPageScooter.setSurName("Иванушкаивануш");
        orderPageScooter.setAddressOrder("Улица Мичуринская, д. 11");//
        orderPageScooter.setMetroStation();
        orderPageScooter.setUserPhoneNumber("899988877755");
        orderPageScooter.clickOrderNextButtonOrderPage();
        orderPageScooter.setOrderDeliveryDate("14.01.2024");
        orderPageScooter.setTimeRentScooter();
        orderPageScooter.clickOrderButtonCreate();
        orderPageScooter.clickPopUpOrderYesButton();
        //проверить модальное окно "Заказ оформлен"
        assertTrue(orderPageScooter.texPopUpWindowOrderDone());
    }

    @Test //переход к форме заказа через кнопку "Заказать" в теле главной страницы. Заполнение всех полей в форме заказа
    public void getOrderPageScooterHomeFinish() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickOrderButtonHomeFinish();

        //создать объект страницы оформления заказа
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.setUsername("Братец иванушка");
        orderPageScooter.setSurName("Солнышко");
        orderPageScooter.setAddressOrder("Улица имени Куйбышева Валериана Владимировича д.5");
        orderPageScooter.setMetroStation();
        orderPageScooter.setUserPhoneNumber("89998887775");
        orderPageScooter.clickOrderNextButtonOrderPage();
        orderPageScooter.setOrderDeliveryDate("11.01.2024");
        orderPageScooter.setTimeRentScooter();
        orderPageScooter.clickColorScooter();
        orderPageScooter.setCommentFoCourier("Сестрицааленушкабратецц");
        orderPageScooter.clickOrderButtonCreate();
        orderPageScooter.clickPopUpOrderYesButton();
        //проверить модальное окно "Заказ оформлен"
        assertTrue(orderPageScooter.texPopUpWindowOrderDone());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
