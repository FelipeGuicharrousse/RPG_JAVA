import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
    private String nombre;
    private int vida, xp, fuerza, inteligencia, energia, mana, posicion, ganar, vida_maxima, energia_maxima, mana_maximo;
    private List<Mision> lista_misiones;

    //Los metodos Setter son para definir un atributo en un valor
    //Los metodos Getter son para devolver dicho atributo como retorno


    // metodos abstracto de ataque, hechizo y subir experiencia
    public abstract int ataque();
    public abstract int hechizo();
    public abstract void subir_experiencia(int cantidad);
    
    // Inicializamos la lista de misiones
    public void iniciar_lista(){
        this.lista_misiones = new ArrayList<Mision>();
    }

    public void set_ganar(int ganar){
        this.ganar = ganar;
    }

    public void set_nombre(String nombre){
        this.nombre = nombre;
    }

    public void set_xp(int xp){
        this.xp = xp;
    }

    public void set_vida(int vida){
        this.vida = vida;
    }

    public void set_energia_maxima(int energia_maxima){
        this.energia_maxima = energia_maxima;
    }

    public void set_vida_maxima(int vida_maxima){
        this.vida_maxima = vida_maxima;
    }

    public void set_mana_maximo(int mana_maximo){
        this.mana_maximo = mana_maximo;
    }

    public void set_fuerza(int fuerza){
        this.fuerza = fuerza;
    }

    public void set_inteligencia(int inteligencia){
        this.inteligencia = inteligencia;
    }

    public void set_energia(int energia){
        this.energia = energia;
    }

    public void set_mana(int mana){
        this.mana = mana;
    }

    public void set_posicion(int posicion){
        this.posicion = posicion;
    }

    public int get_ganar(){
        return this.ganar;
    }

    public int get_vida_maxima(){
        return this.vida_maxima;
    }

    public int get_energia_maxima(){
        return this.energia_maxima;
    }

    public int get_mana_maximo(){
        return this.mana_maximo;
    }

    public int get_xp(){
        return this.xp;
    }

    public int get_vida(){
        return this.vida;
    }

    public int get_fuerza(){
        return this.fuerza;
    }

    public int get_inteligencia(){
        return this.inteligencia;
    }

    public int get_energia(){
        return this.energia;
    }

    public int get_mana(){
        return this.mana;
    }
    
    public String get_nombre(){
        return this.nombre;
    }

    public int get_posicion(){
        return this.posicion;
    }

    // Dependiendo de la cantidad de xp ingresada en la funcion esta retornara el nivel
    // en donde se debe encontrar
    public int calcular_nivel(int cantidad){
        if (cantidad <= 10) {
            return 1;
        }else if (cantidad <= 25){
            return 2;
        }else if (cantidad <= 50){
            return 3;
        }else if (cantidad <= 100){
            return 4;
        }else if (cantidad <= 200){
            return 5;
        }else if (cantidad <= 350){
            return 6;
        }else if (cantidad <= 600){
            return 7;
        }else{
            return 8;
        }
    }

    // Toma los parametros recibidos por el metodo y los crea en una clase Mision
    // luego mete este objeto en la lista_misiones
    public void add_list(char requisito, int valor, int cantidad, int recompensa){
        Mision mision = new Mision(requisito, valor, cantidad, recompensa);
        lista_misiones.add(mision);
    }

    // Esta funcion buscara todas las misiones de la lista, las cuales sean de matar 
    // a una cantidad de enemigos y la incrementara en 1
    public void incrementar_lista_matar(){
        for (int i = 0; i < this.lista_misiones.size(); i++) {
            if (this.lista_misiones.get(i).get_requisito() == 'm'){
                this.lista_misiones.get(i).incrementar();
            }
        }
    }

    // Cambio el valor de posicion de todas la misiones que sean de llegar de un 
    // punto a otro
    public void cambiar_lista_mover(){
        for (int i = 0; i < this.lista_misiones.size(); i++) {
            if (this.lista_misiones.get(i).get_requisito() == 'v'){
                this.lista_misiones.get(i).cambiar(this.posicion);
            }
        }
    }

    // Llama a la funcion verificar_requisito, esto es si la mision esta completada entonces
    // guardar la xp que esta debe entregar, hara esto con toda la lista, una vez terminado
    // retornara la xp acumuluda por la revision de misiones
    public int mision_ganada(){
        int experiencia_ganada = 0;
        for (int i = 0; i < this.lista_misiones.size(); i++) {
            if (this.lista_misiones.get(i).verificar_requisito()){
                experiencia_ganada += this.lista_misiones.get(i).get_recompensa();
                System.out.println();
                System.out.println("Felicidades completaste la mision");
                System.out.println("Ganaste: " + this.lista_misiones.get(i).get_recompensa() + " de XP");
                this.lista_misiones.remove(i);
                i--;
            }
        }
        return experiencia_ganada;
    }
}
