package com.a1st.prodtool.config;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import com.a1st.prodtool.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */

@Component
@AllArgsConstructor
public class SeedData implements CommandLineRunner {
    private final TodoService todoService;


    @Override
    public void run(String... args) throws Exception {
        List<Todo> todos = todoService.getAll();
        if (todos.isEmpty()) {

            Todo todo1 = Todo.builder().description("edit tutorial").status(StatusType.BACKLOG).build();
            Todo todo2 = Todo.builder().description("shoot tutorial").status(StatusType.IN_PROGRESS).build();
            Todo todo3 = Todo.builder().description("tutorial script").status(StatusType.DONE).build();

            todoService.save(todo1);
            todoService.save(todo2);
            todoService.save(todo3);

        }
    }
}
