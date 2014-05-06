package br.com.ieadam.controle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.security.core.context.SecurityContextHolder;

import com.lowagie.text.DocumentException;

import br.com.ieadam.componentes.DataUtil;
import br.com.ieadam.componentes.Parametro;
import br.com.ieadam.componentes.RelatorioUtil;
import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.AreaServico;
import br.com.ieadam.servico.NucleoServico;
import br.com.ieadam.servico.ZonaServico;
import br.com.ieadam.utils.IEADAMUtils;
import br.com.ieadam.utils.PathRelatorios;

@ManagedBean
@SessionScoped
public class RelatorioBalanceteSintetico implements Serializable {

	private static final long serialVersionUID = 4085044268094923889L;

	private Parametro parametro;

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

		this.paginaCentralControlador
				.setPaginaCentral("paginas/relatorio/balancetesintetico.xhtml");

	}

	public void atualizarNucleo() {
		this.filtroRelatorioDTO.setNucleos(this.nucleoServico
				.findByZona(this.filtroRelatorioDTO.getZona().getId()));
		this.filtroRelatorioDTO.setAreas(new ArrayList<Area>());
		System.out.println(" nucleo = "
				+ this.filtroRelatorioDTO.getNucleos().size());

	}

	public void atualizarArea() {
		this.filtroRelatorioDTO.setAreas(this.areaServico
				.findByNucleo(this.filtroRelatorioDTO.getNucleo().getId()));

	}

	public void redirecionarModuloPrincipalSecretaria() {
		paginaCentralControlador
				.setPaginaCentral("paginas/perfil/lista.xhtml");
	}

	public void imprimir() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath("/WEB-INF/jasper/teste.jasper");

		Calendar dataInicio = new GregorianCalendar(this.parametro.getAno(),
				this.parametro.getMes().getMes(), 1);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("DATA_MES_ANO", dateFormat.format(dataInicio.getTime()));
		params.put("MES_ANO", IEADAMUtils.getMesByIndice(this.parametro.getMes().getMes())+"/"+this.parametro.getAno());
		params.put("ZONA", this.filtroRelatorioDTO.getZona().getIdZona());
		params.put("NUCLEO", this.filtroRelatorioDTO.getNucleo().getIdNucleo());
		params.put("AREA", this.filtroRelatorioDTO.getArea().getIdArea());

        byte[] relatorio = relatorioUtil.gerarRelatorioWebBytes(params, arquivo);   

        HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
        res.setContentType("application/pdf");  
        // Codigo abaixo gerar o relatorio e disponibiliza diretamente na pagina   
        // res.setHeader("Content-disposition", "inline;filename=arquivo.pdf");  
        res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");  
        try {
			res.getOutputStream().write(relatorio);
			res.getCharacterEncoding();
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				res.getOutputStream().flush();
				res.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
        
        FacesContext.getCurrentInstance().responseComplete(); 
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
	
	public void processarPDF() throws IOException, DocumentException {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        ServletContext context = (ServletContext) externalContext.getContext();
		String arquivo = context.getRealPath(PathRelatorios.RELATORIO_TESOURARIA_PROVENTOS_PASTORAL.getNome());

		Calendar dataInicio = new GregorianCalendar(this.parametro.getAno(),
				this.parametro.getMes().getMes(), 1);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("DATA_MES_ANO", dateFormat.format(dataInicio.getTime()));
		params.put("MES_ANO", IEADAMUtils.getMesByIndice(this.parametro.getMes().getMes())+"/"+this.parametro.getAno());
		params.put("ZONA", this.filtroRelatorioDTO.getZona().getIdZona());
		params.put("NUCLEO", this.filtroRelatorioDTO.getNucleo().getIdNucleo());
		params.put("AREA", this.filtroRelatorioDTO.getArea().getIdArea());
		 
        byte[] relatorio = relatorioUtil.gerarRelatorioWebBytes(params, arquivo);   

        externalContext.setResponseContentType("application/pdf");
        externalContext.getResponseOutputStream().write(relatorio);

        fc.responseComplete();
    }
}