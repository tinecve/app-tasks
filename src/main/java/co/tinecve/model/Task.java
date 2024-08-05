package co.tinecve.model;

public class Task {

	private Integer id;
	private String tarea;
	private String prioridad;
	private User usuario;

	public Task(String tarea, String prioridad, User usuario) {
		super();
		this.tarea = tarea;
		this.prioridad = prioridad;
		this.usuario = usuario;
	}

	public Task(Integer id, String tarea, String prioridad, User usuario) {
		super();
		this.id = id;
		this.tarea = tarea;
		this.prioridad = prioridad;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
