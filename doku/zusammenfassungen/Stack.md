# Stack
*Stack: Last-In-First-out -> Die neuen Objekt werden "oben auf den Stapel gelegt", dass neuste element ist oben.*
\
\
\
Erster Zeiger der auf den ersten Knoten des Stacks zeigt.
```Java
public class Stack {
    private Knoten erster;
}
```
Methode "isEmpty" gibt "true" zurück falls der Stack leer ist.
```Java
public class Stack {
    public boolean isEmpty() {
        return erster == null;
    }
}
```
Die Methode "push" die ein neues objekt oben auf den Stapel legt
```Java
public class Stack {
    public void push(String pInhalt) {
        // Fall 1 leerer Stack
        if (erster == null) {
            erster = new Knoten(pInhalt);
        } else {
            // Fall 2 Stack nicht leer
            Knoten n = erster;
            erster = new Knoten(pInhalt);
            ertser.setNext(n);
        }
    }
}
```
Die Methode "pop" löscht das zuletzt eingefügte Objekt.
```Java
public class Stack {
    public void pop() {
        if (isEmpty()) {
            first = first.getNext();
        }
    }
}
```
Die Methode "top" gibt das oberste Objekt zurück, das nach dem LIFO Prinzip das zuletzt eingefügte Objekt ist.
```Java
public class Stack {
    public String top() {
        if(isEmpty()) {
            return first.getInhalt();
        }
        return null;
    }
}
```


