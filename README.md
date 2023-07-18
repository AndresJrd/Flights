# Flights

[Expedia - Java Coding Exercise .docx.pdf](https://github.com/AndresJrd/Flights/files/12079891/Expedia.-.Java.Coding.Exercise.docx.pdf

curl --location 'http://localhost:8080/v1/flights'

curl --location 'http://localhost:8080/v1/flights/mocked'

curl --location 'http://localhost:8080/v1/flights/mocked?airline=United%20Airlines'

curl --location 'http://localhost:8080/v1/flights/mocked?airline=United%20Airlines&departureDateTime=2019-10-15T20%3A00%3A00.000Z'

Para el ejercicio del vuelo las oportunidades de mejora son las siguientes:
- Debería contar con circuit breaker para evitar consultar un recurso caído.
- Podría contar con algún mecanismo de resiliencia como reintentos en las consultas a recursos externos.
- Podría dotar de una caché con un TTL, si estamos dispuestos a contar con un delay en la actualización de la información sobre vuelos.
- No se manejan todos los errores posibles que pueden generarse en la aplicación.
- Podría agregar Swagger para disponibilizar información sobre la api.
- Dar mayor cobertura en los test.
- El uso del filtro por hora deberia permitir buscar entre rangos.

<img width="750" alt="Captura de Pantalla 2023-07-18 a la(s) 11 03 29" src="https://github.com/AndresJrd/Flights/assets/41649546/426b5e51-e9ff-40d4-b57c-ff027bd85297">
<img width="761" alt="Captura de Pantalla 2023-07-18 a la(s) 11 03 38" src="https://github.com/AndresJrd/Flights/assets/41649546/affce359-4ed2-4fdd-bfb1-bf407f0c7431">






# Water
![Captura de Pantalla 2023-07-18 a la(s) 08 36 36](https://github.com/AndresJrd/Flights/assets/41649546/dd23e577-56f6-45b9-b827-5e8ebd34f043)





Solo plantear la solución.

Para el ejercicio del agua, utilizaría lo siguiente:

- Asumiendo que los datos de entrada x,y fueron validados (se encuentran dentro de los valores posibles de la dimensión de la dimensión de la isla).
- Haría uso de una estructura auxiliar (como un arreglo bidimensional de booleanos) para llevar registro de las coordenadas visitadas.
- Haciendo uso de la recursividad iría visitando en profundidad a los vecinos de las coordenadas dadas.
- En cada visita a un vecino se revisará:
    - Si la posición ya fue visitada (validando con la estructura de posiciones visitadas a fin de no recorrer infinitamente).
    - Si puede fluir ( validar si la altura de la posición actual es menor a la del vecino que se está visitando )
    - Si si se alcanzó la costa.
