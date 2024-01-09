package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Magaza {
    public Magaza(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final By magazaTikla = By.xpath("//div[@class='fmi-menu']//li[contains (., 'Mağazalarımız')]//a");
    public final By ilSec = By.id("cities1");
    public final By gaziantepSec = By.xpath("//option[@value='27']");
    public final By ilceSec = By.id("towns");
    public final By sehitkamilSec = By.xpath("//option[contains(.,'şehitkamil')]");
    public By defaultElement;
    private List<String> textToWrite;

    public void magazaTiklanir() throws InterruptedException {
        Action.scrollUntilVisible(magazaTikla);
        Thread.sleep(3000);
        Action.clickElement(magazaTikla);
    }
    public void ilSecilir(){
        Action.clickElement(ilSec);
    }
    public void gaziantepSecilir(){
        Action.clickElement(gaziantepSec);
    }
    public void ilceSecilir(){
        Action.clickElement(ilceSec);
    }
    public void sehitkamilSecilir(){
        Action.clickElement(sehitkamilSec);
    }

    public void listelenenler(){
        defaultElement = By.xpath("//div[@class='str-title']");
        textToWrite=Action.getTextElements(defaultElement);
        System.out.println(Action.getTextElements(defaultElement));
    }

    public void yazdir(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(textToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
