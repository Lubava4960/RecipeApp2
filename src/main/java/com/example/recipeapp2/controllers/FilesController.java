package com.example.recipeapp2.controllers;

import com.example.recipeapp2.service.FilesService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
class FilesController {
    private final FilesService filesService;

    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }

    @GetMapping(value = "/export")

    public ResponseEntity<InputStreamResource> downloadDataFile() throws FileNotFoundException {
        File file = filesService.getRecipeFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));//скачивание ресурса
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())//размер файла
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"RecipesLog.json\"")
                    .body(resource);
        } else {

            return ResponseEntity.noContent().build();
        }
    }

   @PostMapping(value = "/files/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file) {
        filesService.cleanDataFile();
        File dataFile = filesService.getRecipeFile();
       try(FileOutputStream fos = new FileOutputStream(dataFile)){
                   IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
         e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



}