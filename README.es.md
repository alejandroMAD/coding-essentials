## Fundamentos de Programación
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](https://github.com/alejandroMAD/coding-essentials/blob/main/README.es.md)

Conjunto de tres proyectos independientes de programación en Java que abarcan el uso de algoritmos básicos, fundamentos de la Programación Orientada a Objetos (POO) y conexión a bases de datos (JDBC), diseñados para que estudiantes de 1º de Programación del CFGS de Desarrollo de Aplicaciones Multiplataforma puedan repasar y superar el curso.

Exceptuando el primer ejercicio, que es un caso de pura imaginación para aplicar conceptos de POO, los ejercicios restantes son el embrión de proyectos y aplicaciones reales con utilidad práctica.

## Índice de contenido
1. [Ejercicio primero: Linaje de Robots](#linaje-robots)
    1. [Conocimientos necesarios](#linaje-conocimientos)
    2. [Requisitos](#linaje-requisitos)
    3. [Salida en consola](#linaje-salida)
2. [Ejercicio segundo: Yum Snack Bar](#yum-snack-bar)
    1. [Conocimientos necesarios](#yum-conocimientos)
    2. [Requisitos](#yum-requisitos)
    3. [Salida en consola](#yum-salida)
3. [Ejercicio tercero: Biblioteca Filipinas](#biblioteca-filipinas)
    1. [Conocimientos necesarios](#biblioteca-conocimientos)
    2. [Requisitos](#biblioteca-requisitos)
    3. [Salida en consola](#biblioteca-salida)


<h2 id="linaje-robots">
  Ejercicio primero: Linaje de Robots 
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f916.png" alt="slot_machine" style="float:right;width:64px;height:64px;">
</h2>

<h3 id="linaje-conocimientos">Conocimientos necesarios:</h3>

* Creación de un programa de consola en Java
* Uso de Eclipse u otro IDE
* Programación Orientada a Objetos
* Estructuras básicas (variables, métodos, constantes, operadores)
* Control de flujo (condicionales, bucles)
* Visibilidad encapsulamiento
* Arrays uni y bidimensionales
* Tipos enumerados (Enum)
* Sobreescritura de métodos
* Sobrecarga de métodos / sobrecarga de constructores
* Herencia y polimorfismo
* Uso de static y final
* Casting o refundición de tipos
* Uso de funciones aleatorias

<h3 id="linaje-requisitos">Requisitos:</h3>

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
    
<h2 id="yum-snack-bar">
  Ejercicio segundo: Yum Snack Bar
  <img src="https://github.githubassets.com/images/icons/emoji/unicode/1f37f.png?v8" alt="popcorn" style="float:right;width:64px;height:64px;">
</h2>









## Licencia
    Copyright © 2022 Alejandro M. González
    
    Licencia MIT: https://opensource.org/licenses/MIT
