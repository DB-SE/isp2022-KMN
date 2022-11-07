# isp2022-KMN

## Blatt 2 Begründungen

> Welche Arten von Laufzeitparametern (global, propagiert, . . . ) verwendest du und
warum?

Die Laufzeitparameter für gerichtete und ungerichtete Kanten werden mit einem `EdgeType` Enum als Parameter an den
Methodenaufruf für DFS übergeben. Da ungerichtet/gerichtet sich nur in ausgewählten Situationen Relevanz hat, ist es sinnvoll, die Unterscheidung nur in diesen Fällen vorzunehmen. Dadurch spart man weitere Sub-Klassen, oder weiter verteilte Fallunterscheidungen.
Für die Eigenschaften gewichtet/ungewichtet, sowie mit oder ohne Label werden keine Parameter verwendet. Diese werden stattdessen mit Hilfe des Template Method Patterns und Vererbung realisiert. Dadurch wird Code Scattering und generell Code Smell reduziert, da die Eigenschaften nicht als Parameter im Graphen nicht weitergereicht und überprüft werden müssen.

> (Wo) ist der Einsatz von Design Patterns sinnvoll?

Für die Eigenschaft Labeled lässt sich das Method Template Pattern gut nutzen, da die Graphen mit oder ohne Label prinzipiell gleich funktionieren. Allerdings lässt sich zum Beispiel das Decorator Pattern nicht anwenden, da der gewichtete Graph zusätzliche Funktionalität hat, und sich die Sub-Graphen daher nicht unter einem gemeinsamen Decorator-Interface vereinen lassen.

> Welche Vor- und Nachteile hat deine Lösung?

Unsere Lösung verwendet keine globalen Parameter und da die Parameter als Methodenparameter übergeben werden, beschränkt sich das Handling dieser Parameter immer auf die entsprechenden Methoden, und ist ansonsten nicht innerhalb der Klassen präsent.
Das bedeutet, dass die Parameter dynamischer sind, als globale Parameter, aber trotzdem das Scattering-Problem des propagierten Ansatzes weitesgehend vermeiden.
Ein Nachteil der Umsetzung ist, dass das Kombinieren der Eigenschaften recht aufwändig ist, dass ist aber unter anderem dem oben angesprochenen Punkt des fehlenden gemeinsamen Interfaces geschuldet.