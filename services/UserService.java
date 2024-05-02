package br.com.portfolio.crud.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.portfolio.crud.entities.User;
import br.com.portfolio.crud.repositories.UserRepository;
import br.com.portfolio.crud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> usuario = repository.findById(id);
		
		return usuario.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	public User insert(User usuario) {
		
		return repository.save(usuario);
	}
	
	public void delete(Long id) {
		
		try {
		  User cadastro = findById(id);
		  repository.deleteById(cadastro.getId());
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
		
	}

	private void updateDados(User cadastro, User usuario) {
		
		cadastro.setNome(usuario.getNome());
		cadastro.setEmail(usuario.getEmail());
		cadastro.setTelefone(usuario.getTelefone());
		
	}

	public User update(Long id, User usuario) {
			
		try {
			User cadastro = findById(id);
			
			updateDados(cadastro, usuario);
	
			return repository.save(cadastro);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	
	}

	
 
}
