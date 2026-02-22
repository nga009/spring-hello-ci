package com.example.demo.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Override
    public List<String> getTodos() {
        return List.of(
                "本物のServiceです",
                "通常はこちらが使われます"
        );
//        throw new IllegalStateException("本物が呼ばれました（テストでは呼ばれないはず）");

    }
}
