package co.tinecve.model;

public class Task {

	private String tarea;
	private String prioridad;
	private User usuario;

	public Task(String tarea, String prioridad, User usuario) {
		super();
		this.tarea = tarea;
		this.prioridad = prioridad;
		this.usuario = usuario;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
