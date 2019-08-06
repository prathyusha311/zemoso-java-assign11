package com.labs.zemoso;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String args[])
    {
        try{
            Map<Character,Integer> map = new HashMap<Character,Integer>();

            String path = "/home/zadmin/Desktop/";
            path = path + args[0];
            FileReader fr = new FileReader(path);

            int i;
            while ((i=fr.read()) != -1){
                char ch = (char) i;
                if(ch=='\n')
                    continue;
                if(map.containsKey(ch)) {
                    int count = map.get(ch);
                    map.put(ch,count+1);
                }
                else {
                    map.put(ch,1);
                }
            }

            FileWriter fileWriter = new FileWriter("/home/zadmin/Desktop/output.txt");
            BufferedWriter out = new BufferedWriter(fileWriter);

            for(Map.Entry<Character,Integer> it : map.entrySet()){
                out.write(it.getKey() + " " + it.getValue() + "\n");
            }
            out.close();

        }catch (Exception exp) {
            System.out.println("Exception occured");
        }
    }
}
