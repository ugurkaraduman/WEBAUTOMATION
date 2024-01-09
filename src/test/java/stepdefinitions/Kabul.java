package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.KabulEt;

public class Kabul {
    KabulEt kabulEt=new KabulEt();

    @Given("Cerezler kabul edilir ve tamama basılır")
    public void cerezlerKabulEdilir(){
        kabulEt.kabulEdilir();
    }


}

