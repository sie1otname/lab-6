# SEG3502 — Laboratoire 6 — Service Web REST « Calculator »

Sie Samuel Traore — 300445506

Service Web REST Spring Boot (Kotlin) qui expose les quatre opérations de la calculatrice,
avec la documentation OpenAPI 3 générée automatiquement (springdoc-openapi).

| Opération | Requête |
|---|---|
| Addition | `GET /calculator/add/{nombre1}/{nombre2}` |
| Soustraction | `GET /calculator/subtract/{nombre1}/{nombre2}` |
| Multiplication | `GET /calculator/multiply/{nombre1}/{nombre2}` |
| Division | `GET /calculator/divide/{nombre1}/{nombre2}` |

Une division par zéro ou un nombre invalide retourne `400 Bad Request` (via `ControllerExceptionHandler`).

## Exécution (Java 21)

```bash
./gradlew bootRun        # Windows : gradlew.bat bootRun
```

- Exemple : http://localhost:8080/calculator/add/12/30 → `42.0`
- Swagger UI : http://localhost:8080/swagger-ui.html
- OpenAPI JSON : http://localhost:8080/v3/api-docs — YAML : http://localhost:8080/v3/api-docs.yaml

## Tests

```bash
./gradlew test
```
