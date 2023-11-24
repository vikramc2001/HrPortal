package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Schedule;
import com.mindgate.main.repository.ScheduleRepositoryInterface;

@Service
public class ScheduleService implements ScheduleServiceInterface {

	@Autowired
	private ScheduleRepositoryInterface scheduleRepositoryInterface;
	
	@Override
	public boolean addNewSchedule(Schedule schedule) {
		
		return scheduleRepositoryInterface.addNewSchedule(schedule);
	}

	@Override
	public Schedule updateSchedule(Schedule schedule) {
		
		return scheduleRepositoryInterface.updateSchedule(schedule);
	}

	@Override
	public boolean deleteSchedule(String scheduleId) {
		
		return scheduleRepositoryInterface.deleteSchedule(scheduleId);
	}

	@Override
	public Schedule getScheduleByScheduleId(String scheduleId) {
		
		return scheduleRepositoryInterface.getScheduleByScheduleId(scheduleId);
	}

	@Override
	public List<Schedule> getAllSchedules() {
		
		return scheduleRepositoryInterface.getAllSchedules();
	}

	@Override
	public List<Schedule> getAllSchedulesByInterviewerId(String interviewerId) {
		// TODO Auto-generated method stub
		return scheduleRepositoryInterface.getAllSchedulesByInterviewerId(interviewerId);
	}

}
