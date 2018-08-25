package com.mt.demo.multidata.web;

import com.mt.demo.multidata.aaadb.entity.Dog;
import com.mt.demo.multidata.aaadb.repository.DogRepository;
import com.mt.demo.multidata.catdb.entity.Cat;
import com.mt.demo.multidata.catdb.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * WebController
 *
 * @author MT.LUO
 * 2018/8/22 11:39
 * @Description:
 */
@RestController
public class WebController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private CatRepository catRepository;

    @PostMapping("/cat")
    public Cat addCat(@Valid Cat cat){
        catRepository.save(cat);
        return cat;
    }

    @PostMapping("/dog")
    public Dog addDog(@Valid Dog dog){
        dogRepository.save(dog);
        return dog;
    }

    @GetMapping("/cat/list")
    public List<Cat> catList(){
        return catRepository.findAll();
    }

    @GetMapping("/dog/list")
    public List<Dog> dogList(){
        return dogRepository.findAll();
    }



    @PostMapping("/test/a/{id}")
    public Object test(@PathVariable Integer id){
        return catRepository.findOneById(id);
    }

    @PostMapping("/test/b/{id}")
    public Object test(@PathVariable Integer id, @RequestBody List<Integer> ids){
        return catRepository.checkAuth(id, ids);
    }

    @PostMapping("/test/c")
    public Object test(@RequestBody TestDTO testDTO){
        return catRepository.findOneById(testDTO.getId());
    }

    @PostMapping("/test/d")
    public Object testd(@RequestBody TestDTO testDTO){
        return catRepository.checkAuth(testDTO.getId(), testDTO.getRid());
    }
    @PostMapping("/test/e")
    public Object teste(@RequestBody TestDTO testDTO){
        return catRepository.selectCat(testDTO.getId(), testDTO.getRid());
    }

}
