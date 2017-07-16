package com.example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LEE on 2017. 7. 16..
 */
public interface MyDataDao <T> extends Serializable{

    public List<T> getAll();

}
