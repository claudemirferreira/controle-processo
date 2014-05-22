package br.com.ieadam.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.StreamedContent;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.componentes.Parametro;
import br.com.ieadam.componentes.RelatorioUtil;
import br.com.ieadam.componentes.Util;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.UsuarioAreaServico;
import br.com.ieadam.servico.UsuarioNucleoServico;
import br.com.ieadam.servico.UsuarioZonaServico;
import br.com.ieadam.servico.ZonaServico;

import com.lowagie.text.DocumentException;

@ManagedBean
@SessionScoped
public abstract class RelatorioGenerico implements Serializable {

	private static final long serialVersionUID = -2799171038466794271L;

	private Parametro parametro;

	private boolean visualizar = false;

	@ManagedProperty(value = "#{filtroRelatorioDTO}")
	private FiltroRelatorioDTO filtroRelatorioDTO;

	@ManagedProperty(value = "#{relatorioUtil}")
	private RelatorioUtil relatorioUtil;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;

	@ManagedProperty(value = "#{usuarioZonaServicoImpl}")
	private UsuarioZonaServico usuarioZonaServico;

	@ManagedProperty(value = "#{usuarioNucleoServicoImpl}")
	private UsuarioNucleoServico usuarioNucleoServico;

	@ManagedProperty(value = "#{usuarioAreaServicoImpl}")
	private UsuarioAreaServico usuarioAreaServico;

	private StreamedContent streamedContent;

	public abstract String telaRelatorio();

	public abstract String nomeRelatorio();

	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();

		this.filtroRelatorioDTO.setZona(new Zona());
		this.filtroRelatorioDTO.setNucleo(new Nucleo());
		this.filtroRelatorioDTO.setArea(new Area());

		this.filtroRelatorioDTO
				.setUsuarioLogado((Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal());

		// chamada responsavel por preencher os combos de acordo com o nivel de
		// acesso do pastor
		this.preencherCombos(this.filtroRelatorioDTO.getUsuarioLogado());

		this.parametro = new Parametro();

		this.parametro.setAno(DataUtil.pegarAnocorrente());
		this.parametro.setMes(DataUtil.pegarMescorrente());

		this.visualizar = false;

		this.paginaCentralControlador.setPaginaCentral(telaRelatorio());

	}

	public void redirecionarModuloPrincipalSecretaria() {
		paginaCentralControlador.setPaginaCentral("paginas/perfil/lista.xhtml");
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}

	public void visualiarRelatorio() {
		this.visualizar = true;
	}

	public void processarPDF() throws IOException, DocumentException {

		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext externalContext = fc.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath(nomeRelatorio());

		// BLOCO USADO PARA TESTES
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = new Usuario();
		u.setLogin("login");
		usuarios.add(u);
		// BLOCO USADO PARA TESTES

		Calendar dataInicio = new GregorianCalendar(
				this.parametro.getAnoInicio(), this.parametro.getMesInicio()
						.getMes(), 1);
		Calendar dataFim = new GregorianCalendar(this.parametro.getAnoFim(),
				this.parametro.getMesFim().getMes(), 1);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("DATA_INICIO", dataInicio.getTime());
		params.put("DATA_FIM", dataFim.getTime());
		params.put("ZONA", this.filtroRelatorioDTO.getZona().getIdZona());
		params.put("NUCLEO", this.filtroRelatorioDTO.getNucleo().getIdNucleo());
		params.put("AREA", this.filtroRelatorioDTO.getArea().getIdArea());

		externalContext.setResponseContentType("application/pdf");

		try {
			byte[] relatorio = relatorioUtil.gerarRelatorioWebBytes(params,
					arquivo);

			if (relatorio == null || relatorio.length < 1000) {
				arquivo = context.getRealPath("/resources/relatorioVazio.pdf");
				FileInputStream file = new FileInputStream(new File(arquivo));
				relatorio = Util.getBytes(file);
			}

			externalContext.getResponseOutputStream().write(relatorio);

		} catch (FileNotFoundException e) {

			arquivo = context.getRealPath("/resources/relatorioNotFound.pdf");
			FileInputStream file = new FileInputStream(new File(arquivo));

			externalContext.getResponseOutputStream()
					.write(Util.getBytes(file));

		} finally {
			fc.responseComplete();
		}

	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public RelatorioUtil getRelatorioUtil() {
		return relatorioUtil;
	}

	public void setRelatorioUtil(RelatorioUtil relatorioUtil) {
		this.relatorioUtil = relatorioUtil;
	}

	public PaginaCentralControlador getpaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setpaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public PaginaCentralControlador getPaginaCentralControlador() {
		return paginaCentralControlador;
	}

	public void setPaginaCentralControlador(
			PaginaCentralControlador paginaCentralControlador) {
		this.paginaCentralControlador = paginaCentralControlador;
	}

	public ZonaServico getZonaServico() {
		return zonaServico;
	}

	public void setZonaServico(ZonaServico zonaServico) {
		this.zonaServico = zonaServico;
	}

	public NucleoServico getNucleoServico() {
		return nucleoServico;
	}

	public void setNucleoServico(NucleoServico nucleoServico) {
		this.nucleoServico = nucleoServico;
	}

	public AreaServico getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(AreaServico areaServico) {
		this.areaServico = areaServico;
	}

	public UsuarioZonaServico getUsuarioZonaServico() {
		return usuarioZonaServico;
	}

	public void setUsuarioZonaServico(UsuarioZonaServico usuarioZonaServico) {
		this.usuarioZonaServico = usuarioZonaServico;
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

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarNucleo() {
		boolean zonaAssociada = false;

		this.filtroRelatorioDTO.setNucleos(new ArrayList<Nucleo>());

		/*
		 * Verifica se a zona escolhida no combo esta associada ao usuario. SE
		 * estiver, devera listar todos os Nucleos desta zona e nao apenas o
		 * Nucleo associado.
		 */
		zonaAssociada = this.zonaServico.isUsuarioDeZona(
				this.filtroRelatorioDTO.getUsuarioLogado().getId(),
				this.filtroRelatorioDTO.getZona().getId());

		/*
		 * SE a ZONA nao estiver associada ao usuario, deverah ser pesquisado os
		 * NUCLEOS que o usuario faz parte DESTA regiao
		 */
		if (!zonaAssociada) {
			this.filtroRelatorioDTO.setNucleos(this.nucleoServico
					.listaNucleoToUsuarioAndZona(
							this.filtroRelatorioDTO.getUsuarioLogado(),
							this.filtroRelatorioDTO.getZona()));
		}

		/*
		 * SE a lista de nucleos estiver vazia, significa que o Usuario eh de
		 * REGIAO
		 */
		if (this.filtroRelatorioDTO.getNucleos().size() == 0) {
			this.filtroRelatorioDTO.setNucleos(this.nucleoServico
					.findByZona(this.filtroRelatorioDTO.getZona().getId()));
		}

		/*
		 * SE a lista de NUCLEO estiver com tamanho 1, deverah ser setado o
		 * NUCLEO da lista no objeto NUCLEO e deverah atualizar o combo de AREA
		 */
		if (this.filtroRelatorioDTO.getNucleos().size() == 1) {
			this.filtroRelatorioDTO.setNucleo(this.filtroRelatorioDTO
					.getNucleos().iterator().next());
			this.atualizarArea();
		}

		System.out.println(" nucleo = "
				+ this.filtroRelatorioDTO.getNucleos().size());
	}

	/**
	 * Metodo utilizado para atualizar o combo de Nucleo
	 */
	public void atualizarArea() {

		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());

		boolean nucleoAssociado = false;

		/*
		 * Verifica se o nucleo escolhido no combo esta associado ao usuario. SE
		 * estiver, devera listar todas as Areas deste nucleo e nao apenas a
		 * Area associada.
		 */
		nucleoAssociado = this.nucleoServico.isUsuarioDeNucleo(
				this.filtroRelatorioDTO.getUsuarioLogado().getId(),
				this.filtroRelatorioDTO.getNucleo().getId());

		/*
		 * SE o NUCLEO nao estiver associada ao usuario, deverah ser pesquisada
		 * as AREAS que o usuario faz parte DESTE nucleo
		 */
		if (!nucleoAssociado) {

			this.filtroRelatorioDTO.setAreas(this.areaServico
					.listaAreaToUsuarioAndNucleo(
							this.filtroRelatorioDTO.getUsuarioLogado(),
							this.filtroRelatorioDTO.getNucleo()));
		}

		/*
		 * SE a lista de areas estiver vazia, significa que o Usuario eh de
		 * NUCLEO
		 */
		if (this.filtroRelatorioDTO.getAreas().size() == 0) {
			this.filtroRelatorioDTO.setAreas(this.areaServico
					.findByNucleo(this.filtroRelatorioDTO.getNucleo().getId()));
		}
	}

	public void preencherCombos(Usuario usuario) {

		this.filtroRelatorioDTO.setZonas(new ArrayList<Zona>());
		this.filtroRelatorioDTO.setNucleos(new ArrayList<Nucleo>());
		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());

		this.filtroRelatorioDTO.setZonas(this.zonaServico
				.listaZonaUsuario(usuario.getId()));

		if (this.filtroRelatorioDTO.getZonas().size() == 1) {
			this.filtroRelatorioDTO.setNucleos(this.nucleoServico
					.listaNucleoUsuario(usuario));
		}

		if (this.filtroRelatorioDTO.getNucleos().size() == 1) {
			this.filtroRelatorioDTO.setAreas(this.areaServico
					.findByMembroAndNucleo(usuario.getIdMembro(),
							this.filtroRelatorioDTO.getNucleos().iterator()
									.next().getId()));
		}
	}

}