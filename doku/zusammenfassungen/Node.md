# Knoten
*Der Knoten ist das Element/Objekt einer dynamischen Datenstruktur*
\
\
\
In der Klasse Knoten (oder Node) wird der Node einen Inhalt und eine weitere Node gegeben.
```Java
public class Knoten {
    private String inhalt;
    private Node next;
}
```
\
\
\
Hier kann man schon die Dynamik erkennen, den in jedem Knoten ein anderer Knoten der einen weiteren Knoten besitzt usw. bis zur Unendlichkeit. Den Inhalt kann je nach Datentyp angepasst werden.
<img src="C:\Users\aswin.peterf\Schule\Informatik\Extras\Bild\Unendlichkeit.jpeg"/>
(Jeder Ring steht für eine Node)
\
\
\
Man kann jedem Knoten einen Inhalt geben und diesen auch "getten" lassen.
```Java
public class Knoten {
    public Knoten(String pInhalt) {
        this.inhalt = pInhalt;
    }
    public String getInhalt() {
        return inhalt;
    }
}
```
Man kann den nachfolgenden Knoten bestimmen und "getten" lassen.
```Java
public class Knoten {
    public Knoten getNext() {
        return next;
    }
    public void setNext(Knoten pKnoten) {
        this.next = pNode;
    }
}
```

