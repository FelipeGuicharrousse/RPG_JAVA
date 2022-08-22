
public class Malo extends NPC{
    private int cantidad_energia, cantidad_mana;

    // Contructor de un npc malo
    public Malo(String nombre, int cantidad_energia, int cantidad_mana){
        set_nombre(nombre);
        this.cantidad_energia = cantidad_energia;
        this.cantidad_mana = cantidad_mana;
    }

    // Aleatoriamente vera si el "dado" lanzado es menor que 6, si es asi, entonces 
    // disminuira la energia y el mana, estos dos se lanzan dados separados
    public void interaccion(Jugador jugador){
        System.out.println(get_nombre() + ": SOY MALO TE VOY A DISMINUIR TU ENERGIA y MANA EN " + this.cantidad_energia + " y " + this.cantidad_mana);
        int numero_aleatorio = (int)(Math.random()*10+1);
        if (numero_aleatorio <= 6) {
            jugador.set_energia(jugador.get_energia() - cantidad_energia);
            if (jugador.get_energia() < 0) {
                jugador.set_energia(0);
            }
        }
        numero_aleatorio = (int)(Math.random()*10+1);
        if (numero_aleatorio <= 6) {
            jugador.set_mana(jugador.get_mana() - cantidad_mana);
            if (jugador.get_mana() < 0) {
                jugador.set_mana(0);
            }
        }
    }
    
}
