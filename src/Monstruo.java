
import java.util.Scanner;

public class Monstruo implements Enemigo{
    private int vida, dano;

    // Constructor de la clase
    public Monstruo(int vida, int dano){
        this.vida = vida;
        this.dano = dano;
    }

    // Comienza avisandonos que nos encontramos con un monstruo
    // Luego hara un ciclo hasta que el jugador se quede sin vida, pero a la mitad del
    // ciclo se preguntara si el monstruo se quedo sin vida, si este es el caso se termina el ciclo 
    public void combate(Jugador jugador){
        System.out.println();
        System.out.println("TE ENCONTRASTE CON UN MONSTRUO");
        System.out.println("Su vida es de: " + this.vida);
        System.out.println("Su dano es de: " + this.dano);

        //Nos 
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
                if (this.vida < 0) {
                    this.vida = 0;
                }
                System.out.println("La vida del Monstruo es de: " + this.vida);
            } else {
                int dano_jugador = jugador.hechizo();
                this.vida -= dano_jugador;
                System.out.println(jugador.get_nombre() + " hizo un daño de: " + dano_jugador);
                if (this.vida < 0) {
                    this.vida = 0;
                }
                System.out.println("La vida del Monstruo es de: " + this.vida);
            }

            // Preguntaremos si el enemigo tiene vida, si tiene vida seguiremos el combate
            if(this.vida <= 0){
                break;
            }
            // Le haremos dano al jugador y mostraremos la info por pantalla
            jugador.set_vida(jugador.get_vida() - this.dano);
            System.out.println("¡Oh no! El Monstruo le hizo un daño de " + this.dano + " a " + jugador.get_nombre());
            System.out.println("La vida de " + jugador.get_nombre() + " es de: " + jugador.get_vida());
        }
        if (jugador.get_vida() < 0) {
            jugador.set_vida(0);
        }
        if (this.vida <= 0){
            // Si logramos matarlo incrementaremos las misiones en las cuales hay que matar monstruos
            jugador.incrementar_lista_matar();
            int experiencia_ganada = jugador.mision_ganada();
            if (experiencia_ganada > 0){
                // Calculamos la experiencia se la subimos a nuestro jugador.
                jugador.subir_experiencia(experiencia_ganada);
            }
            System.out.println("¡Felicidades! derrotaste al Monstruo");
        }
    }

}
