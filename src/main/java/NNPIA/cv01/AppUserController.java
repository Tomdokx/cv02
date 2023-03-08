package NNPIA.cv01;

import NNPIA.cv01.security.AuthenticationRequest;
import NNPIA.cv01.security.AuthenticationResponse;
import NNPIA.cv01.security.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



import javax.validation.Valid;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
@RestController
public class AppUserController {

    AppUserDAO appUserDAO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

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
}
