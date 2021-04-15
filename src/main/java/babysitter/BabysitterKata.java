package babysitter;

public class BabysitterKata {

    public static int income(int startTime, int bedTime, int endTime) throws Exception{

        if(startTime < 5 || startTime > 12){
            throw new Exception("Please enter valid start time");
        }
        if(bedTime < startTime || bedTime > 12){
            throw new Exception("Enter a valid bed time");
        }
        if(endTime >= 5 && endTime < bedTime){
            throw new Exception("Enter a valid end time");
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

}
