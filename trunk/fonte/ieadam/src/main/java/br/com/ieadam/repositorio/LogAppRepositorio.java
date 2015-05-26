package br.com.ieadam.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ieadam.dominio.LogApp;

public interface LogAppRepositorio extends JpaRepository<LogApp, Long> {

	@Query("select l from LogApp l where l.usuario.idUsuario = :usuario")
	public List<LogApp> findByUsuario(@Param("usuario") int usuario);
	
	@Query("select l from LogApp l, Usuario u where l.usuario.idUsuario = u.idUsuario and u.nome like :usuario "
			+ "and l.dataHoraAcao between :dataInicio and :dataFim")
	public List<LogApp> findByFiltros(@Param("usuario") String nome, 
			@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim);
	
}