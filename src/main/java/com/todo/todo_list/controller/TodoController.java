package com.todo.todo_list.controller;

import com.todo.todo_list.model.TodoItem;
import com.todo.todo_list.service.TodoService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoItem> addTodo(@RequestBody TodoItem todo) {
        TodoItem savedTodo = todoService.saveTodoItem(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getTodos() {
        List<TodoItem> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}
