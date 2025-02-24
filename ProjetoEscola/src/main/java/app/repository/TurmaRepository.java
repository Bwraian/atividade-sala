package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Aluno;
import app.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	public List<Turma> findByAnoBetween(int anoInicio, int anoFim);
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano);
	
	public List<Turma> findByNomeAndTurno(String nome, String turno);
	
	@Query("SELECT t FROM Turma t WHERE t.curso.nome = :nome")
	public List<Turma> findByNomeCurso(@Param("nome") String nomeCurso);
	
}