package br.com.ieadam.servico;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Zona;

public interface CongregacaoServico {

	public List<Congregacao> listarTodos();

	public Congregacao salvar(Congregacao congregacao);

	public void remover(Congregacao congregacao);

	public List<Congregacao> findByArea(Area area);
	
	public List<Congregacao> listaCongregacaoToZona(Zona zona);

}