package ru.scooter.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//класс главной страницы
public class HomePageScooter {
    //локатор кнопки "Заказать" на главной странице в хедере
    private final By orderButtonInHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    //локатор кнопки "Заказать" в теле главной страницы
    private final By orderButtonHomeFinish = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //локатор кнопки принять куки "да все привыкли"
    private final By acceptCookieButton = By.id("rcc-confirm-button");
    //локатор Сколько это стоит? И как оплатить?
    private final By whatPrice = By.xpath(".//div[@id='accordion__heading-0']");
    //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private final By itPrice = By.xpath(".//div[@id='accordion__panel-0']/p");
    //локатор Хочу сразу несколько самокатов! Так можно?
    private final By orderSeveralScooter = By.xpath(".//div[@id='accordion__heading-1']");
    //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private final By oneOrderOneScooter = By.xpath(".//div[@id='accordion__panel-1']/p");
    //локатор Как рассчитывается время аренды?
    private final By howTimeRentScooter = By.xpath(".//div[@id='accordion__heading-2']");
    //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final By timeRentScooterDescription = By.xpath(".//div[@id='accordion__panel-2']/p");
    //локатор Можно ли заказать самокат прямо на сегодня?
    private final By orderScooterToday = By.xpath(".//div[@id='accordion__heading-3']");
    //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final By orderScooterTomorrow = By.xpath(".//div[@id='accordion__panel-3']/p");
    //локатор Можно ли продлить заказ или вернуть самокат раньше?
    private final By orderExtensionOrReturn = By.xpath(".//div[@id='accordion__heading-4']");
    //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final By orderExtensionOrReturnDescription = By.xpath(".//div[@id='accordion__panel-4']/p");
    //локатор Вы привозите зарядку вместе с самокатом?
    private final By chargingScooter = By.xpath(".//div[@id='accordion__heading-5']");

    //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private final By chargingScooterDescription = By.xpath(".//div[@id='accordion__panel-5']/p");
    //локатор Можно ли отменить заказ?
    private final By orderCancel = By.xpath(".//div[@id='accordion__heading-6']");
    //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private final By orderCancelDescription = By.xpath(".//div[@id='accordion__panel-6']/p");
    //локатор я жизу за МКАДом, привезёте?
    private final By orderDeliveryOutMkad = By.xpath(".//div[@id='accordion__heading-7']");
    //Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final By orderDeliveryOutMkadDescription = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;

    }

    //кликнуть по кнопке "Заказать" в хедере
    public void clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }

    //кликнуть по кнопке "Заказать" в теле главной страницы
    public void clickOrderButtonHomeFinish() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButtonHomeFinish));

        WebElement element = driver.findElement(orderButtonHomeFinish);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(orderButtonHomeFinish).click();
    }

    //принять куки
    public void clickCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }

    //получить текст ответа на вопрос из выпадающего списка раздела "Вопросы о важном"
    public String getQuestionAboutOrderScooter(int questionAboutOrderScooterNumber, int answerAboutOrderScooterNumber) {
        //список вопросов
        List<By> questionsAboutOrderScooterNumber = new ArrayList<>();

        questionsAboutOrderScooterNumber.add(0, whatPrice);

        questionsAboutOrderScooterNumber.add(1, orderSeveralScooter);

        questionsAboutOrderScooterNumber.add(2, howTimeRentScooter);

        questionsAboutOrderScooterNumber.add(3, orderScooterToday);

        questionsAboutOrderScooterNumber.add(4, orderExtensionOrReturn);

        questionsAboutOrderScooterNumber.add(5, chargingScooter);

        questionsAboutOrderScooterNumber.add(6, orderCancel);

        questionsAboutOrderScooterNumber.add(7, orderDeliveryOutMkad);

        //список ответов
        List<By> answersAboutOrderScooterNumber = new ArrayList<>();

        answersAboutOrderScooterNumber.add(0, itPrice);

        answersAboutOrderScooterNumber.add(1, oneOrderOneScooter);

        answersAboutOrderScooterNumber.add(2, timeRentScooterDescription);

        answersAboutOrderScooterNumber.add(3, orderScooterTomorrow);

        answersAboutOrderScooterNumber.add(4, orderExtensionOrReturnDescription);

        answersAboutOrderScooterNumber.add(5, chargingScooterDescription);

        answersAboutOrderScooterNumber.add(6, orderCancelDescription);

        answersAboutOrderScooterNumber.add(7, orderDeliveryOutMkadDescription);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderButtonInHeader));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsAboutOrderScooterNumber.get(questionAboutOrderScooterNumber)));

        driver.findElement(questionsAboutOrderScooterNumber.get(questionAboutOrderScooterNumber)).click();
        return driver.findElement(answersAboutOrderScooterNumber.get(answerAboutOrderScooterNumber)).getText();
    }
}
