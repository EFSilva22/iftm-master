package queimando.iftm.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.professorangoti.condominio.model.Apartamento;
import com.professorangoti.condominio.repository.ApartamentoRepository;
import com.professorangoti.condominio.repository.ProprietarioRepository;

import queimando.iftm.model.cadastrarpro;
import queimando.iftm.repository.CadastrarRepository;

@Controller
public class CadastrarController {

    @Autowired
    CadastrarRepository repository;

    @GetMapping("cad_promo")
    public String formCadastroPromo(Model model) {
        model.addAttribute("promocao", new CadastrarPro());
        return "form_cadastro";
    }

    @PostMapping("cad_promo")
    public String Promocao(Promocao professor) {
        System.out.println("passei por aqui");
        db.update("insert into professores(nome) values(?)", professor.getNome());
        return "home";
    }

    @GetMapping("rel_apto")
    public String relatorio(Model model) {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        List<Apartamento> lista = repository.findAll();
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println("------------ tempo de execução: " + (timestamp2.getTime() - timestamp1.getTime()));
        timestamp1 = new Timestamp(System.currentTimeMillis());
        List<Apartamento> lista2 = repository.findAll2();
        timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println("=============tempo de execução: " + (timestamp2.getTime() - timestamp1.getTime()));
        model.addAttribute("apartamentos", lista);
        return "rel_apto";
    }

}