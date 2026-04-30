package gm.tareas.servicio;

import gm.tareas.modelo.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicioTarea {
    public List<Tarea> listarTareas();
    public Tarea buscarTareaPorId(Integer idTarea);
    public void agregarTarea(Tarea tarea);
    public void eliminarTarea(Tarea tarea);
}
