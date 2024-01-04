package com.a1st.prodtool.services;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import com.a1st.prodtool.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */
@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAll(){
        return  todoRepository.findAll();
    }

    public Todo save(Todo newTodo){
        if(newTodo.getId() == null){
            newTodo.setCreatedAt(LocalDateTime.now());
        }
        newTodo.setUpdatedAt(LocalDateTime.now());
        return todoRepository.save(newTodo);
    }

    public List<Todo> getAllByStatus(StatusType status) {
        return todoRepository.findByStatus(status);
    }

    public Todo getById(long id) {
        return todoRepository.findById(id).orElse(null);
    }
}
