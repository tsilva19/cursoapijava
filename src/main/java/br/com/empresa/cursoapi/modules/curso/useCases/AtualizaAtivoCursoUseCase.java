package br.com.empresa.cursoapi.modules.curso.useCases;

import br.com.empresa.cursoapi.modules.curso.CursoEntity;
import br.com.empresa.cursoapi.modules.curso.CursoRepository;
import br.com.empresa.cursoapi.modules.curso.StatusCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AtualizaAtivoCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(Long id) {
        Optional<CursoEntity> optionalCourse = cursoRepository.findById(id);
        if (optionalCourse.isPresent()) {
            CursoEntity curso = optionalCourse.get();
            curso.setActive(!curso.isActive());
            if (curso.isActive()) {
                curso.setStatus(StatusCurso.ACTIVE);
            } else {
                curso.setStatus(StatusCurso.INACTIVE);
            }
            curso.setUpdatedAt(LocalDateTime.now());
            return cursoRepository.save(curso);
        }
        return null; // Tratar caso não encontre o curso com o ID informado
    }
}
