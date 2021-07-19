# Evolution_algorithm_Zen_garden
http://www2.fiit.stuba.sk/~kapustik/zen.html

Môj algoritmus :

Najprv pridáme rozmery záhrady (ako row a col ) potom zvolíme s akou 
metódou chcem selektovať na to som urobil 2 rôzne metódu 1) Roulette
selekciu a 2) Tournament selekciu. Jedincov počet gény môžu obsahovať
maximálne polovicu obvodu plus počet kamene. Ja používam iba polovicu 
obvodu , čiže počet génov = (strana A + strana B ) / 2. Gény obsahujú čísla čo
reprezentujú vstupy do záhrady . 

Ked sme zvolili rozmery záhrady a spôsob selekciu tak načítame kamene najprv
dáme počet kamene a potom toľkokrát načítam pozície kameňov ako X a Y .
Potom pridáme počet jedincov v Populáciu a maximálnu počet generáciu .
Vytvoríme prvú populáciu s jedincami ktorí majú náhodne vygenerovane čísla
ako gény.

Vypočítame fitnes pre jedinci a podlá zvolene spôsob vyselektujeme 2 rodičia
a spravíme z toho 2 deti , to urobíme toľko krát kým nemáme naplnene novu 
populáciu . Kde nová generácia je naplnená tak ešte majú šancu na aj na mutáciu
vyberieme jedinci s pravdepodobnosťou 10% na mutáciu a potom jeho gény
majú šancu na mutáciu 40%. keď sme urobili aj mutácia tak mame novu 
generáciu .

Začneme vypočítať fitness a urobíme selekciu pre nove generácii až kým
nenájdeme riešeniu pre danú záhradu.


Výsledky pre 10x16 kameň : 6 selekcia : Roulette 
Kameni : 2,1 ; 4,2 ; 3,4 ; 1,5 ; 6,8 ; 6,9
Populácia : 500 Max Generácia : 500
Výsledná matica : 

[11] [ 9] [18] [18] [18] [18] [ 1] [17] [17] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [14] 

[11] [ 9] [ 9] [ 9] [ 9] [ K] [ 1] [17] [17] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[11] [ K] [ 9] [ 9] [ 9] [ 9] [ 1] [17] [17] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[ 9] [ 9] [ 9] [ 9] [ K] [ 9] [ 1] [17] [17] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[10] [10] [ K] [ 9] [ 9] [ 9] [ 1] [17] [17] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[15] [10] [ 8] [ 8] [ 8] [ 8] [ 1] [ 4] [ 4] [ 4] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[15] [10] [ 8] [13] [13] [ 8] [ 1] [ 4] [ K] [ K] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[15] [10] [ 8] [13] [13] [ 8] [ 1] [ 4] [16] [16] [ 2] [12] [ 6] [ 7] [3] [ 5] 

[15] [10] [ 8] [13] [13] [ 8] [ 1] [ 4] [16] [16] [ 2] [12] [ 6] [ 7] [ 3] [ 5] 

[15] [10] [ 8] [13] [13] [ 8] [ 1] [ 4] [16] [16] [ 2] [12] [ 6] [ 7] [ 3] [ 5]

