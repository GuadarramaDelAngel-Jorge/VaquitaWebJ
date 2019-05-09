# Vaquita_web

Tabla de contenidos (ToC)
-------------------------

* [Condiciones, descripción, problema identificado, solución y arquitectura](#condiciones,-descripcion,-problema-identificado,-solucion-y-arquitectura)
* [Condiciones de la licencia Apache-2.0](#condiciones-de-la-licencia-apache-2.0)
  * [Descripción](#descripcion)
  * [Problema](#problema)
  * [Solución](#solucion)
  * [Arquitectura](#arquitectura)
  * [Nota importante](#nota)
* [Requerimientos](#parte2)
  * [Servidores de aplicación, web, bases de datos, etc](#servidores)
  * [Paquetes adicionales](#paquetes)
  * [Versión de Java, etc...](#version-java)
* [Instalación](#parte3)
  * [¿Cómo instalar el ambiente de desarrollo?](#instalar)
  * [¿Cómo ejecutar pruebas manualmente?](#pruebas)
  * [¿Cómo implementar la solución en producción en un ambiente local o en la nube como Heroku?](#heroku)
* [Configuración](#parte4)
  * [Configuración del producto (archivos de configuración](#archivos-configuracion)
  * [Configuración de los requerimientos](configuracion-requerimientos)
* [Uso](#parte5)
  * [Sección de referencia para usuario final. Manual para usuarios finales](#seccion-referencia)
  * [Sección de referencia para usuario administrador](#seccion-referencia-admin)
* [Contenido](#parte6)
  * [Guía de contribución de usuarios](#contribucion-usuarios)
    * [Clonar repositorio](#clonar)
    * [Crear un nuevo branch](#branch)
    * [Enviar un pull request](#pull-request)
    * [Hacer merge](#merge)
* [Roadmap](#parte7)
  * [¿Qué es lo que sigue?](#que-sigue)

Condiciones de la licencia Apache-2.0
=====================================
Es la licencia creada en principio por la Apache Software Foundation para publicar los paquetes del proyecto Apache, sin embargo en la actualidad es usada para muchos otros proyectos. Se considera una licencia permisiva porque no requiere que los trabajos derivados sean publicados bajo la misma licencia y tampoco exige la liberación del código fuente. Los cambios a la versión original deben reflejarse en un archivo en el código fuente y pueden ser publicados usando cualquier otra licencia. Lo más importante de esta licencia es que los derechos de autor deben conservarse tanto en el código fuente como en los binarios.

Descripción
-----------
El dueño de un restaurante ha tenido una buena racha con el aumento en su clientela reafirmando que tiene grandes aspiraciones para el negocio, sin embargo, no cuenta con la seguridad y confianza para implementar una solución basada en TI. Actualmente cuentan con tres motos para brindar servicio a domicilio y en el lugar apenas pueden atender a 10 clientes debido a que el local solo cuenta con una barra para servir.

Problema identificado
---------------------
Han recibido sugerencias por parte de clientes que necesitan hacer pedidos de comida para llevar, añadiendo a esto, actualmente la línea telefónica está dada de baja. La solución que buscan ellos es un portal donde los clientes puedan ver los datos principales del restaurante y un apartado para hacer sus pedidos y hasta que lleguen al lugar proceder al pago para hacer eficiente el tiempo.

Solución
--------
Lo que se espera del sistema es que se pueda manejar los pedidos de los clientes únicamente como una medida para tener un mejor control para el restaurante. Al principio le llegaría una notificación por correo al negocio con cada uno de los nombres de los clientes y sus códigos de transacción. Posteriormente se buscaría la manera de manejar las confirmaciones mediante el sistema a base de perfiles como dueño, cajero, cliente y administrador.

Arquitectura
------------
La arquitectura se basará en el patrón MVC. Los desarrollos de aplicaciones web se han convertido ya en una necesidad para todas las organizaciones, porque permiten aprovechar las ventajas que ofrece el acceso a Internet y liberan al usuario de tener que instalar una nueva aplicación en cada computadora. Estos tipos de desarrollos utilizan un patrón de arquitectura llamado MVC o Modelo-Vista-Controlador.

La arquitectura MVC separa los elementos del sistema en componentes independientes, cada uno con una función específica,razón por la cual es muy parecida al patrón arquitectónico de capas.

Nota importante
===============
Por motivos de desarrollo y presupuesto, se ha escogido un proveedor de servicios en la nube como es AWS. Este servicio administrado en la nube, solo para MySQL nos brindará acceso al componente del servidor MySQL, pero no al sistema operativo subyacente, que será mantenido por el proveedor del servicio. En este caso no importa porque no se necesitará mucho poder de procesamiento.

http://aws.amazon.com/free/ explica la oferta de servicios de nivel gratuito de Amazon Web Services (AWS), que es el proveedor de alojamiento en la nube. El Servicio de Base de Datos Relacional (RDS) ofrece un pequeño servidor MySQL ("micro") con 640 MB de RAM y 20 GB o espacio en disco duro sin cargo mensual durante los primeros 12 meses. Después del primer año, ese servidor costará 18.75 USD por mes.

Para ambiente de desarrollo se implementó una base de datos local con la que se hicieron los diagramas  y las pruebas, por lo que al no contar con servidor de base de datos, la prueba externa realizada por alguna otra persona se tendrá que hacer directamente desde el WAR y no tendrá base de datos, sólo un ejemplo de cómo se vería el proceso.

Requerimientos
==============

Servidores de aplicación, web, bases de datos, etc.
---------------------------------------------------
TOMCAT 8.0.53, MySQL y la tecnología que ofrezca AWS que es cambiante y no se podría determinar en este preciso momento.

Paquetes adicionales
--------------------
Ninguno, ya que las dependencias son manejadas por la misma aplicación y se instalarán correctamente en el servidor web y en el proveedor de servicios en la nube

Versión de JDK, etc
--------------------
JDK 8
Java 1.8.0_201

Instalación
-----------

Cómo instalar el ambiente de desarrollo
---------------------------------------
Es posible instalar las aplicaciones web con formato WAR desde el gestor de aplicaciones de Tomcat al que se puede acceder desde la página principal del servidor (http://localhost:8080), usando el botón Manage App.

1.	Al intentar acceder te solicitará un nombre de usuario y contraseña que disponga de permisos para acceder al gestor.
2.	Si no dispones de un usuario configurado para esto, observarás las instrucciones necesarias en la página que aparecerá cuando no hayas podido acceder.
3.	Te indica que debes registrar en el archivo de configuración tomcat-users.xml, un usuario con perfil de manager-gui. Para ello puedes usar una estructura similar a la que pone de ejemplo:

```
<role rolename="manager-gui"/>
<user username="tomcat" password="s3cret" roles="manager-gui"/>
```

4.	Tras guardar las modifiaciones y reiniciar el servidor, debes poder acceder a la página del gestor de aplicaciones con el usuario que hayas declarado.
5.	Observarás que aparece una lista de las aplicaciones que ya se encuentren instaladas. Puedes desinstalar cualquiera de ellas usando el botón Replegar, o instalar nuevas aplicaciones usando el botón Desplegar que puedes encontrar más abajo, seleccionando previamente el archivo WAR correspondiente con el botón Selecionar archivo.


Configuración
-------------

Uso
---

Contenido
---------

Roadmap
-------
