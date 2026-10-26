package Factory;

import java.util.Scanner;

public class Main   {
    public static void main(String[] args) {
        System.out.println("Enter notification type (SMS, EMAIL,PUSH,WHATSAPP): ");

        Scanner sc = new Scanner(System.in);

        String type =sc.nextLine();

        //null checking
        //NotificationFactory.create(null);

        /*
        if(notification.equals("SMS")) {
            new SMSNotification().send(notification);
        }
        else if(notification.equals("EMAIL")) {
            new EmailNotification().send(notification);
        }
        else if(notification.equals("PUSH")) {
            new PushNotification().send(notification);
        }
        else{
            System.out.println("Invalid Notification");
        }

         */


        // this is obj
        //we cannot write new because forbidden to write obj from interface

        //Araba a = fabrika.uret()

        Notification notification = NotificationFactory.create(type);
        notification.send("Hello ");




    }
}
