package pl.jazapp.app.webapp.register;


import pl.jazapp.app.webapp.model.Storage;
import pl.jazapp.app.webapp.model.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
public class RegisterController {
    public String register(RegisterRequest registerRequest) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (Storage.IsUserExist(registerRequest.getUsername())) {
            context.addMessage(null, new FacesMessage("Username is already taken."));

        } else if (!registerRequest.getPassword().equals(registerRequest.getPasswordCheck())) {
            context.addMessage(null, new FacesMessage("Passwords do not match."));
        } else {
            Storage.AddToStorage(registerRequest.getUsername(), new User(registerRequest.getUsername(),
                    registerRequest.getPassword(),registerRequest.getEmail(), registerRequest.getBirthday(),
                    registerRequest.getFirstName().substring(0, 1).toUpperCase() + registerRequest.getFirstName().substring(1),
                    registerRequest.getLastName().substring(0, 1).toUpperCase() + registerRequest.getLastName().substring(1)));

        }


        return "/login.xhtml?faces-redirect=true";
    }
}