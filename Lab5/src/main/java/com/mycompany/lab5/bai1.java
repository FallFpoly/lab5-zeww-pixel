/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai1 {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nghia");
        while (true) {
            System.out.print("Nhập số thực: ");
            Double x = scanner.nextDouble();
            list.add(x);
            scanner.nextLine(); 

            System.out.print("Nhập thêm (Y/N)? ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("\nDanh sách các số đã nhập:");
        double tong = 0;
        for (Double so : list) {
            System.out.println(so);
            tong += so;
        }
        System.out.println("Tổng các số: " + tong);
    }
}
