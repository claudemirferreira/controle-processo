package br.com.ieadam.repositorio;

import java.util.List;

import br.com.ieadam.dominio.Congregacao;
import br.com.ieadam.dominio.Zona;

public interface CongregacaoRepositorioSql {

	public List<Congregacao> listaCongregacaoToZona(Zona zona);

}