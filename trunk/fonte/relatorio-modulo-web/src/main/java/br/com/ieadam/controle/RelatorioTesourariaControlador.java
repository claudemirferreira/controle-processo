package br.com.ieadam.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.RelatorioTesourariaServico;

@ManagedBean
@SessionScoped
public class RelatorioTesourariaControlador {

	private FiltroRelatorioDTO filtroRelatorioDTO;
	
	@ManagedProperty(value = "#{relatorioTesourariaServicoImpl}")
	private RelatorioTesourariaServico relatorioTesourariaServico;
	
	@PostConstruct
	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();
		this.filtroRelatorioDTO.setUsuarioLogado(
				(Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}

	public void gerarRelatorio() {
		this.relatorioTesourariaServico.gerarRelatorioTesouraria(this.filtroRelatorioDTO);
	}

	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}

	public RelatorioTesourariaServico getRelatorioTesourariaServico() {
		return relatorioTesourariaServico;
	}

	public void setRelatorioTesourariaServico(
			RelatorioTesourariaServico relatorioTesourariaServico) {
		this.relatorioTesourariaServico = relatorioTesourariaServico;
	}
}
