package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository AlunoRepository;	
	
	public String save(Aluno aluno) {
		
		 if (AlunoRepository.existsByCpf(aluno.getCpf())) {
	            throw new RuntimeException("CPF já cadastrado!");
	        }
		 
		 if (aluno.getTelefone() == null) {
	            aluno.setCadastrocompleto(false);
	        } else {
	            aluno.setCadastrocompleto(false);
	        }
		this.AlunoRepository.save(aluno);
		return "Aluno Salvo com sucesso!";
	}
	
	public String update(long id,Aluno aluno) {
		
		Aluno alunoExistente = AlunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

		if (!alunoExistente.getCpf().equals(aluno.getCpf()) && AlunoRepository.existsByCpf(aluno.getCpf())) {
	            throw new RuntimeException("CPF já cadastrado!");
	        }
		
		aluno.setId(id);
		this.AlunoRepository.save(aluno);
		return "Aluno com o ID: " + id + " editado com sucesso!";
	}
	
	public String delete(long id) {
		this.AlunoRepository.deleteById(id);
		return "Aluno deletado com sucesso!";
	}
	
	public Aluno findById(long id) {
		return this.AlunoRepository.findById(id).get();
	}
	
	public List<Aluno> findAll() {
		return this.AlunoRepository.findAll();
	}
	
	public List<Aluno> findByFirstnameStartingWith(String nomeAluno){
		return this.AlunoRepository.findByNomeStartingWith(nomeAluno);
	}
	
	public List<Aluno> findByTelefoneContaining(String telefone){
		return this.AlunoRepository.findByTelefoneContaining(telefone);
	}
	
	public List<Aluno> findByNomeTurma(String turma){
		return this.AlunoRepository.buscarAlunosPorNomeDaTurma(turma);
	}
	
}