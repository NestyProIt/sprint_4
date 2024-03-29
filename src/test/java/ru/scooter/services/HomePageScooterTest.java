package ru.scooter.services;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class HomePageScooterTest {
    //поля
    private final String textAnswerAboutOrderScooterNumber;
    private final int questionAboutOrderScooterNumber;
    private final int answerAboutOrderScooterNumber;
    private final boolean isVisibleAboutOrderScooterNumber;
    private WebDriver driver;

    public HomePageScooterTest(int questionAboutOrderScooterNumber,
                               int answerAboutOrderScooterNumber,
                               String textAnswerAboutOrderScooterNumber,
                               boolean isVisibleAboutOrderScooterNumber) {
        this.questionAboutOrderScooterNumber = questionAboutOrderScooterNumber;
        this.answerAboutOrderScooterNumber = answerAboutOrderScooterNumber;
        this.textAnswerAboutOrderScooterNumber = textAnswerAboutOrderScooterNumber;
        this.isVisibleAboutOrderScooterNumber = isVisibleAboutOrderScooterNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswerAboutOrderScooter() {
        //тестовые данные для выпадающего списка в разделе "Вопросы о важном"
        return new Object[][]{
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},

        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkQuestionAboutOrderScooter() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickCookieButton();
        boolean actualText = homePageScooter.getQuestionAboutOrderScooter(questionAboutOrderScooterNumber, answerAboutOrderScooterNumber)
                .equals(textAnswerAboutOrderScooterNumber);
        assertEquals("Фактический текст не соответствует ожидаемому", isVisibleAboutOrderScooterNumber, actualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
