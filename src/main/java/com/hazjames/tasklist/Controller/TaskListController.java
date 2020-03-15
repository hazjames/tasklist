package com.hazjames.tasklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
public class TaskListController {

  private static ArrayList<String> taskList = new ArrayList();

  @PostMapping("/")
  private String addTask(@Valid String task, ModelMap modelMap) {
    taskList.add(task);

    modelMap.put("taskList", taskList);
    return "home";
  }

  @RequestMapping("/")
  private String getHome(@RequestParam(required = false, name="del") Integer item, ModelMap modelMap){
    if(item != null && item < taskList.size()){
      taskList.remove((int) item);
    }

    modelMap.put("taskList", taskList);
    return "home";
  }
}
