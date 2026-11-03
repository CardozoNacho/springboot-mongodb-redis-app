# Reseñas de películas | Spring Boot, MongoDB y Redis

[English](README.md)

Proyecto académico individual de Carlos Ignacio Cardozo Peragallo. CRUD de reseñas con interfaz Vaadin, endpoints REST y caché Redis. El nombre original `ProyectoBDD2` se conserva en el código; no acredita Behavior-Driven Development.

## Tecnologías y arquitectura

Java 21, Spring Boot 3.5.0, Vaadin 24.7.6, Spring Data MongoDB, Spring Cache, Spring Data Redis, Lombok y Maven Wrapper.

```text
REST -> ReviewController -> ReviewService -> ReviewRepository -> MongoDB
Vaadin -> llamadas Java a ReviewController
ReviewService -> MovieReviewService -> consulta por película con caché Redis
```

Las pantallas desarrolladas son vistas Java de Vaadin. Los recursos generados no se presentan como una aplicación React independiente. Los documentos Review se almacenan en `BddCrud.mflix`.

## Endpoints reales

| Método | Ruta | Operación |
|---|---|---|
| POST | `/api/reviews` | Crear reseña |
| GET | `/api/reviews/one/{id}` | Consultar reseña por ObjectId |
| GET | `/api/reviews/movie-by-review/{id}` | Buscar reseñas de la película asociada a esa reseña |
| PUT | `/api/reviews/{id}` | Guardar reseña con el id indicado |
| DELETE | `/api/reviews/{id}` | Eliminar reseña |

El segundo GET recibe el id de una reseña, no el de una película.

## Ejecución local

Requiere JDK 21, MongoDB en `localhost:27017` y Redis en `localhost:6379`. En Windows pueden ejecutarse los servicios de datos con Docker Desktop o WSL; el repositorio no incluye Compose.

```bash
git clone https://github.com/CardozoNacho/springboot-mongodb-redis-app.git
cd springboot-mongodb-redis-app
```

Revisar `src/main/resources/application.properties`. Ejecutar `mvnw.cmd spring-boot:run` en Windows o `./mvnw spring-boot:run` en Linux/macOS. Abrir `http://localhost:8080/create` o `/retrieve`.

## Límites actuales

- `ReviewService.get` cachea reseñas y `MovieReviewService` cachea listas. Actualizar/eliminar invalida toda la región `BddCrud`; crear todavía no invalida listas existentes.
- Reseñas y listas comparten región y claves basadas en identificadores; pueden colisionar si un id de reseña coincide con un id de película. Conviene separar regiones/claves.
- `ReviewRepository` declara Integer como tipo genérico de id aunque sus métodos específicos usan ObjectId; queda pendiente unificarlo.
- La validación de UI no equivale a validación completa de las solicitudes REST. No hay mediciones de rendimiento publicadas.

## Pruebas

`mvnw.cmd test` o `./mvnw test` ejecuta el test de carga de contexto existente. No hay escenarios BDD ni configuración de informe de cobertura. Revisión estática: la ejecución integral debe verificarse con JDK 21 y los servicios disponibles.

No se incluye un archivo de licencia en el repositorio.
