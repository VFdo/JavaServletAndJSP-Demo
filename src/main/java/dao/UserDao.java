package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	public User getUserById(int id){
        User user = new User();
        try{
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM user WHERE id = " + id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setActive(resultSet.getBoolean("isActive"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public boolean addUser(int userId, String userName, boolean isActive) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			String query = "INSERT INTO user (id, name, isActive) VALUES (?, ?, ?);";
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setInt(1, userId);
	        statement.setString(2, userName);
	        statement.setBoolean(3, isActive);

	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted > 0) {
	            return true;
	        }
	        return false;

		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
