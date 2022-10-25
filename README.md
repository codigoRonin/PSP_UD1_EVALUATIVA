# Actividad Evaluable

Se desea crear una aplicación capaz de ejecutar procesos en segundo plano, cuya funcionalidad debe ser la siguiente.

1. **CONVERTIR A ROMANO** → Crear un programa (proceso) que a través de los argumentos del método main, reciba un entero y muestre dicho entero convertido a número romano a través de la salida estándar. 

    Dicho argumento debera de ser un número entero comprendido entre 1 y el 3999, debe finalizar con valor -1 y, a través de la salida de error estándar, mostrar el mensaje “Solo convertimos a romano números del 1 al 3999.”
    
    Iniciaremos un proceso que inicie el anterior, a través de su propia entrada estándar recoja el entero proporcionado por el usuario. Muestra por pantalla el resultado comprobando tanto el caso correcto como el incorrecto.

    [**Normas para escribir un número romano**](http://recursostic.educacion.es/descartes/web/materiales_didacticos/romanos/normas.htm#:~:text=Se%20colocan%20a%20la%20izquierda,vez%2C%20no%20se%20pueden%20repetir).

   
2.	**CREAR FICHA DE USUARIO** → Debemos almacenar el nombre, apellidos y año de nacimiento del usuario con el siguiente formato:

            ---------------
            |   NEW USER  |
            ---------------

            Name: Pepito
            Surname: Pepitez
            Birth date: 1458
         
            -----------------         

Para ello:
    
-	Crear un programa (proceso) en el que pediremos la información al usuario a través de la entrada estándar.En caso de que alguno de los datos venga sin informar o de que el año de nacimiento no tenga un formato correcto (No sea un número entero), el proceso debe terminar con valor -1 y devolver el mensaje “La información proporcionada no es correcta”. Finalmente dará formato a la información y la devolverá a través de su salida estándar.

-	Iniciaremos un proceso que inicie el anterior, a través de su propia entrada estándar recoja los datos por parte del usuario. Donde haremos que la salida de este proceso se almacene en un fichero de texto con el nombre: nombreUsuario_ApellidoUsuario.txt. Y la salida de error, en caso de producirse, deberá almacenarse en un fichero llamado: [ERROR]nombreUsuario_ApellidoUsuario.txt. Comprobaremos tanto el caso correcto como el incorrecto 

3.	**COMPROBAR CALIFICACIONES** → Crear un programa (proceso) que a través de los argumentos del método main, reciba tantas calificaciones como sean necesarias y muestre si se ha aprobado todo,alguna o ninguna a través de la salida estándar. En caso de recibir cualquier argumento que no sea un número entero, debe finalizar con valor -1 y, a través de la salida de error estándar, mostrar el mensaje “Todos los operadores deben ser números enteros.”

    Iniciaremos un proceso que inicie el anterior, a través de su propia entrada estándar recoja tantas calificaciones como el usuario desee hasta que el usuario introduzca un "*". Muestra por pantalla el resultado comprobando todas las posibilidades asi como como un caso incorrecto incorrecto (Introduciendo un valor no númerico).

4.	**HACER PING** → Crear un programa (proceso) que a través de los argumentos del método main, reciba una dirección para hacer ping. En caso de no recibir parámetro o que no exista mostrar el mensaje "Se require de una dirección para hacer ping." En caso de que el párametro sea correcto que dicho progtrama invoque alcomando ping con dicha drección y muestre su salida.

Iniciaremos un proceso que inicie el anterior,solicitando al usuario una dirección y un número entero. Debemos iniciar tantos PING como valor tenga el número entero introducido y, en todos ellos, mostrar resultado. En caso de que el usuario no introduzca su nombre o de que el segundo valor no sea un número entero, debemos informar del error a través de la salida de error estándar.

---
**LA ESTRUCTURA DEL PROYECTO** → tendrá un único proceso padre que será el encargado de interactuar con el usuario y de iniciar los diferentes procesos hijos.

Para ello, en Main.java crearemos un menú con la siguiente estructura:

    AFIANZANDO PROCESOS [Evaluable]
    -------------------------------
    1. Convertir a números romanos
    2. Crear fichero de usuario
    3. Comprobar calificaciones
    4. Hacer Ping
    5. Salir

    Seleccione una opción (1-5):

La aplicación estará en ejecución mientras que el usuario no escoja la opción salir.


## Criterios de calificación.

1. Cada apartado de este ejercicio cuya funcionalidad haya sido implementada correctamente tiene una puntuación de 2.25 puntos.

2.	La correcta creación del menú tiene una puntuación de 1 punto.

3.	Los siguientes fallos reducen la puntuación de cada uno de los apartados:

    -	Resource leak: menos 0.5 por cada error.
    -	Unhandled Exception: menos 0.5 por cada error.

        -	Las excepciones deben capturarse lo más cerca posible al lugar en el que se produzcan y deben controlarse de forma específica, es decir, debemos evitar el uso de la clase padre Exception.

4. Cualquier apartado no funcional, es decir, que no cumpla con lo solicitado, podrá optar, tan solo al 20% del total de su calificación.

5. Se penalizará el no optimizar los algotitmos de cada apartado con una reducción de 0.5 puntos.

6. Se penalizará con una reducción de 0.5 puntos en cada apartado si no se utilizan prácticas de código limpio.

## Nota

Para todos los casos en los que aplique: Usaremos la salida estándar para mostrar aquellos mensajes correspondientes a una ejecución correcta, mientras que usaremos la salida de error para aquellos mensajes correspondientes a una finalización anormal.
