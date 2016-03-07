package com.tracebucket.dictionary.api;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 *
 * Integration test to bootstrap the root {@link org.springframework.context.ApplicationContext}.
 *
 * @author ffazil
 * @since 04/03/16
 */
public class ApplicationIntegrationTest {
    @Test
    public void initializesRootApplicationContext() {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {

            context.register(DictionaryApiApplication.class);
            context.refresh();

            new Repositories(context);
        }
    }

    @Test
    public void initializesWebApplicationContext() {

        try (AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext()) {

            applicationContext.register(DictionaryApiApplication.class);
            applicationContext.setServletContext(new MockServletContext());
            applicationContext.refresh();
        }
    }
}
