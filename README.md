# ProyectoBDD2 - BDD con MongoDB y Redis

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-green)
![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-green)
![Redis](https://img.shields.io/badge/Redis-Cache-red)
![REST API](https://img.shields.io/badge/API-REST-orange)

Un proyecto desarrollado en **Spring Boot 3.5.0** con **Java 21** que implementa patrones BDD (Behavior-Driven Development) utilizando **MongoDB** como base de datos y **Redis** para caching. La interfaz de usuario está construida con **Vaadin 24.7.6** y **React**.

## 📋 Descripción del Proyecto

ProyectoBDD2 es una aplicación web empresarial que demuestra:
- **Arquitectura BDD**: Enfoque en el comportamiento del negocio
- **Persistencia con MongoDB**: Base de datos NoSQL flexible
- **Caching con Redis**: Mejora de rendimiento y escalabilidad
- **UI Moderna**: Interfaz reactiva con Vaadin y React
- **Backend REST**: APIs con Spring Web

## 🚀 Tecnologías Principales

| Componente | Versión | Propósito |
|-----------|---------|----------|
| **Java** | 21 | Lenguaje base |
| **Spring Boot** | 3.5.0 | Framework principal |
| **MongoDB** | - | Base de datos NoSQL |
| **Redis** | - | Cache en memoria |
| **Vaadin** | 24.7.6 | Framework UI |
| **React** | - | Librería frontend |
| **Maven** | - | Gestor de dependencias |

## 📁 Estructura del Proyecto

```
TpBddMongoRedis/
├── src/
│   ├── main/
│   │   ├── java/com/main/proyectobdd2/
│   │   │   ├── controller/          # Controladores REST
│   │   │   ├── model/               # Modelos de datos
│   │   │   ├── repository/          # Acceso a datos (MongoDB)
│   │   │   ├── service/             # Lógica de negocio
│   │   │   ├── views/               # Vistas Vaadin
│   │   │   ├── AppShellConfig.java  # Configuración principal
│   │   │   └── ProyectoBdd2Application.java # Punto de entrada
│   │   ├── frontend/                # Código React
│   │   │   ├── index.html
│   │   │   ├── generated/           # Componentes generados
│   │   │   ├── jar-resources/       # Recursos estáticos
│   │   │   └── themes/              # Temas personalizados
│   │   └── resources/
│   │       └── application.properties # Configuración
│   └── test/                         # Tests unitarios
├── pom.xml                           # Configuración Maven
├── mvnw / mvnw.cmd                   # Maven Wrapper
└── README.md                          # Este archivo
```

## 🔧 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 21 JDK**: [Descargar](https://www.oracle.com/java/technologies/downloads/#java21)
- **MongoDB**: [Descargar](https://www.mongodb.com/try/download/community)
- **Redis**: [Descargar](https://redis.io/downloads/)
- **Git**: Para clonar el repositorio

### Verificación de Requisitos

```bash
# Verificar Java
java -version

# Verificar MongoDB (debe estar ejecutándose en localhost:27017)
mongo --version

# Verificar Redis (debe estar ejecutándose en localhost:6379)
redis-cli --version
```

## 🎯 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/tuusuario/TpBddMongoRedis.git
cd TpBddMongoRedis
```

### 2. Iniciar MongoDB

```bash
# Windows
mongod

# Linux/Mac
brew services start mongodb-community
```

### 3. Iniciar Redis

```bash
# Windows
redis-server.exe

# Linux/Mac
redis-server
```

### 4. Configurar Aplicación (opcional)

Edita `src/main/resources/application.properties` si necesitas cambiar los hosts o puertos:

```properties
spring.application.name=ProyectoBDD2

# MongoDB Configuration
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=BddCrud

# Redis Configuration
spring.cache.type=redis
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

## 💻 Ejecutar la Aplicación

### Opción 1: Usando Maven Wrapper (Recomendado)

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

### Opción 2: Usando Maven instalado

```bash
mvn spring-boot:run
```

### Opción 3: Compilar y ejecutar JAR

```bash
# Compilar
mvnw.cmd clean package

# Ejecutar
java -jar target/ProyectoBDD2-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: **http://localhost:8080**

## 🧪 Ejecutar Tests

```bash
# Tests unitarios
mvnw.cmd test

# Con cobertura
mvnw.cmd clean test
```

## 📦 Dependencias Principales

### Spring Boot Starters
- `spring-boot-starter-cache` - Soporte para caching
- `spring-boot-starter-data-mongodb` - Integración MongoDB
- `spring-boot-starter-data-redis` - Integración Redis
- `spring-boot-starter-web` - APIs REST
- `spring-boot-starter-test` - Testing

### Vaadin
- `vaadin-spring-boot-starter` - Framework UI moderno

### Utilidades
- `lombok` - Reduce código boilerplate

## 🏗️ Arquitectura

```
┌─────────────────────────────────────────────────┐
│           UI (Vaadin + React)                   │
├─────────────────────────────────────────────────┤
│           Controllers (REST)                    │
├─────────────────────────────────────────────────┤
│           Services (Business Logic)             │
├─────────────────────────────────────────────────┤
│           Repositories (Data Access)            │
├─────────────────────────────────────────────────┤
│  MongoDB (Persistencia)  │  Redis (Cache)      │
└─────────────────────────────────────────────────┘
```

### Flujo de Datos

1. **Request**: Usuario interactúa con la UI (Vaadin/React)
2. **Controller**: Recibe la solicitud REST
3. **Service**: Aplica lógica de negocio (BDD)
4. **Cache**: Verifica Redis para datos frecuentes
5. **Repository**: Accede a MongoDB si es necesario
6. **Response**: Devuelve datos al cliente

## 🔐 Características

- ✅ **Patrón BDD**: Desarrollo orientado al comportamiento del negocio
- ✅ **Caching Inteligente**: Redis reduce carga en BD
- ✅ **BD NoSQL**: MongoDB proporciona flexibilidad
- ✅ **UI Responsiva**: Vaadin con React
- ✅ **Logs Detallados**: DEBUG activado para MongoDB y Spring Web
- ✅ **Fácil Deployment**: Ejecutable JAR independiente

## 📝 Configuración de Logging

El proyecto incluye configuración de logs DEBUG para:
```properties
logging.level.org.springframework.data.mongodb=DEBUG
logging.level.org.springframework.web=DEBUG
```

Para cambiar los niveles, modifica `application.properties`:
```properties
logging.level.root=INFO
logging.level.com.main.proyectobdd2=DEBUG
```

## 🚨 Solución de Problemas

### MongoDB no conecta
```bash
# Verifica que MongoDB está ejecutándose
netstat -an | findstr :27017

# Reinicia el servicio
# Windows: Ctrl+C en terminal MongoDB y ejecuta mongod nuevamente
```

### Redis no conecta
```bash
# Verifica que Redis está ejecutándose
netstat -an | findstr :6379

# Reinicia Redis
# Windows: Ctrl+C y ejecuta redis-server.exe nuevamente
```

### Errores de compilación
```bash
# Limpia y reconstruye
mvnw.cmd clean install
```

### Puerto 8080 en uso
```bash
# Cambia el puerto en application.properties
server.port=8081
```

## 📚 Recursos Útiles

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [MongoDB Documentation](https://docs.mongodb.com/)
- [Redis Documentation](https://redis.io/documentation)
- [Vaadin Documentation](https://vaadin.com/docs)
- [BDD Best Practices](https://cucumber.io/docs/bdd/)

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo licencia MIT. Ver el archivo `LICENSE` para más detalles.

## ✉️ Contacto

Para preguntas o soporte, por favor abre un issue en el repositorio.

---

**Última actualización**: Febrero 2026  
**Versión**: 0.0.1-SNAPSHOT  
**Estado**: En desarrollo
