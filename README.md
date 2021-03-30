# xml-json-campus

### Problema
Immagazzinare i dati di un campus online nel file system. I dati devono essere integri e uniformi ad una specifica ben definita. Il campus avra' una lista di studenti, corsi e argomenti trattati. 

### Soluzione
Per garantire l'uniformita' dei dati si fara' uso di un `xsd schema` e i dati verranno dichiarati nei file `xml`. 

#### Dichiarazione schema xsd
Dichiarazione di uno schema `XSD`:

```
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
	targetNamespace="http://www.sg.com" 
	xmlns="http://www.sg.com"
	elementFormDefault="qualified">
	
	<xs:element name="student" type="studentType" />
	
	<xs:complexType name="studentType">
		...
	</xs:complexType>
</xs:schema>
```
Dove:
* `xmlns:xs="http://www.w3.org/2001/XMLSchema"` - indica di utilizzare il prefisso `xs:` per usare elementi presenti nel namespace "http://www.w3.org/2001/XMLSchema". 
* `targetNamespace="http://www.sg.com"` - il nuovo namespace da creare. Chi volesse accedere agli elementi e i tipi definiti in questo schema dovra' usare il namespace `http://www.sg.com`.
* `xmlns="http://www.sg.com"` - il namespace di default e' "https://www.sg.com" e gli elementi dichiarati in quel namespace non hanno bisogno di un prefisso.
* `elementFormDefault="qualified"` - indica che qualsiasi elemento dichiarato in questo namespace, quando utilizzato in un documento XML, non ha bisogno di essere prefissato se il namespace e' quello di default. 

#### Creazione di un documento XML
Un documento `XML` che utilizza lo schema xsd dichiarato sopra:

```
<campus xmlns="http://www.sg.com"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.sg.com schema-online-campus.xsd">

	<student>
	  ...
	</student>
</campus>	
```
Dove:
* `xmlns="http://www.sg.com"` - indica il namepsace di default. Tutti gli elementi usati in questo documento XML appartenenti al namespace "http://www.sg.com" non hanno bisogno di un prefisso.
* `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"` - indica che lo schema XML del namespace "http://www.w3.org/2001/XMLSchema-instance" e' accessibile mediante il prefisso `xsi:` (serve solo per accedere all'attributo `schemaLocation` descritto sotto).
* `xsi:schemaLocation="http://www.sg.com schema-online-campus.xsd"` - definisce dove si trova lo schema da usare: la parte prima della stringa indica il namespace "http://www.sg.com", mentre l'altra parte indica il percorso dello schema xsd dove e' stato definito questo namespace.

#### A cosa servono i file xml?
XML � un meta-linguaggio per definire la struttura di documenti e dati. Un documento XML � un file di testo che contiene una serie di tag, attributi e testo secondo regole sintattiche ben definite nel suo XML Schema (xsd).

# Maneggiare file xml usando java

#### DOMParser
Il parsing e' un processo che analizza un flusso di dati in input ( da file o da tastiera ) che determina la correttezza sintattica di tale input. In java esistono, tra gli altri, due approcci: il SAX e il DOM. DOMParser carica tutto l'albero del xml in memoria, e ogni elemento diventa un nodo dell'albero rappresentato da una classe che implementa l'interfaccia org.w3c.dom.Node.

#### Inizializzare e usare DOMParser
* Occorre istanziare un oggetto document di tipo Document, parsare il file xml di interesse e inizializzare, tramite un oggetto parser di tipo DOMParser, il document da cui prendere i valori del file xml. 
* Creato il document, ogni elemento viene rappresentato come un nodo. Tramite il metodo `getElementsByTagName("nome_elemento")`, si estrae il nodo dell'elemento `nome_elemento`. 
* Se ci sono, si estrapolano tutti i figli tramite `getChildNodes()` che restituisce una lista di nodi di tipo `NodeList`. 
* Per ottenere il valore di ogni singolo elemento (nodo) utilizziamo il metodo `getTextContent()`.

# Links

* [XSD/XML w3schools](https://www.w3schools.com/xml/schema_schema.asp) - Come creare un `xsd schema` 
* [XSD tutorialspoint](https://www.tutorialspoint.com/xsd/xsd_tutorial.pdf) - Pdf con concetto di base xsd schema/xml
* [Xml Esempio Wikipedia](https://it.wikipedia.org/wiki/XML_Schema#Esempio) - Significato di Xml ed esempio di sua creazione
* [Creazione di xml tramite Eclipse](http://www.w3big.com/it/eclipse/eclipse-create-xml-file.html) - Creazione di un file xml tramite IDE Eclipse
* [Validazione XSD/XML schema online](https://www.freeformatter.com/xml-validator-xsd.html) - Online validator per testare la correttezza di un file xsd e xml

* [java-sax-parser](https://www.baeldung.com/java-sax-parser)

https://stackoverflow.com/questions/7215931/reading-huge-xml-file-using-stax-and-xpath
https://stackoverflow.com/questions/1863250/is-there-any-xpath-processor-for-sax-model
https://github.com/pprados/xpath4sax
http://andreas.haufler.info/2012/01/conveniently-processing-large-xml-files.html
