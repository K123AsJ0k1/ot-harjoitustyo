# Arkkitehtuurikuvaus

# Rakenne 

# Käyttöliittymä

# Sovelluslogiikka

Sovelluksen perusversion datamalli koostuu seitsemästä tietokannasta nimiltään UsernameDatabase, ClassDatabase, NameDatabase, DesriptionDatabase, RequrimentDatabase, RealityDatabaseja AbilityDatabase, joiden metodit keskustelevat rajapintojen DatabaseInterface ja UsernameInterfacen kautta käyttöliittymän kanssa ja jotka mahdollistavat tietokantojen luomisen, tietokantojen olemassaolon tarkastamisen, tiedon lisäämisen tietokantaan, tiedon tarkastamisen tietokannasta, tiedon id haun tietokannasta, tiedon identitetti haun tietokannasta, listan luomisen tietokannasta, rajoitetun listan luomisen tietokannasta, tiedon poistamisen tietokannasta ja tietokannan poistamisen. 

Lisäksi on olemassa rajapinta FileWriterInterface, joka mahdollistaa tiedostojen luomisen toiminnallisuuden käyttöliittymälle, Ability olio, joka mahdollistaa tietokantojen yhdistämisen käyttöliittymän toiminnallisuuksiksi, TextRefineryInterface, joka mahdollistaa eri teksti editointi tapojen tuomisen ja TextTemplateInterface, joka mahdollistaa erilaisten profiili mallien tuomisen, jolloin käyttöliittymän toiminoille tarjotu metodit ovat:

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
- public boolean addUserInformation(String information)
- public boolean searchUserInformation(String information)
-  public Integer searchUsernameId(String information)
- public boolean removeUserInformation(String information)
- public boolean removeDatabase() throws Exception

**FileWriterInterface**

- public boolean saveTextAsAFile(String information, File file)

**Ability**

- public String getClassIdentity()
- public String getNameIdentity()
- public String getDescriptionIdentity()
- public String getRequrimentIdentity()
- public String getRealityIdentity()
- public String toString()

**TextRefineryInterface**

- public boolean givenTextLineChecker(String information)
- public boolean givenTextLineHasSpaces(String information)
- public String choosenAbilityIsFoundFromText(String information, String abilityInformation)
- public List<String> choosenAbilitiesAreFoundFromText(String information, List<String> abilityList)
- public Integer giveTextWordCount(String infromation)
- public Integer giveCharacterCount(String infromation)
  
 **TextTemplateInterface**
 
 -public String simpleMaker()


Tiivistettynä DatabaseInterface mahdollistaa tietokantojen hallitsemisen, UsernameInterface mahdollistaa käyttäjien hallitsemisen, FileWriterInterface mahdollistaa tiedostojen luonnin hallitsemisen ja Ability-olio mahdollistaa tietokantojen tiedon keräämisen käyttöliittymän ymmärtään muotoon.

Alla oleva luokka/pakkauskaavio näyttää tämän hetkisen (19.4.2020) sovelluslogiikan suhdetta UserInterfacen, sen käyttämien rajapintojen, tietokantojen ja olioiden välillä
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

Pakkauksen dao luokat ClassDatabase,NameDatabase,DescriptionDatabase,RequrimentDatabase,RealityDatabase ja UsernameDatabase hyödyntävät SQLlite:ä tietojen tallentamiseen tietokannan nimen mukaisiin tiedostoihin. 

Luokat noudattavat Data Acces Object-suunnitelumallia ja ne voidaan tarpeen mukaan korvata uusilla toteutuksilla, jos sovelluksen datan talletustapa halutaan vaihtaa, sillä ne ovat eristettyjä DatabaseInterface ja UsernameInterfacen taakse ja sovelluslogiikka ei hyödynnä näitä luokkia suoraan.

**Päätoiminnallisuudet**

Alla olevat sekvenssikaaviot kuvaavat sovelluksen päätoiminallisuuden toimintalogiikkaa

**Käyttäjän luominen**

Käyttäjän luodessa uuden käyttäjän, eli hänen laitettuaan syötekentään haluamansa käyttäjän ja painettuaan create username painiketta, etenee sovelluksen kontrolli seuraavasti: 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%A4j%C3%A4nluonnin%20sekvenssikaavio.png)

Painikkeen painamiseen reagoiva tapahtumakäsittelijä saa sen sisällä olevan sovelluslogiikan ottamaan tekstikentässä olevan merkkijonon ja jos merkkijono on pidempi kuin 5, niin käyttöliittymä pääsee jatkamaan käyttäjä tunnuksen olemassaolon tarkastukseen. Käyttöliittymä tarkastaa UsernameInterfacen avulla, löytyykö annettu käyttäjä nimi UsernameDatabase tietokannasta ja jos se ei löydy, niin UsernameDatabase lähettää falsen, jonka UsernameInterface viestittään takaisin käyttöliittymälle. Saadun tiedon ollessaan false, käyttöliittymä lisää UsernameInterfacen kautta uuden käyttäjän UsernameDatabasen tietokantaan, jonka jälkeen UsernameDatabase lähetää true ja tämä estää errori if-lauseen aktivoitumisen ja näin käyttöliittymä vaihtaa näkymäksi screenMainMenu scenen, eli sovelluksen päävalikon jossa näkyy kolme sovelluksen hallinnoitiin tärkeätä nappia. 


# Ohjelman rakenteeseen jääneet heikkoudet
