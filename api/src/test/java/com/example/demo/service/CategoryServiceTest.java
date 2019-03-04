package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.of;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository repository;

    @Autowired
    private CategoryService service;

    @Before
    public void setUp() {
        given(repository.save(any(Category.class))).willReturn(new Category());
        given(repository.findById(anyLong())).willReturn(of(new Category()));
        given(repository.findById(anyLong())).willReturn(of(new Category()));
    }

    @Test
    public void mustSaveACategory() {
        CategoryDto categoryDto = new CategoryDto("Teste 5");
        Category category = service.save(categoryDto);
        assertTrue(category instanceof Category);
    }

    @Test
    public void mustFindACategoryById() {
        Long id = 16165656L;
        Category category = service.findById(id);
        assertTrue(category instanceof Category);
    }
}