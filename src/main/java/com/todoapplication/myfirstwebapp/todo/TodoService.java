package com.todoapplication.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private static List<ToDo> toDos = new ArrayList<>();

    private static int toDoCount = 5;
    static{
        toDos.add(new ToDo(1,"testingAlvin","alvin", LocalDate.now().plusYears(1),false));
        toDos.add(new ToDo(2,"rest","alvin", LocalDate.now().plusYears(2),false));
        toDos.add(new ToDo(3,"java","alvin", LocalDate.now().plusYears(3),false));
        toDos.add(new ToDo(4,"testCase","alvin", LocalDate.now().plusYears(4),false));
        toDos.add(new ToDo(5,"caseTest","alvin", LocalDate.now().plusYears(5),false));
    }


    public List<ToDo> findByUserName(String UserName){

        return toDos;
    }

    public void addToDo(String username,String Description,LocalDate targetDate,boolean isdone){
        ToDo todo = new ToDo(5,Description,username, targetDate.now().plusYears(5),isdone);
        toDos.add(todo);
    }
}
