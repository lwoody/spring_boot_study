package com.example;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Repository
public class MsgDataDaoImpl implements MsgDataDao<MsgData>{

    private EntityManager entityManager;

    public MsgDataDaoImpl(EntityManager manager){
        entityManager = manager;
    }

    public MsgDataDaoImpl(){
        super();
    }


    @Override
    public List<MsgData> getAll() {
        return entityManager.createQuery("from MsgData").getResultList();
    }

    @Override
    public MsgData findById(long id) {
        return (MsgData) entityManager.createQuery("from MsgData where id = "+id).getSingleResult();
    }
}
