public class Druida extends Jugador{
    // Constructor de la clase
    public Druida(String nombre){
        set_nombre(nombre);
        set_vida(15);
        set_fuerza(5);
        set_inteligencia(5);
        set_energia(5);
        set_mana(5);
        iniciar_lista();
        set_ganar(0);
    }

    // Primero veera si el jugador tiene energia mayor que 0, si es asi entonces calculara el dano
    // que debe causar, si el energia es menor que 0 entonces llama al setter para dejarla en 0
    public int ataque(){
        if (get_energia() == 0) {
            return 0;
        }
        int dano = ((get_fuerza() + get_inteligencia())/3) * Math.max(get_energia()/3, get_mana()/2);
        set_energia(get_energia() - 3);
        if (get_energia() <= 0){
            set_energia(0);
        }
        return dano;
    }

    // Primero veera si el jugador tiene mana mayor que 0, si es asi entonces calculara el dano
    // que debe causar, si el mana es menor que 0 entonces llama al setter para dejarla en 0
    public int hechizo(){
        if (get_mana() == 0) {
            return 0;
        }
        int dano = ((get_fuerza() + get_inteligencia())/3) * Math.max(get_energia()/2, get_mana()/3);
        set_mana(get_mana() - 3);
        if (get_mana() <= 0) {
            set_mana(0);
        }
        return dano;
    }

    // Calcula el nivel sin el aumento y luego el nivel con el aumento de xp
    // si los niveles son diferentes significa que aumento de nivel
    // por lo cual entrara a un ciclo hasta que llegue al nivel que le corresponde por
    // la experiencia. Antes de subir los atributos, dejara todos estos con sus valores
    // maximos correspondientes al nivel.
    public void subir_experiencia(int cantidad){
        int nivel_actual = calcular_nivel(get_xp());
        set_xp(get_xp() + cantidad);
        int nivel_a_llegar = calcular_nivel(get_xp());
        
        if (nivel_a_llegar != nivel_actual) {
            set_vida(get_vida_maxima());
            set_energia(get_energia_maxima());
            set_mana(get_mana_maximo());
            while (nivel_actual < nivel_a_llegar) {
                nivel_actual++;
                System.out.println("Subiste del nivel " + (nivel_actual-1) + " al " + nivel_actual);
                set_vida(get_vida() + nivel_actual);
                set_fuerza(get_fuerza() + nivel_actual);
                set_inteligencia(get_inteligencia() + nivel_actual);
                set_energia(get_energia() + nivel_actual);
                set_mana(get_mana() + nivel_actual);
                set_energia_maxima(get_energia());
                set_vida_maxima(get_vida());
                set_mana_maximo(get_mana());
                System.out.println("Tu vida ahora es de: " + get_vida());
                System.out.println("Tu fuerza ahora es de: " + get_fuerza());
                System.out.println("Tu inteligencia ahora es de: " + get_inteligencia());
                System.out.println("Tu energia ahora es de: " + get_energia());
                System.out.println("Tu mana ahora es de: " + get_mana());
                System.out.println();
            }
        }
        
    }
}
