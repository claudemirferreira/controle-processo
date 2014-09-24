package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Area;
import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Nucleo;
import br.com.ieadam.dominio.Zona;

public interface MembroRepositorioSql {

	public List<Membro> pesquisaAvancada(Zona zona, Nucleo nucleo, Area area,
			Congregacao congregacao, Membro membro);
	
	public List<Membro> pesquisar(Membro membro, Congregacao congregacao);

}