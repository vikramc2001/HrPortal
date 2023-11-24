package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Schedule;
import com.mindgate.main.repository.ScheduleRepositoryInterface;
import com.mindgate.main.service.ScheduleServiceInterface;

@RestController
@CrossOrigin("*")
@RequestMapping("scheduleapi")
public class ScheduleController {

	@Autowired
	private ScheduleServiceInterface scheduleServiceInterface;
	
	@RequestMapping(value="schedules",method = RequestMethod.GET)
	public List<Schedule> allSchedules(){
		return scheduleServiceInterface.getAllSchedules();
	}
	
	@RequestMapping(value="add/schedule",method = RequestMethod.POST)
	public boolean addSchedule(@RequestBody Schedule schedule) {
		return scheduleServiceInterface.addNewSchedule(schedule);
	}
	
	@RequestMapping(value="getone/{scheduleId}" ,method = RequestMethod.GET)
	public Schedule getScheduleByScheduleId(@PathVariable String scheduleId) {
		return scheduleServiceInterface.getScheduleByScheduleId(scheduleId);
	}
	
	@RequestMapping(value = "delete/{scheduleId}",method = RequestMethod.DELETE)
	public boolean deleteSchedule(@PathVariable String scheduleId) {
		return scheduleServiceInterface.deleteSchedule(scheduleId);
	}
	
	@RequestMapping(value = "update/schedule" ,method = RequestMethod.PUT)
	public Schedule updateEmployee(@RequestBody Schedule schedule) {
		return scheduleServiceInterface.updateSchedule(schedule);
	}
	
	@RequestMapping(value="getallschedule/{interviewerId}",method = RequestMethod.GET)
	public List<Schedule> allSchedulesByInterviewerId(@PathVariable String interviewerId){
		return scheduleServiceInterface.getAllSchedulesByInterviewerId(interviewerId);
	}
}
