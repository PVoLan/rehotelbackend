package com.example.demo.controllers.tools;

public interface RequestAction<TResult>{
    TResult run () throws Exception;
}
