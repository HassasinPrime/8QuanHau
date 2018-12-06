/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8quanhau;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hassasin
 */
public class quanhau {
    private int n;
    private ArrayList<Boolean> check_hang,check_cot,check_tong,check_hieu;
    private ArrayList<Integer> result=new ArrayList();
    public quanhau(int n){
        this.n=n;
        check_hang=new ArrayList();
        check_cot=new ArrayList();
        check_tong=new ArrayList();
        check_hieu=new ArrayList();
    }
    public void setN(int n) {
        this.n = n;
    }
    
    public void reset(){
        for (int i=0;i<=n;i++){//n hang, n cot
            check_hang.add(Boolean.TRUE);
            check_cot.add(Boolean.TRUE);
        }
        for (int i=0;i<=2*n-2;i++){//hiệu (i-j) =[1-n,n-1]-->[0,2n-2], tong (i+j) =[2,2n]-->[0,2n-2]
            check_tong.add(Boolean.TRUE);
            check_hieu.add(Boolean.TRUE);
        }
        result=new ArrayList();
    }
    public Boolean check(int i,int j){
        System.out.println("aaa_check");
        System.out.println(i+" "+j+"\n");
        if (i>n||j>n) return Boolean.FALSE;
        if  (!check_hang.get(i-1)) return Boolean.FALSE;
        if  (!check_cot.get(j-1)) return Boolean.FALSE;
        if  (!check_tong.get(i+j-2)) return Boolean.FALSE;
        if  (!check_hieu.get(i-j+n-1)) return Boolean.FALSE;
        return Boolean.TRUE;
    }
    public void update(int i,int j){
        System.out.println("aaa_update");
        System.out.println(i+" "+j+"\n");
        check_hang.set(i-1, Boolean.FALSE);
        check_cot.set(j-1, Boolean.FALSE);
        check_tong.set(i+j-2, Boolean.FALSE);
        check_hieu.set(i-j+n-1, Boolean.FALSE);
    }
            
    public void out(){
        for (int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
            System.out.println("");
        }
    }
    public void out_file() throws FileNotFoundException{
        File out=new File("C:\\Users\\phamd\\Desktop\\out.txt");
        PrintWriter pw= new PrintWriter(out);
        for (int i=0;i<result.size();i++){
            pw.print(result.get(i)+" ");
            pw.println("");
        }
    }
    
    public void SetHau(int i){
        
        for (int j=1;j<=n;j++){
            if (check(i,j)) {
                result.add(j);
                update(i,j);                
                if (i==n) {out();reset();}
                SetHau(i+1);
            }
        }       
    }
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        quanhau data=new quanhau(n);
        data.reset();
        data.SetHau(1);
    }
}
