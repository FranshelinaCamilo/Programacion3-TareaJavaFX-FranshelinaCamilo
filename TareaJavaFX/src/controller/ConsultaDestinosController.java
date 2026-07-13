package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Destino;
import utils.ArchivoUtil;
import utils.Navegacion;
import javafx.scene.control.*;

public class ConsultaDestinosController {
        @FXML
    private TableView<Destino> tvDestinos;

    @FXML
    private TableColumn<Destino, String> colDestinos;



    @FXML
    public void initialize(){
        colDestinos.setCellValueFactory(
            new PropertyValueFactory<>("nombre")
        );
        CargarDestinos();
    }

    private void CargarDestinos(){
        ObservableList<Destino> destinos = FXCollections.observableArrayList(ArchivoUtil.LeerListaDestinos());
        tvDestinos.setItems(destinos);
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
        Navegacion.abrirVentana("/view/ConsultarPaquetes.fxml", "Consulta de Paquetes");
    }

    @FXML
    private void abrirConsultaDestinos() {
        System.out.println("Ya estás en la ventana de consulta de destinos.");
    }
}
