# Documentación del proyecto

Aquí se encontrará todo lo relacionado al proyecto en cuanto a:
- Información general
- Arquitectura
- Contenido del mismo
- Código
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

En cuánto a las entidades en java se verían de la siguiente forma: ***ajustar***

#### Actividad:
Representa una actividad ofrecida por el club, como yoga, natación, tenis, etc. Atributos: 
- long id
- string nombre
- string descripción
- horario
- duración
- costo
- capacidad máxima

#### Socio:
Representa a una persona que es miembro del club. Atributos: 
- id,
- nombre, 
- apellido,
- documento,
- fecha de nacimiento, 
- dirección, 
- número de contacto,
- estado (alta/baja) Boolean
- Membresia membresia
- (Relacion many to many)
- Actividad actividad
- correo electrónico, etc.

#### Entrenador:
Representa a un entrenador o instructor que imparte clases o actividades en club.
Atributos: 
- id,
- nombre, 
- apellido, 
- especialidad, 
- horario de disponibilidad, etc.

#### Reserva:
Representa la reserva de una actividad realizada por un socio.
Atributos: 
- id,
- socio (referencia al socio que hizo la reserva), 
- actividad (referencia a la actividad reservada), 
- fecha y hora de la reserva, 
- estado (confirmada, pendiente, cancelada), etc.

#### Clase:
Representa una clase específica impartida por un entrenador, como "Clase de Yocon María".
Atributos: 
- id,
- nombre de la clase, 
- descripción, 
- horario, 
- duración, 
- entrenador (referencia al entrenador que la imparte), etc.

#### Instalación:
Representa una instalación o espacio dentro del club, como una piscina, una cancde tenis, un gimnasio, etc.
Atributos: 
- id
- nombre, 
- descripción,
- -img

#### Membresía:
Representa una membresía o tipo de suscripción que un socio puede tener en el club.
Atributos: 
- id,
- tipo de membresía (mensual, anual, etc.),
- beneficios incluidos,
- costo, etc.

### Secciones y funcionalidades de la web
Inicio  club(Intalaciones)  Disciplinas  Profesores Registrate/Inciar

La pagina permitira que el socio pueda inciar secion o registrarse, inscribirse en actividades y poder solicitar la alta/baja de la membresia.

El socio podra ver listado de todas las activdades a las cuales este inscripto, con sus respectivo de talle.

El admin podra dar de baja/alta profesores o disciplinas y inhabilitar socios por falta de pago.

Brindar datos de contacto, redes sociales.

Galeria de instalaciones.

## Código
