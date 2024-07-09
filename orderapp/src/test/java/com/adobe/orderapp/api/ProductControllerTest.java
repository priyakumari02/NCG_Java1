package com.adobe.orderapp.api;

import com.adobe.orderapp.OrderappApplication;
import com.adobe.orderapp.entity.Product;
import com.adobe.orderapp.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; // get, post, put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // status

import java.util.Arrays;
import java.util.List;

@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = OrderappApplication.class)
// or without security
//@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private OrderService service; // mock bean is injected and not the actual bean

    @Autowired
    private MockMvc mockMvc; // use this to make HTTP request

    @Test
    public void testGetProducts() throws Exception {
        // mock data
        List<Product> products = Arrays.asList(
                Product.builder().id(12).name("A").price(450).quantity(10).build(),
                Product.builder().id(89).name("B").price(890).quantity(90).build()
        );
        // mocking
        when(service.getProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(12)))
                .andExpect(jsonPath("$[1].name", is("B")));

        verify(service,times(1)).getProducts();
    }


    @Test
    public void addProductTest() throws Exception {
        Product p = Product.builder().name("some").quantity(100).price(500).build();
        ObjectMapper mapper = new ObjectMapper(); // jackson for Java<-->JSON
        String json = mapper.writeValueAsString(p);
        // mocking
        when(service.saveProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

            mockMvc.perform(post("/api/products")
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()); // 201
        verify(service,times(1)).saveProduct(Mockito.any(Product.class));
    }

    @Test
    public void addProductExceptionTest() throws Exception {
        Product p = Product.builder().name("").quantity(-100).price(0).build();
        ObjectMapper mapper = new ObjectMapper(); // jackson for Java<-->JSON
        String json = mapper.writeValueAsString(p);
        // no need to mocking
       // when(service.saveProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

        mockMvc.perform(post("/api/products")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors", hasSize(3)))
                .andExpect(jsonPath("$.errors", hasItem("Name is required")));

//        verifyNoInteractions(service);
        verify(service,times(0)).saveProduct(Mockito.any(Product.class));
    }

}
