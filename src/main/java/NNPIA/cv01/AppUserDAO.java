package NNPIA.cv01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AppUserDAO extends JpaRepository<AppUser,Integer> {
    @Query("SELECT u from AppUser u where u.active = true")
    List<AppUser> getActiveUsers();
    @Query("SELECT u from AppUser u where u.active = ?1")
    List<AppUser> getUsersByActivity(boolean active);
    @Query("SELECT u from AppUser u where u.id = ?1")
    AppUser getUserById(int id);
    @Query("SELECT u from AppUser u where u.username = ?1")
    AppUser getUserByUsername(String username);
}
