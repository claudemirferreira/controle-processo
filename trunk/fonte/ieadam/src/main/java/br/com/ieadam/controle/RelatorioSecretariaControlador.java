package br.com.ieadam.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ieadam.dominio.Usuario;
import br.com.ieadam.dto.FiltroRelatorioDTO;
import br.com.ieadam.servico.RelatorioSecretariaServico;

@ManagedBean
@SessionScoped
public class RelatorioSecretariaControlador {

	private FiltroRelatorioDTO filtroRelatorioDTO;
	
	@ManagedProperty(value = "#{relatorioSecretariaServicoImpl}")
	private RelatorioSecretariaServico relatorioSecretariaServico;
	
	@PostConstruct
	public void init() {
		this.filtroRelatorioDTO = new FiltroRelatorioDTO();
		this.filtroRelatorioDTO.setUsuarioLogado(
				(Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}

	public void gerarRelatorio() {
		this.relatorioSecretariaServico.gerarRelatorioSecretaria(this.filtroRelatorioDTO);
	}
	
	public String relatorioSecretaria() {
		return "/pages/relatorio/secretaria/pesquisa.jsf";
	}
	
	public FiltroRelatorioDTO getFiltroRelatorioDTO() {
		return filtroRelatorioDTO;
	}

	public void setFiltroRelatorioDTO(FiltroRelatorioDTO filtroRelatorioDTO) {
		this.filtroRelatorioDTO = filtroRelatorioDTO;
	}

	public RelatorioSecretariaServico getRelatorioSecretariaServico() {
		return relatorioSecretariaServico;
	}

	public void setRelatorioSecretariaServico(
			RelatorioSecretariaServico relatorioSecretariaServico) {
		this.relatorioSecretariaServico = relatorioSecretariaServico;
	}
}
