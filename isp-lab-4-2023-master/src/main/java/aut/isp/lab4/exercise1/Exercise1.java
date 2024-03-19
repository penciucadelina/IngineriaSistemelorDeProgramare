package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {

        //doar currentTime, restul raman null
        AquariumController A1 = new AquariumController();
        A1.setCurrentTime(12.1f);
        System.out.println(A1);

        AquariumController A2 = new AquariumController("Neptune", "Apex Fusion", 12.3f);
        System.out.println(A2.toString());


    }
}
