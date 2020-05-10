package rme.stud.admin_sys.Controller;

import rme.stud.admin_sys.Repository.implementations.StudentRepo;
import rme.stud.admin_sys.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class MainController {
    /*
    @Autowired
    StudentService studentService;

     */
    private StudentRepo studentRepo;

    public MainController() throws ClassNotFoundException {
        try {
            studentRepo = new StudentRepo();
        }catch(ClassNotFoundException e){System.out.println(e);}

    }


    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", studentRepo.readAll());

        return "students";
    }
    @GetMapping("/create")
    public String showCreatePage(){

        return "redirect:/students";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) throws SQLException {
        studentRepo.create(student);
        return "redirect:/students";
    }

    @GetMapping("/update")
    public String showUpdatePage(){

        return "students";
    }

    @PostMapping("/update")
    public String Update(@ModelAttribute Student student) throws SQLException {
        studentRepo.create(student);
        return "redirect:/students";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        studentRepo.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/blog")
    public String blog(){

        return "blog";
    }


}
