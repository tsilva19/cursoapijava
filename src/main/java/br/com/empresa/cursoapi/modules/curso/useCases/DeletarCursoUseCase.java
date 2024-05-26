package br.com.empresa.cursoapi.modules.curso.useCases;

import br.com.empresa.cursoapi.modules.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public void execute(Long id) {
        cursoRepository.deleteById(id);
    }

}
