package com.ebi;

import com.ebi.dataaccessobject.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EbiCrudManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbiCrudManagerApplication.class, args);}

}
