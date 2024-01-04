package com.a1st.prodtool.controllers;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import com.a1st.prodtool.services.TodoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */
@RestController
@AllArgsConstructor
public class TodoFormController {
    private final TodoService todoService;

    @PostMapping("/todos/new")
    public void createTodo(@Valid Todo newTodo, HttpServletResponse response) throws IOException {
        newTodo.setStatus(StatusType.BACKLOG);
        todoService.save(newTodo);
        response.sendRedirect("/");
//        return "redirect:/";
    }
}
