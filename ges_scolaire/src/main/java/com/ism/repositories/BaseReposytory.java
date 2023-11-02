package com.ism.repositories;

public interface BaseReposytory<T> {
            
    int insert(T data);
    int update(T data);

}
