package org.example.student.controller;

import org.example.student.model.Class;
import org.example.student.model.Student;
import org.example.student.service.ClassService;
import org.example.student.service.IClassService;
import org.example.student.service.IStudentService;
import org.example.student.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    private static final IStudentService service = new StudentService();
    private static final IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            default:
                listStudent(req,resp);
                break;
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        List<Class> classList = classService.findAll();
        req.setAttribute("classes", classList);
        dispatcher.forward(req,resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<Student> studentList = service.getAllStudent();

        req.setAttribute("student", studentList);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req,resp);
                break;
        }
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Integer idClass = Integer.valueOf(req.getParameter("idClass"));
        String nameClass = req.getParameter("nameClass");
        Class aClass = new Class(idClass, nameClass);
        Student student = new Student(id, name, email, address, aClass);
        service.addStudent(student);
        resp.sendRedirect("/student");
    }
}
