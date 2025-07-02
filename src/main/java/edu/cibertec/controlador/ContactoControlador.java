package edu.cibertec.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.modelo.Contacto;
import edu.cibertec.modelo.Tipo;
import edu.cibertec.modelo.Usuario;

@RestController
@RequestMapping("/api/contactos")
public class ContactoControlador {

	List<Contacto> contactos = new ArrayList<Contacto>();
	
	public ContactoControlador() {
		contactos.add(new Contacto(1, "Miguel Grau","911111111","mg@correo.com",new Tipo(2, "Trabajo"),new Usuario(1,"Yo")));
		contactos.add(new Contacto(2, "Cesar Vallejo","922222222","cv@correo.com",new Tipo(1, "Familiar"),new Usuario(1,"Yo")));
		contactos.add(new Contacto(3, "Alfonso Ugarte","933333333","au@correo.com",new Tipo(1, "Familiar"),new Usuario(2,"Tu")));
		contactos.add(new Contacto(4, "Fco. Bolognesi","944444444","fb@correo.com",new Tipo(2, "Trabajo"),new Usuario(1,"Yo")));
	}
	
	@GetMapping
	public List<Contacto> listar(){
		return contactos;
	}
	
	@GetMapping("/{id}")
	public Contacto obtenerPorId(@PathVariable int id) {
		for (Contacto contacto : contactos) {
			if (contacto.getId()==id)
				return contacto;
		}
		return null;
	}
	
	@PostMapping
	public void crear(@RequestBody Contacto contacto) {
		contactos.add(contacto);
	}
	@PutMapping("/{id}")
	public void actualizar(@PathVariable int id,@RequestBody Contacto contacto) {
		for (Contacto c : contactos) {
			if (c.getId()==id) {
				c.setNombre(contacto.getNombre());
				c.setTelefono(contacto.getTelefono());
				c.setEmail(contacto.getEmail());
				break;
			}
		}
	}
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		int posicion=-1;
		for (Contacto contacto : contactos) {
			if (contacto.getId()==id) {
				posicion=contactos.indexOf(contacto);
				break;
			}
		}
		if (posicion>=0)
			contactos.remove(posicion);
		
	}
	@GetMapping("/tipo/{idTipo}")
	public List<Contacto> listarPorTipo(@PathVariable int idTipo) {
		List<Contacto> lista = new ArrayList<Contacto>();
		for (Contacto contacto : contactos) {
			if (contacto.getTipo().getId()==idTipo)
				lista.add(contacto);
		}
		return lista;
	}
	@GetMapping("/usuario/{idUsuario}")
	public List<Contacto> listarPorUsuario(@PathVariable int idUsuario) {
		List<Contacto> lista = new ArrayList<Contacto>();
		for (Contacto contacto : contactos) {
			if (contacto.getUsuario().getId()==idUsuario)
				lista.add(contacto);
		}
		return lista;
	}

}
