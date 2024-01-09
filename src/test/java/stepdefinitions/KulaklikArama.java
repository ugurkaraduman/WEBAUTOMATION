package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Kulaklik;

public class KulaklikArama {

    Kulaklik kulaklik = new Kulaklik();

    @When("Arama alanına tıklanır")
    public void aramaAlaninaTiklanir(){
        kulaklik.aramaTikla();
    }

    @And("Arama alanına {} yazılır")
    public void aramaAlanınaYazılır(String arg0) {
        kulaklik.kulaklikYazi(arg0);
    }

    @And("Bluetooth Kulaklık seçilir")
    public void bluetoothKulaklıkSecilir() throws InterruptedException {
        kulaklik.kategoriSec();
    }

    @And("En Çok Satanlar Filtresi uygulanır")
    public void enCokSatanlarFiltresiUygulanır() {
        kulaklik.filtreUygula();
    }

    @And("İlk ürün seçilir")
    public void ilkUrunSec() {
        kulaklik.ilkUrunuSec();
    }

    @And("Sepete Ekle butonuna tıklanır")
    public void sepeteEklenir() throws InterruptedException {
        kulaklik.sepeteEkle();
    }

    @And("Browserda geri gidilir")
    public void browserdaGeriGidilir() {
        kulaklik.geriGit();
    }

    @And("Son ürüne gidilir")
    public void sonUruneGidilir() {
        kulaklik.sonUruneGit();
    }

    @And("Son ürün seçilir")
    public void sonUrunSecilir() throws InterruptedException {
        kulaklik.sonUrunuSec();
    }


    @And("Sepetime Git butonuna tıklanır")
    public void sepetimeGitButonunaTıklanır() {
        kulaklik.sepetimeGit();
    }

    @And("Ucuz olan ürün bir artırılır")
    public void ucuzOlanUrunBirArtırılır(){
        kulaklik.artıButonuTıkla();
    }

    @And("Alışverişi Tamamla butonuna tıklanır")
    public void alısverisiTamamlaButonunaTıklanır() {
        kulaklik.alisverisiTamamlaButonu();
    }

    @And("Üye Olmadan Devam Et butonuna tıklanır")
    public void uyeOlmadanDevamEtButonunaTıklanır() {
        kulaklik.uyeOlmadanDevamEtButonunaTıklanır();
    }

    @And("Eposta adresi yazılır")
    public void epostaAdresiYazılır() {
        kulaklik.epostaAdtesiYaz();
    }

    @Then("Ürünün sepete eklendiği görüntülenir")
    public void ilkUrununSepeteEklendigiGoruntulenir() {
        kulaklik.ilkUrunEklendi();
    }
}
