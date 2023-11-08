package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Schedule;

public interface ScheduleServiceInterface {

	boolean addNewSchedule(Schedule schedule);
	
	Schedule updateSchedule(Schedule schedule);
	
	boolean deleteSchedule(String scheduleId);
	
	Schedule getScheduleByScheduleId(String scheduleId);
	
	List<Schedule> getAllSchedules();
}
