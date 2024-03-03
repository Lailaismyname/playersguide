package challenge60;
import challenge60.util.CharberryTree;
import challenge60.util.Notifier;
import challenge60.util.Harvester;

class Observia {

    public static void main(String[] args ) {
        CharberryTree tree = new CharberryTree();
		tree.attach(new Notifier());
		tree.attach(new Harvester());
        while (true) tree.maybeGrow();
    }
}

/* oke ik kom hier later op terug want ik snap het niet helemaal.
* De story so far, het idee is dat je een observer hebt en een subject. 
* De observers houden dan bij wanneer er iets veranderd in een bepaalde state van het subject
* Dit kun je het beste doen met een interface omdat je dan zeker weet dat alle classe de juiste methods overnemen, 
* plus je kan de observers als observers type gebruiken en doorpasen.
*/