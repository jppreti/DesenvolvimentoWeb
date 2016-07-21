package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ClienteValidator")
public class ClienteValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent uiComp, Object obj) throws ValidatorException {
		if (obj==null)
			throw new ValidatorException(new FacesMessage("Cliente inválido!"));
		String email = (String) obj;
		boolean achou = false;
		for (Cliente c : Cliente.clientes)
			if (c.getEmail().equals(email))
				achou=true;
		if (achou == false)
			throw new ValidatorException(new FacesMessage("Cliente não Cadastrado!"));
	}

}
