Notas
 Ejecutar primero el test crearBaseDatosTest para poder crear la base de datos en H2
 La clase PersonaJDBC contiene la logica para las modificaciones a la base

Desventajas
 Utilizar jdbc implica el manejo de cada objeto y su tabla en la base de datos
  -Está acoplado a la base de datos debido que los cambios que se realizan pueden impactar causando errores

Conexiones
 se tienen que cerrar las conexiones a la bd ya que estas son finitas
 
Tipos de conexiones
 DriverManager
  -Funciona para aplicaciones estandar
 DataSource
  -Funciona para aplicaciones javaEE
 Pool de conexiones 
  -Funciona para aplicaciones estandar y javaEE
  -Conjunto de objetos con conexion a la base de datos.
   Ayuda a no estar creando muchas conexiones ya que es costoso

Tipos de sentencias
 Statement
  -Ejecutar cualquier tipo de sentencia SQL
  -tiene metodos como executeQuery para select, executeUpdate para dml y ddl, y execute que se utiliza para todo
 PreparedStatement
  -Se utiliza igual que Statement, pero las sentencias se guardan en cache
   Por si se quiere ejecutar una instruccion multiples veces conviene el preparedStatement
 CallableStatement
  -Se utiliza para ejecutar procedimientos almacenados
  