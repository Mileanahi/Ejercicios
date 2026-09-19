public class Mago extends Personaje{
    public  Mago (int id, String nombre, int nivel) {
        super (id, nombre, nivel);
    }
    @Override 
    public String realizaAcciones () {
        return "Lanza un hechizo defensivo contra los demonios"; 

    } 

}
