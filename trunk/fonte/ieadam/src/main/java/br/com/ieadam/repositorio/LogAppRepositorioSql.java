package br.com.ieadam.repositorio;

import java.util.Date;
import java.util.List;

import br.com.ieadam.dominio.LogApp;

public interface LogAppRepositorioSql {
	
	public List<LogApp> listarLogByFiltros(String nomeUsuario, Date dataInicio, Date dataFim);

}