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

    @FXML
    private TextField nombreTareaTexto;

    @FXML
    private TextField responsableTareaTexto;

    @FXML
    private TextField estatusTareaTexto;

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

    public void agregarTarea(){
        if (nombreTareaTexto.getText().isEmpty()){
            mostrarMensaje("Error Validacion", "Debe proporcionar una tarea");
            nombreTareaTexto.requestFocus();
            return;
        }
        else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            servicioTarea.agregarTarea(tarea);
            mostrarMensaje("Informacion", "Tarea agregada");
            limpiarFormulario();
            listarTareas();
        }
    }

    private void recolectarDatosFormulario(Tarea tarea){
        tarea.setNombreTarea(nombreTareaTexto.getText());
        tarea.setResponsable(responsableTareaTexto.getText());
        tarea.setEstatus(estatusTareaTexto.getText());
    }

    private void limpiarFormulario(){
        nombreTareaTexto.clear();
        responsableTareaTexto.clear();
        estatusTareaTexto.clear();

    }

    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
