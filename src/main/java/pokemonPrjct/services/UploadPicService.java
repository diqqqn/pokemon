package pokemonPrjct.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import pokemonPrjct.entities.PokemonEntity;
import pokemonPrjct.repositories.PokemonRepository;

@Service
public class UploadPicService {

    @Autowired
    private PokemonRepository pRepository;

    public void UploadPicInImageAndWriteInDB(MultipartFile file) {
        PokemonEntity pEntity = new PokemonEntity();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);
        if (fileName.contains("..")) {
            System.out.println("not a viled file");
        }
        try {
            pEntity.setPicPath(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pRepository.save(pEntity);
    }
}
