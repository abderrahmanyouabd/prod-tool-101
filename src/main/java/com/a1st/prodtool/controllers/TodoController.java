package com.a1st.prodtool.controllers;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import com.a1st.prodtool.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */

@RestController
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PutMapping("/todos/{id}")
    public Todo updateTodoItem(@PathVariable("id") long id) {
        Todo updatedTodo = todoService.getById(id);
        if (updatedTodo.getStatus() == StatusType.BACKLOG) {
            updatedTodo.setStatus(StatusType.IN_PROGRESS);
        } else if (updatedTodo.getStatus() == StatusType.IN_PROGRESS) {
            updatedTodo.setStatus(StatusType.DONE);
        } else if (updatedTodo.getStatus() == StatusType.DONE) {
            updatedTodo.setStatus(StatusType.IN_PROGRESS);
        }

        return todoService.save(updatedTodo);
    }
}
