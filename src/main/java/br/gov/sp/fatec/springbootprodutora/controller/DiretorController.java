package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

/*Anotações breves... alguns métodos precisam ser melhorados junto com as view para que seja exibido os dados
de filmagem participadas e dirigidas */

@RestController
@RequestMapping(value = "/diretor")
@CrossOrigin

public class DiretorController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Diretor.class)
    @GetMapping
    public List<Diretor> buscarTodos()
    {
        return produtoraService.buscarTodosDiretores();
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value="/id/{id}")
    public Diretor buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarDiretorPorId(id);
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value = "/nome/{nome}")
    public Diretor buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDiretorPorNome(nome);
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Diretor> buscaDiretorPorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDiretorPorLetra(nome);
    }
}