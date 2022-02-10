package business;

import dataAccessLayer.UserDAO;
import model.LoginData;

import javax.ws.rs.WebApplicationException;

public class LoginController {
    private static UserDAO userDAO = new UserDAO();

    public String validateUser(LoginData loginData) {
        //Prøv at se om der er en bruger der matcher username?
        LoginData user = userDAO.findUser(loginData.getUsername());
        //Kontroller om der var en bruger med det rette kodeord?
        if (user !=null && user.getPassword().equals(loginData.getPassword())) {
            //returner en token!
            return JWTHandler.generateToken(loginData.getUsername());
        }
        //Afvis med en 401 hvis login fejler!
        throw new WebApplicationException("FYFY",401);
    }
}
