import java.util.Scanner;

public class Neutro extends NPC{
    private char requisito;
    private int valor, recompensa, ya_dio_mision;

    // Constructor de la clase
    public Neutro(String nombre, char requisito, int valor, int recompensa){
        set_nombre(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = 0;
    }

    // Nos pregunta si es que queremos completar una mision, nosotros podemos aceptarla o rechazarla
    public void interaccion(Jugador jugador){
        // Mostramos esto siempre y cuando no hayan tomado la mision de antemano
        if(this.ya_dio_mision == 0){
            if (this.requisito == 'v') {
                System.out.println(get_nombre() + ": hola, ¿quieres cumplir esta mision? Deberas llegar a " + this.valor + " del mundo y recibirás " + this.recompensa + " de xp");
            } else {
                System.out.println(get_nombre() + ": hola, ¿quieres cumplir esta mision? Deberas matar " + this.valor + " de Monstruos y recibirás " + this.recompensa + " de xp");
            }
            System.out.println ("Por favor acepte o rechaze la mision");
            System.out.println ("   1. Aceptar");
            System.out.println ("   2. Rechazar");
            Scanner entradaEscaner = new Scanner(System.in); 
            int respuesta = entradaEscaner.nextInt();
            entradaEscaner.nextLine();
            // Agregamos las misiones correspondiente a la lista de misiones del jugador
            if (respuesta == 1) {
                if (this.requisito == 'v'){
                    jugador.add_list(this.requisito, this.valor, jugador.get_posicion(), recompensa);
                } else {
                    jugador.add_list(this.requisito, this.valor, 0, recompensa);
                }
                this.ya_dio_mision++;
                System.out.println("Mision entregada con exito");
            }else{
                // Mensaje si no acepta la mision
                System.out.println(get_nombre() + ": Vuelve si cambias de opinion!!!.");
            }

        }else{
            // Mensaje si ya le dimos la mision
            System.out.println(get_nombre() + ": ya te di mision, jaja saludos.");
        }
        

    }
}
