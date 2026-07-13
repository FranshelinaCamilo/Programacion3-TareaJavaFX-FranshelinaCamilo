package controller;
import javafx.application.Platform;
import javafx.fxml.FXML;
import utils.ArchivoUtil;
import utils.Navegacion;
import javafx.scene.control.*;

public class RegistroDestinosController {

    @FXML
    private TextField txtDestino;

    @FXML
    private Label lblMensajes;

    @FXML
    private void abrirRegistroPaquetes() {
        Navegacion.abrirVentana("/view/RegistroPaquetes.fxml", "Registro de Paquetes");
        lblMensajes.setText("Registro de Paquetes abierto");
    }

    @FXML
    private void abrirRegistroDestinos() {
        lblMensajes.setText("Ya se encuentra en la ventana de Registro de Destinos");
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
    private void guardarDestino() {
        String nombre = txtDestino.getText();

        if(nombre.isEmpty()) {
            lblMensajes.setText("El campo de destino no puede estar vacío.");
            return;
        }
        else{
            ArchivoUtil.guardarDestino(nombre);
            lblMensajes.setText("Destino guardado exitosamente.");
            txtDestino.clear();
        }
    }

    @FXML
    private void guardadoSinDatos() {
        lblMensajes.setText("No se puede guardar, acceda a las ventanas de registros para ingresar datos");
    }

    @FXML
    private void salir() {
        Platform.exit();
    }
}
