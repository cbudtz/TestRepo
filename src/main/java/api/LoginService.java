package api;

import business.LoginController;
import model.LoginData;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginService {
    private static LoginController loginController = new LoginController();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    // Tager imod deserialiserede data fra frontenden til Java-Object
    public String doLogin(LoginData loginData){
        //returner en token hvis det går godt
        return loginController.validateUser(loginData);
    }
}
