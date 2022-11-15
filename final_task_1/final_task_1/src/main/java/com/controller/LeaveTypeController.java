package com.controller;

import com.domain.Employee;
import com.domain.LeaveType;
import com.service.EmployeeService;
import com.service.TypeService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/leaveType")
public class LeaveTypeController {
    private final TypeService typeService;
    //    private final TypeService typeService;
    private LeaveTypeController leaveTypeController;
    public LeaveTypeController(TypeService typeService){
        this.typeService = typeService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/show")
    public String show(Model model) {
        LeaveType leaveType = new LeaveType();
        model.addAttribute("leaveType", leaveType);
        return "registration";
    }

    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("leaveType") LeaveType leaveType,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            LeaveType LeaveType;
            TypeService.insert(leaveType);
            return "confirmation";
        }
    }
}
