package com.expluto.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private int id;
    private String response;
}
