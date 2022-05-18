package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.model.BlogType;
import com.codegym.service.IBlogService;
import com.codegym.service.IBlogTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;


    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2)Pageable pageable){
        Page<Blog> blogPage = this.iBlogService.findAll(pageable);
        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createBlog(@Validated @RequestBody BlogDto blogDto,
                                                       BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Blog blog = new Blog();
        BlogType blogType = new BlogType();
        blogType.setId(blogDto.getBlogType().getId());

        blog.setBlogType(blogType);
        BeanUtils.copyProperties(blogDto, blog);
        this.iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<List<FieldError>> updateBlog(@RequestParam Integer id,@Validated  @RequestBody BlogDto blogDto,
                                           BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        Optional<Blog> blogOptional = Optional.ofNullable(iBlogService.findById(id));
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogDto.setBlogId(blogOptional.get().getBlogId());
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Blog> updateBlog(@RequestParam Integer id){
        Optional<Blog> blogOptional = Optional.ofNullable(this.iBlogService.findById(id));
        if (!blogOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iBlogService.deleteById(id);
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }

}
