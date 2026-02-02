package TesteProjetoAPI.TesteProjetoAPI_1.repository;

import TesteProjetoAPI.TesteProjetoAPI_1.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}