package Persistence;

import BL.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements UserDAOInterface {

    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DBHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getEmail(), user.getName(), user.getSurname(), user.getPhone());
    }

    public static User convertUserDTOToUser(UserDTO userDTO) {

        return new User(userDTO.getEmail(), userDTO.getName(), userDTO.getSurname(), userDTO.getPhone());
    }

    @Override
    public UserDTO getObject(UserDTO tmp) {
        return null;
    }

    @Override
    public void addObject(UserDTO tmp) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Users('EMAIL', 'NAME', 'SURNAME', 'PHONE')" +
                    " VALUES(?, ?, ?, ?)");
            statement.setObject(1, tmp.getEmail());
            statement.setObject(2, tmp.getName());
            statement.setObject(3, tmp.getSurname());
            statement.setObject(4, tmp.getPhone());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeObject(UserDTO tmp) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Users WHERE id = ?");
            statement.setObject(1, getObject(tmp).getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObject(UserDTO tmp) {

    }
}
