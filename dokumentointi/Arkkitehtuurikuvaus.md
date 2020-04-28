# Arkkitehtuurikuvaus

# Rakenne 

Ohjelma on rakenteeltaan nelitasoinen, ja koodin pakkausrakenne on seuraava:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkausrakenne.png)

Pakkaus main sisältää sovelluksen käynnistykseen tarvitun mainin, pakkaus ui sisältää tarvitun käyttöliittymä koodin, pakkaus domain sisältää tarvittavat rajapinnat ja pakkaus dao sisältää käyttöliittymän tarvitsemat tietokannat. Lisäksi on huomioitava se, että pakkaus ui siirtää sovellusloogikan pakkauksille scene, service ja textlogic, missä scene pakkaus sisältää osan käyttöliittmän scene olioista, service sisältää osan sovelluslogiikasta ja textlogic sisältää käyttöliittymän tekstieditori sovelluslogiikan.

# Käyttöliittymä

Käyttöliittymä sisältää yksitoista erillistä näkymää 

- kirjautuminen
- uuden käyttäjän luominen
- päävalikko
- ominaisuusvalikko
- ominaisuuksien lisäys
- ominaisuuksien poistaminen
- profiili valikko
- profiilin luonti 
- ominaisuuden valitseminen
- tiedoston luonti
- pääkäyttäjä näkymä

jokainen näistä on toteutettu omana Scene-oliona. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksena stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa ui.UserInterface.

Käyttöliittymä tullaan eristämään kokonaan sovelluslogiikasta, eli käyttöliittymä kutsuu tilanteeseen sopivia metodeja ja asettaa tarvitut parametrit niihin.



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
 
 -public String simpleMaker()
  
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

**Käyttäjän luominen**

Käyttäjän luodessa uuden käyttäjän, eli hänen laitettuaan syötekentään haluamansa käyttäjän ja painettuaan create username painiketta, etenee sovelluksen kontrolli seuraavasti: 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4nluonnin%20sekvenssikaavio.png)

Painikkeen painamiseen reagoiva tapahtumakäsittelijä saa sen sisällä olevan sovelluslogiikan ottamaan tekstikentässä olevan merkkijonon ja jos merkkijono on pidempi kuin 5, niin käyttöliittymä pääsee jatkamaan käyttäjä tunnuksen olemassaolon tarkastukseen. Käyttöliittymä tarkastaa UsernameInterfacen avulla, löytyykö annettu käyttäjä nimi UsernameDatabase tietokannasta ja jos se ei löydy, niin UsernameDatabase lähettää falsen, jonka UsernameInterface viestittään takaisin käyttöliittymälle. Saadun tiedon ollessaan false, käyttöliittymä lisää UsernameInterfacen kautta uuden käyttäjän UsernameDatabasen tietokantaan, jonka jälkeen UsernameDatabase lähetää true ja tämä estää errori if-lauseen aktivoitumisen ja näin käyttöliittymä vaihtaa näkymäksi screenMainMenu scenen, eli sovelluksen päävalikon jossa näkyy kolme sovelluksen hallinnoitiin tärkeätä nappia. 


# Ohjelman rakenteeseen jääneet heikkoudet
