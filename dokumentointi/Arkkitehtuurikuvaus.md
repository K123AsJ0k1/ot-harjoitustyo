# Arkkitehtuurikuvaus

# Rakenne 

# Käyttöliittymä

# Sovelluslogiikka

Sovelluksen perusversion datamalli koostuu seitsemästä tietokannasta nimiltään UsernameDatabase, ClassDatabase, NameDatabase, DesriptionDatabase, RequrimentDatabase, RealityDatabaseja AbilityDatabase, joiden metodit keskustelevat rajapintojen DatabaseInterface ja UsernameInterfacen kautta käyttöliittymän kanssa ja jotka mahdollistavat tietokantojen luomisen, tietokantojen olemassaolon tarkastamisen, tiedon lisäämisen tietokantaan, tiedon tarkastamisen tietokannasta, tiedon id haun tietokannasta, tiedon identitetti haun tietokannasta, listan luomisen tietokannasta, rajoitetun listan luomisen tietokannasta, tiedon poistamisen tietokannasta ja tietokannan poistamisen. Lisäksi on olemassa rajapinta FileWriterInterface, joka mahdollistaa tiedostojen luomisen toiminnallisuuden käyttöliittymälle ja Ability olio, joka mahdollistaa tietokantojen yhdistämisen käyttöliittymän toiminnallisuuksiksi, jolloin käyttöliittymän toiminoille tarjotu metodit ovat:

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

Tiivistettynä DatabaseInterface mahdollistaa tietokantojen hallitsemisen, UsernameInterface mahdollistaa käyttäjien hallitsemisen, FileWriterInterface mahdollistaa tiedostojen luonnin hallitsemisen ja Ability-olio mahdollistaa tietokantojen tiedon keräämisen käyttöliittymän ymmärtään muotoon.

Alla olevan luokka/pakkauskaavio näyttää tämän hetkisen (7.4.2020) sovelluslogiikan suhdettaa UserInterfacen ja tietokantojen välillä: 
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

# Ohjelman rakenteeseen jääneet heikkoudet
