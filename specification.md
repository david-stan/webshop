
# SISTEMI BAZIRANI NA ZNANJU SIIT - PREDLOG PROJEKTA

## Članovi tima:
Boris Šuličenko, SW 4/2016

## Opis problema:
	Motivacija za razvoj webshop-a baziranog na pravilima je što se način poslovanja može lako menjati jer će većina poslovne logike biti realizovana kroz pravila. Ovo nam omogućava da ne mora eksplicitno programer menjati pravila poslovanja, već to može da uradi i domenski ekspert.

	Problem koji ovaj projekat rešava je webshop koji radi po uzoru na AliExpress. Cela aplikacija bi predstavljala jednu platformu na kojoj mogu da se registruju kupci i prodavci (koji predstavljaju različite prodavnice). Aplikacija bi imala 3 korisničke uloge: kupac, prodavac i admin.
	Kupac ima mogućnost da: pretražuje i filtrira artikle po kategoriji i ceni. Kada završi sa pretragom kupac može da potvrdi kupovinu nakon koje se pokreće rezoner koji računa sve popuste na artikle i vraća korisniku konačnu cenu. Nakon izvršene kupovine rezoner će proveriti stanje artikala u magacinu i obavestiće prodavca ako je taj broj manji od prethodno definisane vrednosti. Kupac takođe ima i uvid u sve svoje porudžbine.
	Prodavac može da dodaje/menja/briše artikle. Prilikom dodavanja i izmene se zadaju mogući popusti poput klasičnog popusta, popusta na količinu, popusta za kupce koji često kupuju kod njega i mogućnost korišćenja kupona.
	Admin može da dodaje/menja/briše prodavce. Može da kreira sezonske popuste (npr. black friday) i popuste na određenu kategoriju artikla.

	Ulaz u sistem predstavljaju artikli koji se kupuju sa njihovim informacijama o popustu i podaci o kupcu sa njegovim osobinama koje takođe utiču na popust. Kao izlaz se očekuje izračunati popust na dati artikal.
	U sistemu neće postojati predefinisana baza znanja, već će se ona vremenom popunjavati sa podacima o korisnicima i artiklima, tj. rezonovanje isključivo zavisi od kupca i artikla koji kupuje i eventualno njegovih prethodnih kupovina ako je prodavac omogućio popust za kupce koji često kupuju od njega.
	
## Pravila
- obavestiti prodavca ako je količina artikala u magacinu ispod određene vrednosti
- aplikacija sama menja kategoriju kupca na osnovu broja kupovina ili potrošene sume novca
- kupci sa kategorijom SILVER, GOLD i DIAMOND ne plaćaju poštarinu
- kupci sa kategorijom GOLD imaju popust na sve artikle od npr. 5%
- kupci sa kategorijom DIAMOND imaju popust na sve artikle od npr. 10%
- računanje svih popusta prilikom kupovine: klasičan popust na artikal, popust na količinu, sezonski popust, popust na kategoriju, popust za česte kupce kod jednog prodavca i popust na osnovu kupona. Ovde bi se vodilo računa da ukupni popust ne može da pređe neku predefinisanu vrednost, a i da se ne mogu baš sve vrste popusta iskoristiti istovremeno.

## Primer rezonovanja za kupovinu artikla:
- korisnik filtrira i pretrazuje artikle
- kada naiđe na artikal koji želi, naručuje ga
- pokreće se rezoner koji će da računa cenu tog artikla za datog korisnika na osnovu njegovih ostvarenih popusta i ostalih popusta koji postoje za artikal
- rezoner vraća konačnu cenu korisniku
- korisnik potvrđuje kupovinu
- pokreće se pravilo za kupovinu koje treba da kasnije aktivira pravila za promenu kategorije kupca i pravilo za obaveštavanje prodavca ako je broj artikala u magacinu manji od predefinisane vrednosti čime postižemo forward chaining.


