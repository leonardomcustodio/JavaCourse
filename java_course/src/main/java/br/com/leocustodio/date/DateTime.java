package br.com.leocustodio.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTime {
    public static void main(String[] args) {
        
        //Beginner exercises list
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("BEGINNER EXERCISES LIST");
        System.out.println("--------------------------------------------");
        System.out.println();

        LocalDate nowDate = LocalDate.now();
        System.out.println("Current date: " + nowDate);
        System.out.println();

        LocalDate adding5DaysToNow = nowDate.plusDays(5);
        System.out.println("Adding 5 days to current date: " + adding5DaysToNow);
        System.out.println();
        
        LocalDate subtract3MonthsFromNow = nowDate.minusMonths(3);
        System.out.println("Subtract 3 months from current date: " + subtract3MonthsFromNow);
        System.out.println();

        LocalDate convertString = LocalDate.parse("2024-03-14");
        System.out.println("Converting 2024-03-14 string to LocalDate: " + convertString);
        System.out.println();
      
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Current date and time with no time zone: " + nowDateTime);
        System.out.println();

        LocalDateTime addingTimeToCurrentTime = nowDateTime.plusHours(7).plusMinutes(30);
        System.out.println("Adding 7 hours and 30 minutes to current LocalDateTime: " + addingTimeToCurrentTime);
        System.out.println();

        LocalDate convertedFromLocalDateTimeNow = LocalDate.from(nowDateTime);
        System.out.println("Converting current LocalDateTime to LocalDate: " + convertedFromLocalDateTimeNow);
        System.out.println();

        Instant nowInstant = Instant.now();
        System.out.println("Current Instant with time zone default GMT: " + nowInstant);
        System.out.println();

        LocalDateTime instantConverted = LocalDateTime.ofInstant(nowInstant, ZoneId.systemDefault());
        System.out.println("Current Instant converted to LocalDateTime on system default time zone" + instantConverted);
        System.out.println();

        LocalDate beginDate = LocalDate.parse("1988-08-27");
        LocalDate finalDate = LocalDate.now();
        Period diffPeriod = Period.between(beginDate, finalDate);
        System.out.println("The difference between 1988-08-27 and current date is " + diffPeriod.getYears() + " years " + diffPeriod.getMonths() +  " months and " + diffPeriod.getDays() + " days." );
        System.out.println();



        //Intermediate exercises list
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("INTERMEDIATE EXERCISES LIST");
        System.out.println("--------------------------------------------");
        System.out.println();
        
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Converting current date format to dd/MM/yyyy: " + format1.format(nowDate));
        System.out.println();

        nextBusinessDay();

    }


    //Metod next business day
    
    static void nextBusinessDay(){

        LocalDate businessDate = LocalDate.parse("1988-08-26");
        int days = 0;

        if (businessDate.getDayOfWeek() == DayOfWeek.FRIDAY){
            days = 3;
        }else if (businessDate.getDayOfWeek() == DayOfWeek.SATURDAY){
            days = 2;
        }else {
            days = 1;
        }

        LocalDate nextBusinessDate = businessDate.plusDays(days);
        System.out.println("Current date is: " + businessDate + " (" + businessDate.getDayOfWeek() 
        + ") and the next business day is " + nextBusinessDate +  " (" 
        + nextBusinessDate.getDayOfWeek() + ").");
    }



    
}
    