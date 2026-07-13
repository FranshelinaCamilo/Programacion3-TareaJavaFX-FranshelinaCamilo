package controller;

import javafx.fxml.FXML;
import utils.Navegacion;
import javafx.scene.control.Label;
import javafx.application.Platform;


public class PrincipalController {

    @FXML
    private Label lblMensajes;
    
    @FXML
    private void abrirRegistroPaquetes() {
        Navegacion.abrirVentana("/view/RegistroPaquetes.fxml", "Registro de Paquetes");
        lblMensajes.setText("Registro de Paquetes abierto");
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
    private void salir() {
        Platform.exit();
    }

    @FXML
    private void guardadoSinDatos() {
        lblMensajes.setText("No se puede guardar, acceda a las ventana de registro de paquetes");
    }

}
