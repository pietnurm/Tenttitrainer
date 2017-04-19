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

## Alustava luokkakaavio (päivitetty)
![Alt text](https://helsinkifi-my.sharepoint.com/personal/pietnurm_ad_helsinki_fi/_layouts/15/guestaccess.aspx?docid=1c8f7c6b1b2fd42e0b2ac9c7e810b6d86&authkey=AZ4M65fJtDPzjhMO4J8aR1Q)

## Sekvenssikaavioita käyttötapauksista
![Alt text](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IGvDpHlubmlzdMOkIHRlbnR0aSBrYWlraXN0YSBreXN5bXlrcwAZBQoKS2F5dHRvbGlpdHR5bWEtPlQAKgVuYWt5bWEANRQAFAYKABsMLT5LAE8Fc3ZhcmFzdG87AF0HAAgIOiBuZXcgABYOICgAFg4pACMvAFQOLmhhZVRhbGxlbm5ldHV0S2F0ZWdvcmlhdCgpOwpub3RlIHJpZ2h0IG9mAHgPAIEZElRhcgCCIwVhIGzDtnl0eXlrw7YgbGlzdGFsdGEgYWllbW1pbiB0AGUIdHVqYSBrAGkHb2l0YS4AQS9MAGAGIGt1cnNzaTEuCgCCLh4tPgCBVAk7ACwIAIJZBwCBbQggKABFBykAKiIAgxkfbGlzYWEAgkUJAC0rAIEREwCBWQgAgxwPAIUHB2V0KCkAgxoQAIFWEwCDCRUAhUkJw6QgamEgbWFsbGl2YXN0YXVrc2lhAIIdCWxsZQCDDBEAgjkTAIMJCCIAhT4HMSIsICIASQtzMSIKAIJyEgCFewkAhXQJAIVpDQCGCggoADsbAIFGOgB8BwCFHQl2aWVsw6QgdMOkdMOkAIcFCHTDpDogRWkAhVIFZHkuAIEuFgCDJBQAgxkJLmFkZACHLwgpAIFwFACHaCEAhT0gAIhwDwCHLA8AiQ0OdmFsaXRzZSAidGUAhyoFa2Fpa2tpAIlVC8OkIgCJGA9UZXN0aTsgACsGSwArBQCJFgYAFAUACw0AiQAfADUVAEwMLmx1bwCKDwcAiDgFKCkKAGsTAIk3MXBhbGF1dACBNQcAhi8NAII3IwCBahMASgYAgjUKAINjCwoKCgo&s=napkin)

![Alt text](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgS8OkeXR0w7Z0YXBhdXM6IGx1byB1dXNpIGthdGVnb3JpYQoKS2F5dHRvbGlpdHR5bWEtPkt5c3lteXNlZGl0b3JpOiBrw6R5bm5pc3TDpCBrAA8NCgAdDgAyCXZhcmFzdG87ACcIAAkHOiBuZXcgABYOICgAFg4pACMxAFYOLmhhZVRhbGxlbm5ldHV0SwCBXwh0KCk7Cm5vdGUgcmlnaHQgb2YAeg8AgRsSVGFya2lzdGFhIGzDtnl0eXlrw7YgbGlzdGFsdGEgYWllbW1pbiB0AGUIdHVqYQCCTglvaXRhLgBBL0VpAGQFZHkuAIJQCACCMRctAIMTEQCCWDFsdW8AghIJKCJrdXJzc2kxIgCCdAkAYRg-AIJHCTsgAC4HAINOBwAYNQCBBSBpc2FhAIEdCgCBHwcAbzYAgVwHAIQPEACFZgVrc2V0KCkAhA4QAIFXEwCECApvbmtvIHNhbWFubmltaXNlbGxlAIIKB2xsZQCECAwAhisHa3Npw6QgamEgbWFsbGl2YXN0YXVrc2kAhBISAIJNEwCEDAwAgm4RAIQCCgCGXRgAhBsyCg&s=napkin)
