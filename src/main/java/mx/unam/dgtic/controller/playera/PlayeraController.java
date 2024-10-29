package mx.unam.dgtic.controller.playera;

import jakarta.validation.Valid;
import mx.unam.dgtic.model.Equipo;
import mx.unam.dgtic.model.Marca;
import mx.unam.dgtic.model.Playera;
import mx.unam.dgtic.service.equipo.EquipoServiceImpl;
import mx.unam.dgtic.service.marca.MarcaServiceImpl;
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

import java.util.List;

@Controller
@RequestMapping("/playera")
public class PlayeraController {
    
    @Autowired
    PlayeraServiceImpl playeraService;
    @Autowired
    MarcaServiceImpl marcaService;
    @Autowired
    EquipoServiceImpl equipoService;

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
        List<Equipo> equipos = equipoService.mostrar();
        List<Marca> marcas = marcaService.mostrar();

        model.addAttribute("equipo",equipos);
        model.addAttribute("marca",marcas);
        model.addAttribute("playera",playera);
        return "/playera/alta-playera";
    }

    @PostMapping("/salvar-playera")
    public String salvarPlayera(@Valid @ModelAttribute("playera") Playera playera,
                              BindingResult result,
                              Model model,
                              RedirectAttributes flash) {
        List<Equipo> equipos = equipoService.mostrar();
        List<Marca> marcas = marcaService.mostrar();

        model.addAttribute("equipo",equipos);
        model.addAttribute("marca",marcas);

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
