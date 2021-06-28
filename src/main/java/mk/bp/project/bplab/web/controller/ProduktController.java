package mk.bp.project.bplab.web.controller;

import mk.bp.project.bplab.service.ProduktService;
import mk.bp.project.bplab.service.ProduktiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;

@Controller
@RequestMapping("/produkt")
public class ProduktController {
    private final ProduktiService service;
    private final ProduktService produktService;
    public ProduktController(ProduktiService service, ProduktService produktService) {
        this.service = service;
        this.produktService = produktService;
    }
    
    @GetMapping()
    public String list(Model model){
        model.addAttribute("produkti",service.findAll());
        model.addAttribute("bodyContent", "listProdukti");
        return "master-template";
    }
    @GetMapping("/cena/{id}")
    public String cena(@PathVariable Integer id, Model model){
        model.addAttribute("produkt", id);
        model.addAttribute("bodyContent", "promeniCena");
        return "master-template";
    }
    
    @PostMapping("/cena/{id}")
    public String cena(@PathVariable Integer id,@RequestParam BigDecimal cena, Model model) throws SQLException {
        produktService.changeCena(id, cena);
        model.addAttribute("bodyContent", "promeniCena");
        return "master-template";
    }
    
    @GetMapping("/dodadi")
    public String dodadu(Model model){
        model.addAttribute("bodyContent", "dodadiProdukt");
        return "master-template";
    }
    
    @PostMapping("/dodadi")
    public String dodadu(@RequestParam String ime,
                         @RequestParam String proizvoditel,
                         @RequestParam Integer kolicina,
                         @RequestParam BigDecimal tezina,
                         @RequestParam BigDecimal cena, Model model) throws SQLException {
        produktService.saveProdukt(ime,proizvoditel,kolicina,tezina,cena);
        return "redirect:/produkt";
    }
    
    
}
