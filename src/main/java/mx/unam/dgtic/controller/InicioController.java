package mx.unam.dgtic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InicioController {

    @Value("${spring.application.name}")
    String nombreApp;

    @GetMapping("/")
    public String inicioPagina(Model model) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("nombreAplicacion", nombreApp);
        model.addAttribute("fecha", formato.format(new Date()));
        return "layout/layout";
    }

    @GetMapping("/inicio")
    public String inicioPrincipal(Model model) {
        model.addAttribute("contenido", "Agregar código para Tu HTML");
        model.addAttribute("fecha", "No hay fecha");
        model.addAttribute("nombreAplicacion", "Se cambia");
        return "login";
    }
}
