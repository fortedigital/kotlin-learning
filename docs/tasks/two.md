Oppgave:
Lag et program som simulerer et spill med en karakter som kan bevege seg rundt på et todimensjonalt rutenett. Karakteren skal starte i øvre venstre hjørne av rutenettet og kan bevege seg i fire retninger: opp, ned, venstre og høyre. Målet med spillet er å nå et bestemt mål i nedre høyre hjørne av rutenettet. Karakteren kan bevege seg én rute av gangen og kan ikke gå utenfor rutenettet.

Krav:

1. Lag en klasse Character som representerer karakteren i spillet. Karakteren skal ha en startposisjon (0,0) i øvre venstre hjørne av rutenettet.
2. Implementer metoder for å flytte karakteren i de fire retningene (opp, ned, venstre, høyre) ved å oppdatere karakterens posisjon i rutenettet.
3. Lag en klasse Grid som representerer rutenettet. Grid skal ha en bestemt størrelse, for eksempel 5x5 ruter.
4. Implementer en metode i Grid som sjekker om karakteren har nådd målet i nedre høyre hjørne av rutenettet.
5. Lag en hovedfunksjon som bruker Character og Grid-klassene til å simulere spillet. La brukeren angi retningene for å bevege karakteren ved å taste inn kommandoer (f.eks. "opp", "ned", "venstre", "høyre") fra tastaturet. Etter hver kommando skal programmet oppdatere karakterens posisjon og sjekke om målet er nådd.
6. Legg til feilhåndtering for ugyldige kommandoer, for eksempel hvis brukeren taster inn en retning som fører karakteren utenfor rutenettet.
7. Det må være tester :)