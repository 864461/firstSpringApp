package com.todoapplication.myfirstwebapp.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
public class TodoControllerJPA {
    public TodoControllerJPA(TodoService todoService,TodoRepository todoRepository) {

        this.todoService = todoService;
        this.todoRepository =todoRepository;
    }

    private TodoService todoService;
    private TodoRepository todoRepository;



    @RequestMapping("list-todos")
    public String toDoController(ModelMap model){


//        List<Todo> todos = todoService.findByUserName(getUsername(model));
        List<Todo> todos = todoRepository.findByUserName(getUsername(model));
        model.put("todos", todos);
        return "listTodos";
    }


    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String addToDoController(ModelMap model){
        String userName =getUsername(model);
        Todo todo = new Todo(0,"",userName,LocalDate.now(),false);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String newToDoController(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()) {
            return "todo";
        }
        String userName = getUsername(model);
        todo.setUserName(userName);
        todo.setDone(false);
        todoRepository.save(todo);
//        todoService.addToDo( userName, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
//        todoService.deleteToById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo")
    public String updateTodo(@RequestParam int id,ModelMap modelMap){
        Todo todo = todoRepository.findById(id).get();
        modelMap.put("todo", todo);
        return "todo";
    }



    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String saveUpdatedTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()) {
            return "updateTodo";
        }
        String userName = getUsername(model);
        todo.setUserName(userName);
        todo.setDone(false);
        todoRepository.save(todo);
//        todoService.updateToDo( id,userName, todo.getDescription(),  todo.getTargetDate(), false);
        return"redirect:list-todos";
    }


    private String getUsername(ModelMap model){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
}
}
