package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import utils.*;
import javafx.scene.control.*;
import model.*;

public class RegistroPaquetesController {
    @FXML
    private Label lblMensajes;
    
    @FXML 
    private ComboBox<String> cmbDestino;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDestinatario;

    @FXML
    private TextField txtPeso;

    @FXML
    private ProgressBar progressBar;
    

    @FXML
    public void initialize(){
        cmbDestino.setItems(FXCollections.observableArrayList("Santo Domingo", "Santiago", "San Francisco de Macoris", "La vega"));
    }

    @FXML
    private void CargarDestinos() {
        if (cmbDestino != null) {
            ObservableList<String> destinos = FXCollections.observableArrayList(
                "Santo Domingo", "Santiago", "San Francisco de Macoris", "La vega"
            );
            ArrayList<Destino> listaDestinos = ArchivoUtil.LeerListaDestinos();
            
            if (listaDestinos != null && !listaDestinos.isEmpty()) {
                for (Destino d : listaDestinos) {
                    String nombre = d.getNombre(); 
                    
                    if (!destinos.contains(nombre)) {
                        destinos.add(nombre);
                    }
                }
            }
            cmbDestino.setItems(destinos);
        }
    }

    @FXML
    private Paquete crearPaquete() {
        String destino = cmbDestino.getValue();

        if(destino == null || destino.isEmpty()) {
            destino = "no especificado";
        }

        return new Paquete(txtCodigo.getText(), txtDestinatario.getText(), Integer.parseInt(txtPeso.getText()), destino);
    }

    @FXML
    private void guardarPaquete() {
        Paquete paquete = crearPaquete();
        boolean exito = ArchivoUtil.guardarPaquete(paquete);

        if (exito) {
            lblMensajes.setText("Paquete guardado exitosamente");
        } else {
            lblMensajes.setText("Error al guardar el paquete");
        }
    }

    @FXML
    private void abrirRegistroPaquetes() {
        lblMensajes.setText("Ya se encuentra en la ventana de Registro de Paquetes");
    }

    @FXML
    private void abrirRegistroDestinos() {
        Navegacion.abrirVentana("/view/RegistroDestinos.fxml", "Registro de Destinos");
        lblMensajes.setText("Registro de Destinos abierto");
    }

    @FXML
    private void abrirConsultaPaquetes() {
        Navegacion.abrirVentana("/view/ConsultarPaquetes.fxml", "Consulta de Paquetes");
        lblMensajes.setText("Consulta de Paquetes abierta");
    }

    @FXML
    private void abrirConsultaDestinos() {
        Navegacion.abrirVentana("/view/ConsultarDestinos.fxml", "Consulta de Destinos");
        lblMensajes.setText("Consulta de Destinos abierta");
    }

    @FXML
    private void guardarConHilo() {
        Paquete paquete = crearPaquete();
        lblMensajes.setText("guardando en segundo plano...");

        progressBar.setProgress(0);
        Thread hilo = new Thread(() -> {
        try{
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(200);
                int progreso = i;

                Platform.runLater(() -> {
                    progressBar.setProgress(progreso / 10.0);
                    lblMensajes.setText("Guardando paquete... " + (progreso * 10) + "%");
                });

                ArchivoUtil.guardarPaquete(paquete);

                Platform.runLater(() -> {
                    progressBar.setProgress(0);
                    lblMensajes.setText("Paquete guardado exitosamente");
                });}
            } catch (InterruptedException e) {
                lblMensajes.setText("Error al guardar el paquete...");
            }
        });

        hilo.start();

        boolean exito = ArchivoUtil.guardarPaquete(paquete);
        Platform.runLater(() -> {
            if (exito) {
                lblMensajes.setText("Paquete guardado exitosamente");
            } else {
                lblMensajes.setText("Error al guardar el paquete");
            }
        });
    }

    @FXML
    private void guardarRunLater() {
        lblMensajes.setText("guardando datos con runLater...");
    }

    @FXML
    private void salir() {
        Platform.exit();
    }
}
