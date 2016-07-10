package crudImplementOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crudDaoINTERFACE.CRUDintarface;
import main.ConnectTo;
import model.User;
import model.WaterPumpModel;

public class CRUDuser implements CRUDintarface <User>{
	
	
	private final static String SQL_CREATE = "INSERT INTO `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table` VALUES(?,?,?,?,?,?)";	
	private final static String SQL_GET_ALL = "SELECT * FROM `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table`";
	private final static String SQL_GET_BY_ID = "SELECT * FROM `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table` WHERE user_id=?";
	private final static String SQL_UPDATE = "UPDATE `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table` SET `login`=?, `password`=?, `first_name`=?, `last_name`=?, `role`=? WHERE user_id=?";
	private final static String SQL_DELETE = "DELETE FROM `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table` WHERE user_id=?";
	//login, password, first_name, last_name, role, user_id, id
	@Override
	public User create(User user) {
		Connection conn = ConnectTo.getConnection();
		PreparedStatement pstat;
		try{
			pstat = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pstat.setInt(1, user.getId());
			pstat.setString(2, user.getLogin());
			pstat.setString(3, user.getPassword());
			pstat.setString(4, user.getFirstName());
			pstat.setString(5, user.getLastName());
			pstat.setString(6, user.getRoleName());
			pstat.executeUpdate();
			pstat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		Connection conn = ConnectTo.getConnection();
		WaterPumpModel pump = null;
		List<User> listOfUsers = new ArrayList<>();
		ResultSet rs;
		try (Statement st = conn.createStatement()){
				//NO
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}

	@Override
	public User getByID(int id) {
		Connection conn = ConnectTo.getConnection();
		ResultSet rs;
		User user = null;
		try (PreparedStatement ps = conn.prepareStatement(SQL_GET_BY_ID)){
				//NO
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean update(User user) {
		Connection conn = ConnectTo.getConnection();
		int count = 0;
		try (PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
			//NO
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0?true:false;
	}

	@Override
	public boolean delete(User user) {
		Connection conn = ConnectTo.getConnection();
		int count = 0;
		try (PreparedStatement ps = conn.prepareStatement(SQL_DELETE)){
			//NO
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count>0?true:false;
	}

	public int find(String login, String password){
		int userID = -1;
		final String SELECT = "SELECT `user_id` FROM `dbdf16c637ec3145c394a3a5d500dc2cd1`.`user_table` WHERE `login`=? AND `password`=?";
		Connection conn = ConnectTo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(SELECT);
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (true) {
				if (rs.next()) {
					userID = rs.getInt(1);
					System.out.println(userID);
				} else {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userID;
		
	}
}
