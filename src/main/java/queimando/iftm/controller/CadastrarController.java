package queimando.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import queimando.iftm.model.Cadastrar;
import queimando.iftm.repository.CadastrarRepository;

@Controller
public class CadastrarController {

    @Autowired
    CadastrarRepository repository;

    @GetMapping("cad_promo")
    public String formCadastroPromo(Model model) {
        model.addAttribute("promocao", new Cadastrar());
        return "form_cadastro";
    }

    @PostMapping("cad_promo")
    public String gravaNovaPromocao(Cadastrar cadastrar, Model model) {

        return "redirect:/cadastrarpro";
    }

}