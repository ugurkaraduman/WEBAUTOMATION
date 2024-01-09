package pages;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

public class Kulaklik {


    public Kulaklik () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public By sonUruneTikla;

    private String urunAdedi;

    private int urunSayi;

    private String urunFiyat1,urunFiyat2;

    private double birinciUrunFiyati,ikinciUrunFiyati;

    public final By urunFiyat1By = By.xpath("//div[@class='cart-row'][1]//div[@class='prd-prc2']//b");

    public final By urunFiyat2By = By.xpath("//div[@class='cart-row'][2]//div[@class='prd-prc2']//b");

    public final By birinciUrunuArttir = By.xpath("//form[@id='updateCartForm1']//div[@class='crp-qty']//button[@class='plus  quantity-right-plus']");

    public final By ikinciUrunuArttir = By.xpath("//form[@id='updateCartForm0']//div[@class='crp-qty']//button[@class='plus  quantity-right-plus']");

    public final By aramaAlaninaTikla = By.xpath("//div[@class='sbx-header']");

    public final By aramaAlani = By.xpath("//div[@class='sbx-input']//input[@id='search-input']");

    public final By bKulaklikTikla = By.xpath("//div[@class='sbox-result']//div[@class='sbox-result-list sbx-resul sbx-popl category']//a[@title='Bluetooth Kulaklık']");

    public final By enCokSatanlar = By.xpath("//div[@class='input radio']//label[contains(.,'En Çok Satanlar')]");

    public final By ilkUrunTikla = By.xpath("//div[@id='product-item'][1]");

    public final By sepeteEkleButonu = By.id("addToCartButton");

    public final By urunSayisi = By.xpath("//div[@class='plp-paging-info']//b");

    public final By dahaFazlaUrunGor = By.xpath("//button[@class='btn btn-extra plp-paging-load-more']//span[contains(.,'Daha Fazla Ürün Gör')]");

    public final By sepetimeGitButonu = By.xpath("//div[@class='pac-buttons']//a[@class='btn btn-primary']");

    public final By alisverisiTamamla = By.xpath("//div[@class='cart-sum-cta']//a[@title='Alışverişi Tamamla']");

    public final By uyeOlmadanDevamEt = By.xpath("//a[@title='Üye Olmadan Devam Et']");

    public final By ePosta = By.id("guest.email");

    public final By basariylaEklendiBy = By.xpath("//div[@class='modal-product-added mnp mnp-target mnp-m-bottom mnp-d-center mnp-lg']//div[@class='mnp-title']");

    public final By urunGuncellendi = By.xpath("//div[@id='js-global-success-message']//div//div");

    public void aramaTikla(){
        Action.clickElement(aramaAlaninaTikla);
    }
    public void kulaklikYazi(String urun){
        Action.sendKeysElement(aramaAlani, urun);
    }

    public void kategoriSec() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickElement(bKulaklikTikla);
    }

    public void filtreUygula() {
        Action.clickElement(enCokSatanlar);
    }

    public void ilkUrunuSec() {
        Action.clickElement(ilkUrunTikla);
    }

    public void sepeteEkle() throws InterruptedException {
        Action.scrollUntilVisible(sepeteEkleButonu);
        Thread.sleep(2000);
        Action.clickElement(sepeteEkleButonu);
    }

    public void geriGit() {
        Action.back();
    }

    public void sonUruneGit() {
        urunAdedi=Action.getTextElement(urunSayisi);
    }

    public void sonUrunuSec() throws InterruptedException {
        urunSayi=Integer.valueOf(urunAdedi);
        for(int i=20;i<urunSayi;i+=20){
            if(!(Action.getTextElement(urunSayisi).isBlank())){
                Thread.sleep(3000);
                Action.scrollUntilVisible(dahaFazlaUrunGor);
                Thread.sleep(3000);
                Action.clickElement(dahaFazlaUrunGor);
            }
        }
        Action.scrollUntilVisible(By.xpath("//div[@id='product-item'][" + urunAdedi + "]"));
        Thread.sleep(3000);
        Action.clickElement(By.xpath("//div[@id='product-item'][" + urunAdedi + "]"));

    }


    public void sepetimeGit() {
        Action.clickElement(sepetimeGitButonu);
    }

    public void ilkUrunFiyatiniAl() {
        urunFiyat1=Action.getTextElement(urunFiyat1By);
        urunFiyat1 = urunFiyat1.replace(" TL", "");
        System.out.println(urunFiyat1);
    }

    public void ikinciUrunFiyatiniAl() {
        urunFiyat2=Action.getTextElement(urunFiyat2By);
        urunFiyat2 = urunFiyat2.replace(" TL", "");
        System.out.println(urunFiyat2);
    }


    public void artıButonuTıkla(){
        ilkUrunFiyatiniAl();
        ikinciUrunFiyatiniAl();
        birinciUrunFiyati=Double.parseDouble(urunFiyat1);
        System.out.println(birinciUrunFiyati);
        ikinciUrunFiyati=Double.parseDouble(urunFiyat2);
        System.out.println(ikinciUrunFiyati);
        if (birinciUrunFiyati < ikinciUrunFiyati){
            Action.clickElement(birinciUrunuArttir);
            Action.checkElementText(urunGuncellendi,"Ürün miktarı güncellendi");
        }else {
            Action.clickElement(ikinciUrunuArttir);
            Action.checkElementText(urunGuncellendi,"Ürün miktarı güncellendi");
        }

    }

    public void alisverisiTamamlaButonu() {
        Action.clickElement(alisverisiTamamla);
    }

    public void uyeOlmadanDevamEtButonunaTıklanır() {
        Action.clickElement(uyeOlmadanDevamEt);
    }

    public void epostaAdtesiYaz() {
        Action.sendKeysElement(ePosta,"abcd@gmail.com");
    }

    public void ilkUrunEklendi() {
        Action.checkElementText(basariylaEklendiBy,"Ürün başarıyla sepetinize eklendi");
    }
}
