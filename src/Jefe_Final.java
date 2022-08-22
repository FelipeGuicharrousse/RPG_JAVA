import java.util.Scanner;

public class Jefe_Final implements Enemigo {
    private int dano_base, vida;
    private String nombre;
    
    // Constructor de la clase, inicializa todas los atributos
    public Jefe_Final(int dano_base, int vida, String nombre){
        this.dano_base = dano_base;
        this.vida = vida;
        this.nombre = nombre;
    }


    // Comienza dandonos una bienvenida
    // Luego hara un ciclo hasta que el jugador se quede sin vida, pero a la mitad del
    // ciclo se preguntara si el monstruo se quedo sin vida, si este es el caso se termina el ciclo 
    public void combate(Jugador jugador){
        System.out.println();
        System.out.println(this.nombre + ":¡Soy el Jefe Final! Mi nombre es " + this.nombre + "¡Y sera el ultimo nombre que escuches!");
        int vida_base = this.vida;

        while(jugador.get_vida() > 0){
            // Informamos el estado del jugador
            System.out.println();
            System.out.println("Tu vida es de: " + jugador.get_vida());
            System.out.println("Tu energia es de: " + jugador.get_energia());
            System.out.println("Tu mana es de: " + jugador.get_mana());
            System.out.println();
            //Preguntamos el metodo de combate
            System.out.println("Elige tu forma de combate");
            System.out.println("    1. Ataque");
            System.out.println("    2. Hechizo");
            
            Scanner entrada = new Scanner(System.in);
            int forma_combate = entrada.nextInt();
            entrada.nextLine();

            // Evaluemos el dano hecho por cada combate dependiendo del caso, y mostraremos 
            // la cantidad de dano provocado al monstruo y la vida del monstruo, si su vida
            // es menor que 0 entonces la dejaremos en 0
            if (forma_combate == 1) {
                int dano_jugador = jugador.ataque();
                this.vida -= dano_jugador;
                System.out.println(jugador.get_nombre() + " hizo un daño de: " + dano_jugador);
                if (this.vida < 0){
                    this.vida = 0;
                }
                System.out.println("La vida de " + this.nombre +" es de: " + this.vida);
            } else {
                int dano_jugador = jugador.hechizo();
                this.vida -= dano_jugador;
                System.out.println(jugador.get_nombre() + " hizo un daño de: " + dano_jugador);
                if (this.vida < 0){
                    this.vida = 0;
                }
                System.out.println("La vida de " + this.nombre +" es de: " + this.vida);
            }

            // Preguntaremos si el enemigo tiene vida, si tiene vida seguiremos el combate
            if(this.vida <= 0){
                break;
            }
            // Calcularemos el dano que hara el jefe final y mostraremos la info por pantalla
            int dano;
            int fase = 1;
            if (this.vida > vida_base/2) {
                fase = 2;
            }
            dano = this.dano_base + (2*fase);
            jugador.set_vida(jugador.get_vida() - dano);
            if (jugador.get_vida() < 0) {
                jugador.set_vida(0);
            }
            System.out.println("¡Oh no!" + this.nombre + " le hizo un daño de " + dano + " a " + jugador.get_nombre());
            System.out.println("La vida de " + jugador.get_nombre() + " es de: " + jugador.get_vida());
            
        }
        // Si Ganamos el combate mostrar el mensaje final
        if (this.vida <= 0){
            System.out.println(this.nombre + ": Me derrotaste eso es imposible, estoy muriendo!!");
            System.out.println("¡FELICIDADES! GANASTE EL JUEGO");
        }
    }
}
