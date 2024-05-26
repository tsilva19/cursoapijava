package br.com.empresa.cursoapi.modules.curso.useCases;

import br.com.empresa.cursoapi.modules.curso.CursoEntity;
import br.com.empresa.cursoapi.modules.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AtualizarCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(Long id, String name, String category) {
        Optional<CursoEntity> optionalCourse = cursoRepository.findById(id);
        if (optionalCourse.isPresent()) {
            CursoEntity curso = optionalCourse.get();
            if (name != null) {
                curso.setName(name);
            }
            if (category != null) {
                curso.setCategory(category);
            }
            curso.setUpdatedAt(LocalDateTime.now());
            return cursoRepository.save(curso);
        }
        return null; // Tratar caso não encontre o curso com o ID informado
    }

}
