package com.example.velocista;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.velocista.model.VelocistaModel;
import com.example.velocista.repository.VelocistaRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(VelocistaRepository repository) {
        return args -> {

            // Cancella eventuali dati precedenti
            repository.deleteAll();

            // Inserisce velocisti di esempio
            repository.save(new VelocistaModel(null, "Usain Bolt", 34, 9.58));
            repository.save(new VelocistaModel(null, "Carl Lewis", 35, 9.86));
            repository.save(new VelocistaModel(null, "Justin Gatlin", 33, 9.74));
            repository.save(new VelocistaModel(null, "Yohan Blake", 32, 9.69));

            System.out.println("Database inizializzato con velocisti di test.");
        };
    }
}