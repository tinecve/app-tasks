package co.tinecve.services;

import java.util.List;

import co.tinecve.model.Task;

public class TaskService {

	public boolean registrarTarea(Task task) {
		return true;
	}
	
	public boolean cancelarTarea(Long id) {
		return true;
	}
	
	public List<Task> listarTareas(Long id){
		return null;
	}
	
	public boolean modificarTarea(Long id, Task task) {
		return true;
	}
	
	public Task buscarTarea(Long id) {
		return null;
	}
	
}
