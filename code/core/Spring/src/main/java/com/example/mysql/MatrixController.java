package com.example.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;


@Controller // This means that this class is a Controller
@RequestMapping(path="/matrix")
public class MatrixController {
    @Autowired // calling repository
    private MatrixRepository matrixRepository;

    @PostMapping(path="/add")
    public @ResponseBody String add (@RequestParam Integer id, @RequestParam String test){
        Matrix m = new Matrix(id, test);
        matrixRepository.save(m);
        return "Matrix Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Matrix> getsAll() {
        return matrixRepository.findAll();
    }

}