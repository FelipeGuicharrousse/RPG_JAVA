
public class Mision {
    char requisito;
    int valor;
    int cantidad;
    int recompensa;

    //Los metodos Setter son para definir un atributo en un valor
    //Los metodos Getter son para devolver dicho atributo como retorno


    // Constructor de la mision
    public Mision(char requisito, int valor, int cantidad, int recompensa){
        this.requisito = requisito;
        this.valor = valor;
        this.cantidad = cantidad;
        this.recompensa = recompensa;
    }

    // Vera si cumple el con el requisisto de pasar la mision. Si es de llegar a un casilla'
    // exacta lo veera y si es de matar a una cantidad x de enemigos de igual forma
    // Retornara true si se cumplio la mision y false si aun no se completa
    public boolean verificar_requisito(){
        if (this.requisito == 'v') {
            if (this.cantidad == this.valor) {
                return true;
            }else{
                return false;
            }
        }
        else{
            if (cantidad >= valor) {
                return true;
            }else{
                return false;
            }
        }
    }

    public char get_requisito(){
        return this.requisito;
    }

    // Incrementa la cantidad en 1
    public void incrementar(){
        this.cantidad++;
    }

    // cambia el valor de cantidad en un numero exacto, es igual que un Setter pero con otro nombre
    public void cambiar(int posicion){
        this.cantidad = posicion;
    }

    public int get_recompensa() {
        return this.recompensa;
    }

    public int get_cantidad() {
        return this.cantidad;
    }

    public int get_valor(){
        return this.valor;
    }
}
