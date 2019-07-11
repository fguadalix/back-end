Mejoras a implementar

- Añadir páginación a las consultas , será fundamental cuando se carguen los datos antiguos.
- Cambiar el http basic auth actual a jwt token.
- Actualmente, al hacer el get de un profesional se obtiene todo lo relacionado con un 
profesional(asignaciones, contactos y experiencias). Se hizo asi para tener toda la información agrupada en una sola llamada, 
y los recursos accesibles por hateoas por si el front desea consultarlos. 
Sin embargo, dado que el front siempre navega a esas entidades para traer daots se puede cambiar la relacion con contactos y 
work experience a one to many. El objetivo de este cambio sería
reducir las llamadas a las bases de datos, ya que el many to many genera updates y selects por debajo que acaban afectando al rendimiento.
- Realizar todos los test e2e modelando casos de negocio.
- La base de datos h2 solo deberia estar presente en modo test
- Añadir flyway para el control de versiones de la DB ( no ha funcionado por el sql server). El java 8
utiliza un cifrado no compatible con sql server, es necesario editar el fichero java security .
Una vez hecho esto, el flyway daba un error de cannot set ansi values, y tuve que dejarlo para tiempos mejores
El enlace al error sql con java es este : https://stackoverflow.com/questions/51433759/springboot-2-0-unable-to-access-sql-server-database
- Debido al problema anterior, recomiendo migrar a postgresql.
- Las búsquedas por palabras clave generan el índice en el filesystem, investigar como guardarlo en el heap para que sea más rápido.
- Considerar migración a ElasticSearch.
