package day01.consoleMvc;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleStart {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        while(true){
            doGet();
            doPost();
        }



    }

    public static void doGet(){

        ConsoleController controller = new ConsoleController();
        List<ConsoleDto> result = controller.doGet();
        System.out.println( result );

    }

    public static void doPost(){
        System.out.println("title : ");
        String title = sc.next();


        ConsoleController controller = new ConsoleController();
        boolean result = controller.doPost( title );
        System.out.println( result );


    }

}
