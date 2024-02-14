package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class HomePageControllerTest {
    @InjectMocks
    HomePageController homepageController;

    @BeforeEach
    void SetUp(){

    }

    @Test
    void testCreateHomepage() {
        Model model = mock(Model.class);
        String returnedValue = homepageController.createProductPage(model);
        assertEquals("Homepage", returnedValue);
    }
}