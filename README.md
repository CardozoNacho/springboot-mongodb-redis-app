# Movie Reviews | Spring Boot, MongoDB and Redis

[Español](README.es.md)

An individual academic project by Carlos Ignacio Cardozo Peragallo. A review CRUD application with a Vaadin interface, REST endpoints and Redis caching. The original code name `ProyectoBDD2` refers to its academic context, not to Behavior-Driven Development.

## Stack and architecture

Java 21, Spring Boot 3.5.0, Vaadin 24.7.6, Spring Data MongoDB, Spring Cache, Spring Data Redis, Lombok and Maven Wrapper.

```text
REST -> ReviewController -> ReviewService -> ReviewRepository -> MongoDB
Vaadin -> Java method calls to ReviewController
ReviewService -> MovieReviewService -> cached movie review lookup with Redis
```

The UI consists of Java Vaadin views; generated resources do not represent a separate authored React app. Review documents are stored in `BddCrud.mflix`.

## Implemented endpoints

| Method | Path | Operation |
|---|---|---|
| POST | `/api/reviews` | Create a review |
| GET | `/api/reviews/one/{id}` | Find a review by ObjectId |
| GET | `/api/reviews/movie-by-review/{id}` | Find reviews of the movie associated with this review |
| PUT | `/api/reviews/{id}` | Save a review using the supplied id |
| DELETE | `/api/reviews/{id}` | Delete a review |

The second GET takes a **review id**, not a movie id.

## Local setup

Requires JDK 21, MongoDB at `localhost:27017` and Redis at `localhost:6379`. On Windows, the data services can run through Docker Desktop or WSL. No Compose file is included.

```bash
git clone https://github.com/CardozoNacho/springboot-mongodb-redis-app.git
cd springboot-mongodb-redis-app
```

Review `src/main/resources/application.properties`. Run `mvnw.cmd spring-boot:run` on Windows or `./mvnw spring-boot:run` on Linux/macOS. Open `http://localhost:8080/create` or `/retrieve`.

## Current limitations

- `ReviewService.get` caches individual reviews and `MovieReviewService` caches lists. Updates and deletes clear the entire `BddCrud` region; creating a review does not yet invalidate existing lists.
- Reviews and lists share the region with identifier-based keys. Keys may collide if a review id matches a movie id; separate regions or keys are needed.
- `ReviewRepository` declares Integer as its generic id type, although its specific methods use ObjectId. This needs to be unified.
- UI validation does not provide complete REST request validation. No performance measurements are published.

## Tests and verification

`mvnw.cmd test` or `./mvnw test` runs the existing context-load test. There are no BDD scenarios or configured coverage reports. The documentation was checked against source code; end-to-end execution still needs verification with JDK 21 and the data services running.

No license file is included in the repository.
