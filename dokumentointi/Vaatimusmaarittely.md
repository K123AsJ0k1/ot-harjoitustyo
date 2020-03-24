# Vaatimusmäärittely

# Sovelluksen tarkoitus 

Sovelluksen avulla käyttäjä pystyy generoimaan fiktiivisten henkilöiden profiileja tarkasteltavaksi tiedostoksi. Sovellusta pystyy käyttämään useampi rekiseröitynyt käyttäjä, joilla kaikilla on oma yksilöllinen ominaisuus- ja profiililistansa.

# Käyttäjät

Sovelluksessa on alussa ainoastaan yksi käyttäjärooli, joka on normaali käyttäjä. Myöhemmässä vaiheessa, sovellukseen saatetaan lisätä suuremmilla oikeuksilla varustettu pääkäyttäjä. 

# Perusversion tarjoama toiminnallisuus

**Sovelluksen kirjautumiskäyttöliittymä**

- käyttäjä pystyy luomaan uuden käyttäjä tunnuksen järjestelmään
 - tunnuksen täytyy olla uniikki ja pituudeltaan vähintään 5 merkkiä
- käyttäjä voi kirjautua järjestelmään 
  - käyttäjän on kirjautuakseen syötettävä olemassa oleva käyttäjätunnus kirjautumislomakkeeseen
  - jos käyttäjätunnusta ei ole olemassa, niin järjestelemä ilmoittaa tästä
  
**Sovelluksen pääkäyttöliittymä**

-käyttäjä näkee päävalikkossa olevan ominaisuushallinta,profiilihallinta ja uloskirjautuminen valinnat
 - ominaisuushallinta siirtää käyttäjän uuteen valikkoon
 - profiilihallinta siirtää käyttäjän uuteen valikkoon
 - uloskirjautuminen palauttaa käyttäjän takaisin kirjautumiskäyttöliittymään
 
**Sovelluksen ominaisuushallintakäyttöliittymä**

- käyttäjä näkee valikossa lisää ominaisuus,poista ominaisuus ja siirry takaisin päävalikkoon
 - lisää ominaisuus mahdollistaa uuden fiktiivisen ominaisuuden lisäämisen tietokantaan
 - poista ominaisuus mahdollistaa käyttäjän luomien fiktiivisten ominaisuuksien poistamisen tietokannasta
 - siirry takaisin siirtää käyttäjän takaisin pääkäyttöliittymään

**Sovelluksen profiilihallintakäyttöliittymä**

- käyttää näkee valikossa luo profiili, luo tiedosto profiilista, resetoi nykyinen profiili ja siirry takaisin päävalikkoon
 - luo profiili mahdollistaa tietokannassa olevien ominaisuuksien käyttämisen profiilin luomisessa
 - luo tiedosto profiilista mahdollistaa valmiista profiilista generoidun tiedoston luomisen
 - resetoi nykyinen profiili mahdollistaa luodun profiilin tyhjentämisen 
 - siirry takaisin siirtää käyttäjän takaisin pääkäyttöliittymään
   
# Jatkokehitysideoita

Perusversion valmistumisen jälkeen sitä tullaan täydentämään ajan salliessa esimerkiksi seuraavilla toiminnallisuuksilla

- tietokannassa olevien ominaisuuksien tarkastelu
- profiilien tallentaminen tietokantaan
- tietokannassa olevien profiilien tarkastaminen
- tietokannassa olevien ominaisuuksien muokkaus
- tietokannassa olevien profiilien muokkaus
- muiden käyttäjien omnaisuuksien ja profiilien tarkastelu
- pääkäyttäjän luominen
- käyttäjien salasana tarkastuksen ja tallennuksen luominen
- sovelluksen käyttäminen yksityisessä tilassa ilman käyttäjätunnusten kysymistä
- pääkäyttäjien sovelluksen ylläpito työkalut
- olemassa olevien käyttäjä tunnusten ja niihin liittyvien ominaisuuksien ja profiilien poisto
- ominaisuuksien ja profiilien paremmusjärjestys
- muiden käyttäjien ominaisuuksien ja profiilien hyödyntäminen
- uusien ominaisuuksien ja profiilien luominen satunnaisuudella 




  


  
