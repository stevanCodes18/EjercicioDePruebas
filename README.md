# PlayerTest - Pruebas Unitarias con JUnit 6

## 📋 Descripción
Este proyecto contiene las pruebas unitarias realizadas sobre la clase `PlayerTest.java` con (JUnit 6).  

##metodos implementados
- Se implementaron los métodos de inicialización `@BeforeEach` y `@AfterEach`.
- En cada test se crea un nuevo objeto `Player` cuando es necesario.
- Se libera el objeto anterior con `player = null` en `@AfterEach`.
- Se utilizó el enfoque recomendado en el PDF: un estado por defecto con `@BeforeEach` y configuración específica por test cuando hace falta probar casos concretos

### ¿Por qué en algunos tests uso el `@BeforeEach` y en otros creo uno nuevo?
-“Porque el `@BeforeEach` me da un estado limpio por defecto (vida=100, ataque=20), pero algunos tests necesitan una vida inicial concreta (80, 20…) para probar casos específicos como **curar hasta el máximo exacto**. Así cada prueba es totalmente independiente y dinámica”

### Resumen del enfoque usado
- `@BeforeEach` + `@AfterEach` 
- En el test del constructor → se usa el player del `@BeforeEach`
- En todos los tests de `curar` y `recibirDaño` → se crea un `new Player(...)` con la vida inicial necesaria para ese caso concreto

