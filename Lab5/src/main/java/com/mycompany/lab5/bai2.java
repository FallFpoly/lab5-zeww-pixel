/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai2 {

    public static void main(String[] args) {
        ArrayList<String> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách họ và tên");
            System.out.println("2. Xuất danh sách vừa nhập");
            System.out.println("3. Xuất danh sách ngẫu nhiên");
            System.out.println("4. Sắp xếp giảm dần và xuất danh sách");
            System.out.println("5. Tìm và xóa họ tên");
            System.out.println("6. Kết thúc");
            System.out.print("Chọn chức năng (1-6): ");
            chon = Integer.parseInt(scanner.nextLine());

            switch (chon) {
                case 1 -> {
                    System.out.println("Nhập họ và tên (nhập 'x' để kết thúc):");
                    while (true) {
                        System.out.print(">> ");
                        String hoTen = scanner.nextLine();
                        if (hoTen.equalsIgnoreCase("x")) break;
                        danhSach.add(hoTen);
                    }
                }

                case 2 -> {
                    System.out.println("Danh sách vừa nhập:");
                    for (String ten : danhSach) {
                        System.out.println(ten);
                    }
                }

                case 3 -> {
                    System.out.println("Danh sách ngẫu nhiên:");
                    Collections.shuffle(danhSach);
                    for (String ten : danhSach) {
                        System.out.println(ten);
                    }
                }

                case 4 -> {
                    System.out.println("Danh sách sắp xếp giảm dần:");
                    Collections.sort(danhSach);
                    Collections.reverse(danhSach);
                    for (String ten : danhSach) {
                        System.out.println(ten);
                    }
                }

                case 5 -> {
                    System.out.print("Nhập họ tên cần xóa: ");
                    String tenCanXoa = scanner.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).equalsIgnoreCase(tenCanXoa)) {
                            danhSach.remove(i);
                            daXoa = true;
                            break;
                        }
                    }
                    if (daXoa) {
                        System.out.println("Đã xóa: " + tenCanXoa);
                    } else {
                        System.out.println("Không tìm thấy tên cần xóa.");
                    }
                }

                case 6 -> System.out.println("Chương trình kết thúc.");

                default -> System.out.println("Vui lòng chọn từ 1 đến 6.");
            }
        } while (chon != 6);
    }
}
