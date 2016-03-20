package com.tracebucket.dictionary.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// Explicitly configure @EntityScan to enable the JSR-310 JPA 2.1 converters
@EntityScan(basePackageClasses = { DictionaryApiApplication.class, Jsr310JpaConverters.class })
// Explicitly enable entity links as Boot fails to auto-configure them
@EnableEntityLinks
@EnableScheduling
public class DictionaryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DictionaryApiApplication.class, args);
	}
}
