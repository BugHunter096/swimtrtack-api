# SwimTrack API

API REST en Java 21 + Spring Boot para gestionar nadadores y marcas de natación.

Este proyecto está pensado como backend pequeño pero serio para portfolio:
estructura clara, DTOs, validación, endpoints REST y pruebas básicas.

## Stack

- Java 21
- Spring Boot 3
- Maven
- Jakarta Validation
- JUnit 5

## Ejecutar

```bash
mvn spring-boot:run
```

La API arranca en:

```txt
http://localhost:8080
```

## Endpoints

### Crear nadador

```bash
curl -X POST http://localhost:8080/api/swimmers \
  -H "Content-Type: application/json" \
  -d '{"name":"Paula García","category":"Junior","sex":"F"}'
```

### Listar nadadores

```bash
curl http://localhost:8080/api/swimmers
```

### Registrar marca

```bash
curl -X POST http://localhost:8080/api/records \
  -H "Content-Type: application/json" \
  -d '{"swimmerId":1,"style":"Libre","sessionType":"Competición","seconds":62.45,"notes":"Mejor marca personal"}'
```

### Ver marcas

```bash
curl http://localhost:8080/api/records
```

### Mejor marca de un nadador

```bash
curl "http://localhost:8080/api/records/best?swimmerId=1&style=Libre"
```

## Qué demuestra

- Diseño REST básico.
- Separación por capas: controller, repository, service, model y dto.
- Validación de entrada.
- Uso de Java moderno.
- Testing unitario de lógica de negocio.

## Mejoras para v2

- Persistencia con PostgreSQL o SQLite.
- Autenticación JWT.
- Swagger/OpenAPI.
- Dockerfile.
- Tests de integración.
