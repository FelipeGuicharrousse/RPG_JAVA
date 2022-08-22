
public abstract class NPC {
    private String nombre;

    //Los metodos Setter son para definir un atributo en un valor
    //Los metodos Getter son para devolver dicho atributo como retorno

    public void set_nombre(String nombre){
        this.nombre = nombre;
    }

    public String get_nombre(){
        return this.nombre;
    }

    // metodo abstracto para la interaccion de los NPC
    public abstract void interaccion(Jugador jugador);
}
