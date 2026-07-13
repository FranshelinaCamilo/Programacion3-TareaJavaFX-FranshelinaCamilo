package model;

public class Destino {
    //atributos
    private String nombre;

    //constructores
    public Destino(String nombre) {
        setNombre(nombre);
    }
    public Destino() {
        setNombre("");
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
