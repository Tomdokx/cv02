package NNPIA.cv01;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

/*
* 1)
* @Controller is used to declare common web controllers which can return HTTP response
* but @RestController is used to create controllers for REST APIs which can return JSON.
* */

/*
* 2)
* XML uses a tag to define the structure just like HTML.
* JSON data is stored like a map with key/value pairs.
* YAML uses indentation to define structured data. So each block in the YAML is differentiated by the number of white spaces.
* */

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@RestController
public class HelloController {

    AppUserDAO appUserDAO;

    @GetMapping("")
    public String helloWorld() {
        return appUserDAO.getUsersByActivity(false).toString();
    }

    @GetMapping(value={"/path/{someID}"})
    public String HelloWorldWithPath(@PathVariable(value="someID") final String id) {
        return "Hello world with " + id;
    }

    @GetMapping("/query")
    public String HelloWorldWithQuery(@RequestParam final String id) {
        return "Hello world with query " + id;
    }

    @GetMapping("/user")
    public String registerUserCredential(@RequestBody User user){
        return user.toString();
    }
}

