package br.com.empresa.cursoapi.modules.curso.useCases;

import br.com.empresa.cursoapi.modules.curso.CursoEntity;
import br.com.empresa.cursoapi.modules.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> execute() {
        return cursoRepository.findAll();
    }

}
