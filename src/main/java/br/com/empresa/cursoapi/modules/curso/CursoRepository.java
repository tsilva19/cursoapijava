package br.com.empresa.cursoapi.modules.curso;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    List<CursoEntity> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);
}
