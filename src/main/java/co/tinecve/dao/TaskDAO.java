package co.tinecve.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.tinecve.model.Task;
import co.tinecve.model.User;
import co.tinecve.util.ConexionDB;

public class TaskDAO {

	private ConexionDB conexionDB;

	private static final String INSERTAR = "INSERT INTO tasks () VALUES ();";
	private static final String ACTUALIZAR = "UPDATE tasks SET tarea = ?, prioridad = ?, usuario = ?  WHERE id = ?;";
	private static final String ELIMINAR = "DELETE from tasks WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM tasks WHERE id = ?;";
	private static final String LISTAR = "SELECT * FROM tasks;";
	private static final String BUSCAR_BY_NOMBRE = "SELECT * FROM tasks WHERE nombre = ?;";

	public TaskDAO() {
		this.conexionDB = ConexionDB.getConexion();
	}

	public void insertar(Task task) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(INSERTAR);

			preparedStatement.setString(1, task.getTarea());
			preparedStatement.setString(2, task.getPrioridad());
			preparedStatement.setInt(3, task.getUsuario().getId());
			preparedStatement.setInt(4, task.getId());

			conexionDB.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void actualizar(Task task) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(ACTUALIZAR);

			preparedStatement.setString(1, task.getTarea());
			preparedStatement.setString(2, task.getPrioridad());
			preparedStatement.setInt(3, task.getId());

			conexionDB.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void eliminar(Integer id) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(ELIMINAR);

			preparedStatement.setInt(1, id);

			conexionDB.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public List<Task> buscar(Integer id_) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(BUSCAR);

			preparedStatement.setInt(1, id_);

			ResultSet rs = conexionDB.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String tarea = rs.getString("tarea");
				String prioridad = rs.getString("prioridad");
				Integer userId = rs.getInt("usuario");
				User user = new User();
				user.setId(userId);

				tasks.add(new Task(id, tarea, prioridad, user));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return tasks;
	}

	public List<Task> listar() {
		List<Task> tasks = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(LISTAR);
			ResultSet rs = conexionDB.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String tarea = rs.getString("tarea");
				String prioridad = rs.getString("prioridad");
				Integer userId = rs.getInt("usuario");
				User user = new User();
				user.setId(userId);

				tasks.add(new Task(id, tarea, prioridad, user));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return tasks;
	}

	public List<Task> buscarPorNombre(String nombre) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(BUSCAR_BY_NOMBRE);

			preparedStatement.setString(1, nombre);

			ResultSet rs = conexionDB.query();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String tarea = rs.getString("tarea");
				String prioridad = rs.getString("prioridad");
				Integer userId = rs.getInt("usuario");
				User user = new User();
				user.setId(userId);

				tasks.add(new Task(id, tarea, prioridad, user));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return tasks;
	}

}
