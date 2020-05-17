
package pl.jazapp.app;


import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@SessionScoped
public class UserContext implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long userId;


    public UserContext() {
    }


    public Long getUserId() {
        return userId;
    }


    public void logIn(Long userId) {
        this.userId = userId;
    }
}
