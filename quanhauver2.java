/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Hassasin
 */
public class quanhauver2 {
    private int n;
    //into Image and InterFace
    private ArrayList<Integer> key=new ArrayList();
    private ArrayList<String> result=new ArrayList();
    //into Image_1
    private ArrayList<String> result_key=new ArrayList();
    private ArrayList<String> pos=new ArrayList();
    Boolean check=Boolean.FALSE;
    //
    //public PrintWriter pw;
    //File out= new File("out.txt");
    
    public quanhauver2(int n) throws IOException {
        this.n=n;
        for (int i=0;i<=n;i++)   key.add(0);
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public Boolean check(int x,int y){
        String a="";
        a+=x+" "+y+" ";
        for(int i=1;i<x;i++){
            if (key.get(i)==y||Math.abs(i-x)==Math.abs(key.get(i)-y))
                {a+="0";pos.add(a);result_key.add(key_now());return Boolean.FALSE;}
            }
        a+="1";pos.add(a);result_key.add(key_now());
        
        return Boolean.TRUE;
    }
    public String key_now(){
        String out="";
        for(int i=0;i<=n;i++){
            if (i<key.size())out+=String.valueOf(key.get(i))+" ";
            else out+="0"+" ";
        }
        return out;
    }
    public void out() throws IOException {
        String c="";
        for (int i=1;i<=n;i++)  {System.out.print(key.get(i)+" ");c+=String.valueOf(key.get(i))+" ";}
        //result.add(String.valueOf(key2));

        /*for (int i=0;i<a.length();i++){
             if(i<a.length()-1) c+=a.charAt(i)+" ";
             else c+=a.charAt(i);
        }*/
        result.add(c);
        System.out.println("");
    }
    public void SetHau(int i) throws IOException {
        for (int j=1;j<=n;j++){
            if (check(i,j)){
                key.set(i,j);
                if (i==n)   {out();output o=new output();o.out_file(pos, result_key);}
                SetHau(i+1);
            }
        }
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public ArrayList<String> getPos() {
        return pos;
    }
    public Boolean getCheck() {
        return check;
    }

    public ArrayList<String> getResult_key() {
        return result_key;
    }
    
    
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        quanhauver2 data=new quanhauver2(n);
        data.SetHau(1);
        ArrayList<String> a;
        a=data.getResult();
        System.out.println("Test");
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
}