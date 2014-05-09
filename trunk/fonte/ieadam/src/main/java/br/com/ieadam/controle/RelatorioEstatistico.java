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
import br.com.ieadam.servico.ZonaServico;
import br.com.ieadam.utils.PathRelatorios;

import com.lowagie.text.DocumentException;

@ManagedBean
@SessionScoped
public class RelatorioEstatistico implements Serializable {

	private static final long serialVersionUID = -2799171038466794271L;

	private Parametro parametro;

	private boolean visualizar = false;

	private FiltroRelatorioDTO filtroRelatorioDTO;

	@ManagedProperty(value = "#{relatorioUtil}")
	private RelatorioUtil relatorioUtil;

	@ManagedProperty(value = "#{zonaServicoImpl}")
	private ZonaServico zonaServico;

	@ManagedProperty(value = "#{areaServicoImpl}")
	private AreaServico areaServico;

	@ManagedProperty(value = "#{nucleoServicoImpl}")
	private NucleoServico nucleoServico;

	@ManagedProperty(value = "#{paginaCentralControlador}")
	private PaginaCentralControlador paginaCentralControlador;

	private StreamedContent streamedContent;

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
		this.filtroRelatorioDTO.preencherCombos(
				this.filtroRelatorioDTO.getUsuarioLogado(), zonaServico,
				nucleoServico, areaServico);

		this.parametro = new Parametro();

		this.parametro.setAno(DataUtil.pegarAnocorrente());
		this.parametro.setMes(DataUtil.pegarMescorrente());

		this.visualizar = false;

		this.paginaCentralControlador
				.setPaginaCentral("paginas/relatorio/estatistico.xhtml");

	}

	public void atualizarNucleo() {
		this.filtroRelatorioDTO.setNucleos(this.nucleoServico
				.findByZona(this.filtroRelatorioDTO.getZona().getId()));
		System.out.println(" nucleo = "
				+ this.filtroRelatorioDTO.getNucleos().size());

	}

	public void atualizarArea() {
		this.filtroRelatorioDTO.setAreas(this.areaServico
				.findByNucleo(this.filtroRelatorioDTO.getNucleo().getId()));

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
		String arquivo = context
				.getRealPath(PathRelatorios.RELATORIO_SECRETARIA_MEMBROS
						.getNome());

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

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}
}