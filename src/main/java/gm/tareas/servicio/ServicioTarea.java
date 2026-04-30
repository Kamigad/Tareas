package gm.tareas.servicio;

import gm.tareas.modelo.Tarea;
import gm.tareas.repositorio.RepositorioTarea;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicioTarea implements IServicioTarea{

    @Autowired
    private RepositorioTarea repositorioTarea;

    @Override
    public List<Tarea> listarTareas() {
        List<Tarea> tareas = repositorioTarea.findAll();
        return tareas;
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
        Tarea tarea = repositorioTarea.findById(idTarea).orElse(null);
        return tarea;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        repositorioTarea.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        repositorioTarea.delete(tarea);
    }
}
