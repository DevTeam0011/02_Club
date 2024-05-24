# Documentación del proyecto

Aquí se encontrará todo lo relacionado al proyecto en cuanto a:
- [Información general](https://github.com/GGNahuel/Proyecto-001-egg/blob/main/DOCUMENTACION.md#informaci%C3%B3n-general)
- [Arquitectura](https://github.com/GGNahuel/Proyecto-001-egg/blob/main/DOCUMENTACION.md#arquitectura)
- [Contenido del mismo](https://github.com/GGNahuel/Proyecto-001-egg/blob/main/DOCUMENTACION.md#contenido-del-mismo)
- [Código](https://github.com/GGNahuel/Proyecto-001-egg/blob/main/DOCUMENTACION.md#c%C3%B3digo)
- ...
  
## Información general
El proyecto consta de un sitio web que permitirá tanto a un club de deportes administrar las membresías y pagos de sus socios, como a los usuarios el poder solicitar la inscripción a alguna de las actividades del club, o el uso de alguna de sus instalaciones según la membresía que tengan.

### Acerca del equipo de trabajo
El proyecto está conformado por ex-estudiantes de Egg Cooperation a modo de práctica de un proyecto web Full-Stack. Los principales desarrolladores son:
- [Ezequiel Movia](https://github.com/EzequielMovia)
- [Ignacio Flores](https://github.com/IgnacioF99)
- [Leandro Muro](https://github.com/LMuro96)
- [Nahuel Gómez Gahn](https://github.com/GGNahuel)

## Arquitectura
La estructura principal del proyecto será un monolito organizado en capas.
- Capa de interfaz de usuario
- Capa de controladores
- Capa de servicio
- Capa de datos

### Herramientas a utilizar *(especificar verciones)*
#### Backend
- Java
- Spring boot
- Base de datos MySql
#### Frontend
- JavaScript
- React.js

### Metodología
- Los datos que se transmitan entre el front end y el backend serán a traves de DTOs.
- 

## Contenido del mismo
### Entidades de la base de datos
Las tablas y sus relaciones estan especificadas en este diagrama:
*imagen*

En cuánto a las entidades en java se verían de la siguiente forma: 

#### Actividad:
Representa una actividad ofrecida por el club, como yoga, natación, tenis, etc. Atributos: 
- Long id
- String nombre
- String descripción
- Double costo
- boolean estado
- Entrenador (ManyToOne) entrenador_id

#### Socio:
Representa a una persona que es miembro del club. Atributos: 
- Long id
- String nombre,
- String apellido
- Integer documento
- LocalDate fecha de nacimiento
- String dirección
- String telefono
- boolean alta
- Actividad (ManyToMany) actividad
- Clase (ManyToMany) clase
- Membresia (ManyToOne) membresia

#### Entrenador:
Representa a un entrenador o instructor que imparte clases o actividades en club.
Atributos: 
- Long id
- String nombre 
- String apellido
- String especialidad
- boolean estado

#### Clase:
Representa una clase específica impartida por un entrenador, como "Clase de Yocon María".
Atributos: 
- Long id
- String nombre
- LocalTime horario
- Turno(enum) turno
- Entrenador(ManyToOne) entrenador_id

#### 🔄Membresía:
Representa una membresía o tipo de suscripción que un socio puede tener en el club.
Atributos: 
- id,
- tipo de membresía (mensual, anual, etc.),
- beneficios incluidos,
- costo, etc.

### Secciones y funcionalidades de la web
- Inicio  
- Club(Instalaciones)  
- Actividades
- Profesores 
- Registrate/Inciar

La pagina permitira que el socio pueda inciar secion o registrarse, inscribirse en actividades y poder solicitar la alta/baja de la membresia.

El socio podra ver listado de todas las activdades a las cuales este inscripto, con sus respectivo detalle.

El admin podra dar de baja/alta profesores o disciplinas y inhabilitar socios por falta de pago.

Brindar datos de contacto, redes sociales.

Galeria de instalaciones.

## Código
### Backend
#### src/main/.../Others
##### **metodosUtiles.java**
Dentro de esta clase irán métodos o propiedades que se pueden usar de forma global en distintas clases. Por ejemplo validaciones.
- *checkArraysHaveSameLength(array1, array2)*: Método privado de la clase que se usa para comprobar que los arrays que se ingresan tengan la misma longitud.
  
- *validateFieldsAreNotEmptyOrNull(String[] fieldNames, Object... fields)*: Método estático de acceso público que permite validar que los campos ingresados no sean nulos o estén vacíos (en caso de que sean de tipo string o list), caso contrario arrojaría una excepción.
  - String[] fieldNames: recibe un array con los ***nombres*** de los campos, que en caso de que se arroje la excepción será mostrado de la forma que se ingrese en el mensaje de esta. 
  
  - Object... fields: después de ingresar el array de strings se podrá poner tantos campos como sea necesario. Estos deben ser los ***valores*** de los campos. (el conjunto de *fields* que se ingresen será transformado en un array de tipo Object).
  - **Importante**: cuando se implementa este metodo, los valores que se quieran validar, *fields*, deben estar colocados en el mismo orden que se colocan en el *fieldNames*.
  - *Ejemplo de uso*:
    ```java
    /* suponiendo que antes se obtuvo de una forma x un objeto con las propiedades que se mencionan a continuación. 
    El objeto en este caso es "socio", y se quiere solo validar el id, nombre y su estado de membresía 
    (suponiendo que cuenta con esas propiedades) */
    metodosUtiles.validateFieldsAreNotEmptyOrNull(
      new String[]{"id", "nombre", "estado de membresía"}, // fieldNames
      socio.getId(), socio.getNombre(), socio.getEstadoMembresia() //fields
    )
    ```
    La excepción recibe un valor y su mensaje es `"El campo " + valor + " ingresado no puede ser nulo ni estar vacío."`, y suponiendo que en este ejemplo el estado de la membresía ingresado es `null` la excepción arrojará: `"El campo 'estado de la membresía' ingresado no puede ser nulo ni estar vacío."`