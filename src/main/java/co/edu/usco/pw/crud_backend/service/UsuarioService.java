package co.edu.usco.pw.crud_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usco.pw.crud_backend.model.Usuario;
import co.edu.usco.pw.crud_backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> obtenerTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario actualizarUsuario(Long id, Usuario usuarioDetalles) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		usuario.setNombre(usuarioDetalles.getNombre());
		usuario.setEmail(usuarioDetalles.getEmail());
		usuario.setTelefono(usuarioDetalles.getTelefono());
		return usuarioRepository.save(usuario);
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}
