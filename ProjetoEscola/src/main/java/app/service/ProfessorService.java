package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		 if (professorRepository.existsByEmail(professor.getEmail())) {
	            throw new RuntimeException("Email já cadastrado!");
	        }

	        if (professor.getEmail().contains("@outlook.com")) {
	            throw new RuntimeException("Domínio de e-mail não permitido");
	        }
		
		this.professorRepository.save(professor);
		return "Professsor salvo com sucesso!";
		
	}
	
	public String update(long id, Professor professor) {
		professor.setId(id);
		this.professorRepository.save(professor);
		return "Professor com o ID: " + id + " editado com sucesso!";
	}
	
	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "Professor deletado com sucesso!";
	}
	
	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}
	
	public List<Professor> findAll() {
		return this.professorRepository.findAll();
	}
	
	public List<Professor> findByNomeOrEspecialidade(String nome, String especialidade){
		return this.professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
	}
	
	public List<Professor> findBybuscarProfessoresSemGmail(){
		return this.professorRepository.buscarProfessoresSemGmail();
	}
	
	public List<Professor> findBybuscarProfessoresEmailExato(String email){
		return this.professorRepository.buscarProfessoresEmailExato(email);
	}
	
}