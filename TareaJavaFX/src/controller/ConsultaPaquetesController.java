package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Paquete;
import javafx.application.Platform;
import javafx.collections.*;
import utils.ArchivoUtil;
import utils.Navegacion;

public class ConsultaPaquetesController {
    
    @FXML
    private TableView<Paquete> tvTabla;

    @FXML
    private TableColumn<Paquete, String> colCodigo;

    @FXML
    private TableColumn<Paquete, String> colDestinatario;

    @FXML
    private TableColumn<Paquete, Integer> colPeso;

    @FXML
    private TableColumn<Paquete, String> colDestino;


    @FXML
    public void initialize(){
        colCodigo.setCellValueFactory(
            new PropertyValueFactory<>("codigo")
        );
        colDestinatario.setCellValueFactory(
            new PropertyValueFactory<>("destinatario")
        );
        colPeso.setCellValueFactory(
            new PropertyValueFactory<>("peso")
        );
        colDestino.setCellValueFactory(
            new PropertyValueFactory<>("destino")
        );
        CargarPaquete();
    }

    private void CargarPaquete(){
        ObservableList<Paquete> paquetes = FXCollections.observableArrayList(ArchivoUtil.LeerListaPaquetes());
        tvTabla.setItems(paquetes);
    }

    @FXML
    private void salir() {
        Platform.exit();
    }

    @FXML
    private void abrirRegistroPaquetes() {
        Navegacion.abrirVentana("/view/RegistroPaquetes.fxml", "Registro de Paquetes");
    }

    @FXML
    private void abrirRegistroDestinos() {
        Navegacion.abrirVentana("/view/RegistroDestinos.fxml", "Registro de Destinos");
    }

    @FXML
    private void abrirConsultaPaquetes() {
        System.out.println("Ya se encuentra en la ventana de Consulta de Paquetes");
    }

    @FXML
    private void abrirConsultaDestinos() {
        Navegacion.abrirVentana("/view/ConsultarDestinos.fxml", "Consulta de Destinos");
    }
}
