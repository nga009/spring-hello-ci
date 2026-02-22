package com.example.demo.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    MockMvc mvc;

    // Boot 4では @MockBean の代わりに @MockitoBean
    @MockitoBean
    TodoService todoService;

    @Test
    void todos_are_returned_from_fake_service() throws Exception {
        given(todoService.getTodos()).willReturn(List.of("テスト用のTODO"));

        mvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("テスト用のTODO"));

        verify(todoService, times(1)).getTodos();

    }

}
