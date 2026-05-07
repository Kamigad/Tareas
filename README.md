# ✅ Gestor de Tareas

Aplicación de escritorio desarrollada con **Spring Boot** y **JavaFX** que permite gestionar tareas de forma sencilla. Puedes registrar actividades indicando su nombre, el responsable y el estado actual, además de listarlas, modificarlas y eliminarlas.

---

## ✨ Funcionalidades

- 📋 **Listar** todas las tareas registradas
- 🔍 **Buscar** una tarea por su ID
- ➕ **Agregar** nuevas tareas
- ✏️ **Modificar** tareas existentes
- 🗑️ **Eliminar** tareas

Cada tarea contiene: **ID**, **nombre de la tarea**, **responsable** y **estado**.

---

## 🚀 Tecnologías utilizadas

| Tecnología        | Versión  |
|-------------------|----------|
| Java              | 26       |
| Spring Boot       | 4.0.6    |
| JavaFX            | 20       |
| Spring Data JPA   | -        |
| MySQL             | -        |
| Lombok            | -        |
| Maven             | -        |

---

## 📋 Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- [Java JDK 26+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://www.mysql.com/downloads/)

---

## ⚙️ Configuración

### 1. Clona el repositorio

```bash
git clone https://github.com/Kamigad/Tareas.git
cd Tareas
```

### 2. Crea la base de datos

```sql
CREATE DATABASE tareas_db;
```

### 3. Configura las credenciales

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tareas_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Ejecución

### Con Maven Wrapper

```bash
# Linux / Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

### Con Maven instalado

```bash
mvn spring-boot:run
```

---

## 🗂️ Estructura del proyecto

```
Tareas/
├── src/
│   ├── main/
│   │   ├── java/gm/tareas/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── fxml/          ← Vistas de JavaFX
│   └── test/
├── pom.xml
└── README.md
```

---

## 📦 Modelo de datos

| Campo        | Tipo     | Descripción                          |
|--------------|----------|--------------------------------------|
| `id`         | Long     | Identificador único de la tarea      |
| `nombre`     | String   | Nombre o descripción de la tarea     |
| `responsable`| String   | Persona encargada de la tarea        |
| `estado`     | String   | Estado actual (ej: Pendiente, Hecho) |

---

## 👤 Autor

**Kamigad**  
[GitHub](https://github.com/Kamigad)

---

## 📄 Licencia

Este proyecto es de uso libre con fines educativos.
