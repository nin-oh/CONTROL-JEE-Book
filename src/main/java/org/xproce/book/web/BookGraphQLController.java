package org.xproce.book.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import org.xproce.book.dto.BookDTO;
import org.xproce.book.service.BookService;


import java.util.List;


public class BookGraphQLController {
    public static void main(String[] args) {
        SpringApplication.run(BookGraphQLController.class, args);
    }

@Bean
CommandLineRunner start(BookService bookService){
        return  args -> {
            bookService.saveBooks(
                     List.of(
                            BookDTO.builder().titre("book1").datePublication("2024-11-10").publisher("pub1").price(123.0).build(),
                            BookDTO.builder().titre("book2").datePublication("2024-11-10").publisher("pub2").price(1234.0).build(),
                            BookDTO.builder().titre("book3").datePublication("2024-11-10").publisher("pub3").price(1235.0).build(),
                            BookDTO.builder().titre("book4").datePublication("2024-11-10").publisher("pub4").price(1236.0).build()
                    )

            );
        };
    }
}
