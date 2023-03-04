package pokemonPrjct.pokemon.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import pokemonPrjct.pokemon.Pokemon;
import pokemonPrjct.pokemon.services.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getPokemonByName(name);
        return pokemon != null ? ResponseEntity.ok(pokemon) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updatePokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
        Pokemon existingPokemon = pokemonService.getPokemonByName(name);
        if (existingPokemon == null) {
            return ResponseEntity.notFound().build();
        }
        pokemon.setName(name);
        pokemonService.updatePokemon(pokemon);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePokemon(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getPokemonByName(name);
        if (pokemon == null) {
            return ResponseEntity.notFound().build();
        }
        pokemonService.deletePokemon(pokemon);
        return ResponseEntity.noContent().build();
    }
}

//    Това е клас контролер на Spring Boot, който преобразува HTTP заявки към методи, които изпълняват CRUD (Създаване, Четене, Актуализиране и Изтриване) операции на Pokemon обекти.
//
//        Анотациите @RestControllerи @RequestMappingсе използват за дефиниране на основния URL адрес за всички заявки, обработвани от контролера.
//
//        Анотацията @Autowiredсе използва за инжектиране на PokemonServiceзависимостта в контролера. Класът PokemonServiceсъдържа бизнес логика за взаимодействие с базата данни и извършване на CRUD операции върху Pokemonобекти.
//
//        Контролерът има четири метода, които съответстват съответно на HTTP GET, POST, PUT и DELETE заявки.
//
//        getAllPokemon()методът е съпоставен с GET заявка към основния URL адрес /api/pokemonи връща списък с всички обекти на Pokemon в базата данни.
//
//        getPokemonByName(String name)методът е съпоставен към GET заявка с URL параметър {name}и връща обект ResponseEntity, който съдържа обекта Pokemon с посоченото име. Ако не съществува такъв покемон, се връща отговор 404 Not Found.
//
//        addPokemon(Pokemon pokemon)методът се нанася на POST заявка към основния URL адрес /api/pokemonи добавя нов обект на Pokemon към базата данни.
//
//        updatePokemon(String name, Pokemon pokemon)методът е картографиран към PUT заявка с URL параметър {name}и актуализира съществуващ Pokemon обект в базата данни с новия Pokemon обект, предоставен в тялото на заявката. Ако не съществува такъв покемон, се връща отговор 404 Not Found.
//
//        deletePokemon(String name)методът е съпоставен към заявка DELETE с URL параметър {name}и изтрива обекта Pokemon с посоченото име от базата данни. Ако не съществува такъв покемон, се връща отговор 404 Not Found.
//
//        Други методи могат да бъдат добавени към контролера за извършване на допълнителни операции върху Pokemon обекти.