/*
    java 25.0.1 2025-10-21 LTS
    Java(TM) SE Runtime Environment (build 25.0.1+8-LTS-27)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0.1+8-LTS-27, mixed mode, sharing)
 */
public class HelloWeek2{
    public static void main(String[] args){

        System.out.println(System.getProperty("java.version"));

        if (args.length >= 1){
            System.out.print("Hello, " + args[0]);
        }
        else
            System.out.print("Hello, trainee!");
    }
}