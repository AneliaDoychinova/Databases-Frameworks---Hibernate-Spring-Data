package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class q_Phonebook17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");

        Map<String,String> phonebook = new HashMap<>();

        while (!line[0].equalsIgnoreCase("end")){
            String command = line[0];
            String name = line[1];

            switch (command){
                case "A":
                    String number = line[2];
                    phonebook.put(name,number);
                    break;
                case "S":
                    if(phonebook.containsKey(name)){
                        System.out.printf("%s -> %s%n", name, phonebook.get(name));
                    }
                    else{
                        System.out.printf("Contact %s does not exist.%n",name);
                    }
                    break;

            }

            line = bf.readLine().split("\\s+");
        }
    }
}
