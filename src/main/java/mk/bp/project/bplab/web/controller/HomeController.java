package mk.bp.project.bplab.web.controller;

import mk.bp.project.bplab.model.Magacin;
import mk.bp.project.bplab.model.ProduktSeNaogjaVoMagacin;
import mk.bp.project.bplab.service.IzvrsheniNarachkiService;
import mk.bp.project.bplab.service.ProduktMagacinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    private final ProduktMagacinService service;
    private final IzvrsheniNarachkiService narachkiService;
    public HomeController(ProduktMagacinService service, IzvrsheniNarachkiService narachkiService) {
        this.service = service;
        this.narachkiService = narachkiService;
    }
    
    @GetMapping
    public String Home(Model model){
        model.addAttribute("narachki", narachkiService.findAll());
        model.addAttribute("bodyContent","Home");
        return "master-template";
    }
}
