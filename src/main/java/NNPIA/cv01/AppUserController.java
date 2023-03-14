package NNPIA.cv01;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@RestController
public class AppUserController {

    AppUserDAO appUserDAO;

    @GetMapping(value={"/app-user/{id}"})
    public String getUserById(@PathVariable(value="id") final int id) {
        AppUser user = appUserDAO.getUserById(id);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return user.toString();
    }

    @GetMapping("/app-user/addAppUser")
    public void registerUserCredential(@RequestBody AppUser user){
        appUserDAO.save(user);
    }
    @GetMapping(value={"/app-user/deleteAppUser/{id}"})
    public void registerUserCredential(@PathVariable(value="id") final int id){
        appUserDAO.deleteById(id);
    }
    @GetMapping(value={"/app-user/updateAppUser/{id}"})
    public void registerUserCredential(@PathVariable(value="id") final int id, @Valid @RequestBody AppUser user){
        AppUser u = appUserDAO.getUserById(id);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setActive(user.isActive());
        u.setCreation_date(user.getCreation_date());
        u.setUpdate_date(user.getUpdate_date());
        appUserDAO.save(u);
    }

    public AppUser findByUsername(String username) {
        return appUserDAO.getUserByUsername(username);
    }

    @QueryMapping
    @GetMapping(value="/graphql")
    public List<AppUser> getUsers(){
        return appUserDAO.findAll();
    }
}
