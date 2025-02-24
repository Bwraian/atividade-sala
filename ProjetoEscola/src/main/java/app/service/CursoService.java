package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		this.cursoRepository.save(curso);
		return "Curso salvo com sucesso!";
	}
	
	public String update(long id,Curso curso) {
		curso.setId(id);
		this.cursoRepository.save(curso);
		return "Curso com o ID: " + id + " editado com sucesso!";
	}
	
	public String delete(long id) {
		this.cursoRepository.deleteById(id);
		return "Curso deletado com sucesso!";
	}
	
	public Curso findById(long id) {
		return this.cursoRepository.findById(id).get();
	}
	
	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}
	
	//JPQL Querys
	
	public List<Curso> buscarCursosPeloNome(String nomeCurso) {
        return cursoRepository.findByNomeIgnoreCase(nomeCurso);
    }
}