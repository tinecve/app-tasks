package co.tinecve.model;

public class User {

	private Integer id;
	private String nombre;
	private String password;
	private String userName;
	private String email;

	public User() {
		super();
	}

	public User(String nombre, String password, String userName, String email) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.userName = userName;
		this.email = email;
	}

	public User(Integer id, String nombre, String password, String userName, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.userName = userName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
