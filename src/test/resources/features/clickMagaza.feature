@clickMagaza

  Feature: Kurumsal-Mağazalarımız seçme senaryosu

   Scenario:Mağazalarımız tıklama senaryosu
     Given Cerezler kabul edilir ve tamama basılır
     When Mağazalarımız tıklanır
     And İl seçilir
     And Gaziantep seçilir
     And İlçe seçilir
     And Şehitkamil seçilir
     And Listelenen mağazaları getir
     And Mağazaları "magaza.txt" dosyasına yazdırır