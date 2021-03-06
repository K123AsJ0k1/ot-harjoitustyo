# Käyttöohje

Lataa joko koko repositori tai valitse uusin release

# Ohjelman käynnistäminen

Ohjelma voidaan käynnistää joko luomalla jar mvn Packagen avulla,hakemalla otettu release tai komennolla

```Java -jar (releasen nimi).jar```

# Konfigurointi

Käynnistäessä ohjelman ilmestyy seuraava tervetuloa näkymä:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20tervetuloa%20valikko.PNG)

Voit valita joko julkisen sovelluksen julkisen tilan, joka mahdollistaa monet käyttäjät tai yksityisen tilan, joka mahdollistaa ainoastaan yhden käyttäjän, voit jopa keskyettää asennuksen painamalla shut down. 

Valitsemalla public mode ja painamalla next, ilmestyy seuraava näkymä:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20dao%20asetukset%20public.PNG)

Dao asetus näkymässä pystyt antamaan sovelluksen tietokanta kansiolle ja sen tietokannoille eri nimet valitsemalla tarkastettava nimi ja kirjoittamalla haluttu nimi tekstikenttään, joka on sisältää ainoastaan a-z tai A-Z merkkejä ja on vähintään 5 merkkiä ja korkeintaan 20 merkkiä pitkä. Painamalla previous päädyt takaisin tervetuloa näkymään ja taas painamalla next, ilmestyy seuraava näkymä: 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20p%C3%A4%C3%A4k%C3%A4ytt%C3%A4j%C3%A4%20asetus%20public.PNG)

Pääkäyttäjä asetus näkymässä pystyt menemään joko takaisin dao asetus näkymään painamalla previous tai sitten lopettamaan asennuksen finish buttonin avulla, taas asennus vaatii vähintään yhden pääkäyttäjän olemassa olon joten luo yli 5 merkkiä ja alle 15 pitkä käyttäjä nimi ja salasana, jotka koostuvat ainoaastaan merkeistä a-z tai A-Z ja paina createa painiketta.Asennuksen jälkeen, siirrytään pääkäyttäjä asetus näkymästä kirjautumisnäkymään

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20kirjautumisn%C3%A4kym%C3%A4.PNG)

Valitsemalla private mode ja painamalla next, ilmestyy seuraava näkymä:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovellukden%20dao%20asetus%20private.PNG)

Dao asetus näkymä toimii samanlaisesti kuin julkisen tilan asennuksessa, mutta pääkäyttäjiä ei tarvitse luoda ja näin dao asetuksen näkymästä voi päästä previous painikkeen kautta takaisin tervetuloa näkymään tai yksityisen tilan päävalikkoon, jonkä näkymä on

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20p%C3%A4%C3%A4valikko%20private.PNG)


# Kirjautuminen

Julkisessa tilassa oleva sovellus siirtyy aina joko asennuksen jälkeen tai uudellen käynnistyksen yhteydessä kirjautumisnäkymään:

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20kirjautumisn%C3%A4kym%C3%A4.PNG)

Kirjautuminen onnistuu kirjoittamalla olemassaoleva käyttäjätunnus ja salasana syötekenttiin ja painamalla login

# Uuden käyttäjän luominen

Kirjautumisnäkymästä on mahdollista siirtyä uuden käyttäjän luomisnäkymään painikkeella sign in.

Uusi käyttäjä luodaan syöttämällä käyttäjä nimi ja salasana syötekenttiin ja painamalla create

Käyttäjän on oltava vähintään 5 merkkiä ja korkeintaan 15 merkkiä pitkä ja sen merkkijonojen on oltava joko a-z tai A-Z

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20uuden%20k%C3%A4ytt%C3%A4j%C3%A4n%20luomisn%C3%A4kym%C3%A4.PNG)

Jos käyttäjän luominen onnistuu, palataan kirjautumis näkymään tai vaihtoehtoisesti painamalla return.

# Päävalikko 

Julkisessa tilassa olevassa sovelluksessa kirjautumisnäkymästä siirrytään päävalikkoon, jossa voidaan valita siirtyä joko ominaisuus valikkoon, profiili valikkoon, pääkäyttäjä valikkoon tai palata takaisin kirjautumisnäkymään kirjautumalla ulos.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20p%C3%A4%C3%A4valikko%20n%C3%A4kym%C3%A4.PNG)

Yksityisessä tilassa olevassa sovelluksessa päävalikko siirtyy aina asennuksen jälkeen tai uudelleen käynnistämisen yhteydessä yksityiseen päävalikkoon, jossa voidaan valita siirtyä joko ominaisuus valikkoon, profiili valikkoon, pääkäyttäjä valikkoon tai sulkea ohjelma.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20p%C3%A4%C3%A4valikko%20private.PNG)

# Ominaisuus valikko 

Päävalikosta siirrytään ominaisuus valikkoon, jossa voidaan valita siirtyä´lisää ominaisuus näkymään, poista ominaisuus näkymään tai palata takaisin päävalikkoon returnin kautta.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20omaisuus%20valikko%20n%C3%A4kym%C3%A4.PNG)

# Omaisuuden lisääminen

Ominaisuus valikosta voidaan siirtyä ominaisuuden lisäämiseen, jossa täyttämällä jokaisen tekstikentän ja painamalla create ability painikettaa voidaan luoda uusi ominaisuus ja taas painamalla returnia palataan takaisin ominaisuus valikkoon.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20luo%20ominaisuus%20n%C3%A4kym%C3%A4.PNG)

# Ominaisuuden poistaminen

Ominaisuus valikosta voidaan siirtyä ominaisuuden poistamiseen, jossa näkyy luodut ominaisuudet ja jotka voidaa poista painamalla listassa haluttua ominaisuutta ja painamalla remove ability ja taas painamalla returnia palataan takaisin ominaisuus valikkoon.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20poista%20ominaisuuksia%20n%C3%A4kym%C3%A4.PNG)

# Profiili valikko

Päävalikosta voidaan siirtyä profiili valikkoon, jossa näkyy luo profiili, luo tiedosto profiilista, resetoi profili ja return, joista luo profiili ja luo tiedosto profiilista vievät omiin näkymiin, resetoi profiilin painaminen resetoi profiilin ja taas return palauttaa päävalikkoon. 

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20profiili%20valikko%20n%C3%A4kym%C3%A4.PNG)

# Profiilin luominen

Profiili valikosta voidaan siirtyä profiilin luontiin, jossa voidaan luoda teksti dokumentti eri työkalujen avulla ja jotka voidaan avata painamalla oikeata hiiri näppäintä, taas editorista voidaan poistua painamalla yläpalkin exit profile creatoria ja valitsemalla haluttu tilanne.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20profiili%20luoja%20n%C3%A4kym%C3%A4.PNG)

# Ominaisuuden valitseminen

Profiilin luonnista voidaan siirtyä ominaisuuden luontiin painamalla oikeaa hiiri näppäintä ja valitsemalla choose ability, itse näkymässä taas listasta painamalla haluttu ominaisuus ja painamalla choose ability palataan takaisin profiilin luontiin. Taas return palauttaa ilman ominaisuuden valitsemista.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20valitse%20ominaisuus%20n%C3%A4kym%C3%A4.PNG)

# Profiilin muuttaminen tiedostoksi

Profiili valikosta voidaan siirtyä profillin luomiseen tiedostoksi näkymään, jossa näkyy editorissa luotu teksti ja jossa painamalla save voidaan siirtyä tallenna nimellä näkymään, ja taas return palauttaa takaisin profiili valikkoon.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20muuta%20profilli%20tiedostoksi%20n%C3%A4kym%C3%A4.PNG)

# Tallenna tiedosto näkymä

Luo profiilista tiedosto näkymästä voidaan siirtyä painamalla save tallenna nimellä näkymään, jossa voidaan standardin tapaan valita tiedoston paikka ja nimi.Painamalla tallenna tiedosto tallentuu ja painamalla peruuta palataan takaisin luo profiilista tiedostoon näkymään.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20tallenna%20tiedosto%20n%C3%A4kym%C3%A4.PNG)

# Pääkäyttäjän valikko

Päävalikosta ainoastaan admin oikeuden omistavat käyttäjät voivat siirtyä pääkäyttäjä valikkoon, jossa voidaan tarkastella parametri tietokantojen sisältämiä tietoja tai sitten tarkastella käyttäjä tietokannan sisältämiä tietoja.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20p%C3%A4%C3%A4k%C3%A4ytt%C3%A4j%C3%A4%20valikko.PNG)

# Parametri lista

Pääkäyttäjä valikosta voidaan siirtyä parametri listaan, joka näyttää class,name,description,requriment ja reality tietokantojen tiedot, ja painamalla return palataan takaisin pääkäyttäjä valikkoon

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20parametri%20lista.PNG)

# Käyttäjä lista 

Pääkäyttäjä valikosta voidaan siirtyä käyttäjä listaan, joka näyttää käyttäjien id:et, nimet ja heidän oikeudet, listan avulla voi poistaa haluttu käyttäjä valitsemalla hänet listasta ja painamalla remove. Listassa olevia kaikkia pääkäyttäjiä ei voida poistaa, mutta kaikki user oikeuden omaavat voidaan poistaa. Listasta voidaan palata takaisin pääkäyttäjä valikkoon painamalla return.

![alt text](https://github.com/K123AsJ0k1/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Sovelluksen%20k%C3%A4ytt%C3%A4j%C3%A4%20lista.PNG)




