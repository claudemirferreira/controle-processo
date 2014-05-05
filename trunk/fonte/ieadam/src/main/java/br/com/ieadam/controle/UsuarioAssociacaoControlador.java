package br.com.ieadam.controle;

import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.UsuarioArea;
import br.com.ieadam.dominio.UsuarioNucleo;
import br.com.ieadam.dominio.UsuarioZona;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.UsuarioAreaServico;
import br.com.ieadam.servico.UsuarioNucleoServico;
import br.com.ieadam.servico.UsuarioServico;
import br.com.ieadam.servico.UsuarioZonaServico;
import br.com.ieadam.servico.ZonaServico;

@ManagedBean
@SessionScoped
public class UsuarioAssociacaoControlador {

	private Usuario usuario;

	private List<Zona> zonas;

	private List<Nucleo> nucleos;

	private List<Area> areas;
	
	private List<Zona> filteredZonas;

	@ManagedProperty(value = "#{usuarioServicoImpl}")
	private UsuarioServico usuarioServico;

	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{usuarioZonaServicoImpl}")
	private UsuarioZonaServico usuarioZonaServico;

	@ManagedProperty(value = "#{usuarioNucleoServicoImpl}")
	private UsuarioNucleoServico usuarioNucleoServico;

	@ManagedProperty(value = "#{usuarioAreaServicoImpl}")
	private UsuarioAreaServico usuarioAreaServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	public UsuarioServico getUsuarioServico() {
		return usuarioServico;
	}

	public void setUsuarioServico(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}

	public ZonaServico getZonaServico() {
		return zonaServico;
	}

	public void setZonaServico(ZonaServico zonaServico) {
		this.zonaServico = zonaServico;
	}

	public AreaServico getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(AreaServico areaServico) {
		this.areaServico = areaServico;
	}

	public NucleoServico getNucleoServico() {
		return nucleoServico;
	}

	public void setNucleoServico(NucleoServico nucleoServico) {
		this.nucleoServico = nucleoServico;
	}

	public UsuarioNucleoServico getUsuarioNucleoServico() {
		return usuarioNucleoServico;
	}

	public void setUsuarioNucleoServico(
			UsuarioNucleoServico usuarioNucleoServico) {
		this.usuarioNucleoServico = usuarioNucleoServico;
	}

	public UsuarioAreaServico getUsuarioAreaServico() {
		return usuarioAreaServico;
	}

	public void setUsuarioAreaServico(UsuarioAreaServico usuarioAreaServico) {
		this.usuarioAreaServico = usuarioAreaServico;
	}

	public UsuarioZonaServico getUsuarioZonaServico() {
		return usuarioZonaServico;
	}

	public void setUsuarioZonaServico(UsuarioZonaServico usuarioZonaServico) {
		this.usuarioZonaServico = usuarioZonaServico;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Nucleo> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<Nucleo> nucleos) {
		this.nucleos = nucleos;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Zona> getFilteredZonas() {
		return filteredZonas;
	}

	public void setFilteredZonas(List<Zona> filteredZonas) {
		this.filteredZonas = filteredZonas;
	}
	
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

	public void showModalAssociacao(Usuario usuario) {
		this.zonas = zonaServico.listarTodos();
		this.nucleos = nucleoServico.listarTodos();
		this.areas = areaServico.listarTodos();
		this.usuario = usuario;

		for (Zona zona : zonas) {
			if (usuarioZonaServico.findByUsuarioAndByZona(usuario, zona) == null)
				zona.setUsuarioZona(false);
			else
				zona.setUsuarioZona(true);
		}

		for (Nucleo nucleo : nucleos) {
			if (usuarioNucleoServico.findByUsuarioAndByNucleo(usuario, nucleo) == null)
				nucleo.setUsuarioNucleo(false);
			else
				nucleo.setUsuarioNucleo(true);
		}

		for (Area area : areas) {
			if (usuarioAreaServico.findByUsuarioAndByArea(usuario, area) == null)
				area.setUsuarioArea(false);
			else
				area.setUsuarioArea(true);
		}

	}

	public void atualizarZonas(Zona zona) {
		UsuarioZona usuarioZona = new UsuarioZona();

		usuarioZona.setUsuario(this.usuario);
		usuarioZona.setZona(zona);

		if (zona.isUsuarioZona())
			usuarioZonaServico.salvar(usuarioZona);
		else
			usuarioZonaServico.deleteByUsuarioAndByZona(this.usuario, zona);
	}

	public void atualizarNucleos(Nucleo nucleo) {
		UsuarioNucleo usuarioNucleo = new UsuarioNucleo();
		usuarioNucleo.setUsuario(this.usuario);
		usuarioNucleo.setNucleo(nucleo);

		if (nucleo.isUsuarioNucleo())
			usuarioNucleoServico.salvar(usuarioNucleo);
		else
			usuarioNucleoServico.deleteByUsuarioAndByNucleo(this.usuario,
					nucleo);
	}

	public void atualizarAreas(Area area) {
		UsuarioArea usuarioArea = new UsuarioArea();
		usuarioArea.setUsuario(this.usuario);
		usuarioArea.setArea(area);

		if (area.isUsuarioArea())
			usuarioAreaServico.salvar(usuarioArea);
		else
			usuarioAreaServico.deleteByUsuarioAndByArea(this.usuario, area);
	}

	public void atualizarUsuario(Usuario usuario) {
		usuarioServico.salvar(usuario);
	}

}
