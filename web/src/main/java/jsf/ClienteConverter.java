package jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("ClienteConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uiComp, String value) throws ConverterException {
		for (Cliente c : Cliente.clientes) {
			if (c.getEmail().equals(value))
				return c;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent uiComp, Object value) throws ConverterException {
		if (value!=null) return ((Cliente)value).getEmail();
		return "";
	}

}
