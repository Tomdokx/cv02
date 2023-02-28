package NNPIA.cv01;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task,Integer> {
}
