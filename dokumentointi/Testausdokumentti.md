# Testausdokumentti

Ohjelmaa on testattu automatisoitujen yksikkö- ja integrointi testien avulla JUnitilla ja sekä manuaalisesti tapahtunein järjestelmä tason testein.

# Yksikkö testaus

**Sovelluslogiikka**

Testit testaavat DAO-luokkia ja olioita, mutta se ei testaa käyttöliittymä  UiInstallCore ja UiLogicCore logikkaa tai tiedosto logiikkaa, koska sovelluslogiikan tärkein puoli tulee testattua DAO-luokkien testien avulla. DAO-luokkien testeissä tarkastetaan jokaiset yleiset mahdollisuudet ja niiden yhteistä toimintaa testataan muutamassa integraatio testissä. DAO-luokkien yksikkö ja integraatio testit hyödyntävät samaa tallennus tapaa, eli ne luovat standardi kansion jos sitä ei ole ja lisäävät tietokanta tiedoston siihen. 

**DAO-Luokkat**

DAO luokkien testaamisessa käytety kansio on nimeltään projectdatabases ja se on olemassa testien jälkeen sellaisessa tilassa, ettei tavallinen sovellus pitäisi häiriintyä sen takia.

**Testauskattavuus**

Käyttöliittymä kerrosta ja käyttöliittymä logiikkaa lukuunottamatta sovelluksen testauksen rivikattavuus on 95 prosenttia ja haarautumiskattavuus on 93 prosenttia

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Testikuva.PNG)

Testaamatta jäivitä tiedostojen toiminta, sovelluslogiikan UiInstallCore ja UiLogicCore ja kaikki Playerit.

# Järjestelmätestaus

Sovelluksen järjestelmätestaus on tehty manuaalisesti.

**Asennus ja konfigurointi**

Sovellus on testattu windows ympäristössä siten, että sovellus onnistui luomaan asennuksen kautta tarvitun config tiedoston, tietokanta folderin ja tietokannat.

Sovellus on testattu tilanteessa, jossa tietokanta folder on poistettu ja sovellus hyödyntää config tiedostoa uuden folderin ja tietokantojen luomiseen.


**Toiminnallisuudet**

Määritellydokumentin ja käyttöohjeen toiminnallisuudet on käyty läpi ja jokaisessa tekstikentässä on yritetty syöttää virheellisiä arvoja ja myös tyhjiä arvoja. 

# Sovellukseen jääneet laatuongelmat 

Sovelluksen käyttöliittymä on kömpelö tilanteissa

- Listojen tarkastelussa, kun listassa on enemmän kuin 20 riviä.

- Profiilin edintoiti työkalut voivat olla kömpelöitä ja välillä puutteellisia
