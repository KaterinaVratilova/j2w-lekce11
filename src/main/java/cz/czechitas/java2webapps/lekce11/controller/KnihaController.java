package cz.czechitas.java2webapps.lekce11.controller;

import cz.czechitas.java2webapps.lekce11.entity.Kniha;
import cz.czechitas.java2webapps.lekce11.service.KnihaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Filip Jirsák
 */
@RestController
@RequestMapping("/api")
public class KnihaController {
  private final KnihaService service;

  @Autowired
  public KnihaController(KnihaService service) {
    this.service = service;
  }

  @GetMapping("")
  public Page<Kniha> index(Pageable pageable) {
    return service.seznam(pageable);
  }

  @GetMapping(path = "", params = "vcetneStornovanych=true")
  public Page<Kniha> vcetneStornovanych(Pageable pageable) {
    return service.seznamVcetneStornovanych(pageable);
  }

  @PostMapping("")
  public Kniha pridat(@RequestBody Kniha kniha) {
    return service.pridat(kniha);
  }

  @DeleteMapping("/{id}")
  public Kniha smazat(@PathVariable long id) {
    return service.smazat(id);
  }

  @PostMapping("/{id}/obnovit")
  public Kniha obnovit(@PathVariable long id) {
    return service.obnovit(id);
  }

  @PostMapping("batch")
  public List<Kniha> pridatDavkove(@RequestBody List<Kniha> kniha) {
    return service.pridatDavkove(kniha);
  }
}
