# Trabajo Practico - Tierra Media

## Integrantes del grupo:

- Sebastián Cardozo
- Lucas Rojas
- Upenieks Bracco Teo
- Tomás Miranda

## Decisiones de diseño

En primera instacia creamos una clase principal que funciona como nexo entre las subclases y ejecuta los metodos correspondientes para el correcto flujo del programa. 
Dicha clase obtiene los datos de las atracciones, usuarios y promociones por medio de la lectura de archivos de texto plano que se encuentran alojados en la carpeta Archivo.
Con estos datos, se genera un itinerario para cada usuario a partir de la muestra por consola del listado de atracciones disponibles para dicho usuario contemplando la cantidad de monedas que posee y el tiempo disponible. En el momento en que ya no se encuentran atracciones y/o promociones para ofrecer, se procede con el siguiente usuario en la lista hasta que ya no quede usuario para registrar.
Una vez cargados los datos de atracciones y/o promociones para todos los usuarios se muestra por consola los itinerarios de cada uno.

## Listado de archivos

- archivos
  - atracciones
  - itinerario
  - usuarios
- componentes
  - Atraccion
  - Promocion
  - TipoDeAtracciones
  - Usuario
- excepciones
  - AtraccionYaOfrecidaException
  - MeQuedeSinPlataException
  - MeQuedeSinTiempoException
  - YaNoHayAtraccionesParaOfrecerException
- principal
  - Principal
  - Menu
- promociones
  - Absoluta
  - AxB
  - Porcentual
- pruebas
  - UsuarioTest
  - AtraccionesTest
  - PromocionTest
  - PorcentualTest
  - AxBTest
  - VisualizadorTest
- utilidades
  - Archivo
  - Visualizador
  - GeneradorDeListas

### Componentes
#### Absoluta

Se presenta la logica para aplicar la promocion de tipo Absoluta la cual descuenta el valor del paquete en su totalidad.

#### Atraccion

Se presenta la logica para aplicar el tipo Atracciones a objetos. Contiene la informacion requerida para realizar las operaciones pertinentes a las atracciones.


