## HelpDesk_BoW

Este proyecto es una aplicación de mesa de ayuda (Help Desk) diseñada para un entorno universitario. Está pensada para gestionar tickets, usuarios y departamentos, y fue creada para ejecutarse fácilmente desde IntelliJ IDEA. Además está preparada para integrar procesamiento de lenguaje natural (PLN) para clasificación y análisis de tickets (la integración PLN no está implementada en el código fuente actual; se describen recomendaciones más abajo).

## 📋 Funcionalidades

Este es un sistema completo de HelpDesk que permite:
- Gestión de usuarios con diferentes roles (Admin, Soporte, Usuario)
- Creación y seguimiento de tickets de soporte
- Organización por departamentos
- Control de estados y prioridades
- Estadísticas del sistema

## Requisitos

- JDK 8 o superior instalado y configurado en la variable `PATH`.
- IntelliJ IDEA (recomendado) — Community o Ultimate.

## Abrir y ejecutar en IntelliJ IDEA

1. Abre IntelliJ IDEA.
2. Selecciona "Open" y escoge la carpeta del proyecto: `c:\Users\joaco\Documents\Programming\DesktopBoW`.
3. IntelliJ detectará automáticamente las clases Java en `src/`. Si necesitas, marca `src/` como fuente: clic derecho en la carpeta `src` -> `Mark Directory as` -> `Sources Root`.
4. Ejecuta la clase `Main` desde el panel de la izquierda (clic derecho en `Main.java` -> `Run 'Main.main()'`).

## 🏗️ Arquitectura

```
DesktopBoW/
├── src/                          # Business Logic & Data Layer
│   ├── Main.java                 # Punto de entrada (cuando se integre)
│   └── cr/ac/ucenfotec/
│       ├── bl/                   # Business Layer
│       │   ├── entities/         # Entidades del negocio
│       │   │   ├── Usuario.java
│       │   │   ├── Departamento.java
│       │   │   └── Ticket.java
│       │   └── handlers/         # Lógica de negocio
│       │       ├── UsuarioHandler.java
│       │       ├── DepartamentoHandler.java
│       │       └── TicketHandler.java
│       ├── dl/                   # Data Layer
│       │   ├── UsuariosData.java
│       │   ├── DepartamentosData.java
│       │   └── TicketsData.java
│       └── tl/                   # Transaction Layer
│           └── Controller.java   # Controlador principal
│
└── src_ui/                       # Presentation Layer (Separada)
    ├── MainUI.java               # Punto de entrada de la UI
    └── cr/ac/ucenfotec/ui/
        └── UI.java               # Interfaz de usuario
```

## Descripción de las Capas

### 1. Business Layer (BL)

#### Entities
- **Usuario**: Representa a los usuarios del sistema (admin, soporte, usuario)
- **Departamento**: Representa los departamentos que atienden tickets
- **Ticket**: Representa los tickets de soporte creados por usuarios

#### Handlers
- **UsuarioHandler**: Gestiona operaciones CRUD de usuarios y autenticación
- **DepartamentoHandler**: Gestiona operaciones CRUD de departamentos
- **TicketHandler**: Gestiona operaciones CRUD de tickets y consultas especializadas

### 2. Data Layer (DL)

Contiene las clases que simulan la persistencia de datos:
- **UsuariosData**: Almacena y gestiona la colección de usuarios
- **DepartamentosData**: Almacena y gestiona la colección de departamentos
- **TicketsData**: Almacena y gestiona la colección de tickets

### 3. Transaction Layer (TL)

**Controller**: Coordina las operaciones entre las diferentes capas y expone métodos de alto nivel para:
- Autenticación (login, register, logout)
- Gestión de usuarios
- Gestión de departamentos
- Gestión de tickets
- Validación de permisos
- Estadísticas del sistema

## 👥 Roles y Usuarios de Prueba

### Usuarios Predefinidos:
- **Admin**: admin@helpdesk.com / admin123
- **Usuario**: juan@example.com / 1234
- **Soporte**: maria@example.com / 1234

### Roles:
- **admin**: Acceso total al sistema
- **soporte**: Gestión de tickets
- **usuario**: Crear y ver sus propios tickets

## 🛠️ Tecnologías

- **Lenguaje**: Java
- **IDE**: IntelliJ IDEA (recomendado)

## Versión

**Versión**: 1.0

## Autores

Joaquin Alberto Pappa Larreal
Carlos Viud
Daniel Guzman

## Licencia 

Este proyecto está licenciado bajo la Licencia MIT.