package br.com.ieadam.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.LogApp;
import br.com.ieadam.repositorio.LogAppRepositorio;
import br.com.ieadam.repositorio.LogAppRepositorioSql;

@Service
public class LogAppServicoImpl implements LogAppServico {

	@Autowired
	private LogAppRepositorio repositorio;
	
	@Autowired
	private LogAppRepositorioSql repositorioSql;

	public LogApp salvar(LogApp logApp) {
		return this.repositorio.save(logApp);
	}

	@Override
	public List<LogApp> listarTodos() {
		return this.repositorio.findAll();
	}

	@Override
	public List<LogApp> listarPorUsuario(int idUsuario) {
		return this.repositorio.findByUsuario(idUsuario);
	}

	public List<LogApp> listarPorFiltros(String nomeUsuario, Date dataInicio, Date dataFim) {
//		return this.repositorio.findByFiltros(nomeUsuario, dataInicio, dataFim);
		return this.repositorioSql.listarLogByFiltros(nomeUsuario, dataInicio, dataFim);
	}
}