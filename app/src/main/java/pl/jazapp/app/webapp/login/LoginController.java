package pl.jazapp.app.webapp.login;



import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named
@RequestScoped
public class LoginController {
    public String login(LoginRequest loginRequest) {
        System.out.println(String.format("Tried to log in with username %s and password %s", loginRequest.getUsername(), loginRequest.getPassword()));
       if(true) {
           var flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
           flash.put("error-message", "Username or Password is incorrect.");
           return "/login.xhtml?faces-redirect=true";
       }

        return "/index.xhtml?faces-redirect=true";
    }
}
