package mx.unam.dgtic.controller.usuario;

import jakarta.validation.Valid;
import mx.unam.dgtic.model.Usuario;
import mx.unam.dgtic.service.usuario.UsuarioServiceImpl;
import mx.unam.dgtic.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista-usuario")
    public String listaUsuario(@RequestParam(name = "page",defaultValue = "0")Integer page,
                             @RequestParam(name = "size", defaultValue = "20") Integer size,
                             Model model){
        Pageable pageable = PageRequest.of(page,size);

        Page<Usuario> usuarios = usuarioService.listarTodos(pageable);
        RenderPagina<Usuario> renderPagina = new RenderPagina<>("lista-usuario",usuarios);

        model.addAttribute("usuario",usuarios);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Usuarios");
        return "/usuario/lista-usuario";
    }

    @GetMapping("/alta-usuario")
    public String altaUsuario(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("contenido","Agregar nueva usuario");
        model.addAttribute("usuario",usuario);
        return "/usuario/alta-usuario";
    }

    @PostMapping("/salvar-usuario")
    public String salvarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                              BindingResult result,
                              Model model,
                              RedirectAttributes flash) {

        if (result.hasErrors()) {
            model.addAttribute("contenido", "ERROR. No debe ser vacío");
            return "/usuario/alta-usuario";
        }

        usuarioService.guardar(usuario);
        System.out.println(usuario);
        flash.addFlashAttribute("success", "El usuario se guardó correctamente");

        return "redirect:/usuario/lista-usuario";
    }
}

