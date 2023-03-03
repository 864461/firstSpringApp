package com.todoapplication.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class toDoController {


    private ToDoService toDoService;

    public toDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String toDoController(ModelMap model){
        List<ToDo> alvin = toDoService.findByUserName("alvin");
        model.put("todos", alvin);
        return "listToDos";
    }


    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String addToDoController(ModelMap model){
        String userName = (String) model.get("name");
        ToDo todo = new ToDo(7,"",userName,LocalDate.now().plusYears(3),false);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String newToDoController(ModelMap model, @Valid ToDo todo, BindingResult result){

        if(result.hasErrors()) {
            return "todo";
        }
        String userName = (String) model.get("name");

        toDoService.addToDo( userName, todo.getDescription(),  LocalDate.now(), false);
        return "redirect:list-todos";
    }
}
