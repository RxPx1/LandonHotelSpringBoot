package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
@CrossOrigin
@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeController {

    public static class TimeResponse {
        private String[] times;

        public TimeResponse(String[] times) {
            this.times = times;
        }

        public String[] getTimes() {
            return times;
        }

        public void setTimes(String[] times) {
            this.times = times;
        }
    }

    @GetMapping("/time")
    public TimeResponse timeConverter() {
        SimpleDateFormat FORMATTER = new SimpleDateFormat("hh:mma z");

        try {
            String inputDate = "04:30PM EDT";
            SimpleDateFormat inputFormatter = new SimpleDateFormat("hh:mma z");
            Date date = inputFormatter.parse(inputDate);

            // In EST Timezone
            TimeZone estTimeZone = TimeZone.getTimeZone("EST");
            FORMATTER.setTimeZone(estTimeZone);
            String sDateInEST = FORMATTER.format(date);

            // In MST Timezone
            TimeZone mstTimeZone = TimeZone.getTimeZone("MST");
            FORMATTER.setTimeZone(mstTimeZone);
            String sDateInMST = FORMATTER.format(date);

            // In UTC Timezone
            TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
            FORMATTER.setTimeZone(utcTimeZone);
            String sDateInUTC = FORMATTER.format(date);


            String[] times = {sDateInEST, sDateInMST, sDateInUTC};
            return new TimeResponse(times);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
