package babysitter;

public class BabysitterKata {

    public static int income(int startTime, Time startTimeAMorPM, int bedTime, Time bedTimeAMorPM, int endTime, Time endTimeAMorPM) throws Exception {

        if(isNotValidStartTIme(startTime, startTimeAMorPM)) {
            throw new Exception("Please enter valid start time");
        }

        if(isNotValidBedTIme(startTime, bedTime, bedTimeAMorPM)) {
            throw new Exception("Enter a valid bed time");
        }

        if(isNotValidEndTIme(bedTime, endTime, endTimeAMorPM)) {
            throw new Exception("Enter a valid end time");
        }

        if(startTime == endTime) {
            throw new Exception("Start time and End time must be different");
        }

        int totalPay = 0;

        int firstHours = (bedTime - startTime) * 12;
        totalPay += firstHours;

        if (endTime <= 4) {
            int secondPay = (12 - bedTime) * 8;
            int thirdPay = endTime * 16;
            totalPay += secondPay + thirdPay;
        } else {
            int secondPay = (endTime - bedTime) * 8;
            totalPay += secondPay;
        }
        return totalPay;
   }

    private static boolean isNotValidStartTIme (int startTime, Time startTimeAMorPM) {
        if(startTime < 5 ||
                startTime >= 13 ||
                startTime == 12 && startTimeAMorPM.equals(Time.PM) ||
                startTime < 12 && startTimeAMorPM.equals(Time.AM)) {
            return true;
        }
        return false;
    }

    private static boolean isNotValidBedTIme (int startTime, int bedTime, Time bedTimeAMorPM) {
        if(bedTime < startTime ||
                bedTime >= 13 ||
                bedTime == 12 && bedTimeAMorPM.equals(Time.PM) ||
                bedTime < 12 && bedTimeAMorPM.equals(Time.AM)) {
            return true;
        }
        return false;
    }

    private static boolean isNotValidEndTIme (int bedTime, int endTime, Time endTimeAMorPM) {
        if(endTime == 5 ||
                endTime < 1 ||
                endTime >= 13 ||
                endTime == 12 && endTimeAMorPM.equals(Time.PM) ||
                endTime < 6 && endTimeAMorPM.equals(Time.PM) ||
                endTime < bedTime && endTimeAMorPM.equals(Time.PM)) {
            return true;
        }
        return false;
    }

}
