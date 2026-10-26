package singleton;

public class Logger {
    private int logCount =0;

    private static final Logger logger=new Logger();


    private Logger(){}

    public static  Logger getInstance(){
       /*if(logger==null){
            logger = new Logger();
        }

        */
        //thread-safe
        //eager initialization: when  JVM loading class , eager produce object at a time
        //synchornized keyword: at the same time just enter the one thread in getInstance()

        //Test “bozulma görmedim” der, kod mantığı “bozulamaz” der. Mülakatta da bunu böyle söylersen çok iyi olur.


        return logger;

    }

    public  void log(String message) {
        logCount++;
        System.out.println(logCount + ": " + message);
    }



}
