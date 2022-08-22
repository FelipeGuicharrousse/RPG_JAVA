public class Bueno extends NPC {
    private String atributo;
    private int cantidad;

    // Constructor de la clase
    public Bueno(String nombre, String atributo, int cantidad){
        set_nombre(nombre);
        this.atributo = atributo;
        this.cantidad = cantidad;
    }

    // La encargada de entregarle la bonificacion al jugador
    // Ocupa un switch para ver que atributo es el que tiene que aumentar y luego lo aumenta usando los getter y los setter
    public void interaccion(Jugador jugador){
        System.out.println(get_nombre() + ": Creo que necesitas un poco de ayuda te subire " + this.cantidad + " a tu " + this.atributo + "!!!!");
        switch (this.atributo) {
            case "vida":
                jugador.set_vida(jugador.get_vida() + cantidad);
                if (jugador.get_vida() > jugador.get_vida_maxima()) {
                    jugador.set_vida(jugador.get_vida_maxima());
                }
                break;
            case "xp":
                jugador.subir_experiencia(cantidad);
                break;
            case "energía":
            case "energia":
                jugador.set_energia(jugador.get_energia() + cantidad);
                if (jugador.get_energia() > jugador.get_energia_maxima()) {
                    jugador.set_energia(jugador.get_energia_maxima());
                }
                break;
            case "maná":
            case "mana":
                jugador.set_mana(jugador.get_mana() + cantidad);
                if (jugador.get_mana() > jugador.get_mana_maximo()) {
                    jugador.set_mana(jugador.get_mana_maximo());
                }
                break;
        }
    }
}
