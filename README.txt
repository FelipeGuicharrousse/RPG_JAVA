Nombre: Felipe Guicharrousse Rojas
Rol: 202073555-7


PARA COMPILAR:
    Usando Ubuntu (En mi caso use Windows, con WSL en VisualStudio Code) ingresar en esta carpeta el comando
        $ make
    Luego de haber compilado el programa usar el comando 
        $ make run
    Luego de este comando el programa comenzara a correr automaticamente
    Un comando que tambien puede servir es que si se quiere limpiar los archivos creados por el make o se 
    quiere eliminar el ejecutable se puede usar
        $ make clean


EN LA EJECUCION:
    El Juego nos recibira dandonos la bienvenida, en el primer input que nos piden es el tamano del mundo
    el cual puede ser el que nosotros queramos. Debe ser un numero
    Luego nos pediran mas input cuando tienen esta presentacion:
        1. ...
        2. ...
        3. ...
    Significa que el programa nos esta pidiendo que ingresemos uno de estos numero en la consola elegir una 
    de las opciones validas para continuar con el programa
    Del mismo modo cuando exista este tipo de eleccion:
        a) ...
        b) ...
    El programa nos pide que ingresemos una de esas letras.
    Cuando nos pida la probabilidad de que un enemigo aparezca ingresar numero del 0,0 al 1,0
    Para el ingreso de datos hacerlos todos con enteros, excepto si me piden ingresar nombres, ya que esos 
    son con enteros.
    El juego termina cuando se mata al jefe final.


EN EL CODIGO:
    Cree algunos atributos nuevos en Jugador 
        posicion: Guarda la posicion actual del jugador
        ganar: Inicializada en 0, significa que el jugador no ha ganado. 1 si gana el juego
        vida_maxima: La vida maxima correspondiente al nivel
        energia_maxima: La energia maxima correspondiente al nivel
        mana_maximo: El mana maximo correspondiente al nivel
    En la clase Tierra solo se creo este atributos
        posicion_tierra: La posicion de esa casiila en el mundo

