# Vaatimusmäärittely

# Sovelluksen tarkoitus 

Sovelluksen avulla käyttäjä pystyy generoimaan fiktiivisten henkilöiden profiileja tarkasteltavaksi tiedostoksi. Sovellusta pystyy käyttämään useampi rekistiröitynyt käyttäjä, joilla kaikilla on oma yksilöllinen ominaisuus ja profiili listansa.

# Käyttäjät

Sovelluksessa on olemassa pääkäyttäjä admin ja tavallinen käyttäjä user, jossa ainoastaan pääkäyttäjä pystyy pääsemään pääkäyttäjä valikkoon

# Lopullisen version tarjoama toiminnallisuus

**Sovelluksen asentamiskäyttöliittymä**
- käyttäjä pystyy valitsemaan julkisen ja yksityisen tilan sovellukselle
- asennuksesta luodaan config tiedosto, joka mahdollistaa sovelluksen uudelleen käynnistämisen asennuksen aikana luotujen asetuksien kanssa

**Sovelluksen kirjautumiskäyttöliittymä**

- käyttäjä pystyy luomaan uuden käyttäjä tunnuksen järjestelmään
 - tunnuksen täytyy olla uniikki ja pituudeltaan vähintään 5 merkkiä 
- käyttäjä voi kirjautua järjestelmään 
  - käyttäjän on kirjautuakseen syötettävä olemassa oleva käyttäjätunnus kirjautumislomakkeeseen 
  - jos käyttäjätunnusta ei ole olemassa, niin järjestelemä ilmoittaa tästä 
  
**Sovelluksen pääkäyttöliittymä**

- käyttäjä näkee päävalikkossa olevan ominaisuushallinta,profiilihallinta ja uloskirjautuminen valinnat 
 - ominaisuushallinta siirtää käyttäjän uuteen valikkoon 
 - profiilihallinta siirtää käyttäjän uuteen valikkoon 
 - uloskirjautuminen palauttaa käyttäjän takaisin kirjautumiskäyttöliittymään 
 
**Sovelluksen ominaisuushallinta käyttöliittymä**

- käyttäjä näkee valikossa lisää ominaisuus,poista ominaisuus ja siirry takaisin päävalikkoon 
 - lisää ominaisuus mahdollistaa uuden fiktiivisen ominaisuuden lisäämisen tietokantaan 
 - poista ominaisuus mahdollistaa käyttäjän luomien fiktiivisten ominaisuuksien poistamisen tietokannasta 
 - siirry takaisin siirtää käyttäjän takaisin pääkäyttöliittymään 

**Sovelluksen profiilihallinta käyttöliittymä**

- käyttäjä näkee valikossa luo profiili, luo tiedosto profiilista, resetoi nykyinen profiili ja siirry takaisin päävalikkoon 
 - luo profiili mahdollistaa tietokannassa olevien ominaisuuksien käyttämisen profiilin luomisessa 
 - luo tiedosto profiilista mahdollistaa valmiista profiilista generoidun tiedoston luomisen 
 - resetoi nykyinen profiili mahdollistaa luodun profiilin tyhjentämisen 
 - siirry takaisin siirtää käyttäjän takaisin pääkäyttöliittymään 
 
**Sovelluksen profiilieditointi käyttöliittymä työkalut**
- käyttäjä pystyy valitsemaan haluamansa ominaisuuden
- käyttäjä pystyy tarkastelemaan sanojen määrää
- käyttäjä pystyy tarkastelemaan merkkien määrää
- käyttäjä pystyy tarkastelemaan linjojen määrää
- käyttäjä pystyy tarkastelemaan tekstin rajoja
- käyttäjä pystyy käyttämään perus templatea
 
**Sovelluksen pääkäyttäjä käyttöliittymä**
- sovelluksessa on olemassa pääkäyttäjä admin ja tavallinen user, joissa pääkäyttäjä pääsee hyödyntämään pääkäyttäjä valikkoa
- pääkäyttäjä valikko mahdollistaa tietokantojen parametrien tarkastelun ja olemassa olevien käyttäjien tarkastelun ja poistamisen

   





  


  
