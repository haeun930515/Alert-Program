/*
    @author Haeun Lee
    program :
    Alert to avoid overuse!
    Main: 유저의 사용시간 체크후 각각의 step별로 기능 활성화/비활성화
    체크는
        By clock
        By stopwatch
        Your choice
    Step 1: Alert for usage (warning)
    Step 2: Second warning (Open URL)
    Step 3: Block the computer (Block)
    
   



 */

import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;



public class Main extends TimerTask{
    private static int cnt;
    @Override
    public void run () {
        System.out.println("Timer task started at:" + new Date());
        completeTask();

    }
    private void completeTask(){

        //TODO should be replace to minute instead of seconds (for test)
        int toMinute = cnt * 1000;

        try{

            Thread.sleep(toMinute);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println("Current date is " + d1);

        Main timerTask = new Main();
        Timer timer = new Timer(true);
        System.out.println("Enter the time in minute : ");
        Scanner scan = new Scanner(System.in);
        timer.schedule(timerTask,0);
        System.out.println("TimerTask started");

        cnt = scan.nextInt();
        try {
            //TODO should be replace to minute instead of seconds( for test)
            Thread.sleep(cnt * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Timer task finished at: " + new Date());
        //step 1)open an image for caution
        try{
            File file = new File("/Users/Leehaueun/Downloads/AlertProgram/src/TurnOffImage.png");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Did you quit the job you are doing now? (Yes : 1 / No : 2");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();




        // open an url for stop computer
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://www.google.com/search?q=scary+photo&tbm=isch&source=iu&ictx=1&fir=x8oM2YiU05mRHM%253A%252CxnIjYapc2MaWiM%252C_&usg=AI4_-kQoqAehbURitz2HKxfdV9fD5-rrhw&sa=X&ved=2ahUKEwi34pa44qLgAhXBrIMKHTtQARIQ9QEwAXoECAAQBg#imgrc=_");
            desktop.browse(oURL);
        }catch(Exception e){
            System.out.println("Fail");
        }
        System.out.println("Did you quit the job you are doing now? (Yes : 1 / No : 2");

        int p = reader.nextInt();

        if (p == 1){
            System.out.println("great but you already waste golden time");
            System.exit(0);
        } else {
            System.out.println("Your option is just shutting down the computer.");

            //step 3) lock the mouse pointer

            try {
                /*while (true) {
                    Robot robot = new Robot();
                    robot.mouseMove(300, 300);
                }
                */
                //System.out.println("Do something for block");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}//public main


