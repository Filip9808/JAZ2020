
package pl.jazapp.app;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID = 1L;
    private String WelcomeMessage;

    private boolean IsLogged;

    public boolean isLogged() {
        return IsLogged;
    }
    public void logIn() {
        this.IsLogged = true;
    }
    public void logOut() {
        this.IsLogged = false;
    }



    public String getWelcomeMessage() {
        return WelcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        WelcomeMessage = welcomeMessage;
    }
}
