# Queue
*Queue: First-In-First-Out-> Die neuen Objekten werden "hinten angehängt", das neuste Element ist hinten.*
\
\
\
Erster Zeiger der auf den ersten Knoten zeigt.
```Java
public class Queue {
    private Knoten erster;
}
```
Methode "isEmpty" gibt "true" zurück falls die Queue leer ist.
```Java
public class Queue {
    public boolean isEmpty() {
        return erster == null;
    }
}
```
Die Methode "enqueue" die Objekte an die Queue anhängt.
```Java
public class Queue {
    public void enqueue (String pInhalt) {
        if (isEmpty()) {
            erster = new Knoten(pInhalt);
        } else {
            Knoten n = erster;
            while (n.getNext()!=null) {
                n = n.getNext();
            }
            n.setNext(new Knoten(pInhalt));
        }
    }
}
```
Die Methode "dequeue" die das erste Objekt löscht.
```Java
public class Queue {
    public void dequeue() {
        if(!isEmpty()) {
            first = first.getNext();
        }
    }
}
```
Die Methode "front" die das erste Objekt der Queue zurückgibt.
```Java
public class Queue {
    public Knoten front() {
        if (!isEmpty()) {
            return first;
        }
        return null;
    }
}
```






