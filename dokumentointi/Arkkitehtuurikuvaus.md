# Arkkitehtuurikuvaus

# Rakenne 

# Käyttöliittymä

# Sovelluslogiikka

Sovelluksen perusversion datamalli koostuu seitsemästä tietokannasta nimiltään UsernameDatabase,ClassDatabase,NameDatabase,DesriptionDatabase,RequrimentDatabase,RealityDatabase ja AbilityDatabase, joiden metodit keskustelevat rajapintojen DatabaseInterface ja UsernameInterfacen kautta käyttäliittymän kanssa ja jotka mahdollistavat tietokantojen luomisen, tietokantojen olemassaolon tarkastamisen, tiedon lisäämisen tietokantaan, tiedon tarkastamisen tietokannasta, tiedon id haun tietokannasta, tiedon identitetti haun tietokannasta, listan luomisen tietokannasta, rajoitetun listan luomisen tietokannasta, tiedon poistamisen tietokannasta ja tietokannan poistamisen.Lisäksi on olemassa rajapinta FileWriterInterface, joka mahdollistaa tiedostojen luomisen toiminnallisuuden käyttöliittymälle, jolloin kokonaisuudessaan kaikki käyttöliittymän toiminoille tarjotut metodit ovat:

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

Alla olevan luokka/pakkauskaavio näyttää tämän hetkisen (7.4.2020) sovelluslogiikan suhdettaa UserInterfacen ja tietokantojen välillä: 
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

# Ohjelman rakenteeseen jääneet heikkoudet
