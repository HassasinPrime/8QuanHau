/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassasin
 */
public class Input {
    private ArrayList<String> pos=new ArrayList();
    private ArrayList<String> key=new ArrayList();

    public Input(){
        pos=new ArrayList();
        key=new ArrayList();
        System.out.println("Khởi tạo input()");
    }
    public ArrayList<String> getPos() {
        if (pos.isEmpty()) this.getData();
        return pos;
    }

    public ArrayList<String> getKey() {
        if (key.isEmpty()) this.getData();
        return key;
    }

    public void getData() {
        try {
            Scanner sc=new Scanner(new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\Format.txt"));
            while(true){
                pos.add(sc.nextLine());
                key.add(sc.nextLine());
                }
        } catch (Exception ex) {
            return;
        }
    }
    
}
