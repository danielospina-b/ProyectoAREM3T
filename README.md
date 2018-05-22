###Repositorio para el proyecto de tercer tercio Arquitecturas Empresariales - ECI

####Equipo:  Daniel Ospina - Camilo Mantilla - Sebastián Reyes

[URL Heroku](http://proyecto-arem-omr.herokuapp.com/)

[Repositorio GitHub](https://github.com/danielospina-b/ProyectoAREM3T)


El repositorio contiene la arquitectura utilizada para una implementación tecnológica de la factura electrónica, cuyo requerimiento será obligatorio en Colombia a partir del 2019.

Se incluye el proyecto que corre en Heroku, un formulario web y un API REST que permite a los usuarios reportar los datos de sus facturas para su procesamiento. Cuenta con un sistema de autenticación para brindar seguridad.

#####Dependencias:
-Spring Boot

-Spring Security



Adicionalmente, se encuentra el procesador de facturas que a partir de los datos ingresados en texto plano por los usuarios, convierte a formato XML la factura bajo los requerimientos especificados para esta.

#####Dependencias:
-Spring Boot

-JSON parser