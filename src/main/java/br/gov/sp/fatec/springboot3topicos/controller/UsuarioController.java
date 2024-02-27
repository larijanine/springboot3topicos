package br.gov.sp.fatec.springboot3topicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3topicos.entity.Usuario;
import br.gov.sp.fatec.springboot3topicos.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    //getmapping significa que quando buscar /usuario, ja cai nesse metodo
    @GetMapping
    public List<Usuario> buscarTodosUsuarios() {
        return service.buscarTodosUsuarios();
    }

    @PostMapping
    public Usuario cadastrarNovoUsuario(@RequestBody Usuario usuario) {
        return service.cadastraUsuario(usuario);
    }

    //o value na frente passa o proximo parametro da rota /usuario/{id}
    @GetMapping(value = "/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable("id") Long id) {
        return service.buscarUsuarioPorId(id);
    }


}
