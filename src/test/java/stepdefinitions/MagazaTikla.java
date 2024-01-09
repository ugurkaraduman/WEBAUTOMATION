package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Magaza;


public class MagazaTikla {
    Magaza magaza=new Magaza();
    @When("Mağazalarımız tıklanır")
    public void magazalarimizTiklanir() throws InterruptedException {
        magaza.magazaTiklanir();
    }

    @And("İl seçilir")
    public void ilSecilir(){
        magaza.ilSecilir();
    }

    @And("Gaziantep seçilir")
    public void gaziantepSecilir(){
        magaza.gaziantepSecilir();
    }

    @And("İlçe seçilir")
    public void ilceSecilir(){
        magaza.ilceSecilir();
    }
    @And("Şehitkamil seçilir")
    public void sehitkamilSecilir(){
        magaza.sehitkamilSecilir();
    }
    @And("Listelenen mağazaları getir")
    public void listelenenler(){
        magaza.listelenenler();
    }

    @And("Mağazaları {string} dosyasına yazdırır")
    public void yazdir(String ad){
        magaza.yazdir(ad);
    }
}
