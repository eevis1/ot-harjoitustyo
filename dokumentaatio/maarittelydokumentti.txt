#Vaatimusmäärittely


##Sovelluksen tarkoitus

Sovelluksen avulla opiskelijan on helppo pitää kirjaa suorittamistaan ja suunnittelemistaan opinnoista. Sovelluksen avulla myös opettajat voivat seurata opiskelijoiden etenemistä opinnoissa. Kaikki käyttäjät rekisteröityvät sovelluksen käyttäjiksi.


##Käyttäjät

Käyttäjärooleina ovat opiskelija ja opettaja, joista opettajalla on laajemmat käyttöoikeudet sovelluksesa.


##Suunnitellut toiminnallisuudet

###Perusversio

####Ennen kirjautumista

* Käyttäjän täytyy luoda järjestelmään käyttäjätunnus ja salasana ennen ensimmäistä käyttökertaa.
	* Käyttäjätunnuksen ja salasanan täytyy olla uniikkeja ja vähintään kolme merkkiä pitkiä.
* Kun käyttäjällä on tunnukset, hän voi kirjautua järjestelmään.
	* Kirjautuminen onnistuu syöttämällä olemassa oleva käyttäjätunnus ja oikea salasana kirjautumislomakkeella.
	* Jos käyttäjää ei ole olemassa tai annettu salasana on väärä, järjestelmä ilmoittaa tästä.

####Kirjautumisen jälkeen

* Käyttäjä voi valita opintosuunnan.
* Käyttäjä näkee valitsemansa opintosuunnan pakolliset kurssit.
* Käyttäjä näkee jo suorittamansa kurssit sekä vielä suorittamatta olevat kurssit. 
	* Muokatut suunnitelmat näkyvät vain ne luoneelle opiskelijalle sekä opettajan käyttöoikeuden omavaalle henkilölle.
* Käyttäjä voi lisätä myös yksittäisiä kursseja suunnitelmaansa.
* Käyttäjä voi kirjautua ulos järjestelmästä.


###Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:
* Mahdollisuus kurssien aikataulutukseen.
* Mahdollisuus kurssien poistamiseen suunnitelmasta.
* Opettajille mahdollisuus kommentoida opiskelijoiden suunnitelmia.
* Mahdollisuus useamman eri suunnitelman luomiseen.
* Suoritettujen kurssien arvosanojen merkitseminen.
* Käyttäjätunnuksen poisto.
