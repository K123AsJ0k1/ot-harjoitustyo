# Arkkitehtuurikuvaus

# Rakenne 

Ohjelma on rakenteeltaan viisitasoinen, ja koodin pakkausrakenne on seuraava:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkausrakenne.png)

Pakkaus main sisältää sovelluksen käynnistykseen tarvitun mainin, pakkaus ui sisältää käyttöliittymän tarvitsemat setOnAction tapahtumat ja käynnistämis ja sulkemistapahtumat, pakkaus service sisältää tarvittavat käyttöliittymä scenet, logiikan ja muun toiminallisuuden, pakkaus domain sisältää servicen tarvitsemat rajapinnat ja pakkaus dao sisältää sovelluksen tarvitsemat tietokannat. Lisäksi on huomattavaa se, että service hyödyntää olioita sisältävää assets pakkausta, asennus näkymä pakkausta installscenes pakkausta, perusnäkymä pakkausta mainscenes, lista pakkausta tables, käyttöliittymä logiikkaa sisältävää uilogic pakkausta, tiedosto logiikkaa sisältävää filelogic pakkausta ja teksti logiikkaa sisältävää textlogic pakkausta.

# Käyttöliittymä

Käyttöliittymä jakautuu kahteen osaan, jotka ovat asennus näkymät

- tervetuloa näkymä
- julkinen dao asetus näkymä
- yksityinen dao asetus näkymä
- pääkäyttäjä asetus näkymä

ja perusnäkymät 

- kirjautuminen
- uuden käyttäjän luominen
- julkinen päävalikko
- yksityinen päävalikko
- ominaisuusvalikko
- ominaisuuksien lisäys
- ominaisuuksien poistaminen
- profiili valikko
- profiilin luonti 
- ominaisuuden valitseminen
- tiedoston luonti
- pääkäyttäjä valikko
- parametri lista 
- käyttäjä lista

jokainen näistä on toteutettu omana Scene-oliona, jotka tuodaan hyödyntämällä scenePlayeriä. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksena stageen. Käyttöliittymä on toiminallisesti luokassa ui.UserInterface ja taas jokainen toiminta suoritetaan uiLogic pakkauksen sisältämissä luokissa.

Käyttöliittymä itsessään vastaa setOnAction toiminnasta, kun taas näiden aiheuttamasta toiminnan viestimisestä huolehtivat UiInstallCore ja UiLogicCore, jossa varsinaiset toimet aiheuttavat uilogic pakkauksen luokat ja niiden viestiminen ScenePlayer,DaoPlayer ja TextPlayerin kanssa.

# Sovelluslogiikka

Sovelluksen perusversion datamalli koostuu seitsemästä tietokannasta nimiltään:

- UsernameDatabase
- ClassDatabase
- NameDatabase
- DesriptionDatabase
- RequrimentDatabase
- RealityDatabase
- AbilityDatabase

Tietokannat keskustelevat käyttöliittymän kanssa rajapintojen DatabaseInterface ja UsernameInterface kautta, jotka tarjoavat metodit: 

**DatabaseInterface**

- public boolean createDatabase() throws Exception
- public boolean databaseExists()
- public boolean addInformation(String information)
- public boolean searchInformation(String infromation)
- public Integer searchInformationId(String infromation)
- public String searchInformationTextIdentityt(String infromation)
- public List<String> showDatabaseAsAList()
- public List<String> showDatabaseAsARestrictedList(String infromation)
- public boolean removeInformation(String information)
- public boolean removeDatabase() throws Exception
  
**UsernameInterface**

- public boolean createUsernameDatabase() throws Exception
- public boolean usernameDatabaseExists()
- public boolean addUserInformation(String information, String secondInformation)
- public boolean searchUserInformation(String information)
- public boolean userPasswordCheck(String username, String password)
- public Integer searchUsernameId(String information)
- public boolean removeUserInformation(String information)
- public boolean removeDatabase() throws Exception

Kummankin rajapinnan metodit mahdollistavat perustoiminnot, kuten tiedot lisäyksen, haun, tarkastuksen ja poistamisen, mutta DatabaseInterface mahdollistaa myös tietokannan listaamisen, joko kokonaisena tai rajoitettuna.  

Muita tärkeitä rajapintoja ovat FileWriterInterface,TextRefineryInterface ja TextTemplateInterface ja lisäksi Ability-olio, joiden metodit ovat

**FileWriterInterface**

- public boolean saveTextAsAFile(String information, File file)
- public void showSaveFileDialog(Stage primaryStage, String text)

**TextRefineryInterface**

- public boolean givenTextLineChecker(String information)
- public boolean givenTextLineHasSpaces(String information)
- public String choosenAbilityIsFoundFromText(String information, String abilityInformation)
- public List<String> choosenAbilitiesAreFoundFromText(String information, List<String> abilityList)
- public Integer giveTextWordCount(String infromation)
- public Integer giveCharacterCount(String infromation)
  
 **TextTemplateInterface**
 
 - public String simpleMaker()
  
**Ability**

- public String getClassIdentity()
- public String getNameIdentity()
- public String getDescriptionIdentity()
- public String getRequrimentIdentity()
- public String getRealityIdentity()
- public String toString()

FileWriterInterface mahdollistaa tiedostojen tallentamisen ja siihen tarvittu käyttöliittymä dialogin, TextRefineryInterface mahdollistaa käyttöliittymän antaman profiili tekstin muokkauksen, TextTempalteInterface mahdollistaa erilaisten profiili mallien tuomisen käyttöliittymään ja ability olio mahdollistaa käyttöliittymässä käytety listat.

Alla oleva luokka/pakkauskaavio näyttää tämän hetkisen (28.4.2020) sovelluslogiikan suhdetta eri rajapintojen välillä
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

Pakkauksen dao luokat ClassDatabase,NameDatabase,DescriptionDatabase,RequrimentDatabase,RealityDatabase ja UsernameDatabase hyödyntävät SQLlite:ä tietojen tallentamiseen tietokannan nimen mukaisiin tiedostoihin. 

Luokat noudattavat Data Access Object-suunnitelumallia ja ne voidaan tarpeen mukaan korvata uusilla toteutuksilla, jos sovelluksen datan talletustapa halutaan vaihtaa, sillä ne ovat eristettyjä DatabaseInterface ja UsernameInterfacen taakse ja sovelluslogiikka ei hyödynnä näitä luokkia suoraan.

**Päätoiminnallisuudet**

Alla olevat sekvenssikaaviot kuvaavat sovelluksen päätoiminallisuuden toimintalogiikkaa

**Käyttäjän kirjaantuminen**
Kun kirjautumisnäkymässä on syötekenttään kirjoitettu käyttäjätunnus, salasana ja login painiketta painetaan, etenee sovelluksen kontrolli seuraavasti:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4n%20kirjautumisen%20sekvenssikaavio.png)

Painikkeen painaimiseen reagoiva tapahtumakäsittelijä saa käyttöliittymän hakemaan tekstikenttien sisällä olevat merkkijonot ja tarkastamaan ensiksi käyttäjä nimen olemassa olon ja sitten käyttäjän ja siihen liitetyn salasanan olemassa olon tietokannasta, jotka hyväksymisen jälkeen saavat käyttöliittymän lisäämään käyttäjän ja salasanan username ja password string olioihin ja hakemaan tietokannan antama id numeron käyttäjälle, asettaen sen usernameid olioon ja lopuksi kutsumaan screenMainMenu olion ja näin vaihten näkymän päävalikkoon.



**Käyttäjän luominen**

Käyttäjän luodessa uuden käyttäjän, eli hänen laitettuaan syötekentään haluamansa käyttäjän, salasanan ja painettuaan create username painiketta, etenee sovelluksen kontrolli seuraavasti: 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4nluonnin%20sekvenssikaavio.png)

Painikkeen painaimiseen reagoiva tapahtumakäsittelijä saa käyttöliittymän hakemaan tekstikenttien sisällä olevat merkkijonot ja tarkastamaan käyttäjä nimen ja salasanan pituuden, joiden on oltava vähintään 5 merkkiä pitkiä. Tarkastuksen jälkeen käyttöliittymä tarkastaa rajapinnan kautta, onko käyttäjä nimeä olemassa ja hyväksymisen jälkeen käyttäjä nimen ja salasanan olemassa olon tietokannasta, joiden antaessa false voi käyttöliittymä jatkaa käyttäjänimen ja salasanan lisäämistä tietokantaan. Lisäämisen tuottaessa true arvon ja tultua rajapinnan kautta, käyttöliittymä kutsuu screenMainMenu Scene oliota ja muuttaa näkymän päävalikoksi.

**Ominaisuuden luominen**

Käyttäjän täyttäessä jokaisen tekstikentän ja painettuaan add ability painiketta, etenee sovelluksen kontrolli seuraavasti:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20lis%C3%A4%C3%A4misen%20sekvenssikaavio.png)

Painikkeen painaimiseen reagoiva tapahtumakäsittelijä saa käyttöliittymän hakemaan tekstikenttien sisällä olevat merkkijonot ja lähettää asettaa ne lisättäksi parametreiksi, mikä saa UiAblity Logikin tarkastamaan saatujen parametrien pituudet ja jos ne ovat nolla suuremmat, niin UiAbility lähettää jokaisen parametrin tarkastettavaksi tietokantoihin. Jos kaikki ovat False, niin kaikki parametrit lisätään tietokantoihin ja lisäämisen jälkeen jokaisen parametrin id haetaan, ja jos kaikki ovat 0 suurempia niin ne läpäisevät ja niistä luodaan ominaisuus tietokantaan lisättä merkkijono. Luotu merkkijonon olemassa olo tarkastetaan ominaisuus tietokannasta ja jos sitä ei ole, niin se lisätään ja jos lisääminen onnistuu, niin käyttöliittymään lähetetään viesti. Viesti asetettaan käyttöliittymän käyttämään Label olioon, jonka jälkeen käytetyt tekstikentät tyhjennettään ja käyttöliittymä palautuu normaalin tilaansa. 

**Ominaisuuden poistaminen**

Käyttäjän valittua poistettava ominaisuus ja painettua remove ability painiketta, etenee sovelluksen kontrolli seuraavasti:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20poistamisen%20sekvenssikaavio.png)

Painikkeen painaimiseen reagoiva tapahtumakäsittelijä saa käyttöliittymän hakemaan listassa valitun rivin ja sen sisältämät tiedot, jonka antamat tiedot käyttöliittymä lähettää UIAbilityLogiksille, joka ensin luo String taulun saadusta merkkijonosta ja sen jälkeen UiABilityLogic lähettää id pyynnön rajapinnan kautta parametrien tietokannoille. Saatuaan tarvitut id, se luo niistä Abilitydatabase mukaisen merkkijonon, jonka se lähettää rajapinnan kautta tietokannalle. Abilitydatabasen lähetettyä truen, sen tarkastetaan, jonka jälkeen siirrytään takaisin käyttöliittymään. Käyttöliittmän listasta poistetaan valittu ominaisuus ja tämä saa käyttöliittän pudottamaan sen listasta, jolloin käyttäjä ei näe kyseistä ominaisuutta enää listassa.

**Ominaisuuden valitseminen**

Käyttäjän valittua haluamansa ominaisuuden ja paineuttaan choose ability painikettta, etenee sovelluksen kontrolli seuraavasti:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20valitsemisen%20sekvenssikaavio.png)

Painikkeen painaimiseen reagoiva tapahtumakäsittelijä saa käyttöliittymän hakemaan listassa valitun rivin ja sen sisältämät tiedot, jonka antamat tiedot käyttöliittymä tarkistaa ja sitten lähettää UIAbilityLogiksille, joka luo String taulun saadusta merkkijonosta ja sen jälkeen luo niistä halutun merkkijonon. Merkkijonon valmistuttua, se lähetään takaisin käyttöliittymään jossa se asetettaan choosenAbility, leftOverParameters ja Label olion arvoksi ja sen jälkeen käyttöliittymä kutsuu createProfileScene oliota ja näin käyttöliittymä siirtyy luo profiili sceneen.

**Muut toiminallisuudet**

Sovelluksen sovelluslogiikka toimii yleisesti yllä esitetyillä tavoilla, eli käyttöliittymä tapahtumakäsittelijä kutsuu sopivaa sovelluslogiikan metodia, käyttöliittmä joko kutsuu jotain erillään olevaa sovellusloogikkaa kansiota tai lähettää itse jonkin pyynnön rajapintojen kautta tietokannoille ja ne lähettävät pyynnön mukaisesti joko String, Integer tai Boolean arvon, jonka mukaisesti käyttöliittymä tai erillinen sovelluslogiikka pyytää käyttöliittymää mukautuu halutusti tilanteeseen.


# Ohjelman rakenteeseen jääneet heikkoudet
