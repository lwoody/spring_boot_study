package com.example;

import com.example.repositories.MsgDataRepository;
import com.example.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Controller
public class HeloController {

    @Autowired
    MyDataRepository repository;

    @PersistenceContext
    EntityManager entityManager; //●


    MyDataDaoImpl dao; //●

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg","MyData의 예제입니다.");
        Iterable<MyData> list = dao.getAll(); //●
        mav.addObject("datalist", list);
        return mav;
    }

    @PostConstruct
    public void init(){
        dao = new MyDataDaoImpl(entityManager); //●
        MyData d1 = new MyData();
        d1.setName("tuyano");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
        d1.setMemo("090999999");
        repository.save(d1);
        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("080888888");
        repository.save(d2);
        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("070777777");
        repository.save(d3);
    }








//    @PostConstruct
//    public void init(){
//        MyData d1 = new MyData();
//        d1.setName("kim");
//        d1.setAge(123);
//        d1.setMail("kim@gilbut.co.kr");
//        d1.setMemo("this is my data!");
//        repository.saveAndFlush(d1);
//        MyData d2 = new MyData();
//        d2.setName("lee");
//        d2.setAge(15);
//        d2.setMail("lee@flower");
//        d2.setMemo("my girl friend.");
//        repository.saveAndFlush(d2);
//        MyData d3 = new MyData();
//        d3.setName("choi");
//        d3.setAge(37);
//        d3.setMail("choi@happy");
//        d3.setMemo("my work friend...");
//        repository.saveAndFlush(d3);
//    }
//
//    @Autowired
//    MyDataRepository repository;
//
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav){
//
//        mav.setViewName("index");
//        Iterable<MyData> list = repository.findAll();
//        mav.addObject("datalist",list);
//
//        return mav;
//    }
//
//    @RequestMapping(value="/", method = RequestMethod.POST)
//    @Transactional(readOnly = false)
//    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav){
//
//        repository.saveAndFlush(mydata);
//
//        return new ModelAndView("redirect:/");
//    }
//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView edit(@ModelAttribute MyData mydata,
//                             @PathVariable int id, ModelAndView mav) {
//        mav.setViewName("edit");
//        mav.addObject("title","edit mydata.");
//        MyData data = repository.findById((long) id);
//        mav.addObject("formModel",data);
//        return mav;
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    @Transactional(readOnly=false)
//    public ModelAndView update(@ModelAttribute MyData mydata,
//                               ModelAndView mav) {
//        repository.saveAndFlush(mydata);
//        return new ModelAndView("redirect:/");
//    }

}
