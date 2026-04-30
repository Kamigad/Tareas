package gm.tareas.repositorio;

import gm.tareas.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTarea extends JpaRepository<Tarea,Integer> {
}
