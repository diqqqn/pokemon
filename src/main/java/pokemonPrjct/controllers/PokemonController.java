// PokemonController.java
package pokemonPrjct.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

import pokemonPrjct.entities.PokemonEntity;
import pokemonPrjct.repositories.PokemonRepository;
import pokemonPrjct.services.UploadPicService;

@Controller
public class PokemonController {
   // private static final String UPLOAD_DIR = "static/images/pokemons/";
    @Autowired
    private PokemonRepository pRepository;

    @Autowired
    private UploadPicService uPicService;

    @GetMapping("/list")
    public String getPokemonList(Model model) {
        Iterable<PokemonEntity> pokemon = pRepository.findAll();
        model.addAttribute("pokemonList", pokemon);
        return "list";
    }

    @GetMapping("/add-pokemon")
    public String addPokemon() {
        return "add-pokemon";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("pokemon") PokemonEntity pokemon) {
        pRepository.save(pokemon);
        return "redirect:/list";
    }

    @PostMapping("/arena")
    public String processFormArena(@RequestParam("card1") int card1,
            @RequestParam("card2") int card2,
            @RequestParam("card3") int card3,
            Model model) {
        List<PokemonEntity> pokemons = pRepository.findPokemonsByIds(card1, card2, card3);
        model.addAttribute("myPoke", pokemons);
        return "arena";
    }


    // @PostMapping("/add")
    // public String add(@RequestParam("picPath") MultipartFile file) {
    // PokemonEntity pke = new PokemonEntity();
    // pke.setPicPath(file.getOriginalFilename());
    // pRepository.save(pke);
    // return "redirect:/list";
    // }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        java.util.Optional<PokemonEntity> optionalPokemon = pRepository.findById(id);
        if (optionalPokemon.isPresent()) {
            PokemonEntity pokemon = optionalPokemon.get();
            model.addAttribute("pokemon", pokemon);
            return "edit-pokemon";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
    public String processEditForm(@ModelAttribute("pokemon") PokemonEntity pokemon) {
        pRepository.save(pokemon);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable("id") int id) {
        pRepository.deleteById(id);
        return "redirect:/list";
    }
}