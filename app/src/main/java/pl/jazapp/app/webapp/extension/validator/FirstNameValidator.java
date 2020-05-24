package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("firstnameValidator")
public class FirstNameValidator implements Validator<String> {
    private static final String MESSAGE_ID =
            "pl.jazapp.app.webapp.extension.validator.FirstNameValidator";


    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (!value.matches("^[a-zA-ZśŚżóćźłąŻŹŁÓĆĄŃń]{1,25}$")) {
            var msg = getMsg(context);
            msg.getString(MESSAGE_ID);
            var onlySmallLettersMsg = msg.getString(MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(onlySmallLettersMsg));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class);
    }

}
