/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Hassasin
 */
public class output {
    public output(){
        System.out.println("Khởi tạo output()!");
    }
    public void out_file(ArrayList<String> a,ArrayList<String> b){
        File file= new File("D:\\Code\\Java\\NetBeans\\8QuanHau\\src\\pkg8quanhau\\Format.txt");
        try (PrintWriter pw= new PrintWriter (file)){
            for (int i=0;i<a.size();i++){
                pw.println(a.get(i));
                pw.println(b.get(i));
            } 
            pw.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
