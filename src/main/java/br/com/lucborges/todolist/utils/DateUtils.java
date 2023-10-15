package br.com.lucborges.todolist.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateUtils {
    public Boolean validateIsValidDate(LocalDateTime date) {
        LocalDateTime currentDate = LocalDateTime.now();
        return !currentDate.isAfter(date);
    }

    public Boolean validateIsStartDateIsSmallerThanEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        return !startDate.isAfter(endDate);
    }
}
