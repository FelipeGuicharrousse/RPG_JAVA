public class Bosque extends Tierra{

    // Constructor de bosque; inicializa con la probabilidad del enemigo
    public Bosque(float probabilidad_enemigo){
        set_probabilidad_enemigo(probabilidad_enemigo);
    }

    // Metodo accion ve si el jugador puede llegar a esta casilla, si puede llegar llamara al metodo acciones ubcado en jugador
    public boolean accion(Jugador jugador){
        if (jugador.get_mana() <= 0) {
            return false;
        }
        if (jugador.get_mana() < 3){
            int restar_vida = 3 - jugador.get_mana();
            jugador.set_mana(0);
            jugador.set_vida(jugador.get_vida() - restar_vida);
            if (jugador.get_vida() <= 0){
                return false;
            }
        } else {
            jugador.set_mana(jugador.get_mana() - 3);
        }
        return acciones(jugador);
    }
}
