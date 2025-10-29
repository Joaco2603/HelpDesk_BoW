## HelpDesk_BoW

Este proyecto es una aplicación de mesa de ayuda (Help Desk) diseñada para un entorno universitario. Está pensada para gestionar tickets, usuarios y departamentos, y fue creada para ejecutarse fácilmente desde IntelliJ IDEA. Además está preparada para integrar procesamiento de lenguaje natural (PLN) para clasificación y análisis de tickets (la integración PLN no está implementada en el código fuente actual; se describen recomendaciones más abajo).

## Contenido

- Lenguaje: Java (sin paquetes declarados)
- Estructura del proyecto:
	- `src/Departamento.java` — clase que representa un departamento (nombre, descripción, contacto).
	- `src/Usuario.java` — clase que representa un usuario (nombre, correo, password, teléfono, rol).
	- `src/Ticket.java` — clase que representa un ticket (asunto, descripción, estado, usuario, departamento).
	- `src/Main.java` — clase con `main` de ejemplo que imprime un saludo y un bucle de ejemplo.

## Requisitos

- JDK 8 o superior instalado y configurado en la variable `PATH`.
- IntelliJ IDEA (recomendado) — Community o Ultimate.

## Abrir y ejecutar en IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Selecciona "Open" y escoge la carpeta del proyecto: `c:\Users\joaco\Documents\Programming\DesktopBoW`.
3. IntelliJ detectará automáticamente las clases Java en `src/`. Si necesitas, marca `src/` como fuente: clic derecho en la carpeta `src` -> `Mark Directory as` -> `Sources Root`.
4. Ejecuta la clase `Main` desde el panel de la izquierda (clic derecho en `Main.java` -> `Run 'Main.main()'`).

## Ejecutar desde la terminal (Windows PowerShell)

1. Abre PowerShell.
2. Sitúate en la carpeta del proyecto:

```powershell
cd C:\Users\joaco\Documents\Programming\DesktopBoW
```

3. Compilar las clases Java:

```powershell
javac .\src\*.java
```

4. Ejecutar la clase `Main` (las clases compiladas estarán en `src`):

```powershell
java -cp .\src Main
```

Si `javac` o `java` no están disponibles, instala el JDK y añade su `bin` al `PATH` de Windows.

## Resumen de clases

- `Departamento`:
	- Campos: `nombre`, `descripcion`, `contacto`.
	- Métodos: getters/setters, `toString()`.

- `Usuario`:
	- Campos: `nombre`, `correo`, `password`, `telefono`, `rol`.
	- Métodos: getters/setters, `toString()`.

- `Ticket`:
	- Campos: `asunto`, `descripcion`, `estado`, `usuario` (tipo `Usuario`), `departamento` (tipo `Departamento`).
	- Métodos: getters/setters, `toString()`.

## Estado actual y notas sobre PLN (procesamiento de lenguaje natural)

El código incluido actualmente provee las entidades de dominio y un `Main` de ejemplo. No hay un módulo de PLN ya implementado en este repositorio. A continuación se sugieren vías de integración:

- Integración en Java:
	- Usar bibliotecas como Apache OpenNLP o Stanford CoreNLP para tokenización, lematización y clasificación.
	- Implementar un servicio que reciba el texto del ticket (`descripcion`) y devuelva la categoría/etiquetas.

- Alternativa con microservicio Python (recomendado si ya tienes modelos en Python):
	- Crear una API REST sencilla (Flask/FastAPI) que reciba texto y devuelva la categoría. Consumirla desde Java con `HttpURLConnection` o una biblioteca HTTP moderna.

Recomendación práctica para empezar con PLN:
1. Recolecta ejemplos etiquetados de tickets (asuntos/descripciones + categoría target).
2. Entrena un clasificador (por ejemplo, scikit-learn o un transformer ligero) y expónlo como servicio.
3. Llama al servicio desde la lógica de creación de tickets para asignar departamento o categoría automáticamente.

## Posibles mejoras (siguientes pasos)

- Añadir persistencia: conexión a base de datos (SQLite, H2 para desarrollo) para guardar usuarios y tickets.
- Añadir interfaz (Swing/JavaFX o aplicación web con backend Java + frontend JS).
- Implementar tests unitarios (JUnit) para las entidades y la lógica de negocio.
- Añadir ejemplo de integración PLN básico (ejemplo que llame a un endpoint de prueba).

## Licencia

Coloca aquí la licencia que prefieras (por ejemplo, MIT) o elimina esta sección si no procede.

---

Si quieres, puedo:
- Añadir un ejemplo básico de integración PLN (ej: cliente que llama a un endpoint REST).
- Añadir scripts o un `build.gradle`/`pom.xml` si quieres convertir esto en un proyecto Maven/Gradle.

Dime cuál de estos pasos quieres que implemente y lo hago.

