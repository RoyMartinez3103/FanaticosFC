package mx.unam.dgtic.controller.playera;

import jakarta.validation.Valid;
import mx.unam.dgtic.model.Playera;
import mx.unam.dgtic.service.playera.PlayeraServiceImpl;
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
@RequestMapping("/playera")
public class PlayeraController {
    
    @Autowired
    PlayeraServiceImpl playeraService;

    @GetMapping("/lista-playera")
    public String listaPlayera(@RequestParam(name = "page",defaultValue = "0")Integer page,
                             @RequestParam(name = "size", defaultValue = "20") Integer size,
                             Model model){
        Pageable pageable = PageRequest.of(page,size);

        Page<Playera> playeras = playeraService.listarTodos(pageable);
        RenderPagina<Playera> renderPagina = new RenderPagina<>("lista-playera",playeras);

        model.addAttribute("playera",playeras);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Playeras");
        return "/playera/lista-playera";
    }

    @GetMapping("/alta-playera")
    public String altaPlayera(Model model){
        Playera playera = new Playera();
        model.addAttribute("contenido","Agregar nueva playera");
        model.addAttribute("playera",playera);
        return "/playera/alta-playera";
    }

    @PostMapping("/salvar-playera")
    public String salvarPlayera(@Valid @ModelAttribute("playera") Playera playera,
                              BindingResult result,
                              Model model,
                              RedirectAttributes flash) {

        if (result.hasErrors()) {
            model.addAttribute("contenido", "ERROR. No debe ser vacío");
            return "/playera/alta-playera";
        }

        playeraService.guardar(playera);
        System.out.println(playera);
        flash.addFlashAttribute("success", "La playera se guardó correctamente");

        return "redirect:/playera/lista-playera";
    }
    
}
