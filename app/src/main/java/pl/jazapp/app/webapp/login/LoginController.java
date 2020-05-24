package pl.jazapp.app.webapp.login;


import pl.jazapp.app.UserContext;
import pl.jazapp.app.webapp.model.Storage;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class LoginController {
    @Inject
    private UserContext userContext;


    public String login(LoginRequest loginRequest) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (Storage.IsUsernameAndPasswordCorrect(loginRequest.getUsername(), loginRequest.getPassword())) {
            userContext.logIn();
            userContext.setWelcomeMessage(Storage.getFirstName(loginRequest.getUsername()) + " " + Storage.getLastName(loginRequest.getUsername()));
            return "/index.xhtml?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Username or password is incorrect");

            return null;
        }
    }

    public String logout() {
        userContext.logOut();
        return "/login.xhtml?faces-redirect=true";
    }


}
