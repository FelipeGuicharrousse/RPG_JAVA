
public class Planicie extends Tierra{

    public Planicie(float probabilidad_enemigo){
        set_probabilidad_enemigo(probabilidad_enemigo);
    }

    // Metodo accion deberia ver si el jugador puede llegar a esta casilla pero como siempre
    // llega llama automaticamente a la funcion acciones
    public boolean accion(Jugador jugador){
        return acciones(jugador);
    }
}
