package br.com.empresa.cursoapi.modules.curso.controller;

import br.com.empresa.cursoapi.modules.curso.CursoEntity;
import br.com.empresa.cursoapi.modules.curso.dto.CursoDTO;
import br.com.empresa.cursoapi.modules.curso.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CreateCursoUseCase createCursoUseCase;

    @Autowired
    private ListAllCursoUseCase listAllCursoUseCase;

    @Autowired
    private ListaCursoUseCase listaCursoUseCase;

    @Autowired
    private AtualizarCursoUseCase atualizarCursoUseCase;

    @Autowired
    private DeletarCursoUseCase deletarCursoUseCase;

    @Autowired
    private AtualizaAtivoCursoUseCase atualizaAtivoCursoUseCase;

    @PostMapping
    public ResponseEntity<CursoEntity> createCourse(@Valid @RequestBody CursoDTO cursoDTO) {
        CursoEntity course = createCursoUseCase.execute(cursoDTO.getName(), cursoDTO.getCategory());
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping
    public ResponseEntity<List<CursoEntity>> getAllCourses() {
        List<CursoEntity> courses = listAllCursoUseCase.execute();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CursoEntity>> searchCourses(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        List<CursoEntity> courses = listaCursoUseCase.execute(name, category);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoEntity> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CursoDTO cursoDTO) {
        CursoEntity course = atualizarCursoUseCase.execute(id, cursoDTO.getName(), cursoDTO.getCategory());
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        deletarCursoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CursoEntity> toggleCourseActive(@PathVariable Long id) {
        CursoEntity course = atualizaAtivoCursoUseCase.execute(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

}
