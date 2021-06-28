package mk.bp.project.bplab.web.controller;

import mk.bp.project.bplab.model.view.MagacinProdukt;
import mk.bp.project.bplab.repository.ProduktiVoMagacinRepository;
import mk.bp.project.bplab.service.GradService;
import mk.bp.project.bplab.service.MagacinService;
import mk.bp.project.bplab.service.ProduktMagacinService;
import mk.bp.project.bplab.service.SingleMagacinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/magacin")
public class MagacinController {
    private final MagacinService service;
    private final ProduktMagacinService produktMagacinService;
    private final SingleMagacinService sMagacinService;
    private final GradService gradService;
    
    public MagacinController(MagacinService service, ProduktMagacinService produktMagacinService, SingleMagacinService sMagacinService, GradService gradService, ProduktiVoMagacinRepository produktiVoMagacinRepository) {
        this.service = service;
        this.produktMagacinService = produktMagacinService;
        this.sMagacinService = sMagacinService;
        this.gradService = gradService;
    }
    
    
    @GetMapping
    public String list(Model model){
        model.addAttribute("magacini", service.findAll());
        model.addAttribute("bodyContent", "ListMagacin");
        return "master-template";
    }
    @GetMapping("/{id}")
    public String list(@PathVariable Integer id, Model model){
        List<MagacinProdukt> ps = produktMagacinService.findByMagacin(id);
        model.addAttribute("magacinId", id);
        model.addAttribute("produkti",produktMagacinService.findByMagacin(id));
        model.addAttribute("bodyContent", "listProduktiMagacin");
        return "master-template";
    }
    @GetMapping("/dodadi")
    public String dodadi(Model model){
        model.addAttribute("gradovi", gradService.findAll());
        model.addAttribute("bodyContent", "dodadiMagacin");
        return "master-template";
    }
    @PostMapping("/dodadi")
    public String dodadi(@RequestParam String adresa, @RequestParam Integer grad, Model model) throws SQLException {
        sMagacinService.saveMagacin(adresa, gradService.findById(grad).get());
        return "redirect:/magacin";
    }
    
    @GetMapping("/kolicina")
    public String kolicina(@RequestParam Integer idMagacin,@RequestParam Integer idProdukt, Model model){
        model.addAttribute("idMagacin", idMagacin);
        model.addAttribute("idProdukt", idProdukt);
        model.addAttribute("bodyContent", "promeniKolicina");
        return "master-template";
    }
    
    @PostMapping("/kolicina")
    public String kolicina(@RequestParam Integer idMagacin,@RequestParam Integer idProdukt, @RequestParam Integer kolicina, Model model) throws SQLException {
        produktMagacinService.saveProdukt(idProdukt, idMagacin,kolicina);
        return "redirect:/magacin/" + idMagacin.toString();
    }
}
