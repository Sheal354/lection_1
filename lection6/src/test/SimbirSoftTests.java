package test;

import org.dao.Person;
import org.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimbirSoftTests extends BaseTest {

    @BeforeMethod
    void initBeforeMethod() {
        open("/");
    }

    @Test(description = "Show feedback modal window test")
    public void feedBackModalOpenTest() {
        page(MainPage.class)
                .showFeedbackModal()
                .checkModalWindowVisible()
                .checkTextInput();
        sleep(5000);
    }

    @Test(description = "Open Contacts page")
    public void openContactsPageTest() {
        page(MainPage.class)
                .goToContacts()
                .contactsPageIsOpen();
        sleep(7000);
    }

    @Test(description = "Create Person test")
    public void createPersonTest() {
        Person person = new Person.Builder()
                .withName("Testoviy Test Testovich")
                .withAge(45)
                .withWeight(80)
                .build();
    }

    @Test(description = "Open Vacancies page")
    public void openVacanciesPageTest() {
        page(MainPage.class)
                .goToVacancies()
                .vacanciesPageIsOpen()
                .showMoreInfo()
                .goToSdet();
        sleep(7000);
    }
}
