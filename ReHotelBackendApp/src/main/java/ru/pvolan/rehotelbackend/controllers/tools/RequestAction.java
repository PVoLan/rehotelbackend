package ru.pvolan.rehotelbackend.controllers.tools;

public interface RequestAction<TResult>{
    TResult run () throws Exception;
}
