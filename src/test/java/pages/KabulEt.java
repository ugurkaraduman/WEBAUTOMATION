package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

public class KabulEt {
    public KabulEt(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final By tamamButton = By.xpath("//div[@class='ins-element-content ins-editable-text ins-web-opt-in-reminder-button']//div[contains (., 'Tamam')]");

    public final By kabulEtButton = By.xpath("//div[@class='ins-element-content ins-editable-text ins-web-opt-in-reminder-button']//div[contains (., 'Tamam')]");


    public void kabulEdilir(){
        Action.clickElement(tamamButton);
//        Action.clickElement(kabulEtButton);
    }


}
