# 🛠️ Smart Scheduling

## 📖 Descripción

**Smart Scheduling** es un proyecto desarrollado en el marco de un **Hackatón**, implementado bajo los principios de la **arquitectura hexagonal**. Su propósito es ofrecer un **CRUD desacoplado** para gestionar especialistas y sus políticas de atención, con persistencia en **Supabase** (PostgreSQL en la nube).

La arquitectura hexagonal permite separar el **núcleo de negocio** de la **infraestructura** (base de datos, API, frameworks), garantizando mayor flexibilidad, escalabilidad y mantenibilidad a largo plazo.

---

## 🚀 Tecnologías utilizadas

- **Java 21**  
- **Spring Boot 3.5**  
- **Spring Data JPA**  
- **Supabase (PostgreSQL en la nube)**  
- **Arquitectura Hexagonal (puertos y adaptadores)**  
- **Maven**  
- **Postman** (para pruebas de API)

---

## 📌 Funcionalidades principales

- ✅ CRUD completo de **Especialistas**  
- ✅ CRUD completo de **Políticas de Especialistas**  
- ✅ Persistencia en **Supabase** mediante adaptadores JPA  
- ✅ API REST documentada y lista para pruebas con Postman  
- ✅ Implementación de **puertos y adaptadores** para un desacoplamiento limpio  
- ✅ Logs detallados de consultas SQL con Hibernate

---

## 🧩 Arquitectura

El proyecto está estructurado siguiendo los principios de la **arquitectura hexagonal**, con las siguientes capas:

| Capa             | Descripción                                      |
|------------------|--------------------------------------------------|
| **Domain**       | Entidades y reglas de negocio                    |
| **Ports**        | Interfaces que definen los contratos             |
| **Adapters**     | Implementaciones concretas (JPA, REST, etc.)     |
| **Infrastructure** | Conexiones externas (base de datos, API)       |

---

## 👨‍💻 Autor

**Juan Esteban Dulcey Gómez**  
📍 Tunja, Boyacá – Colombia 🇨🇴  
🎓 Estudiante de Ingeniería de Sistemas en la Universidad Santo Tomás  

### 💼 Enfoque profesional

- Desarrollo de software bajo arquitectura hexagonal y DDD  
- Backend con Java + Spring Boot  
- Diseño y gestión de bases de datos relacionales  
- Soluciones cloud con Supabase y PostgreSQL
