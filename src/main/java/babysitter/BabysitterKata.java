package babysitter;

public class BabysitterKata {



//    int startTime= 5; // PM
//    int bedTime = 6;  // PM
//    int endTime = 4; // AM



    public int income(int startTime, int bedTime, int endTime) {

        int totalPay = 0;

        int firstHours = (bedTime - startTime) * 12;
        totalPay += firstHours;

        if (endTime <= 12) {
            int secondPay = (endTime - bedTime) * 8;
            totalPay += secondPay;
        } else {
            int secondPay = (12 - bedTime) * 8;
            int thirdPay = endTime * 16;
            totalPay += secondPay + thirdPay;
        }
        return totalPay;
    }

}
