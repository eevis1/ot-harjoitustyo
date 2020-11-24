# Ohjelmistotekniikka, harjoitustyö

Opintokirjanpitosovelluksen avulla opiskelijan on helppo pitää kirjaa suorittamistaan ja suunnittelemistaan opinnoista. Sovelluksen avulla myös opettajat voivat seurata opiskelijoiden etenemistä opinnoissa. Kaikki käyttäjät rekisteröityvät sovelluksen käyttäjiksi.


## Huomio Javan versioista

JavaFX aiheuttaa päänvaivaa ohjelmiston konfiguroinnin suhteen. Tässä repositoriossa olevan koodin pitäisi toimia riippumatta käyttämästäsi Javan versiosta. Koodi toimii ainakin laitoksen cubbli-Linuxeissa olevilla Java:n versiolla 8 ja 11.

Jos käytät Javan versiota 8 ja tämä koodi ei toimi, niin repositorion haarassa java8 on versio ohjelmasta, jonka pitäisi toimia myös Java 8:lla. Ainoat erot ovat tiedostossa pom.xml

mainClass määritys on erilainen
osaista dependencies ja plugins puuttuu JavaFX:n liittyvät elementit.
JavaFX:n liittyvistä ongelmista ja niiden kiertämisestä lisää täällä.

Jos et saa projektia toimimaan koneellasi, saat apua pajassa.


## Dokumentaatio


[Käyttöohje](https://github.com/eevis1/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/eevis1/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/eevis1/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuvaus.md)

[Testausdokumentti](https://github.com/eevis1/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

[Työaikakirjanpito](https://github.com/eevis1/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*


### Suoritettavan jarin generointi

Komento

> mvn package

generoi hakemistoon target suoritettavan jar-tiedoston *OtmTodoApp-1.0-SNAPSHOT.jar*


### JavaDoc

JavaDoc generoidaan komennolla

> mvn javadoc:javadoc

JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html*


### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla

> mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*

