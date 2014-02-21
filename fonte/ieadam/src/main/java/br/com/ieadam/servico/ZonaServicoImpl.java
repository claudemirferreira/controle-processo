package br.com.ieadam.servico;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ieadam.dominio.Membro;
import br.com.ieadam.dominio.Zona;
import br.com.ieadam.repositorio.ZonaRepositorio;

@Service
public class ZonaServicoImpl implements ZonaServico, Serializable {

	private static final long serialVersionUID = -5220391642354623929L;

	@Autowired
	private ZonaRepositorio zonaRepositorio;

	@Override
	public List<Zona> listarTodos() {
		return this.zonaRepositorio.findAll();
	}

	@Override
	public Zona salvar(Zona zona) {
		return this.zonaRepositorio.save(zona);
	}

	@Override
	public void remover(Zona zona) {
		this.zonaRepositorio.delete(zona);

	}

	@Override
	public List<Zona> findByMembro(Membro membro) {
		return this.zonaRepositorio.findByMembro(membro);
	}
}