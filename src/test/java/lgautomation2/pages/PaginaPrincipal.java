package lgautomation2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginaPrincipal extends BasePage {

    public PaginaPrincipal(WebDriver driver) {
        super(driver);
    }

    public void clickContact() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("li[id='menu-item-22140'] a")))
        .click();
    }

    public void clickLearnMore() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@href='https://lgads.tv/contact/'][normalize-space()='Learn more']")))
        .click();
    }

    public void clickStartNow() {
        clickLearnMore();
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//img[@title='lg-ad-solution-allblack']")))
        .click();
    }

    public void clickLGAdSolutions() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("img[alt='LG Ad Solutions']")))
        .click();
    }
}







