# Fiktiotietokanta

Sovelluksen avulla käyttäjien on mahdollista listätä tietokantaan erilaisia ominaisuuksia ja luoda niiden avulla fiktiivisiä profiili tiedostoja. Sovellusta on mahdollista käyttää useampi rekisteroitynyt käyttäjä, joilla kaikilla on oma yksilöllinen ominaisuus- ja profiililista. 

# Dokumentaatio
[Käyttöohje]

[Vaatimusmäärittely](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md)

[Arkkitehtuuikuvaus]

[Testausdokumentti]

[Työaikakirjanpito](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

# Komentorivitoiminnot

**Ohjelman suorittaminen**

Ohjelma voidaan suorittaa netbeansin vihreällä nappulalla Fiktiotietokannan mainissa tai menemällä komentorivillä Fiktiotietokanta kansioon ja laittamalla komennon

```mvn compile exec:java -Dexec.mainClass=Fiktiotietokanta.Main```

**Testaus**

Testit suoritetaan komennolla 

```mvn test```

Testikattavuusraportti luodaan komennolla 

```mvn jacoco:report```

Kattavuusraporttia voi tarkastella avaamalla selaimen tiedosto target/site/jacoco/index.html

**Suoritettavan jarin generointi**

Komento 

```mvn package```

generoi hakemistoon target suoritettavan jar-tiedoston Fiktiotietokanta-1.0-SNAPSHOT.jar

**JavaDoc**

JavaDoc generoidaan komennolla 

```mvn javadoc:javadoc```

JavaDocia voi tarkastealla avamaalla selaimellal tiedosto target/site/apidocs/index.html

**Checkstyle**

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

```mvn jxr:jxr checkstyle:checkstyle```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html


