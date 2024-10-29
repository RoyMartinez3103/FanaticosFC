package mx.unam.dgtic.controller.marca;


import mx.unam.dgtic.model.Marca;
import mx.unam.dgtic.service.marca.MarcaServiceImpl;
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
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    MarcaServiceImpl marcaService;
    
    @GetMapping("/lista-marca")
    public String listaMarca(@RequestParam(name = "page",defaultValue = "0")Integer page,
                              @RequestParam(name = "size", defaultValue = "20") Integer size,
                              Model model){
        Pageable pageable = PageRequest.of(page,size);

        Page<Marca> marcas = marcaService.listarTodos(pageable);
        RenderPagina<Marca> renderPagina = new RenderPagina<>("lista-marca",marcas);

        model.addAttribute("marca",marcas);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Marcas");
        return "/marca/lista-marca";
    }

    @GetMapping("/alta-marca")
    public String altaMarca(Model model){
        Marca marca = new Marca();
        model.addAttribute("contenido","Agregar nueva marca");
        model.addAttribute("marca",marca);
        return "/marca/alta-marca";
    }

    @PostMapping("/salvar-marca")
    public String salvarMarca(@ModelAttribute("marca") Marca marca,
                               BindingResult result,
                               Model model,
                               RedirectAttributes flash) {

        if (result.hasErrors()) {
            model.addAttribute("contenido", "ERROR. No debe ser vacío");
            return "/marca/alta-marca";
        }

        marcaService.guardar(marca);
        System.out.println(marca);
        flash.addFlashAttribute("success", "El marca se guardó correctamente");

        return "redirect:/marca/lista-marca";
    }
}
