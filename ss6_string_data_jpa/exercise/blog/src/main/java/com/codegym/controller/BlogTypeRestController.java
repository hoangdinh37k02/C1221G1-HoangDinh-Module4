package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogType;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/type")
public class BlogTypeRestController {
    @Autowired
    private IBlogTypeService iBlogTypeService;

    @GetMapping(value = "/id")
    public ResponseEntity<List<Blog>> findListBlogByBlogTypeId(@RequestParam Integer id){
        BlogType blogType = iBlogTypeService.findById(id);
        if (blogType==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogType.getBlogList(),HttpStatus.OK);
    }
}
