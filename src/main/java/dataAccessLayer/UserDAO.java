package dataAccessLayer;

import model.LoginData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public LoginData findUser(String username) {
        //Brug utilityklasse til at oprette forbindelse:
        Connection connection = DBConnector.getConnection();
        //Lav SQL Query
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Check om der var resultat og konverter til Java-Object (LoginData)
            if (resultSet.next()){
                LoginData foundUser = new LoginData();
                foundUser.setUsername(resultSet.getString("username"));
                foundUser.setPassword(resultSet.getString("password"));
                return foundUser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
