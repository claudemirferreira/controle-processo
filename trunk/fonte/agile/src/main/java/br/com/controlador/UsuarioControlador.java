package br.com.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.DualListModel;

import br.fucapi.bpms.alfresco.dominio.Usuario;
import br.fucapi.bpms.alfresco.servico.AlfrescoServico;

@ManagedBean
public class UsuarioControlador {

	@ManagedProperty(value = "#{alfrescoServicoImpl}")
	private AlfrescoServico alfrescoServico;

	private DualListModel<Usuario> usuarios;

	public String init() {

		List<Usuario> source = new ArrayList<Usuario>();
		List<Usuario> target = new ArrayList<Usuario>();

		source = alfrescoServico.getUsuarios();

		this.usuarios = new DualListModel<Usuario>(source, target);

		return "paginas/exemplos/picklist.xhtml";
	}

	public DualListModel<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(DualListModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public AlfrescoServico getAlfrescoServico() {
		return alfrescoServico;
	}

	public void setAlfrescoServico(AlfrescoServico alfrescoServico) {
		this.alfrescoServico = alfrescoServico;
	}

}