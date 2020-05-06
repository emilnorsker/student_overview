package rme.stud.admin_sys.Repository;

import rme.stud.admin_sys.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepoJPA extends JpaRepository<Student, Integer> {


}
