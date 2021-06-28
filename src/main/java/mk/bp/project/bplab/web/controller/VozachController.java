package mk.bp.project.bplab.web.controller;

import mk.bp.project.bplab.service.VozachService;
import mk.bp.project.bplab.service.VozachiService;
import mk.bp.project.bplab.service.VoziloService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

@Controller
@RequestMapping("/vozach")
public class VozachController {
    private final VozachiService service;
    private final VoziloService voziloService;
    private final VozachService vozachService;
    
    public VozachController(VozachiService service, VoziloService voziloService, VozachService vozachService) {
        this.service = service;
        this.voziloService = voziloService;
        this.vozachService = vozachService;
    }
    
    @GetMapping
    public String list(Model model){
        model.addAttribute("vozachi",service.findAll());
        model.addAttribute("bodyContent", "listVozachi");
        return "master-template";
    }
    
    @GetMapping("/{id}")
    public String vozila(@PathVariable String id, Model model){
        model.addAttribute("vozila", voziloService.findById(vozachService.findById(id).get()));
        model.addAttribute("idVozach", id);
        model.addAttribute("bodyContent","vozilaNaVozach");
        return "master-template";
    }
    @GetMapping("/dodadi")
    public String dodadi(Model model){
        model.addAttribute("bodyContent", "dodadiVozach");
        return "master-template";
    }
    @PostMapping("/dodadi")
    public String dodadi(@RequestParam String ime,
            @RequestParam String prezime,
            @RequestParam String embg,
            @RequestParam String dozvola,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date vazhnost,
            Model model) throws SQLException {
        vozachService.saveVozach(ime,prezime,embg,dozvola,vazhnost);
        return "redirect:/vozach";
    }
    
    @GetMapping("/dodadi/{id}")
    public String dodadiVozilo(@PathVariable String id, Model model){
        model.addAttribute("vozach", id);
        model.addAttribute("bodyContent", "dodadiVozilo");
        return "master-template";
    }
    @PostMapping("/dodadi/{id}")
    public String dodadiVozilo(@PathVariable String id,
                               @RequestParam String registracija,
                         @RequestParam String modelv,
                         @RequestParam String sostojba,
                         @RequestParam BigDecimal kapacitet,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date servis,
                         Model model) throws SQLException {
        voziloService.saveVozilo(id,registracija,modelv,sostojba,kapacitet,servis);
        return "redirect:/vozach";
    }
}
