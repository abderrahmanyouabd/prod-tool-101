package com.a1st.prodtool.repositories;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByStatus(StatusType status);
}
