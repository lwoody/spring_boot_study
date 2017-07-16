package com.example;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {

    private static final long serialVerionUID = 1L;

    private EntityManager entityManager;

    public MyDataDaoImpl(){
        super();
    }

    public MyDataDaoImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<MyData> getAll() {

        Query query = entityManager.createQuery("from MyData");
        List<MyData> list = query.getResultList();
        entityManager.close();
        return list;
    }
}
