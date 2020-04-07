# Arkkitehtuurikuvaus

# Rakenne 

# Käyttöliittymä

# Sovelluslogiikka

Sovelluksen perusversion datamalli koostuu kolmesta tietokannasta nimiltään UsernameDatabase, AbilityParametersDatabase ja AblityDatabase, joissa olevat metodit keskustelevat sovelluksen käyttöliittymän kanssa ja näin mahdollistavat uuden tiedon lisäämisen, olemassa olevan tiedon tarkastamisen ja tiedolle tietokannan antaman Id numeroiden hakemisen.Jokainen näistä tietokannoista tarjoaa käyttöliittymän toiminoille metodit, jotka ovat yleisesti 

**UsernameDatabase ja AbilityParametersDatabase**

- Boolean add(haluttu asia)IntoDatabase(String (haluttu asia))
- Boolean search(haluttu asia)FromDatabase(String (haluttu asia))
- Integer get(haluttu asia)IdFromDatabase(String (haluttu asia))

**AblityDatabase**

- Boolean addAbilityIntoDatabase(int username_id, int class_id, int name_id, int description_id, int requriment_id, int reality_i)
- Boolean searchAbilityFromDatabase(int username_id, int class_id, int name_id, int description_id, int requriment_id, int reality_i)
- Integer getAbilityIdFromDatabase(int username_id, int class_id, int name_id, int description_id, int requriment_id, int reality_i)

Kyseisten metodien avulla käyttöliittymä pystyy lisäämään, tarkastamaan ja hakemaan tietokannan antamia id numeroita. Mainittujen metodien ollessa toisteisia, tullaan niistä todennäköisesti tekemään tulevaisuudessa erillisiä rajapintoja, minkä takia sovelluslogiikka mainittu sovelluslogiikka tulee vielä muuttuumaan.

Alla olevan luokka/pakkauskaavio näyttää tämän hetkisen (7.4.2020) sovelluslogiikan suhdettaa UserInterfacen ja tietokantojen välillä: 
![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkauskaavio.png)

# Tietojen pysyväistallennus

# Ohjelman rakenteeseen jääneet heikkoudet
