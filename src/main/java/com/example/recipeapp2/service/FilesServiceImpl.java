package com.example.recipeapp2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {


    @Value("${path.to.data.file}")
    private String dataFilePath;


    @Value("${name.of.data.file}")
    private String dataFileName;


    @Value("${path.to.ingredient.file")
    private String ingredientFilePath;

    @Value("${name.of.ingredient.file")
    private String ingredientFileName;



    @Override
    public boolean cleanIngredientFile() {
        return false;
    }

    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public File getDataFile() {
        return null;

    }

    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String readFromFile(){
        try{
            return Files.readString(Path.of(dataFilePath,dataFileName));//чтение
        }catch(IOException e){
            throw new RuntimeException(e);

        }

    }
}
