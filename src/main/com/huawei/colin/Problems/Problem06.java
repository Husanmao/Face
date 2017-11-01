package com.huawei.colin.Problems;

import com.sun.istack.internal.NotNull;

/**
 * Time to Words
 */
public class Problem06 {

    /* nums in string */
    private static final String[] nums = {"o'clock", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                     "eleven", "twelve", "thirteen", "fourteen", "Quater", "sixteen", "seventeen",
                     "nighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
                     "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight",
                     "twenty-nine", "half"};


    /**
     * Time to words
     * @param time Time to convert
     * @return Time in words
     */
    @NotNull
    public static String convertTimeToWords(@NotNull String time) throws NumberFormatException {

        String result = "";

        // 1. Split time into two parts
        String[] time_depart = time.split(":");
        int hour = Integer.parseInt(time_depart[0]);
        int minutes = Integer.parseInt(time_depart[1]);

        // 2. Check if illegal argument
        if (hour < 0 || hour > 12 || minutes < 0 || minutes >= 60)
            throw new IllegalArgumentException();

        String hour_str = "";
        String minutes_str = "";
        if (minutes > 30) {
            hour_str = hour == 12 ? nums[1] : nums[(hour + 1)];
            minutes_str = nums[60 - minutes];
            result = minutes_str + " to " + hour_str;
        } else {
            hour_str = nums[hour];
            if (minutes == 0) {
                result = hour_str + " " + nums[0];
            } else {
                minutes_str = nums[minutes];
                result = minutes_str + " past " + hour_str;
            }
        }
        return result;
    }
}
