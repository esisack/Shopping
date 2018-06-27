package com.srx.web.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.srx.model.entities.Company;
import com.srx.model.facades.CompanyFacade;
import com.srx.web.utils.JsfUtil;

@FacesConverter(value = "companyConverter")
public class CompanyConverter implements Converter {
		@EJB
	    private CompanyFacade ejbFacade;

	    @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
	        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
	            return null;
	        }
	        return this.ejbFacade.find(getKey(value));
	    }

	    java.lang.Integer getKey(String value) {
	        java.lang.Integer key;
	        key = Integer.valueOf(value);
	        return key;
	    }

	    String getStringKey(java.lang.Integer value) {
	        StringBuffer sb = new StringBuffer();
	        sb.append(value);
	        return sb.toString();
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
	        if (object == null
	                || (object instanceof String && ((String) object).length() == 0)) {
	            return null;
	        }
	        if (object instanceof Company) {
	            Company o = (Company) object;
	            return getStringKey(o.getCompanyId());
	        } else {
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Company.class.getName()});
	            return null;
	        }
	    }

}
