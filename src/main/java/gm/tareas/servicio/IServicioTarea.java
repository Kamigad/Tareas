package gm.tareas.servicio;

import gm.tareas.modelo.Tarea;

import java.util.List;

public interface IServicioTarea {
    public List<Tarea> listarTareas();
    public Tarea buscarTareaPorId(Integer idTarea);
    public void agregarTarea(Tarea tarea);
    public void eliminarTarea(Tarea tarea);
}
