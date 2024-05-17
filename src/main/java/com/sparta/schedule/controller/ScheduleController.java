
package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/schedule/{id}")
    public List<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }


    @PutMapping("/schedule/{id}/{password}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id,@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id,requestDto,requestDto.getPassword());
    }

    @DeleteMapping("/schedule/{id}/{password}")
    public Long deleteSchedule(@PathVariable Long id,@PathVariable Long password) {
        return scheduleService.deleteSchedule(id);
    }

}