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

/*
    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("students", studentRepo.readAll());
        return "shop";
    }
*/

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", studentRepo.readAll());

        return "students";
    }
    /*
    @GetMapping("/student")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id) {
        Student stu = studentRepo.read(id);
        return "The name is: " + stu.getFornavn() + " and the cpr is " + stu.getCpr();
    }
*/
    @GetMapping("/create")
    public String showCreatePage(){

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) throws SQLException {
        studentRepo.create(student);
        return "redirect:/students";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        studentRepo.delete(id);
        return "redirect:/students";
    }
    /*
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Model model){
        studentRepo.update();
                return "update";
    }
    */

    /*
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentRepo.update());
        return "update";
    }

    @PostMapping("/update")
    public String updateNow(@ModelAttribute Student student){
        studentService.updateStudent(student);
        return "redirect:/shop";
    }
    */
    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/converter")
    public String converter(){

        return "converter";
    }

    @GetMapping("/blog")
    public String blog(){

        return "blog";
    }


}
