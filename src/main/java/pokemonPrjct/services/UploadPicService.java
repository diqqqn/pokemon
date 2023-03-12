package pokemonPrjct.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import pokemonPrjct.entities.PokemonEntity;
import pokemonPrjct.repositories.PokemonRepository;

import javax.persistence.criteria.Path;

@Service
public class UploadPicService {

    @Autowired
    private PokemonRepository pRepository;

    public void uploadPicAndSaveInDB(MultipartFile file) {
        PokemonEntity pEntity = new PokemonEntity();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
            return;
        }
        try {
            pEntity.setPicPath(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pRepository.save(pEntity);
    }

    public String savePic(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a valid file");
            return null;
        }
        try {
            // Specify the directory where the file should be saved
            String uploadDir = "/path/to/upload/dir/";
            Path uploadPath = (Path) Paths.get(uploadDir);
            if (!Files.exists((java.nio.file.Path) uploadPath)) {
                Files.createDirectories((java.nio.file.Path) uploadPath);
            }
            // Save the file to the directory
            Path filePath = (Path) ((java.nio.file.Path) uploadPath).resolve(fileName);
            Files.copy((java.nio.file.Path) file.getInputStream(), (java.nio.file.Path) filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
