package br.com.ieadam.componentes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class MessageControlador {

	public void addInfo(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sample info message", "PrimeFaces rocks!"));
	}

	public void addWarn(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Sample warn message", "Watch out for PrimeFaces!"));
	}

	public void addError(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Sample error message",
								"PrimeFaces makes no mistakes"));
	}

	public void addFatal(ActionEvent actionEvent) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Sample fatal message", "Fatal Error in System"));
	}

}
