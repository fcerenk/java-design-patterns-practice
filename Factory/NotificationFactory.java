package Factory;


//producer machine
public class NotificationFactory {

    public static Notification create(String type) throws IllegalArgumentException {
        if(type==null) throw new NullPointerException("Notification type cannot be null");
        if(type.equalsIgnoreCase("EMAIL")){
            return new EmailNotification();
        }
        else if(type.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();

        }
        else if (type.equalsIgnoreCase("whatsapp")){return new WhatsappNotification();}
        else{
            throw new IllegalArgumentException("Invalid Notification Type: " + type);
        }

    }
}
