# Flights

[Expedia - Java Coding Exercise .docx.pdf](https://github.com/AndresJrd/Flights/files/12079891/Expedia.-.Java.Coding.Exercise.docx.pdf

curl --location 'http://localhost:8080/v1/flights'

curl --location 'http://localhost:8080/v1/flights/mocked'

Para el ejercicio del vuelo las oportunidades de mejora son las siguientes:
- Debería contar con circuit breaker para evitar consultar un recurso caído.
- Podría contar con algún mecanismo de resiliencia como reintentos en las consultas a recursos externos.
- Podría dotar de una caché con un TTL, si estamos dispuestos a contar con un delay en la actualización de la información sobre vuelos.
- No se manejan todos los errores posibles que pueden generarse en la aplicación.
- Podría agregar Swagger para disponibilizar información sobre la api.
- Dar mayor cobertura en los test.


# Water


<img width="1029" alt="Screenshot 2023-07-17 at 1 47 47 PM" src="https://github.com/AndresJrd/Flights/assets/41649546/f8b8490e-f1c8-4c68-8903-46ae0c4d61b5">

Solo plantear la solución.

Para el ejercicio del agua, utilizaría lo siguiente:

- Asumiendo que los datos de entrada x,y fueron validados (se encuentran dentro de los valores posibles de la dimensión de la dimensión de la isla).
- Haría uso de una estructura auxiliar (como un arreglo bidimensional de booleanos) para llevar registro de las coordenadas visitadas.
- Haciendo uso de la recursividad iría visitando en profundidad a los vecinos de las coordenadas dadas.
- En cada visita a un vecino se revisará:
    - Si la posición ya fue visitada (validando con la estructura de posiciones visitadas a fin de no recorrer infinitamente).
    - Si puede fluir ( validar si la altura de la posición actual es menor a la del vecino que se está visitando )
    - Si si se alcanzó la costa.
