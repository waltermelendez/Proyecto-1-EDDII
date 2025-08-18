                         Analisis del enunciado del proyecto


Partes del proyecto fundamental:

1. Almacenar los pacientes en un arbol B+, por medio del ID como clave. LISTO

2. Hacer un moticulo en donde se aguardara su prioridad, este debe de ser un "Heap maximo". Posible solucion, hacer el heap de tipo obejto que contenga tanto el ID como la edad del paciente LISTO

3. El programa recibe archivos de entrada y salida, el tipo de formato es ".txt" 

4.Hacer una tabla hash que sea genérica, con su función hash y que se pueda buscar el objeto. LISTO.


   # Cosas para agregar:

1. Cada sección será procesada de inmediato al ser leída.

2. Buscar si ya existe un paciente por medio de su ID, luego mostrar un mensaje de error 

3. Si el paciente indica su ID, se busca directamente en el árbol B+.

4. Si indica solo su primer nombre y apellido, buscar en la tabla hash.

5. si no se encuentra el paciente, mostrar un mensaje.

6. Después de encontrar al paciente, se agrega al montículo y se atenderá al de mayor prioridad

7. La salida se debe de preguntar si el usuario quiere procesar otro archivo o salir, si desa salir, se guarda toda la información del árbol B+ en un archivo fácil de leer. Al iniciar el programa se debe de cargar directamente en memoria.

8. El archivo debe de guardar tanto el arbol como la tabla, su grado del arbol.

9. Dos opciones del menu, iniciar nuevo arbol o cargar arbol

10. Hacer una funcion para importar y exportar el arbol asi como de exportar la tabla hash.

    #Requisitos técnicos:

 El árbol B+ debe implementarse desde cero y debe ser de grado configurable (queda
a discreción del estudiante cómo se configura).
- La tabla hash debe manejar colisiones.
- El montículo debe ser un heap máximo y debe permitir inserción dinámica.
- Todas las estructuras deben estar sincronizadas al insertar o eliminar pacientes.
- El sistema debe ser modular, limpio, ejecutable por consola y entregar un
ejecutable.
- El sistema debe manejar múltiples ejecuciones: cargar estructuras, procesar archivo, mostrar resultados, guardar estado.



#Cosas faltantes:

*Función para exportar la tabla como el arbol b+.

*Terminar la función de atender, que es la agregar en la tabla y la de eliminar en la tabla.

*Hacer una función para buscar por id ne el arbol. 

*Volver genérica la tabla hash.

*Juntar todo.
