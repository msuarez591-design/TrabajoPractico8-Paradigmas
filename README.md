# 🏦 Sistema de Gestión Bancaria - Banco IUA

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![POO](https://img.shields.io/badge/POO-Orientaci%C3%B3n_a_Objetos-blue?style=for-the-badge)

Este proyecto es el desarrollo de un software de gestión bancaria para el **Banco IUA**, creado como parte del **Trabajo Práctico N° 8 (Integrador + Herencia)** de la materia Paradigmas de Programación II.

**Institución:** Universidad Nacional de la Defensa (UNDEF) - CRUC IUA  
**Carrera:** Ingeniería en Informática  

---

## 📋 Descripción del Proyecto

El sistema permite administrar el registro y control de actividades diarias de la institución bancaria mediante el uso estricto del paradigma Orientado a Objetos (POO). Gestiona clientes, cuentas bimonetarias (Pesos y Dólares), asignación de tarjetas de crédito según la categoría del usuario y el registro histórico de todas las transacciones, garantizando la persistencia de datos mediante archivos de texto.

## 🚀 Funcionalidades Principales

* **Gestión de Clientes:** Altas y bajas lógicas (cambio de estado de `ACTIVO` a `BAJA`).
* **Categorización:** Los clientes se dividen en tipos (`PLATA`, `ORO`, `PLATINO`).
* **Cuentas y Transacciones:** Depósitos y extracciones en Cajas de Ahorro en Pesos o Dólares.
* **Asignación de Tarjetas con Reglas de Negocio:**
  * ❌ **Plata:** No tienen acceso a tarjetas de crédito.
  * 💳 **Oro:** Acceden a tarjeta *Credix* (Límite: $250.000).
  * 💎 **Platino:** Acceden a tarjeta *Premium* (Límite: $500.000).
* **Persistencia de Datos:** Carga automática al iniciar y guardado al finalizar en `clientes.txt` y `transacciones.txt`.
* **Informes y Filtros:** * Detalle general y particular de clientes.
  * Filtro de transacciones por cliente, por mes y por año.

## 🛠️ Tecnologías y Conceptos Aplicados

* **Lenguaje:** Java
* **Conceptos de POO:** Herencia, Encapsulamiento, Polimorfismo, Clases y Objetos.
* **Estructuras de Datos:** Colecciones (`ArrayList`), Iteradores.
* **Manejo de Excepciones:** Bloques `try-catch` y lanzamiento controlado de errores (`throw`).
* **Archivos I/O:** Lectura y escritura de archivos planos de texto (`Scanner`, `FileWriter`, `File`).
* **Documentación:** JavaDoc.

## ⚙️ Instalación y Uso

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/TU_USUARIO/TrabajoPractico8-Paradigmas.git](https://github.com/TU_USUARIO/TrabajoPractico8-Paradigmas.git)
