# Coding Essentials
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.es.md)

A bundle of three independent Java programming projects covering basic algorithms, OOP fundamentals, and database connectivity (JDBC) designed for first-year programming students to train themselves and pass their course.

Every exercise but the first—a mere play of imagination on objects— are the embryo of projects and applications with real practical utility, and I designed them with the intention that, in addition to allowing the training of your programming skills, they turn out to be interesting and entertaining.

<br>

## Table of Contents
1. [First exercise: Robots Lineage](#robots-lineage)
    1. [Required Knowledge](#lineage-knowledge)
    2. [Requirements](#lineage-requirements)
    3. [Console Output](#lineage-output)
    4. [Summary](#lineage-summary)
2. [Second Exercise: Yum Snack Bar](#yum-snack-bar)
    1. [Conocimientos necesarios](#yum-conocimientos)
    2. [Requisitos](#yum-requisitos)
    3. [Guía de precios](#yum-precios)
    4. [Salida en consola](#yum-salida)
3. [Ejercicio tercero: Biblioteca Filipinas](#biblioteca-filipinas)
    1. [Conocimientos necesarios](#biblioteca-conocimientos)
    2. [Requisitos](#biblioteca-requisitos)
    3. [Salida en consola](#biblioteca-salida)


<h2 id="robots-lineage">
  First exercise: Robots Lineage
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f916.png" alt="slot_machine" style="float:right;width:64px;height:64px;">
</h2>

<h3 id="lineage-knowledge">Required Knowledge:</h3>

* Creación de un programa de consola en Java
* Uso de Eclipse u otro IDE
* Programación Orientada a Objetos
* Estructuras básicas (variables, métodos, constantes, operadores)
* Control de flujo (condicionales, bucles)
* Visibilidad y encapsulamiento
* Arrays uni y bidimensionales
* Tipos enumerados (Enum)
* Sobreescritura de métodos
* Sobrecarga de métodos / sobrecarga de constructores
* Herencia y polimorfismo
* Uso de static y final
* Casting o refundición de tipos
* Uso de funciones aleatorias

<h3 id="lineage-requirements">Requirements:</h3>

<p>Escribe un programa en el lenguaje Java, utilizando Eclipse u otro IDE, consistente en una serie de clases de ```Robot``` destinados a realizar cálculos y actividades que arrojen una salida por consola como se describe en los siguientes puntos:<p>

1. Define una superclase abstracta ```Robot``` que servirá de base para la creación de todos los robots. Un Robot contará siempre con un ```nombre``` y ```numeroSerie```, ambos de tipo String. Crea los campos necesarios para la clase Robot y un constructor parametrizado apropiado.
2. La superclase abstracta Robot contará además con un campo estático ```contadorRobots``` que servirá para contar cuántos objetos de tipo ```Robot``` se han construido en total. Asimismo, define métodos _getters_ y _setters_ adecuados para los campos de la clase, excepto el _setter_ para contadorRobots, que no debe ser definido pues se quiere evitar la falsificación externa de este contador de construcciones.
3. Añade a la clase Robot, por último, una sobreescritura del método ```toString()``` propio de todo objeto en Java que devuelva la siguiente información “Soy un Robot de: [nombre=x, número de serie=y]".
4. Crea dos clases abstractas que hereden de ```Robot```, ```RobotArtista``` y ```RobotCientifico```. Ambas clases implementarán su propia sobreescritura del método ```toString()``` añadiendo a lo que devuelve el método ```toString()``` de su superclase, según corresponda, la información: “, disciplina=Ciencias]” o “, disciplina=Artes]”. Considera la posibilidad de que implementen su propio constructor en coordinación con el constructor de la clase ```Robot```.
5. La clase ```RobotCientifico``` declarará un método abstracto ```procesar(double numero)``` para implementación y uso por las clases que hereden de ella. La clase ```RobotArtista``` definirá dos constantes ```REGULAR``` y ```ALEATORIO``` para definir el comportamiento de las clases que hereden de ella (considera la posibilidad de declararlas en un tipo enumerado de Java o ```Enum``` denominado ```Comportamiento```). ```RobotArtista```, por esta razón, debe contar con dos constructores sobrecargados, uno que reciba meramente por parámetros el ```nombre``` y ```numeroSerie``` y asigne automáticamente el Comportamiento ```REGULAR``` al robot artista así construido, y un constructor que especifique además de esos dos parámetros un tercer parámetro de ```Comportamiento```, asignando al campo correspondiente el comportamiento que haya recibido como argumento.
6. Debes definir dos subtipos de ```RobotCientifico```, ```RobotCortador``` y ```RobotPrimo```. Estas dos subclases no podrán ser objeto de herencia por otras clases por debajo de ellas.
7. La clase ```RobotPrimo``` ofrece dos utilidades. 1) Su implementación o concreción de ```procesar(double numero)``` evalúa si el número pasado por argumento es o no un número primo y devuelve un String con un mensaje que lo indica. Son números primos aquellos números naturales que sólo son divisibles por sí mismos y por 1. Considera la introducción de lógica de control que evalúe si el número recibido por parámetro es negativo o tiene decimales, casos en los que un número no puede ser primo. 2) La segunda utilidad de ```RobotPrimo``` será un método para imprimir todos los números primos que existen en un intervalo; por esta razón este método —dale un nombre apropiado— debe recibir por parámetro dos números enteros, el ```principio``` y el ```fin``` de dicho intervalo.
8. La clase ```RobotCortador``` implementa varios métodos sobrecargados ```procesar()``` con diferente signatura. Uno de estos sobreescribe el método abstracto definido por ```RobotCientifico``` y recibe un valor double por parámetro, siendo su misión imprimir en consola por separado la parte entera y la parte decimal del valor recibido como argumento. La clase además definirá: un método ```procesar(int numero)``` que simplemente devuelve el valor recibido dividido por 2 y un método ```procesar(String string)``` que divide la cadena recibida en dos mitades y las imprime por separado en consola. Opcionalmente, puedes crear dos métodos ```procesar()``` adicionales que reciben por parámetro un array de enteros y otro un array de Strings, los dividen por la mitad e imprimen los arrays resultantes por consola.
9. Debes definir dos subtipos de ```RobotArtista```, ```RobotPoeta``` y ```RobotPintor```. Estas dos subclases no podrán ser objeto de herencia por otras clases por debajo de ellas.
10.	```RobotPintor``` tiene dos constructores coordinados con los de su superclase ```RobotArtista```: uno que solamente recibe como argumentos el ```nombre``` y ```numeroSerie``` y otro que, además, recibe un ```Comportamiento```. Esta clase contiene definiciones constantes y estáticas de tres figuras geométricas, ```CUADRADO```, ```TRIÁNGULO``` y ```ROMBO``` (pueden incluirse en un tipo Enum ```Figura```; un método ```dibujar(Figura figura, int altura, char caracter)``` que dibuja en consola cualquiera de las tres figuras, compuesta de una repetición de caracteres del valor char pasado por argumento y de una altura en líneas de consola según la altura pasada por argumento. Ejemplos:
    
<table align="center">
    <tr>
        <td align="center">
            <b>m</b>
            <br><b>mmm</b>
            <br><b>m</b>
        </td>
        <td align="left">
            <b>$</b>
            <br><b>$$</b>
            <br><b>$$$</b>
            <br><b>$$$$</b>
            <br><b>$$$$$</b>
        </td>
        <td align="center">
            <b>uuuu</b>
            <br><b>uuuu</b>
            <br><b>uuuu</b>
            <br><b>uuuu</b>            
        </td>
        <td align="center">
            <b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
            <br><b>pppppppp</b>
        </td>
    </tr>
</table>

11. Considera el uso de una estructura de tipo switch-case en el método de ```RobotPintor``` ```dibujar()``` para determinar el dibujo que se realizará, y la posibilidad de delegar el trabajo de los bucles de impresión en consola de tales dibujos en unos métodos: ```dibujarCuadrado()```, ```dibujarTriangulo()```, ```dibujarRombo()```;
12. Los objetos de ```RobotPintor``` instanciados con un ```Comportamiento``` ```REGULAR``` dibujarán exactamente la figura con la altura y carácter de repetición pasados por argumento, mientras que las instancias de ```RobotPintor``` de ```Comportamiento``` ```ALEATORIO``` ignorarán los parámetros de configuración de ```dibujar()``` y pintarán una figura escogida aleatoriamente, de altura aleatoria (máximo 12 líneas) y un carácter aleatorio. Considera la conveniencia de restringir los caracteres a un rango concreto de caracteres de la tabla ASCII, p. ej. entre 33-95 para evitar la impresión de figuras “invisibles”.
13. La clase ```RobotPoeta``` contiene tres campos de tipo String[] (array de Strings), cada uno de ellos con 4 líneas de un poema o canción diferentes y un campo String[][] (array bidimensional) que almacena los tres poemas. La clase definirá dos constructores sobrecargados coordinados con los de su superclase ```RobotArtista``` y un único método ```recitar()```, que no devuelve nada pero imprime en consola 4 versos de la colección bajo las siguientes reglas: Si la instancia de ```RobotPoeta``` tiene un ```Comportamiento``` ```REGULAR```, imprimirá de manera congruente los 4 versos del poema o canción de uno de los arrays String[] elegido al azar; si tiene un ```Comportamiento``` ```ALEATORIO```, imprimirá 4 versos escogidos aleatoriamente de cualquiera de los tres poemas o canciones, de modo que existirá una probabilidad muy pequeña de que imprima 4 versos del mismo poema en su debido orden.
14. Define, por último, una clase principal con método ```main()``` destinada a instanciar un ```Robot``` de cada tipo (un ```RobotPrimo```, un ```RobotCortador```, un ```RobotPintor``` ```REGULAR```, un ```RobotPintor``` ```ALEATORIO```, un ```RobotPoeta``` ```REGULAR``` y un ```RobotPoeta``` ```ALEATORIO```), imprimir la información general de cada objeto mediante el método ```toString()``` e invocar a continuación los métodos de cada objeto para someterlos a prueba en la ejecución del programa. El orden de pruebas propuesto es el siguiente:

     1. Impresión de datos de los seis objetos.
     2. Solicitar al RobotPrimo procesar el número 11 para saber si es o no primo.
     3. Solicitar al RobotPrimo imprimir el intervalo de números primos entre 1 y 50.
     4. Solicitar a un RobotPintor de Comportamiento REGULAR dibujar un TRIÁNGULO de 8 líneas de alto compuesto de caracteres ‘$’.
     5. Solicitar a un RobotPintor de Comportamiento ALEATORIO imprimir una figura con cualesquiera argumentos: el objeto dibujará una figura de manera aleatoria.
     6. Solicitar al RobotCortador procesar el número 4.0 y procesar el número 0.285714.
     7. Solicitar al RobotCortador procesar el String “acurruca”, procesar el array de enteros {5, 5, 45, 66, 1001, 2, 3, 11} y procesar también el array de Strings {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"}.
     8. Solicitar a un RobotPoeta de Comportamiento REGULAR recitar versos de su colección.
     9. Solicitar a un RobotPoeta de Comportamiento ALEATORIO recitar versos de su colección.
     10. Imprime para terminar un mensaje indicando el número total de Robots construidos.

<h3 id="lineage-output">Console Output:</h3>

```I am a Robot of: [name=Bender, serialNumber=1010011010BU22, discipline=Science]
I am a Robot of: [name=Euclid, serialNumber=E213002248G, discipline=Science]
I am a Robot of: [name=Frida, serialNumber=K15019071954L, discipline=Arts]
I am a Robot of: [name=Salvador, serialNumber=D1904858585A, discipline=Arts]
I am a Robot of: [name=Byron, serialNumber=E18091849AP, discipline=Arts]
I am a Robot of: [name=3DG4R-4LL4N-P03, serialNumber=E18091849AP, discipline=Arts]

+----------------------+
|     Operations     |
+----------------------+

11 is a prime number.

Primes between 1-50:
[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]

$
$$
$$$
$$$$
$$$$$
$$$$$$
$$$$$$$
$$$$$$$$

 G
GGG
 G

Whole part: 4; Decimal part: 0.0
Whole part: 0; Decimal part: 0.285714

acur / ruca
First half: [5, 5, 45, 66] / Second half: [1001, 2, 3, 11]
First half: [Mercurio, Venus, Tierra, Marte] / Second half: [Júpiter, Saturno, Urano, Neptuno]

3-1 Tu rencor, tu porqué, tu agonía...
3-2 O tal vez esa sombra
3-3 que se tumba a tu lado en la alfombra
3-4 A esperar que suba la marea.

1-4 Y no poder del árbol desasirse
2-1 ¿Qué es poesía?, dices mientras clavas
3-1 Tu rencor, tu porqué, tu agonía...
2-2 en mi pupila tu pupila azul.

=====Total robots manufactured: [6]=====
```

<h3 id="lineage-summary">Summary:</h3>

This program is intended to make for a good example of object-oriented programming in Java. It uses abstract classes and inheritance to create a hierarchy of robot classes with different functionalities.

The Robot class serves as the base class for all robots and contains common attributes like name and serial number, as well as a static counter to keep track of the number of robots created. The ArtsRobot and ScienceRobot classes are abstract classes that inherit from the superclass Robot and add functionality specific to their respective disciplines.

The PrimeRobot and CuttingRobot classes inherit from ScienceRobot and provide concrete implementations of the abstract process() method. Each of these robots performs a different operation, such as checking whether a number is prime, cutting a number or string in half.

The PoetRobot and PainterRobot classes inherit from ArtsRobot performing different operations. Their superclass ArtsRobot implement a Behavior attribute that is set to Behavior.REGULAR by default but can be overridden in the constructor. The PoetRobot class uses this attribute to generate poems with different levels of complexity, whereas the PainterRobot paints different shapes made of characters on the console.

Overall, the program demonstrates how to use object-oriented programming concepts like inheritance and abstract classes to create a hierarchy of classes with different functionalities, making the code easier to maintain and extend.

<br>    

<h2 id="yum-snack-bar">
  Ejercicio segundo: Yum Snack Bar
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f37f.png?v8" alt="popcorn" style="float:right;width:64px;height:64px;">
</h2>

<h3 id="yum-conocimientos">Conocimientos necesarios:</h3>

* Programación Orientada a Objetos
* Composición
* Modularización en paquetes e importación de clases
* Uso de Colecciones dinámicas en Java
* Creación y captura de excepciones
* Creación e implementación de Interfaces
* API de tiempo y calendario de Java 8+
* Persistencia de información: API I/O de Java I/O para lectura/escritura de ficheros
* Comparación de objetos (Comparable)

<h3 id="yum-requisitos">Requisitos:</h3>

El objetivo es crear un programa en Java para administrar los aspectos básicos de la venta de productos de un establecimiento de palomitas, bebidas y aperitivos para consumir en el cine. La función principal es el registro de las compras o transacciones, simulando una aplicación de TPV o "cash register".

El establecimiento "Yum Snack Bar" ofrece a sus clientes los siguientes productos: 1) Refrescos y 2) palomitas de diferentes tamaños; 3) chocolatinas o snacks, 4) bolsas de chucherías al peso y 5) bolsas de frutos secos variados que se compran también al peso o granel.

1.	Construye una solución Orientada a Objetos que contemple las diferentes clases necesarias para organizar el programa, utilizando paquetería para dividir lo mejor posible el código agrupando las clases por sus características y finalidad.
2.	Parece clara la conveniencia de utilizar la herencia: por ejemplo, es posible concebir una clase ```CajaPalomitas``` y otra clase ```VasoRefresco```, con características propias, y una superclase ```Producto``` con características comunes como un ```nombre``` y un ```precio```.
3.	Crea unas constantes que definan los tamaños posibles de las palomitas y las bebidas: ```MEDIANO```, ```GRANDE```, ```GIGANTE```. Una solución posible es la definición de un tipo enumerado ```Tamaño```.
4.	Las diferentes clases de productos deben implementar los métodos ```toString()``` y _getters_ y _setters_ necesarios. Los constructores de clases y superclases deben coordinarse según los requisitos del ejercicio. Ten presente que esta es una aplicación para gestionar las transacciones, no de constitución de la tienda y productos: por esta razón no se pasará el nombre ni el precio de los productos en su instanciación, sino que ya tendrán un nombre descriptivo y precio predefinidos. Parece aconsejable utilizar a tal fin campos estáticos como ```NOMBRE``` y ```PRECIO```, a falta del uso de una base de datos de productos. Utiliza el tipo double para manejar el precio de los productos.
5.	Las palomitas y bebidas deben tener diferentes precios en función del tamaño. El constructor de la clase ```VasoRefresco```, además del ```Tamaño```, recibirá por parámetro el ```Sabor``` (```COLA```, ```COLA_LIGHT```, ```NARANJA```, ```LIMON```) para lo cual se recomienda el uso de un tipo Enum ```Sabor``` anidado en la clase. Existirá una clase ```Menu``` que permitirá la compra de la combinación de productos palomitas + bebida a precios especiales de promoción. Es aconsejable utilizar la composición para diseñar esta clase, que constará de objetos ```CajaPalomitas``` y ```VasoRefresco```.
6.	<span id="yum-requisitos-6">El constructor</span> de ```Menu``` evaluará que las palomitas y bebidas pasadas por argumento sean del mismo ```Tamaño```. No se permiten menús con un caja de palomitas y un vaso de bebida de diferente ```Tamaño``` (p.ej. ```Palomitas``` ```MEDIANO``` y ```Refresco``` ```GRANDE```). Crea una excepción personalizada llamada ```ExcepcionTamañoIlegal``` que pueda ser arrojada en tales casos.
7.	Las clases para ```BolsaChucherias``` y ```BolsaFrutosSecos```, que permiten la compra al peso, deben fijar un precio estático referido a 100g de ese producto, y su constructor recibirá por parámetro el peso concreto de la compra, que se multiplicará por aquel atributo para calcular el precio. Crea una interfaz denominada ```Pesable``` con un método ```calcularPrecio(double peso)``` para sea implementado por estas dos clases de productos que se venden a granel. Es aconsejable emplear alguna función de redondeo de 2 decimales para evitar la impresión de precios como 8.250000000000002.
8.	<span id="yum-requisitos-8">Las clases</span> ```BolsaChucherias``` y ```BolsaFrutosSecos``` deben incorporar una lógica que arroje una excepción ```IllegalArgumentException``` si se intenta comprar una bolsa con un precio negativo o anormalmente bajo, menor de 20 g, para prevenir trampas con la balanza.
9.	La clase ```Chocolatina``` será la más simple de todas: hereda de ```Producto```, tendrá un ```precio``` estático, el ```nombre``` estático del producto y un constructor que no recibe argumentos.
10.	<span id="yum-requisitos-10">Crea una clase que ```Tienda``` almacene la información del establecimiento</span> que consideres necesaria y, como mínimo, su ```nombre y la ```fecha``` en que la tienda fue fundada. Utiliza preferiblemente alguna de las clases relativas a fechas de la API de Java 8 o superior. Debes crear un método que permita imprimir en consola un mensaje del tipo: "Bienvenido al programa de Yum Snack Bar, sirviendo palomitas, colesterol y alegría desde hace {x} años". Este número de años debe calcularse de manera dinámica en función de la ```fecha``` de fundación predefinida de la tienda y su diferencia con la fecha actual del sistema cuando se ejecute el programa.
11.	Crea una clase ```Transaccion``` destinada a aglutinar todos los productos comprados por un solo cliente en una operación de caja (p. ej., un cliente compra un ```Menu```, una ```Chocolatina``` y una ```BolsaChucherias``` en una sola ```Transaccion```). Una ```Transaccion``` se compone de un entero ```id```, la ```fechaHora``` exacta de su creación, una ```lista``` de ```<Producto>``` (utiliza una colección dinámica) y el ```precioTotal``` de los productos que la conforman. Crea los métodos necesarios en la clase ```Transaccion```, incluyendo ```toString()``` para mostrar sus componentes en consola, y utiliza los métodos provistos por la clase ```Producto``` para implementar la lógica.
12.	 <span id="yum-requisitos-12">Se necesita conocer cuál es</span> la ```Transaccion``` más cara (```precioTotal``` más elevado) de una lista de transacciones. Puede conseguirse este objetivo de diversas maneras, pero se recomiendo utilizar la interfaz ```Comparable``` o la interfaz ```Comparator``` para este propósito.
13.	Crea una clase ```LogTransaccion``` destinada a almacenar en un fichero **log.txt** la información de todas las transacciones de una sesión del programa y capaz también de leer la información del _log_ y mostrarla por consola. El formato del _log_ y los detalles de implementación son libres, pero se recomienda guardar cada transacción en una línea, con un formato p. ej.: 'fecha-hora trans-id, producto, producto, producto: precio'.
14.	Como ejercicio adicional, introduce en la clase ```LogTransaccion``` la lógica de comprobación necesaria para que la transacción más cara ([punto 12](#yum-requisitos-12)) se guarde en el fichero añadiendo al final de la línea el string “(!)”.
15.	En una clase principal, en el método main(), invoca la frase de presentación de la tienda ([punto 10](#yum-requisitos-10)) y crea sucesivas ventas de productos y transacciones para someter el programa a prueba. Las operaciones a realizar en el método principal son las siguientes:

    1.	Se crearán secuencialmente seis transacciones diferentes (```Transaccion```) con el fin de guardarlas en una lista, pasarlas a ```LogTransaccion``` para guardarlas en el fichero de _log_ y a continuación leer ese fichero e imprimir su contenido en consola.
    2. Para la primera transacción, crea las compras de una ```CajaPalomitas``` ```GRANDE``` y una ```Chocolatina```, guarda la transacción en la lista de transacciones e imprímela.
    3. Para la segunda transacción, compra un ```VasoRefresco``` ```MEDIANO``` y una ```BolsaFrutosSecos``` de 400 g, guarda la transacción e imprímela.
    4. Para la tercera transacción, compra un ```Menu``` compuesto de un ```VasoRefresco``` de ```COLA_LIGHT``` ```GIGANTE``` y una ```CajaPalomitas``` ```MEDIANO```, forzando el lanzamiento (y captura) de la ```ExcepcionTamañoIlegal``` ([punto 6](#yum-requisitos-6)). La excepción debe prevenir que esta transacción inválida se guarde, loguee o imprima en consola.
    5. Para la cuarta transacción, compra una ```BolsaChucherias``` haciendo trampas con la balanza, por un peso de 6 g, forzando el lanzamiento de la ```IllegalArgumentException``` del [punto 8](#yum-requisitos-8). La excepción debe prevenir que esta transacción inválida se guarde, loguee o imprima en consola.
    6. Para la quinta transacción, compra una ```BolsaChucherias``` de 400 g y un ```Menu``` compuesto de un ```VasoRefresco``` ```NARANJA``` ```GIGANTE``` y una ```CajaPalomitas``` ```GIGANTE```. Intenta instanciar el objeto ```Transaccion```, los objetos ```Producto``` y los objetos que componen el ```Menu``` en una sola instrucción de código (instanciación de objetos anónimos o instanciación “al vuelo”). Guarda la transacción e imprímela.
    7. Para la sexta transacción, que será la más cara, compra una ```BolsaChucherias``` de 750 g y un ```VasoRefresco``` de ```COLA``` ```GIGANTE```, guarda la transacción e imprímela.
    8. Imprime en consola cuál es la transacción más cara de toda la sesión.
    9. Por último, guarda la lista de transacciones en el fichero de _log_ y recupera la información que se ha guardado en este fichero para imprimirla por consola.

<h3 id="yum-precios">Guía de precios:</h3>

Se recomienda utilizar esta guía de precios para los productos de la tienda:

<br>

<table align="center">
    <tr>
        <th colspan=2, align="center">
            <b>Guía orientativa de precios de los productos de Yum Snack Bar</b>
        </th>
    </tr>
    <tr>
        <td>
            Palomitas MEDIANO / GRANDE / GIGANTE
        </td>
        <td>
            5.0 / 7.0 / 9.0
        </td>
    </tr>
    <tr>
        <td>
            Refresco MEDIANO / GRANDE / GIGANTE
        </td>
        <td>
            4.5 / 6.0 / 7.5
        </td>
    </tr>
    <tr>
        <td>
            Menú MEDIANO / GRANDE / GIGANTE
        </td>
        <td>
            7.95 / 8.95 / 9.95
        </td>
    </tr>
    <tr>
        <td>
            Chocolatina
        </td>
        <td>
            2.0
        </td>
    </tr>
    <tr>
        <td>
            Bolsa de frutos secos (100 g)
        </td>
        <td>
            1.80
        </td>
    </tr>
    <tr>
        <td>
            Bolsa de chucherías (100 g)
        </td>
        <td>
            1.10
        </td>
    </tr>
</table>

<h3 id="yum-salida">Salida en consola:</h3>

```+------------------------+
| Welcome to the Yum Snack Bar|
| Puerta del Sol, Km. 0, 28013 Madrid, Spain|
| Serving popcorn, cholesterol, and joy for 37  years. |
+------------------------+

Transaction [ID=1,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Popcorn box 'LARGE' - price=7.0], Product: 'Chocolate snack' - price=2.0],
	totalCost=9.0]
	
Transaction [ID=2,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Soda beverage cup 'MEDIUM' - price=4.5], Product: 'Mixed nuts bag' - price=7.2],
	totalCost=11.7]
	
products.IllegalSizeException: Soda cup and popcorn box must be of the same size.
	at products.Menu.<init>(Menu.java:16)
	at store.Main.main(Main.java:42)
	
java.lang.IllegalArgumentException: CandyBag weight must be 20g or higher
	at products.CandyBag.<init>(CandyBag.java:18)
	at store.Main.main(Main.java:55)
	
Transaction [ID=5,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=4.4, Menu: Soda+Popcorn 'EXTRALARGE' - price=9.95],
	totalCost=14.35]
	
Transaction [ID=6,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=8.25, Soda beverage cup 'EXTRALARGE' - price=7.5]],
	totalCost=15.75]

The most expensive transaction (!) is:

Transaction [ID=6,
	formattedTimestamp=15/02/2023-15:00:33,
	items=[Product: 'Gummy candy bag' - price=8.25, Soda beverage cup 'EXTRALARGE' - price=7.5]],
	totalCost=15.75]

==== Transactions in the log file ====

15/02/2023-15:00:33 ID=1, Popcorn box, Chocolate snack; price=9.0
15/02/2023-15:00:33 ID=2, Soda beverage cup, Mixed nuts bag; price=11.7
15/02/2023-15:00:33 ID=5, Gummy candy bag, Soda cup + Popcorn box at menu price; price=14.35
15/02/2023-15:00:33 ID=6, Gummy candy bag, Soda beverage cup; price=15.75 (!)
```

<br>

<h2 id="biblioteca-filipinas">
  Ejercicio tercero: Biblioteca Filipinas
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f4da.png?v8" alt="books" style="float:right;width:64px;height:64px;">
</h2>

<h3 id="biblioteca-conocimientos">Conocimientos necesarios:</h3>

* Programación Orientada a Objetos en Java (composición y otras técnicas)
* Colecciones en Java
* Clases e interfaces de la API JDBC de Java
* Bases de datos relacionales: conceptos y estructura
* Lenguaje MySQL (DDL, DML, DQL)
* Instalación de un servidor MySQL local (p.ej. phpMyAdmin)
* Descarga de un driver JDBC apropiado e instalación en el _classpath_ del proyecto
* Mapeo objeto-relacional manual (sin el uso de un framework ORM)
* Sintaxis CRUD básica en MySQL
* Uso de Prepared Statements
* Cierre de recursos para evitar fugas de memoria (opción de empleo de la sintaxis _try-with-resources_)
* Captura de excepciones
* Buenas prácticas en la escritura de código 

<h3 id="biblioteca-requisitos">Requisitos:</h3>

El objetivo de este ejercicio es crear un programa en Java con utilidad práctica capaz de administrar el servicio de préstamo de libros de una biblioteca de uso público. La aplicación realiza consultas y actualizaciones de una base de datos MySQL cuyas sentencias de creación e inserción de datos se proporcionan al final de este enunciado.

La base de datos almacena información en cuatro tablas: ```library``` con información y reglas generales de la biblioteca; ```book``` con información de los libros en los fondos de la biblioteca y su disponibilidad; ```reader``` con información sobre los lectores o usuarios abonados al servicio de préstamo de la biblioteca; y ```borrowing``` con información sobre los préstamos de libros a los lectores, que incluye claves foráneas que hacen referencia a las tablas ```book``` y ```reader```.

Es importante conocer las **Normas de Préstamo** de la biblioteca para desarrollar el software de administración de manera congruente<sup>1</sup>. La biblioteca diseñada por defecto en las sentencias SQL que se ofrecen más abajo:

1. Permite a cada usuario tener en préstamo un máximo de 3 libros al mismo tiempo.
2. Concede los préstamos por un plazo máximo de 15 días.
3. Y por último, como es típico en muchas bibliotecas públicas de España, fija una penalización para los lectores que devuelvan libros más tarde del plazo máximo, en este caso una penalización de 3 días sin poder tomar prestados libros por cada día de retraso en la devolución de un libro (así, un retraso de 5 días supone una penalización de 15 días).

Conociendo estos requisitos, realiza un programa en Java con las siguientes especificaciones:

1. Crea un proyecto que incorpore en el _classpath_ el driver necesario para manejar una **base de datos MySQL** y define en el programa en Java la ruta, credenciales y otros valores necesarios para establecer la conexión con un servidor local.
2. Crea la base de datos e inserta los valores que se proporcionan al final de este enunciado en un servidor local (_localhost_) MySQL (puedes utilizar p.ej. XAMPP-phpMyAdmin o MySQL Workbench). Los registros de ejemplo suministrados ofrecen una variedad de casos para poder someter el programa que desarrolles a prueba, incluyendo préstamos (“borrowings”) dinámicamente creados en fechas relativas a la fecha del sistema en el momento de inserción de los datos.
3. Crea las clases necesarias en tu proyecto en Java para ofrecer una solución orientada a objetos con la suficiente modularidad. Esto significa que el programa debe tener clases “modelo” equivalentes a las entidades de la base de datos: ```Library```, ```Book```, ```Reader``` y ```Borrowing``` con los campos y miembros que corresponden a los campos de la tabla. Se recomienda dividir el código en clases y paquetes siguiendo un patrón de diseño MVC o arquitecturas modulares similares.
4. El software de administración de una biblioteca como la presentada en este enunciado podría ofrecer muchas funcionalidades tales como operaciones CRUD de libros y lectores abonados, devolución de listas, búsquedas y comparaciones con filtros avanzados, etc. Sin embargo, en este ejercicio sólo debes programar la **funcionalidad necesaria para realizar préstamos de libros a lectores y registrar devoluciones de los libros prestados.** A pesar de que estas dos funciones parecen sencillas, implementarlas adecuadamente con arreglo a las reglas descritas al principio exigirá realizar consultas y comprobaciones en las cuatro tablas.
5. El programa solicitará al usuario con un “menú” por consola, en un bucle infinito, qué opción quiere realizar —```PRESTAMO```, ```DEVOLUCION```, ```SALIR```— y a continuación solicitará los valores de ```ID``` del libro e ```ID``` del lector para llevar a cabo la operación seleccionada, si es posible realizarla, mediante métodos especializados.
6. Debes poner especial atención en que el programa, para realizar préstamos y devoluciones, además de otras situaciones evalúe las reglas de número máximo de préstamos, plazo máximo de días de préstamo y días de sanción por día de retraso en el préstamo de la biblioteca, así como el número de préstamos que tiene un lector, si tiene o no días de sanción, el valor de disponibilidad (```available```) de un libro para saber si está prestado actualmente o no, etcétera.
7. Debe controlarse un caso especial que consiste en el intento de devolver un libro actualmente prestado a un usuario por otro usuario diferente. Si se permitiera hacerlo, aunque el cambio en la disponibilidad del libro se registraría coherentemente, el sistema permitiría el caso indeseado de que un lector viera reducido su número de libros prestados incluso a valores negativos, alterando las normas de funcionamiento de la biblioteca. Para evitarlo, el método que maneja las devoluciones debe comprobar que hay un préstamo del libro especificado al lector introducido y que este préstamo está vigente (la fecha de devolución es nula).
8. OPCIONAL: Puedes intentar implementar la lógica más compleja de este programa: haz que evalúe los días que un lector lleva de retraso en la devolución de libros que todavía tiene prestados y: 
    1. Impida tomar prestados nuevos libros a ese lector si tiene retraso.
    2. Aplique la penalización que le corresponde sumándola al valor del campo ```penalty_count``` de su registro en la tabla ```reader``` y al campo ```overdue_penalty``` del registro de ese préstamo en la tabla ```borrowing``` al tiempo de la devolución.
10. OPCIONAL: Crea una interfaz gráfica con Java Swing u otro _framework_ similar para facilitar la gestión de préstamos y devoluciones de libros en un entorno gráfico.
11. OPCIONAL: Añade otras funciones que consideres interesantes para la aplicación.
12. **RECOMENDACIÓN**: Para buscar en la base de datos préstamos por su ID en orden a registrar una DEVOLUCIÓN, se recomienda limitar la _query_ a la base de datos al último resultado (cláusulas ```DESC LIMIT 1```) para evitar confusiones con préstamos antiguos del mismo libro al mismo lector que podrían producir un funcionamiento anómalo del programa.
13. Para someter a prueba el programa, se realizará una ejecución dando las siguientes órdenes en el menú de selección de opciones:

    1. La primera operación consistirá en registrar un ```PRÉSTAMO``` del libro con ID 1 (“El Quijote”) por el lector con ID 1 (George Stobbart). Se mostrará un mensaje de confirmación, se modificará la disponibilidad del libro y se incrementará el contador de libros prestados de este lector.
    2. La segunda operación consistirá en practicar la ```DEVOLUCIÓN``` del libro con ID 3 (“Las aventuras de Huckleberry Finn”) prestado al lector con ID 1 (George Stobbart). Este préstamo viene preconstituido por las inserciones propuestas al final del enunciado, diseñadas para que se realice con fecha del día mismo de la inserción a las 08:34:05 horas. Se mostrará una confirmación de la devolución, se cambiará la disponibilidad del libro (```true```) , se insertará la fecha de devolución en el registro correspondiente de la tabla `borrowing` y se disminuirá el contador de libros prestados del lector.
    3. La tercera operación consistirá en intentar registrar un ```PRÉSTAMO``` del libro con ID 1 (“El Quijote”) por el lector con ID 6 (Liam McGuire), debiendo mostrarse el mensaje de que no es posible realizar el préstamo tras comprobarse el estado no disponible del libro a causa de la primera operación.
    4. La cuarta operación consistirá en intentar registrar un ```PRÉSTAMO``` del libro con ID 10 (“Vida y destino”) por el lector con ID 4 (Augustin Rosso), debiendo mostrarse el mensaje de que no es posible autorizar el préstamo porque el lector ya tiene 3 libros, el número máximo de préstamos permitidos. 
    5. La quinta operación consistirá en intentar registrar un ```PRÉSTAMO``` del libro con ID 14 (“Los miserables”) por el lector con ID 15 (Gamal Khan), debiendo mostrarse el mensaje, a pesar de que el libro está disponible, de que no es posible autorizar el préstamo porque el lector tiene una penalización por retrasos vigente.
    6. La sexta operación consistirá en intentar registrar la ```DEVOLUCIÓN``` del libro con ID 11 (“La invención de Morel”) por la lectora con ID 9 (Pearl Henderson). Este libro en realidad está prestado al lector con ID 4 (Augustin Rosso) y por lo tanto, el sistema no autorizará la operación informando de esta circunstancia.
    7. La séptima operación consistirá en registrar la ```DEVOLUCIÓN``` del libro con ID 9 (“El perro de los Baskerville”) por el lector con ID 12 (François Plantard), debiendo autorizarse la operación, mostrarse confirmación y practicarse las debidas operaciones de actualización de la base de datos en cuanto al número de libros prestados del lector, la fecha de devolución del préstamo y la disponibilidad del libro devuelto.
    8. OPCIONAL: la octava operación, si se ha implementado la lógica de control del punto 8 opcional, consistirá en intentar registrar el ```PRÉSTAMO``` del libro con ID 9 (“El perro de los Baskerville”) devuelto por otro lector por la lectora con ID 2 (Nicole Collard). Esta lectora no presenta todavía una sanción registrada, pero tiene en préstamo dos libro desde hace 19 y 17 días respectivamente conforme a los datos preconstituidos al final del enunciado, por tanto se ha retrasado en su devolución y se espera que el programa prohíba el nuevo préstamo por este motivo.
    9. OPCIONAL: la novena operación, si se ha implementado la lógica de control del punto 8 opcional, consistirá en registrar la ```DEVOLUCIÓN``` del libro con ID 15 (“Las metamorfosis”) por el lector con ID 3 (André Lobineau), quien ya lleva 1 día de retraso en su devolución. La operación debe ser autorizada y se espera que el programa, además de modificar los campos de disponibilidad del libro, fecha de devolución del préstamo y número de libros prestados de este lector, actualice la base de datos incluyendo la penalización de 3 días por 1 día de retraso.
    10. OPCIONAL: las operaciones décima y undécima, si se ha implementado la lógica de control del punto 8 opcional, consistirán en registrar la ```DEVOLUCIÓN``` de los libros con ID 7 y 12 (“Robinson Crusoe” y “The stand”) de la lectora con ID 2 (Nicole Collard). Al tener un retraso de 4 y 2 días respectivamente en su devolución, se espera que el programa las registre correctamente y actualice la base de datos poniendo a la lectora Nicole Collard una penalización de 12 + 6 = 18 días.
    11. La última operación consistirá en elegir la opción ```SALIR```, que deberá terminar con la ejecución iterativa y finalizar el programa. Conviene comprobar en la base de datos MySQL del servidor si los datos de las tablas ```book```, ```borrowing``` y ```reader``` se han actualizado conforme a los préstamos y devoluciones tramitados durante el ejercicio.

<h3 id="biblioteca-salida">Salida en consola:</h3>

```+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 1
Enter reader ID: 1
Book El Quijote borrowed successfully by George Stobbart and set 'unavailable'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 3
Enter reader ID: 1
Book 'Las aventuras de Huckleberry Finn' returned successfully and set 'available'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 1
Enter reader ID: 6
The book 'El Quijote' is already borrowed.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 10
Enter reader ID: 4
Reader Augustin Rosso has already the maximum borrowings.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 14
Enter reader ID: 15
Reader Gamal Khan has a late return or penalty and can't borrow books.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 11
Enter reader ID: 9
No borrowing found for the specified book and reader IDs.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 9
Enter reader ID: 12
Book 'El perro de los Baskerville' returned successfully and set 'available'.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
borrow
Enter book ID: 9
Enter reader ID: 2
Reader Nicole Collard has a late return or penalty and can't borrow books.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 15
Enter reader ID: 3
Book 'Las metamorfosis' returned successfully and set 'available'.
Late return penalty applied: 3 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 7
Enter reader ID: 2
Book 'Robinson Crusoe' returned successfully and set 'available'.
Late return penalty applied: 12 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
return
Enter book ID: 12
Enter reader ID: 2
Book 'The stand' returned successfully and set 'available'.
Late return penalty applied: 6 days.
+--------------------------------------------------------------+
| Do you want to borrow or return a book? (Borrow/Return/Exit) |
+--------------------------------------------------------------+
exit
Exiting program...
```

<h3 id="biblioteca-insert">Sentencias INSERT de creación de registros de ejemplo en la base de datos:</h3>

<br>

## License
    Copyright (C) 2022  Alejandro M. González
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    
    MIT License: http://opensource.org/licenses/MIT
