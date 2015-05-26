package br.com.ieadam.servico;

import java.util.Date;
import java.util.List;

import br.com.ieadam.dominio.LogApp;

public interface LogAppServico {

	public LogApp salvar(LogApp logApp);
	
	public List<LogApp> listarTodos();	
	
	public List<LogApp> listarPorUsuario(int idUsuario);
	
	public List<LogApp> listarPorFiltros(String nomeUsuario, Date dataInicio, Date dataFim);
}
