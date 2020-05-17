package pl.jazapp.app.webapp.register;



import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



@Named
@RequestScoped
public class RegisterController {
    public String register(RegisterRequest registerRequest) {
        System.out.println(String.format("Tried to register with username %s and password %s", registerRequest.getUsername(), registerRequest.getPassword()));
        return "/login.xhtml?faces-redirect=true";
    }
}