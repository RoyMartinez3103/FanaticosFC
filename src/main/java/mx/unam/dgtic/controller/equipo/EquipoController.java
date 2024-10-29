package mx.unam.dgtic.controller.equipo;

import mx.unam.dgtic.model.Equipo;
import mx.unam.dgtic.service.equipo.EquipoServiceImpl;
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
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    EquipoServiceImpl equipoService;

    @GetMapping("/lista-equipo")
    public String listaEquipo(@RequestParam(name = "page",defaultValue = "0")Integer page,
                              @RequestParam(name = "size", defaultValue = "20") Integer size,
                              Model model){
        Pageable pageable = PageRequest.of(page,size);

        Page<Equipo> equipos = equipoService.listarTodos(pageable);
        RenderPagina<Equipo> renderPagina = new RenderPagina<>("lista-equipo",equipos);

        model.addAttribute("equipo",equipos);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Equipos");
        return "/equipo/lista-equipo";
    }

    @GetMapping("/alta-equipo")
    public String altaEquipo(Model model){
        Equipo equipo = new Equipo();
        model.addAttribute("contenido","Agregar nuevo equipo");
        model.addAttribute("equipo",equipo);
        return "/equipo/alta-equipo";
    }

    @PostMapping("/salvar-equipo")
    public String salvarEquipo(@ModelAttribute("equipo") Equipo equipo,
                               BindingResult result,
                               Model model,
                               RedirectAttributes flash){
        if(result.hasErrors()){
            model.addAttribute("contenido","ERROR. No debe ser vacío");
            return "/equipo/alta-equipo";
        }

        equipoService.guardar(equipo);
        System.out.println(equipo);
        flash.addFlashAttribute("success", "El equipo se guardó correctamente");

        return "redirect:/equipo/lista-equipo";
    }


}
