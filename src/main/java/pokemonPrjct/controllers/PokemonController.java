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

import pokemonPrjct.entities.BattleRoundEntity;
import pokemonPrjct.entities.PokemonEntity;
import pokemonPrjct.repositories.PokemonRepository;
import pokemonPrjct.services.UploadPicService;
import pokemonPrjct.repositories.BattleRoundEntityRepository;

@Controller
public class PokemonController {

    @Autowired
    private PokemonRepository pRepository;

    //Add Plamen
    @Autowired
    private BattleRoundEntityRepository brRepository;
// end Plamen


    // @Autowired
    // private UploadPicService uPicService;

    @GetMapping("/list")
    public String getPokemonList(Model model) {
        Iterable<PokemonEntity> pokemon = pRepository.findAll();
        model.addAttribute("pokemonList", pokemon);
        return "list";
    }

    @GetMapping("/listEnemy")
    public String getEnemyPokemonList(Model model) {
        Iterable<PokemonEntity> pokemon = pRepository.findAll();
        model.addAttribute("pokemonList", pokemon);
        return "listEnemy";
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

        List<PokemonEntity> pokemonsEnemy = pRepository.findRandomPCPokemons();
        model.addAttribute("enemyPoke", pokemonsEnemy);

       // Add some code Plamen
        // Calculate user1_hp and pc_hp based on the chosen pokemon's stats and moves
        int user1_hp = 0;
        for (PokemonEntity pokemon : myPokemons) {
            user1_hp += pokemon.getStats().getHp();
        }

        int pc_hp = 0;
        for (PokemonEntity pokemon : enemyPokemons) {
            pc_hp += pokemon.getStats().getHp();
        }

        // Create a new BattleRoundEntity entity
        BattleRoundEntity br = new BattleRoundEntity();
        br.setBattle_id(1); // Set the battle_id to 1 assuming there is only one battle happening at a time
        br.setRound_number(1); // Set the round_number to 1 assuming this is the first round
        br.setUser1_pokemon_id(card1); // Set the user1_pokemon_id to the ID of the user's chosen pokemon
        br.setPc_pokemon_id(enemyPokemons.get(0).getId()); // Set the pc_pokemon_id to the ID of the randomly chosen PC pokemon
        br.setUser1_hp(user1_hp); // Set the user1_hp to the calculated user1_hp
        br.setPc_hp(pc_hp); // Set the pc_hp to the calculated pc_hp

        // Save the BattleRoundEntity entity to the database using the BattleRoundEntityRepository
        brRepository.save(br);

        // Determine the winner of the battle
        if (user1_hp > pc_hp) {
            model.addAttribute("winner", "You win!");
        } else if (user1_hp < pc_hp) {
            model.addAttribute("winner", "You lose!");
        } else {
            model.addAttribute("winner", "It's a tie!");
        }

        //end added Plamen


        return "arena";
    }


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