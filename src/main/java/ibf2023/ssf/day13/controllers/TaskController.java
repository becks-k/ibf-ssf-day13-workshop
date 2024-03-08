package ibf2023.ssf.day13.controllers;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ibf2023.ssf.day13.models.Task;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping
public class TaskController {

    // Client sends a GET request, e.g. visit page
    @GetMapping(path={"/", "/index.html"})
    public ModelAndView getIndex(HttpSession sess) {
        List<Task> taskList = getTask(sess);
        ModelAndView mav = new ModelAndView("todo");
        mav.addObject("taskList", taskList);
        mav.addObject("task", new Task());

        return mav;
    }

    @PostMapping(path="/todo/clear")
    public ModelAndView clearTask(HttpSession sess) {
        // List<Task> taskList = getTask(sess);
        ModelAndView mav = new ModelAndView("todo");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> CLEAR TASK");
        sess.invalidate();
        mav.setViewName("redirect:/");
        return mav;
    }
    
    // Client sends a POST request, e.g. submit form
    @PostMapping(path="/todo")
    public ModelAndView postTask(HttpSession sess, @ModelAttribute @Valid Task task, BindingResult bindings) {
        
        ModelAndView mav = new ModelAndView("todo");
        // Load session into taskList
        List<Task> taskList = getTask(sess);
        mav.addObject("taskList", taskList);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM: " + task.toString());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INITIATED TASKLIST: " + taskList);

        //LocalDate today =  LocalDate.now();
        // Check if new Task is validated
        // Syntactic validation
        if (bindings.hasErrors()) {
            // Return task back to client
            mav.addObject("task", task);
        } 
        
        // Semantic validation
        // else if (task.getDueDate().isBefore(today)) {
            
        //     FieldError ferr = new FieldError("task", "dueDate", "Key in a date today and after");
        //     bindings.addError(ferr);
        // }

        // Return an empty Task object (field in form becomes empty)
        // Add new Task into taskList
        else {
            mav.addObject("task", new Task());
            taskList.add(task);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ERROR FREE TASKLIST: " + taskList);

            //POST-redirect-GET
            //Client submits form [POST]
            //SB redirects client to new URL [REDIRECT]
            //Client gets new URL [GET]
            mav.setViewName("redirect:/");
        }

        return mav;
    }


    // Check if session exists, load tasks into taskList
    // If not, create new session for client (setAttribute) and create new taskList
    public List<Task> getTask(HttpSession sess) {
        List<Task> taskList = (List<Task>) sess.getAttribute("taskList");
        if (taskList == null) {
            taskList = new LinkedList<>();
            sess.setAttribute("taskList", taskList);
        }
        return taskList;
    }

}
