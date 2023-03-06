package com.todoapplication.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int toDoCount = 0;
    static{
        todos.add(new Todo(toDoCount++,"testingAlvin","alvin", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(toDoCount++,"rest","alvin", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(toDoCount++,"java","alvin", LocalDate.now().plusYears(3),false));
        todos.add(new Todo(toDoCount++,"testCase","alvin", LocalDate.now().plusYears(4),false));
        todos.add(new Todo(toDoCount++,"caseTest","alvin", LocalDate.now().plusYears(5),false));
    }


    public List<Todo> findByUserName(String userName){
        Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName) ;
        return todos.stream().filter(predicate).collect(Collectors.toList());
    }

    public void addToDo(String username,String Description,LocalDate targetDate,boolean isdone){
        Todo todo = new Todo(toDoCount++,Description,username, targetDate.now().plusYears(5),isdone);
        todos.add(todo);
    }

    public void updateToDo(int id,String username,String Description,LocalDate targetDate,boolean isdone){
        Todo todo = findById(id);
        todo.setDescription(Description);
        todo.setTargetDate(targetDate);
        todo.setDone(isdone);
    }

    public Todo findById(int id){
        Todo todo = todos.get(id);
        return todo;
    }

    public void deleteToById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
        todos.removeIf(predicate);
    }
}
