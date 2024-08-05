package co.tinecve.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.tinecve.model.User;
import co.tinecve.util.ConexionDB;

public class UserDAO {
	
	private ConexionDB conexionDB;
	
	private static final String INSERTAR = "INSERT INTO user (nombre, password, username, email) VALUES (?, ?, ?, ?);";
	private static final String ACTUALIZAR = "UPDATE user SET nombre = ?, password = ?, username = ?, email = ? WHERE id = ?;";
	private static final String ELIMINAR = "DELETE FROM user WHERE id = ?;";
	private static final String BUSCAR = "SELECT * FROM user;";
	private static final String LISTAR = "SELECT * FROM user;";
	private static final String BUSCAR_BY_NOMBRE = "SELECT * FROM user WHERE nombre = ?;";
	private static final String BUSCAR_BY_USERNAME = "SELECT * FROM user WHERE username = ?;";
	private static final String BUSCAR_BY_EMAIL = "SELECT * FROM user WHERE email = ?;";
	
	public UserDAO() {
		this.conexionDB = ConexionDB.getConexion();
	}
	
	public void insertar(User user) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(INSERTAR);
			preparedStatement.setString(1, user.getNombre());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getEmail());
			
			conexionDB.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void actualizar(User user) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(ACTUALIZAR);
			preparedStatement.setString(1, user.getNombre());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getId());
			
			conexionDB.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
	public void eliminar(Integer id) {
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(ELIMINAR);
			preparedStatement.setInt(1, id);
			
			conexionDB.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public User buscar(Integer id){
		User user = null;
		
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(BUSCAR);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexionDB.query();
			
			while(rs.next()) {
				Integer idUser = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				
				user = new User(idUser, nombre, password, userName, email);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return user;
	}
	
	public List<User> listar(){
		List<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(LISTAR);
			
			ResultSet rs = conexionDB.query();
			
			while(rs.next()) {
				Integer idUser = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				
				users.add(new User(idUser, nombre, password, userName, email));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return users;
	}
	
	public User buscarPorEmail(String emailUser){
		User user = null;
		
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(BUSCAR);
			preparedStatement.setString(1, emailUser);
			
			ResultSet rs = conexionDB.query();
			
			while(rs.next()) {
				Integer idUser = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				
				user = new User(idUser, nombre, password, userName, email);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return user;
	}
	
	public User buscarPorUserName(String userName_){
		User user = null;
		
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(BUSCAR);
			preparedStatement.setString(1, userName_);
			
			ResultSet rs = conexionDB.query();
			
			while(rs.next()) {
				Integer idUser = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				
				user = new User(idUser, nombre, password, userName, email);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return user;
	}
	
	public List<User> listarPorNombre(String nombre_){
		List<User> users = new ArrayList<User>();
		
		try {
			PreparedStatement preparedStatement = conexionDB.setPreparedStatement(LISTAR);
			preparedStatement.setString(1, nombre_);
			
			ResultSet rs = conexionDB.query();
			
			while(rs.next()) {
				Integer idUser = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String password = rs.getString("password");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				
				users.add(new User(idUser, nombre, password, userName, email));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return users;
	}
	

}
