package com.a1st.prodtool.controllers;

import com.a1st.prodtool.models.StatusType;
import com.a1st.prodtool.models.Todo;
import com.a1st.prodtool.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Abderrahman Youabd aka: A1ST
 */

@RestController
@AllArgsConstructor
public class PageController {
    private final TodoService todoService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newTodo", new Todo());
        modelAndView.addObject("backlog", todoService.getAllByStatus(StatusType.BACKLOG));
        modelAndView.addObject("in_progress", todoService.getAllByStatus(StatusType.IN_PROGRESS));
        modelAndView.addObject("done", todoService.getAllByStatus(StatusType.DONE));
        return modelAndView;
    }

}
