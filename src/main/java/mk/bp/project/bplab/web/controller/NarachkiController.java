package mk.bp.project.bplab.web.controller;

import mk.bp.project.bplab.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/narachki")
public class NarachkiController {
    private final IzvrsheniNarachkiService narachkiService;
    private final NeizvrsheniNarachkiService neizvrsheniNarachkiService;
    private final MagacinService magacinService;
    private final SingleMagacinService sMagacinService;
    private final VoziloService voziloService;
    private final VozachService vozachService;
    private final NarachaniProduktiService narachaniProduktiService;
    
    public NarachkiController(IzvrsheniNarachkiService narachkiService, NeizvrsheniNarachkiService neizvrsheniNarachkiService, MagacinService magacinService, SingleMagacinService sMagacinService, VoziloService voziloService, VozachService vozachService, NarachaniProduktiService narachaniProduktiService) {
        this.narachkiService = narachkiService;
        this.neizvrsheniNarachkiService = neizvrsheniNarachkiService;
        this.magacinService = magacinService;
        this.sMagacinService = sMagacinService;
        this.voziloService = voziloService;
        this.vozachService = vozachService;
        this.narachaniProduktiService = narachaniProduktiService;
    }
    
    @GetMapping
    public String list(Model model) throws SQLException {
        model.addAttribute("narachki", narachkiService.findIzvrsheni());
        neizvrsheniNarachkiService.updateView();
        model.addAttribute("bodyContent","listNarachki");
        return "master-template";
    }
    
    @GetMapping("/narachaj")
    public String narachaj(Model model){
        model.addAttribute("magacini", magacinService.findAll());
        model.addAttribute("bodyContent","narachaj");
        return "master-template";
    }
    @GetMapping("/votek")
    public String narachkiVoTek(Model model){
        model.addAttribute("narachki", narachkiService.findNeizvrsheni());
        model.addAttribute("bodyContent","listNarachki");
            return "master-template";
    }
    @PostMapping("/narachka")
    public String izvrshiNarachka(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dostavaDo,
            @RequestParam(required = false) Integer izvoz,
            @RequestParam(required = false)  Integer uvoz,
            @RequestParam(required = false) Integer[] produkt,
            @RequestParam(required = false) Integer[] kolicina, Model model) throws SQLException {
        
        neizvrsheniNarachkiService.narachaj(dostavaDo, sMagacinService.findById(izvoz).get(), sMagacinService.findById(uvoz).get(),"NEDOSTAVENA", produkt, kolicina);
        model.addAttribute("bodyContent", "Home");
        return "master-template";
    }
    @GetMapping("/izvrshi/{id}")
    public String izvrshiNarachka(@PathVariable Integer id, Model model){
        model.addAttribute("NarachkaId", id);
        model.addAttribute("vozachi", vozachService.findAll());
        model.addAttribute("vozila",voziloService.findAll());
        model.addAttribute("bodyContent", "izberiVozach");
        return "master-template";
    }
    @PostMapping("/izvrshi")
    public String potvrdiNarachka( @RequestParam Integer narachka,
                                   @RequestParam String embg,
                                   @RequestParam String registracija) throws SQLException {
        neizvrsheniNarachkiService.izvrshiNarachka(narachka,embg, registracija);
        return "redirect:/narachki/votek";
    }
    @GetMapping("/narachka/{id}")
    public String listProdukti(@PathVariable Integer id, Model model){
        model.addAttribute("produkti", narachaniProduktiService.findByNarachka(id));
        model.addAttribute("bodyContent", "narachaniProdukti");
        return "master-template";
    }
}
