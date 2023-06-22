package edu.wgu.d387_sample_code.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class WelcomeController {


    @Autowired
    private Executor messageExecutor = Executors.newFixedThreadPool(2);

    @GetMapping("/en")
    public CompletableFuture<ResponseEntity<List<String>>> getWelcomeMessageEN() {
        CompletableFuture<List<String>> completableFuture = new CompletableFuture<>();
        messageExecutor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " - Loading properties for 'en'");
            loadPropertiesAndAddMessage("messages_en_US.properties", completableFuture);
        });
        return completableFuture.thenApply(ResponseEntity::ok);
    }


    @GetMapping("/fr")
    public CompletableFuture<ResponseEntity<List<String>>> getWelcomeMessageFR() {
        CompletableFuture<List<String>> completableFuture = new CompletableFuture<>();
        messageExecutor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " - Loading properties for 'fr'");
            loadPropertiesAndAddMessage("messages_fr_CA.properties", completableFuture);
        });
        return completableFuture.thenApply(ResponseEntity::ok);
    }


    private void loadPropertiesAndAddMessage(String filename, CompletableFuture<List<String>> completableFuture) {
        List<String> welcomeMessages = new ArrayList<>();
        try (InputStream stream = new ClassPathResource(filename).getInputStream()) {
            Properties properties = new Properties();
            properties.load(stream);
            String welcomeMessage = properties.getProperty("welcome");
            welcomeMessages.add(welcomeMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        completableFuture.complete(welcomeMessages);
    }
}







