package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return "Turma salvo com sucesso!";
	}
	
	public String update(long id, Turma turma) {
		turma.setId(id);
		this.turmaRepository.save(turma);
		return "Turma com o ID: " + id + " editado com sucesso!";
	}
	
	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "Turma deletado com sucesso!";
	}
	
	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}
	
	public List<Turma> findAll() {
		return this.turmaRepository.findAll();
	}
	
	//JPQL Repositorio 
	
	public List<Turma> buscarTurmasEntreAnos(int anoInicio, int anoFim) {
        return turmaRepository.findByAnoBetween(anoInicio, anoFim);
    }
	
	public List<Turma> buscarTurmasPorSemestreEAno(String semestre, int ano) {
        return turmaRepository.findBySemestreAndAno(semestre, ano);
    }
	
	public List<Turma> buscarTurmasPorNomeETurno(String nome, String turno) {
        return turmaRepository.findByNomeAndTurno(nome, turno);
    }
	
	public List<Turma> buscarTurmasPeloNomeDoCurso(String nomeCurso) {
        return turmaRepository.findByNomeCurso(nomeCurso);
    }
}