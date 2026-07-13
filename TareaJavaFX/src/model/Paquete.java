package model;

public class Paquete {
    private String codigo;
    private String destinatario;
    private int peso;
    private String destino;

    //constructores
    public Paquete(String codigo, String destinatario, int peso, String destino) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
        this.destino = destino;
    }

    public Paquete() {
        this.codigo = "";
        this.destinatario = "";
        this.peso = 0;
        this.destino = "";
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public int getPeso() {
        return peso;
    }
    public String getDestino() {
        return destino;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Paquete: " + getCodigo() + " - " + getDestinatario() + " - " + getPeso() + " - " + getDestino();
    }
}
