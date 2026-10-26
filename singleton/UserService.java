package singleton;

public class UserService {
   Logger instance = Logger.getInstance();

    public void createUser(){
        instance.log("user created ");
    }
}
