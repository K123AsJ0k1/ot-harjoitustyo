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

- public boolean createDatabase()
- public boolean databaseExists()
- public String getConnectionString()
- public boolean addInformation(String information)
- public boolean searchInformation(String infromation)
- public Integer searchInformationId(String infromation)
- public String searchInformationTextIdentityt(String infromation)
- public List<String> showDatabaseAsAList()
- public List<String> showDatabaseAsARestrictedList(String infromation)
- public boolean removeInformation(String information)
- public boolean removeDatabase()
  
**UsernameInterface**

- public boolean createUsernameDatabase() throws Exception
- public boolean usernameDatabaseExists()
- public String getConnectionString()
- public boolean addUserInformation(String information, String secondInformation)
- public boolean searchUserInformation(String information)
- public boolean userPasswordCheck(String username, String password)
- public Integer searchUsernameId(String information)
- public String searchUsernamePrivilage(String information)
- public List<String> showDatabaseAsAList()
- public boolean removeUserInformation(String information)
- public boolean removeDatabase() throws Exception

Kummankin rajapinnan metodit mahdollistavat perustoiminnot, kuten tiedot lisäyksen, haun, tarkastuksen ja poistamisen, mutta DatabaseInterface mahdollistaa myös tietokannan listaamisen, joko kokonaisena tai rajoitettuna.  

Muita tärkeitä rajapintoja ovat FileManagerInterface, FileWriterInterface, TextRefineryInterface ja TextTemplateInterface, joiden metodit ovat

**FileManagerInterface**

- public String getUserPath()
- public String getDirectoryPath()
- public Boolean configFileExists()
- public Boolean createStandardDirectory()
- public Boolean createModifiedDirectory(String givenName)

**FileWriterInterface**

- public boolean saveTextAsAFile(String information, File file)
- public void showSaveFileDialog(Stage primaryStage, String text)
- public boolean saveTextAsAConfig(String information, FileManagerInterface fileManager);

**TextRefineryInterface**

- public boolean givenTextLineChecker(String information)
- public boolean givenTextLineHasSpaces(String information)
- public String choosenAbilityIsFoundFromText(String information, String abilityInformation)
- public List<String> choosenAbilitiesAreFoundFromText(String information, List<String> abilityList)
- public Integer giveTextWordCount(String infromation)
- public Integer giveCharacterCount(String infromation)
  
 **TextTemplateInterface**
 
 - public String simpleMaker()
 
 FileWriterInterface mahdollistaa tiedostojen tallentamisen ja siihen tarvittu käyttöliittymä dialogin, TextRefineryInterface mahdollistaa käyttöliittymän antaman profiili tekstin muokkauksen ja TextTempalteInterface mahdollistaa erilaisten profiili mallien tuomisen käyttöliittymään.
 
 
 Sovelluksen perustoiminnalle tärkeitä olioita ovat Admin,Parameters, TextMode ja User, joiden metodit ovat:
 
 **Admin**

- public String getUsername()
- public String getPassword()
- public String toString()

**Parameters**

- public String getChosenAbility()
- public String getLeftOverParameters()
- public void setChoosenAbility(STring givenString)
- public void setLeftOVerParameters(String givenString)

**TextMode**

- public void setMode(String givenText)
- public String getMode()

**User**

- public String getUsername()
- public String getPassword()
- public String getPrivilage()
- public Integer getId()
- public void setUsername()
- public void setPassword()
- public void setPrivilage()
- public void setId()

Käyttöliittymän listojen toiminnalle tärkeitä olioita ovat UserTable, ClassTable, NameTable, DescriptionTable, RequrimentTable, RealityTable ja AbilityTable, joiden tarjoamat metodit ovat

**UserTable**

- String getNumberIdentity()
- String getUsernameIdentity()
- String getPrivilageIdentity()
- public String toString()

**ClassTable**

- public String getClassNumberIdentity()
- public String getClassNameIdentity()
- public String toString()

**NameTable**

- public String getNameNumberIdentity()
- public String getNameNameIdentity()
- public String toString()

**DescriptionTable**

- public String getDescriptionNumberIdentity()
- public String getDescriptionNameIdentity()
- public String toString()

**RequrimentTable**

- public String getRequrimentNumberIdentity()
- public String getRequrimentNameIdentity()
- public String toString()

**RealityTable**

- public String getRealityNumberIdentity()
- public String getRealityNameIdentity()
- public String toString()
  
**AbilityTable**

- public String getClassIdentity()
- public String getNameIdentity()
- public String getDescriptionIdentity()
- public String getRequrimentIdentity()
- public String getRealityIdentity()
- public String toString()

Lista oliot mahdollistavat tiedonkulun tietokantojen ja käyttöliittymän eri metodien väleillä, jotka tässä tapauksessa ovat TableView ja sen mahdollistama selection model.


Alla oleva luokka/pakkauskaavio näyttää eri pakkausten ja eri luokkien välisiä sovelluslogiikan suhteita
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

**Config tiedosto**

Sovelluksen asennuksen aikana luodaan config niminen tiedosto, joka sisältää sovelluksen tilan, tietokannan tiedostojen nimen ja tietokantojen nimet, ja jotka ovat muodossa

```ProgramMode: Public/Private```

```FolderName: Annettu nimi```

```UsernameDatabaseName: Annettu nimi```

```ClassDatabaseName: Annettu nimi```

```NameDatabaseName: Annettu nimi```

```DescriptionDatabaseName: Annettu nimi```

```RequrimentDatabaseName: Annettu nimi```

```RealityDatabaseName: Annettu nimi```

```AbilityDatabaseName: Annettu nimi```

tiedosto luodaan ja luetaan FileConfig luokassa, joka sijaitsee filelogic pakkauksessa.

**Tietokantojen kansio tiedosto**

Sovelluksen asennuksen yhteydessä tietokannoille luodaan niitä sisältävä kansio, joka on normaalisti nimetty databases ja testi tapauksessa projectdatabases, ja daoPlayer luo aina annettujen configuration mukaisesti tämän kansion ja sen sisällä olevat tietokannat.

**Tietokannat**

Pakkauksen dao luokat ClassDatabase,NameDatabase,DescriptionDatabase,RequrimentDatabase,RealityDatabase ja UsernameDatabase hyödyntävät SQLlite:ä tietojen tallentamiseen tietokannan nimen mukaisiin tiedostoihin. 

Luokat noudattavat Data Access Object-suunnitelumallia ja ne voidaan tarpeen mukaan korvata uusilla toteutuksilla, jos sovelluksen datan talletustapa halutaan vaihtaa, sillä ne ovat eristettyjä DatabaseInterface ja UsernameInterfacen taakse ja sovelluslogiikka ei hyödynnä näitä luokkia suoraan.

**Päätoiminnallisuudet**

Alla olevat sekvenssikaaviot kuvaavat sovelluksen päätoiminallisuuden toimintalogiikkaa

**Config tiedoston luominen**

Kun käyttäjä on painanut joko yksityisen tilan tai julkisen tilan asennuksen finish painiketta, tullaan linja fileWriter.saveTextAsAConfig(configuration.createConfigString(), fileManager) suorittamaan ja sen jälkeen kun configuration on lähettänyt config merkkijonon, etenee sovelluksen kontrolli seuraavasti:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Config%20tiedoston%20luonti.png)


**Sovelluksen uudelleen käynnistäminen**

kun käyttäjä avaa ohjelman uudelleen, suoritetaan ensin main.Main ja sen jälkeen ui.UserInterface, jonka jälkeen käyttöliittymän init() sisällä alustetaan UiInstallCore ja UiLogicCore. UiInstallCore tarkistaa config tiedoston olemassa olon ja sen ollessa olemassa, se myöntää UiLogicCoren tehdä UiLogicCore.coreStart(), minkä jälkeen sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20uudelleen%20k%C3%A4ynnist%C3%A4minen%20sekvennsikaavio.png)

**Käyttäjän kirjaantuminen**

Kun kirjautumisnäkymässä on kirjoitettu nimi ja salasana ja painettu login painiketta, siirtyy hallinta UiLogicCoren kautta uilogic paketiin ja siellä UiUser luokkaan, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4n%20kirjautumisen%20sekvenssikaavio.png)

**Käyttäjän luominen**

kun uuden käyttäjän näkymässä on kirjoitettu nimi ja salasana ja painettu create painiketta,siirty hallinta UiLogicCoren kautta uilogic pakettiin ja siellä UiUser luokkaan, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4nluonnin%20sekvenssikaavio.png)

**Käyttäjän poistaminen**

kun pääkäyttäjä on valinnut käyttäjä listasta jonkun käyttäjän ja painanut remove painiketta, siirtyy hallinta UiLogicCoren kautta uilogic pakettiin ja siellä olevaan UiMainSupport luokkaan, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4n%20poistamisen%20sekvenssikaavio.png)


**Ominaisuuden luominen**

kun käyttäjä on lisännyt kaikkiin lisää ominaisuuden tekstikenttiin tekstiä ja painanut lisää ominaisuus, siirtyy hallinta UiLogicCoren kautta uilogic pakkaukseen ja siellä olevaan luokkaan UiAbility, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20lis%C3%A4%C3%A4misen%20sekvenssikaavio.png)

**Ominaisuuden poistaminen**

kun käyttäjä on ominaisuuden poisto valikkossa valinnut ominaisuuden ja painanut poista ominaisuus, siirtyy hallinta UiLogicCoren kautta uilogic pakkaukseen ja siellä olevaan luokkaan UiMainSupport, jossa sovelluksen kontrolli etenee seuraavasti  

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20poistamisen%20sekvenssikaavio.png)

**Ominaisuuden valitseminen**

kun käyttäjä on ominaisuuden valitsemis valikossa valinnut omianisuuden ja painanut valitse ominaisuus, siirty hallinta uiLogicCoren kautta uilogic pakkaukseen ja siellä olevaan luokkaan UIMainTransition, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Ominaisuuden%20valitsemisen%20sekvenssikaavio.png)

**Parametri listan luonti**

kun käyttäjä siirtyy pääkäyttäjä valikosta parametri listaan, siirtyy hallinta uiLogicCoren kautta uilogic pakkaukseen ja siellä olevaan luokkaan UIMainTransition, jossa sovelluksen kontrolli etenee seuraavasti

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Parametri%20listan%20luonti%20sekvenssikaavio.png)


**Muut toiminallisuudet**

Muu sovelluslogiikka seuraa yllä olevien sekvenssikaavioiden toiminta periaatteita, eli kun ui.UserInterfacessa tapahtuu setOnAction tapahtuma, joko asennuksen aikana UiInstallCore tai yleisen käytön aikana UILogicCore kuljettaaa tiedon uilogic pakettiin, jossa se käsitellään käyttöliittymän tilanteen mukaisesti joko luokissa UiInstallTransitions, UiInstallSupport, UiTransitions tai UiSupport. Luokan pyytämät asiat viestitetään ScenePlayer,DaoPlayer,TextPlayer tai viite perinnän kautta halutuille olioille, jotka tekevät halutut toimet ja lähettävät todennäköisesti jonkinlaisen information takaisin. Luokkien sisäisten toimien suorittamisen jälkeen, käyttöliittymän stageen tehdään muutoksia perinnän kautta ja näin käyttöliittymä valmistautuu vastaan ottamaan uusia komentoja.  


# Ohjelman rakenteeseen jääneet heikkoudet

- Ohjelman hyödyntämä DAO malli pitäisi onnistua refaktoroinnin kautta muotoutumaan muuhun kuin SQLlite tietokantaan
- DAO:n käyttämät rajapinnat pakottavat tietyt tietokannat luomaan turhia metodeja
- Ohjelmasta löytyy toisteista koodia, mikä tekee joistain luokista turhan pitkiä



