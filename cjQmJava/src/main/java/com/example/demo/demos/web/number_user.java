package com.example.demo.demos.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class number_user {
    private List<String> list_name;
    private String name;
    private List<Long> list;
}
