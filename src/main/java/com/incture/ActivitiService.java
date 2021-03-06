package com.incture;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivitiService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

	@Transactional
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
    }

	@Transactional
    public List<Task> getTasks(String assignee) {
		System.out.println(">> Inside ActivitiService:: getTasks()");
		return taskService.createTaskQuery().list();
//        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

}