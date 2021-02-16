# Mercado Libre - Challenge

## Objetivo
El objetivo de este programa es resolver los 3 niveles de Challenge de Mercado Libre:
* Nivel 1: Construir un programa con 2 metodos:

GetLocation: Recibe una lista de distancias y a partir de una trilateración resuelve la posición
			
GetMessage: Recibe mensajes incompletos y resuelve el mensaje original
			
* Nivel 2: Construir un servicio API Rest que reciba un POST con 3 distancias y 3 mensajes 			y resuelva con las funciones del nivel 1
	
* Nivel 3: Construir un servicio API con POST and a GET de manera de enviar individualmente 			con el POST la distancia y el mensaje a un satélite, y con el GET devuelva la 			ubicación y el mensaje, si fue posible determinarlos		

## Consideraciones
* Se asume que el desfasaje siempre estará al inicio de cada mensaje, representado por strings vacíos.
* Los mensajes siempre contendrán como mínimo la cantidad de posiciones de la frase final.
* Debido a cómo piden la firma de getLocation, se asume que las distancias van a ser enviadas en orden acorde al listado de satélites según inicialización. (1= Kenobi, 2= Skywalker, 3= Sato)
* La función que calcula trilateración usa double (64 bits), por eso se usa en lugar de float (de 32 bits).

## Modelo
### Paquetes

![Screenshot](https://github.com/ignaciocrosta/quasar-challenge/blob/master/doc/Paquetes.png?raw=true)

* El paquete *configuration* contiene el la clase ApplicationYml.Java, la que inicializa la información de los satélites según el archivo de configuración Applicacion.yml
* El paquete *models* contiene las clases que representan al modelo
* El paquete *services* contiene las clases de la capa de negocio, donde se resuelven el mensaje y la localización
* El paquete *resources* contiene las clases que definen los endpoints

### Clases

* El diagrama de clases es el siguiente:

![Screenshot](https://github.com/ignaciocrosta/quasar-challenge/blob/master/doc/Clases.png?raw=true)

### Tecnología
* Se utiliza para el desarrollo Spring boot 2.4.2 y java 11.0.9

## Prerequisitos: Set up
* Instalar JDK 11: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
* Instalar Maven: https://maven.apache.org/install.html

## Getting Started:

* Abrir terminal

* Para compilar y ejecutar:

```bash
	git clone https://github.com/ignaciocrosta/quasar-challenge.git
	cd quasar-challenge
	mvn install
	java -jar target/quasar-challenge.jar
```

* Adicionalmente se disponibiliza el archivo .jar ya compilado para su ejecución.

```bash
	java -jar target/quasar-challenge.jar
```

* Listo para ser utilizado http://localhost:8080/
