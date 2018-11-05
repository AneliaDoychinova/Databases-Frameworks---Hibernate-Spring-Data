package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class r_PhonebookUpgrade18 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");

        Map<String,String> phonebook = new TreeMap<>();

        String name = "";
        while (!line[0].equalsIgnoreCase("end")){
            String command = line[0];

            switch (command){
                case "A":
                    name = line[1];
                    String number = line[2];
                    phonebook.put(name,number);
                    break;
                case "S":
                    name = line[1];
                    if(phonebook.containsKey(name)){
                        System.out.printf("%s -> %s%n", name, phonebook.get(name));
                    }
                    else{
                        System.out.printf("Contact %s does not exist.%n",name);
                    }
                    break;
                case "ListAll":
                    for (Map.Entry<String, String> stringStringEntry : phonebook.entrySet()) {
                        System.out.printf("%s -> %s%n", stringStringEntry.getKey(),stringStringEntry.getValue());
                    }

            }

            line = bf.readLine().split("\\s+");
        }
    }
}
