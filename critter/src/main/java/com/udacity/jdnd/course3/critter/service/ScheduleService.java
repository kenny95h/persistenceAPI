package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesForPet(Long petId){
        return scheduleRepository.findAllByPetsId(petId);
    }

    public List<Schedule> getSchedulesForEmployee(Long employeeId){
        return scheduleRepository.findAllByEmployeesId(employeeId);
    }

    public List<Schedule> getSchedulesForCustomer(Long customerId){
        return scheduleRepository.findAllByPetsCustomerId(customerId);
    }
}
