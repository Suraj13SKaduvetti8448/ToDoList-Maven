package com.todo.todo_list.service;

import com.todo.todo_list.model.TodoItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

@Service
public class TodoService {

    public TodoItem saveTodoItem(TodoItem todo) {
        // Logic to save Todo to a file (or database)
        // For example, writing to a JSON file
        try {
            File file = new File("data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<TodoItem> todos = objectMapper.readValue(file, List.class);
            todos.add(todo);
            objectMapper.writeValue(file, todos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public List<TodoItem> getTodos() {
        File file = new File("todos.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(file, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();  // Return empty list if error occurs
    }
}
