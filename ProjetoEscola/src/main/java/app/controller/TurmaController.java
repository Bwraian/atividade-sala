package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Aluno;
import app.entity.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController{
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma){
		try {
			String mensagem = this.turmaService.save(turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Turma turma){
		try {
			String mensagem = this.turmaService.update(id, turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			String mensagem = this.turmaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id){
		try {
			Turma turma = this.turmaService.findById(id);
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll(){
		try {
			List<Turma> turmaAll = this.turmaService.findAll();
			return new ResponseEntity<>(turmaAll, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/entre-anos")
    public List<Turma> buscarTurmasEntreAnos(@RequestParam int anoInicio, @RequestParam int anoFim) {
        return turmaService.buscarTurmasEntreAnos(anoInicio, anoFim);
    }
	
	@GetMapping("/por-semestre-e-ano")
    public List<Turma> buscarTurmasPorSemestreEAno(@RequestParam String semestre, @RequestParam int ano) {
        return turmaService.buscarTurmasPorSemestreEAno(semestre, ano);
    }
	
	@GetMapping("/por-nome-e-turno")
    public List<Turma> buscarTurmasPorNomeETurno(@RequestParam String nome, @RequestParam String turno) {
        return turmaService.buscarTurmasPorNomeETurno(nome, turno);
    }
	
	@GetMapping("/findByNomeCurso/{curso}")
	public ResponseEntity<List<Turma>> findByNomeCurso(@PathVariable String curso){
		try {
			List<Turma> turma = this.turmaService.buscarTurmasPeloNomeDoCurso(curso);
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}