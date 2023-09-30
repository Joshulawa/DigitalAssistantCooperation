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
@RequestMapping(path="/broker")
public class BrokerController {
    @Autowired // calling repository
    private BrokerRepository brokerRepository;
}