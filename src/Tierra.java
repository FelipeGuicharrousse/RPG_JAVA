
import java.util.Random;

public abstract class Tierra {
    private int posicion_tierra;
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    //Los metodos Setter son para definir un atributo en un valor
    //Los metodos Getter son para devolver dicho atributo como retorno

    // Metodo abstracto de la accion de una casilla
    public abstract boolean accion(Jugador jugador);
    
    public void set_posicion_tierra(int posicion_tierra){
        this.posicion_tierra = posicion_tierra;
    }

    public void set_probabilidad_enemigo(float probabilidad_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
    }

    public void set_monstruo(int vida_monstruo, int dano_monstruo){
        this.monstruo = new Monstruo(vida_monstruo, dano_monstruo);
    }

    public void set_jefe_final(int dano_base, int vida, String nombre){
        this.jefe_final = new Jefe_Final(dano_base, vida, nombre);
    }

    // Tenemos una funcion para cada tipo de NPC.
    public void set_npc_bueno(String nombre, String atributo, int cantidad){
        this.npc = new Bueno(nombre, atributo, cantidad);
    }

    public void set_npc_malo(String nombre, int cantidad_energia, int cantidad_mana){
        this.npc = new Malo(nombre, cantidad_energia, cantidad_mana);
    }

    public void set_npc_neutro(String nombre, char requisito, int valor, int recompensa){
        this.npc = new Neutro(nombre, requisito, valor, recompensa);
    }


    public float get_probabilidad_enemigo(){
        return this.probabilidad_enemigo;
    }

    public Monstruo get_monstruo(){
        return this.monstruo;
    }

    public Jefe_Final get_jefe_final(){
        return this.jefe_final;
    }

    public NPC get_npc(){
        return this.npc;
    }

    public int get_posicion_tierra(){
        return this.posicion_tierra;
    }


    // Primero mira si hay alguna mision que su meta hubiera sido la casilla en la que esta
    // parado ahora, y luego veera si de esas misiones alguna se completo.
    public boolean acciones(Jugador jugador){
        jugador.set_posicion(posicion_tierra);
        jugador.cambiar_lista_mover();
        int experiencia_ganada = jugador.mision_ganada();
        if (experiencia_ganada > 0){
            jugador.subir_experiencia(experiencia_ganada);
        }
        // Si existe algun NPC interactuar con el
        if (this.npc != null){
            npc.interaccion(jugador);
        }

        // Lanzaremos un numero aleatorio si este es menor que la probabilidad entonces
        // hacer que aparezca el enimigo correspondiente
        Random numero_aleatorio = new Random();
        float aleatorio = numero_aleatorio.nextFloat();
        int indicador = 0;
        if (aleatorio <= this.probabilidad_enemigo) {
            if (this.monstruo != null) {
                this.monstruo.combate(jugador);
            }else{
                this.jefe_final.combate(jugador); //OJITOOOO
                indicador = 1;
            }
        }
        // Si el jugador sigue con vida y combatio con el jefe final, indicar que ya gano el juego
        if (jugador.get_vida() > 0) {
            if (indicador == 1){
                jugador.set_ganar(1);
            }
            // retornar true si sigue con vida
            return true;
        }else{
            // retornar false si se murio
            return false;
        }
    }

}
