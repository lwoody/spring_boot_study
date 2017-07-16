package com.example.repositories;

import com.example.MsgData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Repository
public interface MsgDataRepository extends JpaRepository<MsgData, Long>{

}
