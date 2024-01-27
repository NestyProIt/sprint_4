package ru.scooter.services;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//класс страницы  оформления заказа
public class OrderPageScooter {

    //локатор поля "Имя"
    private final By userName = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    private final By surName = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");
    //локатор поля "Адрес: куда привезти заказ"
    private final By addressOrder = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля "Станция метро"
    private final By metroStation = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    //локатор станции метро Красносельская
    private final By metroStationKrasnoselskaya = By.xpath(".//button[@value='5']");
    //локатор поля "Телефон: на него позвонит курьер:"
    private final By userPhoneNumber = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private final By orderNextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
    //локатор поля "Когда привезти самокат"
    private final By orderDeliveryDate = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    //локатор поля "Срок аренды"
    private final By timeRentScooter = By.xpath(".//div[@class='Dropdown-control']");
    //локатор срока аренды - "сутки"
    private final By timeRentScooterOneDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //локатор чекбокса "Цвет самоката"  - чёрный жемчуг
    private final By scooterColorBlackCheckbox = By.xpath(".//label[@for='black']");
    //локатор поля "Комментарий для курьера"
    private final By commentFoCourier = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки "Заказать" ниже формы заказа, на 2-ой странице формы заказа
    private final By orderButtonCreate = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //локатор кнопки "Да" в модальном окне "Хотите оформить заказ?"
    private final By popUpOrderYesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //локатор модального окна "Заказа оформлен"
    private final By headerPopUpWindowOrderDone = (By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']"));
    private final WebDriver driver;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //заполнить поле "Имя"
    public void setUsername(String newUserName) {
        driver.findElement(userName).sendKeys(newUserName);
    }

    //заполнить поле "Фамилия"
    public void setSurName(String newSurName) {
        driver.findElement(surName).sendKeys(newSurName);
    }

    //заполнить поле "Адрес: куда привезти заказ"
    public void setAddressOrder(String newAddressOrder) {
        driver.findElement(addressOrder).sendKeys(newAddressOrder);
    }

    //заполнить поле "Станция метро"
    public void setMetroStation() {
        driver.findElement(metroStation).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(metroStationKrasnoselskaya));
        driver.findElement(metroStationKrasnoselskaya).click();
    }

    //заполнить поле "Телефон: на него позвонит курьер"
    public void setUserPhoneNumber(String newUserPhoneNumber) {
        driver.findElement(userPhoneNumber).sendKeys(newUserPhoneNumber);
    }

    //кликнуть на кнопку "Далее"
    public void clickOrderNextButtonOrderPage() {
        driver.findElement(orderNextButton).click();
    }

    //заполнить поле "Когда привезти самокат"
    public void setOrderDeliveryDate(String newOrderDeliveryDate) {
        driver.findElement(orderDeliveryDate).sendKeys(newOrderDeliveryDate, Keys.ENTER);
    }

    //заполнить поле "Срок аренды"
    public void setTimeRentScooter() {
        driver.findElement(timeRentScooter).click();
        driver.findElement(timeRentScooterOneDay).click();
    }

    //кликнуть на чекбокс в поле "Цвет самоката"
    public void clickColorScooter() {
        driver.findElement(scooterColorBlackCheckbox).click();
    }

    //заполнить поле "Комментарий"
    public void setCommentFoCourier(String newCommentFoCourier) {
        driver.findElement(commentFoCourier).sendKeys(newCommentFoCourier);
    }

    //кликнуть на кнопку "Заказать" ниже формы заказа
    public void clickOrderButtonCreate() {
        driver.findElement(orderButtonCreate).click();
    }

    //кликнуть на кнопку "Да" в модальном окне "Хотите оформить заказ?"
    public void clickPopUpOrderYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(popUpOrderYesButton));
        driver.findElement(popUpOrderYesButton).click();
    }

    //проверить модальное окно "Заказ оформлен"
    public boolean texPopUpWindowOrderDone() {
        return driver.findElement(headerPopUpWindowOrderDone).getText().contains("Заказ оформлен");
    }
}


