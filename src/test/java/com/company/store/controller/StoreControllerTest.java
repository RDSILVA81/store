package com.company.store.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StoreControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void findController(){
        ServletContext servletContext = webApplicationContext.getServletContext();
        assertThat(servletContext).isNotNull();
        assertThat(servletContext instanceof MockServletContext);
        assertThat(webApplicationContext.getBean("storeController")).isNotNull();
    }

    @Test
    @SneakyThrows
    void givenExistedStoreNameShouldReturnSuccess(){
        this.mockMvc.perform(get("/store")
                .param("storeName", "Worten")
        ).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void givenExistedItemIDShouldReturnListOfStoresSuccess(){
        this.mockMvc.perform(get("/store/product")
                .param("id", "1")
        ).andExpect(status().isOk());
    }

}
