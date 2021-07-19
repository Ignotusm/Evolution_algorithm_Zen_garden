# Evolution_algorithm_Zen_garden
http://www2.fiit.stuba.sk/~kapustik/zen.html

Môj algoritmus :

Najprv pridáme rozmery záhrady (ako row a col ) potom zvolíme, akou metódou chcem vybrať chromosómy: na to som urobil 2 rôzne metódy: 1) Roulette selekciu a 2) Tournament selekciu. Maximálny počet génov jedinca môže byť polovica obvodu plus počet kameňov. Ja používam iba polovicu obvodu , čiže počet génov = (strana A + strana B ) / 2. Jednotlivé gény obsahujú čísla(col a row) čo reprezentujú vstupy do záhrady.

Potom ako sme si zvolili rozmery záhrady a spôsob selekcie, tak načítame kamene (najprv počet kameňov, potom každý kameň pomocou súradníc x a y na mape). Potom pridáme počet jedincov v populácii a maximálny počet generácií. Vytvoríme prvú populáciu s jedincami, ktorí majú náhodne vygenerovane čísla ako gény.

Vypočítame fitness pre jedincov a podľa zvoleného spôsobu vyberieme 2 rodičov a urobíme 2 nových jedincov do novej generácie (deti), kým nemáme naplnenú novú populáciu . Keď nová generácia je naplnená, tak ešte majú šancu aj na mutáciu: vyberieme jedincov s pravdepodobnosťou 10% na mutáciu a potom jeho gény majú šancu na mutáciu 40%. Keď sme urobili aj mutáciu, tak máme novu generáciu.

Začneme vypočítať fitnes funkciu a urobíme selekciu pre novú generáciu až kým nenájdeme riešenie pre danú záhradu (fitnes funkcia dosiahla nejakú hranicu).


Výsledky pre mapu rozmeru 10x16, počet kameňov: : 6 selekcia : Roulette 

Súradnice kameňov : 2,1 ; 4,2 ; 3,4 ; 1,5 ; 6,8 ; 6,9

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

