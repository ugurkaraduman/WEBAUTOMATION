@urunEkle

Feature: Kulaklık ekleme senaryosu

  Scenario Outline:Kulaklık ekleme senaryosu
    Given Cerezler kabul edilir ve tamama basılır
    When Arama alanına tıklanır
    And Arama alanına <Urun> yazılır
    And Bluetooth Kulaklık seçilir
    And En Çok Satanlar Filtresi uygulanır
    And İlk ürün seçilir
    And Sepete Ekle butonuna tıklanır
    Then Ürünün sepete eklendiği görüntülenir
    And Browserda geri gidilir
    And Son ürüne gidilir
    And Son ürün seçilir
    And Sepete Ekle butonuna tıklanır
    Then Ürünün sepete eklendiği görüntülenir
    And Sepetime Git butonuna tıklanır
    And Ucuz olan ürün bir artırılır
    And Alışverişi Tamamla butonuna tıklanır
    And Üye Olmadan Devam Et butonuna tıklanır
    And Eposta adresi yazılır

    Examples:
      | Urun               |
      | Bluetooth Kulaklık |

