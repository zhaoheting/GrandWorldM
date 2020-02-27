package com.example.GrandWorldM.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@RestController
public class FileController {

    @GetMapping("/downloadFile")
    public ResponseEntity<FileSystemResource> downloadFile() {

        String str = "adsfdsgdfhth";
        File file = new File("/Users/zhao/Desktop/temporary/swagger-ancillary.txt");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("",);

        return ResponseEntity
                .ok()
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }

    @GetMapping("/downloadZip")
    public ResponseEntity<FileSystemResource> downloadZip() {
        String path = "/Users/zhao/Downloads/GrandWorldG.zip";
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(path));
    }

}
