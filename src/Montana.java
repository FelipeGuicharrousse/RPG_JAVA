
public class Montana extends Tierra{
    
    public Montana(float probabilidad_enemigo){
        set_probabilidad_enemigo(probabilidad_enemigo);
    }

    // Metodo accion ve si el jugador puede llegar a esta casilla, si puede llegar llamara al metodo acciones ubcado en jugador
    public boolean accion(Jugador jugador){
        if (jugador.get_energia() <= 0) {
            return false;
        }
        if (jugador.get_energia() < 3){
            int restar_vida = 3 - jugador.get_energia();
            jugador.set_energia(0);
            jugador.set_vida(jugador.get_vida() - restar_vida);
            if (jugador.get_vida() <= 0){
                return false;
            }
        } else {
            jugador.set_energia(jugador.get_energia() - 3);
        }
        return acciones(jugador);
    }

}
