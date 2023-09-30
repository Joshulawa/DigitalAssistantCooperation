package com.example.mysql;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.mysql.Credentials;
import org.springframework.web.client.RestTemplate;


@Controller // This means that this class is a Controller
@RequestMapping(path="/user")
public class MainController {
    @Autowired // calling repository
    private UserRepository userRepository;
    @Autowired
    private MatrixRepository matrixRepository;

    @Autowired
    private GroupsRepository GroupsRepository;

    @Autowired
    private BrokerRepository BrokerRepository;

    @PostMapping(path="/addUser/{id}/{name}/{email}")
    public @ResponseBody String addNewUser (@RequestParam Integer id, @RequestParam String name, @RequestParam String email){
        User n = new User();
        n.setId(id);
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "User Saved";
    }


    @GetMapping(path="/getName")
    public @ResponseBody Optional<User> getNameFromId(@RequestParam Integer id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getsAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/byId/{id}")
    public @ResponseBody Optional<User> getById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }
    @GetMapping(path = "/byName/{name}")
    public @ResponseBody Integer getIdByName(@PathVariable String name) {
        return userRepository.getIdByName(name);
    }
    @GetMapping(path = "/groupMembers/{groupName}")
    public @ResponseBody List<Integer> getGroupMembers(@PathVariable String groupName){
        Integer groupId = GroupsRepository.getId(groupName);
        return BrokerRepository.getId(groupId);
    }


    private List<String> return_url;


    @PostMapping(path = "/credentials")
    public @ResponseBody String msgInfo(@RequestBody Credentials creds){
        if (creds.getReturn_url() != null) {
            return_url.add(creds.getReturn_url());
        }
        Integer id = creds.getService();
        JSONObject matrixInfo = new JSONObject();
        matrixInfo.put("homeserver", matrixRepository.getServer(id));
        matrixInfo.put("username", matrixRepository.getUsername(id));
        matrixInfo.put("password", matrixRepository.getPassword(id));
        return matrixInfo.toString();
    }


    public void postMessage(JSONObject msgJson, String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(msgJson.toString(), headers);
        restTemplate.postForObject(url, request, String.class);
            //THIS STUFF BELOW CHECKS THE RESPONSE.
//        String personResultAsJsonStr =
//                restTemplate.postForObject(createPersonUrl, request, String.class);
//        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
//
//        assertNotNull(personResultAsJsonStr);
//        assertNotNull(root);
//        assertNotNull(root.path("name").asText());
    }
    @PostMapping(path = "/message")
    public @ResponseBody String msg(@RequestBody Message msg) throws IOException {
        Integer id = userRepository.getIdByServiceId(msg.getAuthor());

        JSONObject msgJson = new JSONObject();
        msgJson.put("author", msg.getAuthor());
        msgJson.put("content", msg.getContent());

        for (String url : return_url) {
            //do post request to that url.
            //Also need to add return url column to message service table.
            postMessage(msgJson, url);
            //If all listeners receives msg set response to true, otherwise false I thinK!
        }

        JSONObject responseJson= new JSONObject();
        responseJson.put("registered", "true"); //For now always true
        return responseJson.toString();
    }

    }
