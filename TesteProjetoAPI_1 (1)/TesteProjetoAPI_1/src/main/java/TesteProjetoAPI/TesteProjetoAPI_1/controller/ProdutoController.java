package TesteProjetoAPI.TesteProjetoAPI_1.controller;

import TesteProjetoAPI.TesteProjetoAPI_1.model.ProdutoEntity;
import TesteProjetoAPI.TesteProjetoAPI_1.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoEntity> listarTodos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public ProdutoEntity criarProduto(@RequestBody @Valid ProdutoEntity produtoEntity) {
        return produtoRepository.save(produtoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoEntity dadosAtualizados) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProdutoEntity produtoEntity = produtoOptional.get();
        produtoEntity.setNome(dadosAtualizados.getNome());
        produtoEntity.setDescricao(dadosAtualizados.getDescricao());
        produtoEntity.setPreco(dadosAtualizados.getPreco());
        produtoEntity.setEstoque(dadosAtualizados.getEstoque());

        ProdutoEntity produtoEntitySalvo = produtoRepository.save(produtoEntity);
        return ResponseEntity.ok(produtoEntitySalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
