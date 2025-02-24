package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	public List<Aluno> findByNomeStartingWith(String nome);
	
	public List<Aluno> findByTelefoneContaining(String telefone);
	
	@Query("SELECT a FROM Aluno a WHERE a.turma.nome = :nome")
	public List<Aluno> buscarAlunosPorNomeDaTurma(@Param("nome") String nomeTurma);
	
	public boolean existsByCpf(String cpf);
	
	//@Query("SELECT c FROM Carro c WHERE c.cor = :cor")
	//public List<Aluno> bucarCarroPelaCor(String Cor);
}