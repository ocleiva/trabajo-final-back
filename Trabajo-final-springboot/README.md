[![Versión](https://img.shields.io/badge/Versión-1.0.0-brightgreen)](https://github.com/tu-usuario/tu-proyecto)
[![Licencia](https://img.shields.io/badge/Licencia-MIT-blue)](https://github.com/tu-usuario/tu-proyecto/blob/main/LICENSE)

## AppSpringBoot-Microservicios

![AppSpringBoot Banner](.media/banner.png)

Este proyecto es un conjunto de microservicios desarrollados con Spring Boot. Incluye funcionalidades de autenticación con JWT, documentación de API con Swagger, y se puede desplegar usando Docker.


## DEMO

[![Watch the video](https://i.pinimg.com/564x/01/95/11/019511c26d8b5b1b1851e4275c0ee38d.jpg)](https://youtu.be/DQxL-Y-AkIo?si=cf_SZfIQJI6Mkub4)


## Características

- **Spring Boot v3.3.1**: Framework para construir aplicaciones Java.
- **Docker v26.1.1**: Contenedorización de aplicaciones.
- **JWT**: JSON Web Tokens para autenticación segura.
- **Swagger**: Documentación de API.


## Estructura del Proyecto

- **CrudOrders**: Microservicio para gestionar órdenes.
- **CrudProducts**: Microservicio para gestionar productos.

## Requisitos

- Java JDK 17 o superior
- Docker
- Docker Compose
- Postman

## Dependencias y Versiones

**Swagger**:
- springdoc-openapi-starter-webmvc-ui: 2.5.0
- springdoc-openapi-ui: 1.6.14

**JWT**:
- jjwt-api: 0.11.5
- jjwt-impl: 0.11.5
- jjwt-jackson: 0.11.5

**Mockito**
- mockito-core: Usando la versión definida por Spring Boot Starter Test
- mockito-junit-jupiter: Usando la versión definida por Spring Boot Starter Test

## Instalación

1. Clonar el repositorio:
   
	git clone https://github.com/ezete13/AppSpringBoot-Microservicios.git

2. Navegar al directorio del proyecto:
	
	cd AppSpringBoot-Microservicios
	
3. Construir los contenedores de Docker:

	docker-compose build

4. Levantar los servicios:

	docker-compose up

## Uso

Acceso a la documentación de Swagger:
CrudProducts -> http://localhost:8083/swagger-ui/index.html
CrudOrders   -> http://localhost:8082/swagger-ui/index.html


Endpoints Principales

Autenticación:
**POST** /auth/login: Inicia sesión y recibe un token JWT.
**POST** /auth/register: Registra un nuevo usuario.

Productos:
**GET** /products: Obtiene la lista de productos.
**POST** /products: Crea un nuevo producto.
**PUT** /products/{id}: Actualiza un producto existente.
**DELETE** /products/{id}: Elimina un producto.

Órdenes:
**GET** /orders: Obtiene la lista de órdenes.
**POST** /orders: Crea una nueva orden.
**PUT** /orders/{id}: Actualiza una orden existente.
**DELETE** /orders/{id}: Elimina una orden.

# Contribuir
¡Siéntete libre de contribuir a este proyecto! Puedes enviar pull requests con nuevas características, mejoras o correcciones de errores.

# Créditos
Este proyecto fue desarrollado como parte de un proyecto universitario por Ezequiel Tello.

# Licencia
Este proyecto está bajo la licencia [Licencia](LICENSE.md) - consulta el archivo [LICENSE.md] para más detalles.

