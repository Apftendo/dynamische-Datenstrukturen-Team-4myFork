# List
*Objekte werden hinten angehängt. Neben dem "erster" Zeiger gibt es einen extra Zeiger "aktuell" oder "Aktuell" der auf ein bestimmtes Objekt zeigt. Nur das "Aktuell" Objekt kann gelöscht werden und Objekte können vor oder nach dem Aktuellen Objekt angefügt werden. Die Position des "Aktuell" Zeiger kann auch gewechselt werden.*
\
\
\
"erster" Zeiger und "aktuell" zeiger die beide auf Objekte zeigen.
```Java
public class List {
    private Knoten erster;
    private Knoten aktuell;
}
```
Methode "isEmpty" gibt "true" zurück falls der Stack leer ist.
```Java
public class List {
    public boolean isEmpty() {
        return erster == null;
    }
}
```
Methode "hasAccess" gibt true, wenn der "aktuell" zeiger auf ein Objekt zeigt.
```Java
public class List {
    public boolean hasAccess() {
        return aktuell!=null;
    }
}
```
Methode "next" die den "aktuell" Zeiger auf das nächste Objekt hinführt.
```Java
public class List {
    public void next() {
        aktuell = aktuell.getNext();
    }
}
```
Methode "toFirst" die den "aktuell" Zeiger aufs erste Objekt hinführt.
```Java
public class List {
    public void toFirst() {
        if(!isEmpty()) {
            aktuell = erster;
        }
    }
}
```
Methode "toLast" die den aktuell Zeiger aufs letzte Objekt hinführt.
```Java
public class List {
    public void toLast() {
        if (!isEmpty()) {
            Knoten n = erster;
            while (n.getNext()!=null) {
                n = n.getNext();
            }
            aktuell = n;
        }
    }
}
```
Methode "getObject" returned aktuell als Objekt.
```Java
public class List {
    public Knoten getObject() {
        if(hasAccess()) {
            return aktuell;
        }
        return null;
    }
}
```
Methode "setObject" die das Objekt auf das der "aktuell" Zeiger zeigt wird durch das vom Parameter ersetzt.
```Java
public class List {
    public void setObject(String pInhalt) {
        Knoten n = aktuell.getNext();
        if(pInhalt!=null) {
            aktuell.setNext(new Knoten(pInhalt));
            aktuell.getNext().setNext(n);
        }
    }
}
```
Methode "append" die ein neues Objekt zum Ende der Liste hinzufügt.
```java
public class List {
    public void append(String pInhalt) {
        Knoten n = ertser;
        if(isEmpty()) {
            erster = new Knoten(pInhalt);
        } else {
            while (n.getNext()!=null) {
                n = n.getNext();
            }
            n.setNext(new Knoten(pInhalt));
        }
    }
}
```
Methode "insert" die ein neues Objekt vor dem Objekt auf dem der "current" Zeiger steht hinzufügt. Wenn die Liste leer ist wird das Objekt am Anfang hinzugefügt.

```Java
import java.util.Objects;

public class List {
    public void insert(String pInhalt) {
        Knoten n = ertser;
        if (hasAccess()) {
            if (Objects.equals(n.getInhalt(),aktuell.getInhalt())) {
                erster = new Knoten(pInhalt);
                erster.setNext(n);
            } else {
                while (!Objects.equals(n.getNext().getInhalt(),aktuell.getInhalt())) {
                    n = n.getNext();
                }
                n.setNext(new Knoten(pInhalt));
                n = n.getNext();
                n.setNext(aktuell);
            }
        }
        if (isEmpty()) {
            erster = new Knoten(pInhalt);
        }
    }
}
```
Methode "concat" die eine Liste an einer anderen Liste hinten anfügt.
```Java
public class List {
    public void concat(Liste pListe) {
        Knoten n = erster;
        if (!isEmpty()&pListe!=null) {
            while(n.getNext()!=null) {
                n = n.getNext();
            }
            n.setNext(pListe.first);
        }
    }
}
```
Methode "remove" die das Objekt auf das der "aktuell" Zeiger zeigt löscht. 
```Java
public class List {
    public void remove() {
        Knoten n = erster;
        Knoten haelftenach = aktuell.getNext();
        if(hasAccess()) {
            while(n.getNext()!=null) {
                n = n.getNext();
            }
            aktuell = null;
            aktuell = n;
            aktuell.setNext(haelftenach);
        }
    }
}
```
