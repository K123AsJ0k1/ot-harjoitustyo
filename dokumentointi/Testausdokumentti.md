# Testausdokumentti

Ohjelmaa on testattu automatisoitujen yksikkö- ja integrointi testien avulla JUnitilla ja sekä manuaalisesti tapahtunein järjestelmä tason testein.

# Yksikkö testaus

**Sovelluslogiikka**

Testit testaavat DAO-luokkia ja olioita, mutta se ei testaa käyttöliittymä  UiInstallCore ja UiLogicCore logikkaa tai tiedosto logiikkaa, koska sovelluslogiikan tärkein puoli tulee testattua DAO-luokkien testien avulla. DAO-luokkien testeissä tarkastetaan jokaiset yleiset mahdollisuudet ja niiden yhteistä toimintaa testataan muutamassa integraatio testissä. DAO-luokkien yksikkö ja integraatio testit hyödyntävät samaa tallennus tapaa, eli ne luovat standardi kansion jos sitä ei ole ja lisäävät tietokanta tiedoston siihen. 

**DAO-Luokkat**

DAO luokkien testaamisessa käytety kansio on nimeltään projectdatabases ja se on olemassa testien jälkeen sellaisessa tilassa, ettei tavallinen sovellus pitäisi häiriintyä sen takia.

**Testauskattavuus**

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Testikuva.PNG)

# Järjestelmätestaus

Sovelluksen järjestelmätestaus on tehty manuaalisesti.

**Asennus ja konfigurointi**

**Toiminnallisuudet**

# Sovellukseen jääneet laatuongelmat 
