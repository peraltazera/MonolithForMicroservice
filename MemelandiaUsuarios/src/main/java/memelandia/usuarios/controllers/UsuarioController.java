package memelandia.usuarios.controllers;


import memelandia.usuarios.core.Usuario;
import memelandia.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        return service.insertUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable String id) {
        return service.findById(id);
    }
}
