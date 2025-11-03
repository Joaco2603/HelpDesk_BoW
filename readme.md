## HelpDesk_BoW

Sistema de mesa de ayuda (Help Desk) con clasificación automática de tickets mediante **Bag of Words (BoW)**. Diseñado para gestionar tickets de soporte técnico, usuarios y departamentos con análisis emocional y técnico del contenido.

## 📋 Funcionalidades

Este es un sistema completo de HelpDesk que permite:
- **Gestión de usuarios** con diferentes roles (Admin, Soporte, Usuario)
- **Creación y seguimiento** de tickets de soporte
- **Clasificación automática** mediante Bag of Words:
  - **Análisis Emocional**: Frustración, Urgencia, Neutralidad, Positivo
  - **Análisis Técnico**: Redes, Impresoras, Cuentas, Hardware
- **Sugerencia automática** de prioridad y departamento
- **Organización por departamentos**
- **Control de estados y prioridades**
- **Estadísticas del sistema**

## 🎯 Clasificador Bag of Words

El sistema incluye un clasificador BoW que analiza el contenido de los tickets:

### Diccionarios Disponibles:
- **Emocional**: Identifica el tono del mensaje (Frustración, Urgencia, Neutralidad, Positivo)
- **Técnico**: Categoriza el problema (Redes, Impresoras, Cuentas, Hardware)

### Funcionalidades del Clasificador:
```java
ClasificadorBoW clasificador = new ClasificadorBoW();

// Analizar ticket completo
AnalisisTicket analisis = clasificador.analizarTicket(asunto, descripcion);
System.out.println("Categoría Emocional: " + analisis.categoriaEmocional);
System.out.println("Categoría Técnica: " + analisis.categoriaTecnica);
System.out.println("Prioridad Sugerida: " + analisis.prioridadSugerida);
System.out.println("Departamento Sugerido: " + analisis.departamentoSugerido);
```

## Requisitos

- **JDK 8 o superior** instalado y configurado en la variable `PATH`
- **IntelliJ IDEA** (recomendado) — Community o Ultimate

## 🚀 Abrir y ejecutar en IntelliJ IDEA

1. Abre IntelliJ IDEA
2. Selecciona "Open" y escoge la carpeta del proyecto
3. IntelliJ detectará automáticamente las clases Java en `src/`
4. Si necesitas, marca los directorios como fuentes:
   - Clic derecho en `Domain/src` -> `Mark Directory as` -> `Sources Root`
   - Clic derecho en `UI/src` -> `Mark Directory as` -> `Sources Root`
5. Ejecuta la clase `MainUI` desde `UI/src/MainUI.java`
   - Clic derecho en `MainUI.java` -> `Run 'MainUI.main()'`

## 🏗️ Arquitectura

```
HelpDesk_BoW/
├── Domain/                       # Capa de Dominio
│   └── src/cr/ac/ucenfotec/
│       ├── bl/                   # Business Layer
│       │   ├── entities/         # Entidades del negocio
│       │   │   ├── Usuario.java
│       │   │   ├── Departamento.java
│       │   │   ├── Ticket.java
│       │   │   └── Tockenizer.java
│       │   ├── handlers/         # Lógica de negocio (Gestores)
│       │   │   ├── UsuarioHandler.java
│       │   │   ├── DepartamentoHandler.java
│       │   │   └── TicketHandler.java
│       │   └── logic/            # Lógica de clasificación
│       │       └── ClasificadorBoW.java
│       └── dl/                   # Data Layer
│           ├── UsuariosData.java
│           ├── DepartamentosData.java
│           ├── TicketsData.java
│           ├── DiccionarioEmocional.java
│           └── DiccionarioTecnico.java
│
└── UI/                           # Capa de Presentación
    └── src/
        ├── MainUI.java           # Punto de entrada
        └── cr/ac/ucenfotec/
            ├── tl/               # Transaction Layer
            │   └── Controller.java
            └── ui/               # Interfaz de usuario
                └── UI.java

```

## 📚 Descripción de las Capas

### 1. Business Layer (BL)

#### Entities
- **Usuario**: Usuarios del sistema con ID, nombre, correo, teléfono y rol
- **Departamento**: Departamentos que atienden tickets con ID, nombre y contacto
- **Ticket**: Tickets de soporte con ID, asunto, descripción, estado, prioridad, fechas, usuario y departamento
- **Tockenizer**: Palabras del diccionario BoW con clasificación y categoría

#### Handlers (Gestores)
- **UsuarioHandler**: CRUD de usuarios y autenticación
- **DepartamentoHandler**: CRUD de departamentos
- **TicketHandler**: CRUD de tickets y consultas especializadas por estado, prioridad, usuario y departamento

#### Logic
- **ClasificadorBoW**: Clasificación automática mediante Bag of Words
  - Análisis emocional del texto
  - Análisis técnico del contenido
  - Sugerencia de prioridad
  - Sugerencia de departamento

### 2. Data Layer (DL)

Simulación de persistencia en memoria:
- **UsuariosData**: Colección de usuarios con datos de prueba
- **DepartamentosData**: Colección de departamentos predefinidos
- **TicketsData**: Colección de tickets en memoria
- **DiccionarioEmocional**: Palabras clave para análisis emocional
- **DiccionarioTecnico**: Palabras clave para categorización técnica

### 3. Transaction Layer (TL)

**Controller**: Coordina operaciones entre capas:
- Autenticación (login, register, logout)
- Gestión completa de usuarios, departamentos y tickets
- Validación de permisos por rol
- Estadísticas y reportes del sistema

### 4. UI Layer

- **UI**: Clase para entrada/salida por consola
- **MainUI**: Punto de entrada que inicia el Controller

## 👥 Roles y Usuarios de Prueba

### Usuarios Predefinidos:
| Rol | Email | Contraseña |
|-----|-------|------------|
| **Admin** | admin@helpdesk.com | admin123 |
| **Usuario** | juan@example.com | 1234 |
| **Soporte** | maria@example.com | 1234 |

### Permisos por Rol:
- **admin**: Acceso total (gestión de usuarios, departamentos, tickets, reportes)
- **soporte**: Gestión y actualización de todos los tickets
- **usuario**: Crear y ver sus propios tickets

## 🏢 Departamentos Predefinidos

1. **Soporte Técnico** - Problemas técnicos generales
2. **Recursos Humanos** - Gestión de cuentas y permisos
3. **Sistemas** - Infraestructura IT y redes
4. **Administración** - Asuntos administrativos

## 🔬 Ejemplo de Uso del Clasificador

```java
ClasificadorBoW clasificador = new ClasificadorBoW();

// Ejemplo 1: Problema de red urgente
String texto1 = "Necesito ayuda urgente, no tengo conexión a la red wifi";
AnalisisTicket analisis1 = clasificador.analizarTicket("Red caída", texto1);
// Resultado: Emocional=Urgencia, Técnico=Redes, Prioridad=Alta, Depto=Sistemas

// Ejemplo 2: Problema de impresora
String texto2 = "La impresora no está funcionando, no imprime nada";
AnalisisTicket analisis2 = clasificador.analizarTicket("Impresora", texto2);
// Resultado: Emocional=Neutralidad, Técnico=Impresoras, Prioridad=Media, Depto=Soporte

// Ejemplo 3: Problema de acceso
String texto3 = "No puedo acceder a mi cuenta, olvidé mi contraseña";
AnalisisTicket analisis3 = clasificador.analizarTicket("Login", texto3);
// Resultado: Emocional=Neutralidad, Técnico=Cuentas, Prioridad=Media, Depto=RRHH
```

## 🛠️ Tecnologías

- **Lenguaje**: Java 8+
- **Paradigma**: Programación Orientada a Objetos
- **Arquitectura**: Capas (Domain, Data, Transaction, UI)
- **IDE**: IntelliJ IDEA (recomendado)
- **NLP**: Bag of Words (Bolsa de Palabras)

## 📝 Notas Importantes

- El sistema **NO requiere JAR externos** para funcionar
- Los datos se almacenan en memoria (se pierden al cerrar)
- El clasificador BoW es completamente funcional sin dependencias
- Los diccionarios son expandibles agregando palabras en las clases Data

## 🔄 Versión

**Versión**: 2.0 - Implementación completa con clasificador BoW

## 👨‍💻 Autores

- Joaquin Alberto Pappa Larreal
- Carlos Viud
- Daniel Guzman

## 📄 Licencia 

Este proyecto está licenciado bajo la Licencia MIT.