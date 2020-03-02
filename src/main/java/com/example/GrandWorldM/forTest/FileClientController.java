package com.example.GrandWorldM.forTest;

import com.example.GrandWorldM.model.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Arrays;

@RestController
public class FileClientController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/getZipFile")
    public ResponseEntity<FileResponse> sendRequestToFile() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<FileResponse> result = restTemplate.exchange("http://localhost:8080/zipFile",
                HttpMethod.GET, entity, FileResponse.class);
        FileResponse fileResponse = result.getBody();
        byte[] bytes;
        try {
            bytes = fileResponse.getBytes();
            File file = new File("c:/des.zip");
//            file.setExecutable(true,false);//设置可执行权限
//            file.setReadable(true,false);//设置可读权限
//            file.setWritable(true,false);//设置可写权限
            file.createNewFile();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            System.out.println(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
