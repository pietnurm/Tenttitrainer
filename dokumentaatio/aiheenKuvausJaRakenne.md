# Aihemäärittely
## Aihe
Luodaan opiskelua tukeva harjoittelusovellus, jonka avulla käyttäjä voi tenttiä itseltään haluamiinsa aihepiireihin liittyviä kysymyksiä. Käyttäjä luo itse kysymyksiä ja mallivastauksia haluamistaan kategorioista (esim kurssi) ja alakategorioista (esim. yksi kurssin aihepiiri). Käyttäjä pystyy muokkaamaan tai poistamaan yksittäisiä kysymyksiä ja kategorioita. Käyttäjä voi tenttiä itseltään kysymyksiä joko koko kategoriasta, yhdestä tai useammasta alakategoriasta, tai kaikista sovellukseen luoduista kategorioista. Ohjelma tenttii käyttäjältä kysymyksiä tämän valitsemista kategorioista satunnaisessa järjestyksessä. Se esittää ensin kysymyksen, ja käyttäjä kirjoittaa vastauksensa tekstikenttään. Tämän jälkeen ohjelma näyttää käyttäjän mallivastauksen sekä käyttäjän oman vastauksen rinnakkain, ja käyttäjä pisteyttää oman vastauksensa asteikolla 1-5. Ohjelma tallentaa käyttäjän pisteet tehtäväkohtaisesti ja laskee keskiarvot jokaiselle kategorialle, alakategorialle ja yksittäiselle kysymykselle. Keskiarvot ovat nähtävissä ohjelman "tulokset"-osiossa. Käyttäjä voi resetoida keskiarvolaskurit kategoriakohtaisesti. Ohjelma tallentaa kysymykset ja tulokset tekstitiedostoihin ohjelman kansiorakenteeseen.
## Käyttäjät
Opiskelija (käyttäjä)
## Käyttäjän toiminnot
###### 1. Muokkaus
- luo kategoria
- luo alakategoria
- luo kysymys ja mallivastaus kategoriaan
  - mahdollisuus valita halutessaan alakategoria
- muokkaa kategorian/alakategorian nimeä
- poista kategoria/alakategoria kaikkine kysymyksineen
- muokkaa kysymystä/mallivastausta
- poista kysymys
###### 2. Harjoittelu
- testaa kategoriaa
  - onnistuu, jos kategoriassa vähintään 1 kysymys
  - **alatoiminnot:** vastaa kysymykseen, pisteytä vastaus
- testaa valittuja alakategorioita
  - onnistuu, jos valituissa alakategorioissa vähintään 1 kysymys
  - **alatoiminnot:** vastaa kysymykseen, pisteytä vastaus
- lopeta testi
  - ilman komentoa testi jatkuu niin kauan kuin kysymyksiä riittää
###### 3. Tulosten tarkastelu
- selaa keskiarvoja
  - kategorian, alakategorian tai yksittäisen kysymyksen perusteella
  - näyttää samalla, montako kysymystä kategoria sisältää ja montako kertaa yksittäiseen kysymymykseen on vastattu
- nollaa kategorian/alakategorian ja kaikkien sen kysymysten laskurit

![Alt text](https://helsinkifi-my.sharepoint.com/personal/pietnurm_ad_helsinki_fi/_layouts/15/guestaccess.aspx?docid=1c7808b718e184256b818aeb18473ca4b&authkey=AXZ3yxbUUW5s-kq52KRzFR4 "Alustava luokkakaavio")
