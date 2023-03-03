package com.todoapplication.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int toDoCount = 5;
    static{
        todos.add(new Todo(1,"testingAlvin","alvin", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"rest","alvin", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(3,"java","alvin", LocalDate.now().plusYears(3),false));
        todos.add(new Todo(4,"testCase","alvin", LocalDate.now().plusYears(4),false));
        todos.add(new Todo(5,"caseTest","alvin", LocalDate.now().plusYears(5),false));
    }


    public List<Todo> findByUserName(String UserName){

        return todos;
    }

    public void addToDo(String username,String Description,LocalDate targetDate,boolean isdone){
        Todo todo = new Todo(5,Description,username, targetDate.now().plusYears(5),isdone);
        todos.add(todo);
    }
}
