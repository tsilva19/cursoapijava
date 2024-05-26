package br.com.empresa.cursoapi.modules.curso.useCases;


import br.com.empresa.cursoapi.modules.curso.CursoEntity;
import br.com.empresa.cursoapi.modules.curso.CursoRepository;
import br.com.empresa.cursoapi.modules.curso.StatusCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoEntity execute(String name, String category) {
        CursoEntity course = new CursoEntity();
        course.setName(name);
        course.setCategory(category);
        course.setActive(true); // Novos cursos são criados como ativos
        course.setStatus(StatusCurso.ACTIVE);
        return cursoRepository.save(course);
    }


}
