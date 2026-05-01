package gm.tareas.controlador;

import gm.tareas.modelo.Tarea;
import gm.tareas.servicio.ServicioTarea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private ServicioTarea servicioTarea;

    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea,Integer> idTareaColumna;

    @FXML
    private TableColumn<Tarea,String> nombreTareaColumna;

    @FXML
    private TableColumn<Tarea,String> responsableTareaColumna;

    @FXML
    private TableColumn<Tarea,String> estatusTareaColumna;

    private final ObservableList<Tarea> tarealist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configararColumna();
        listarTareas();
    }

    private void listarTareas(){
        logger.info("Ejecutando listado de tareas");
        tarealist.clear();
        tarealist.addAll(servicioTarea.listarTareas());
        tareaTabla.setItems(tarealist);
    }

    private void configararColumna(){
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }
}
