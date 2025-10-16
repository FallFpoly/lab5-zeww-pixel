/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai3 {

    public static void main(String[] args) {
        ArrayList<SanPham> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nghia");
        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách sản phẩm");
            System.out.println("2. Sắp xếp giảm dần theo giá và xuất");
            System.out.println("3. Tìm và xóa sản phẩm theo tên");
            System.out.println("4. Xuất giá trung bình của các sản phẩm");
            System.out.println("5. Kết thúc");
            System.out.print("Chọn chức năng (1-5): ");
            chon = Integer.parseInt(scanner.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("Nhập sản phẩm (nhập 'x' để kết thúc):");
                    while (true) {
                        System.out.print("Tên sản phẩm: ");
                        String ten = scanner.nextLine();
                        if (ten.equalsIgnoreCase("x")) break;

                        System.out.print("Giá sản phẩm: ");
                        Double gia = Double.parseDouble(scanner.nextLine());

                        danhSach.add(new SanPham(ten, gia));
                    }
                    break;

                case 2:
                    Comparator<SanPham> comp = new Comparator<SanPham>() {
                        @Override
                        public int compare(SanPham o1, SanPham o2) {
                            return o2.getDonGia().compareTo(o1.getDonGia()); // giảm dần
                        }
                    };
                    Collections.sort(danhSach, comp);
                    System.out.println("Danh sách sản phẩm sau khi sắp xếp:");
                    for (SanPham sp : danhSach) {
                        System.out.println(sp);
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sản phẩm cần xóa: ");
                    String tenCanXoa = scanner.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).getTen().equalsIgnoreCase(tenCanXoa)) {
                            danhSach.remove(i);
                            daXoa = true;
                            break;
                        }
                    }
                    if (daXoa) {
                        System.out.println("Đã xóa sản phẩm: " + tenCanXoa);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm cần xóa.");
                    }
                    break;

                case 4:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách sản phẩm trống.");
                    } else {
                        double tong = 0;
                        for (SanPham sp : danhSach) {
                            tong += sp.getDonGia();
                        }
                        double trungBinh = tong / danhSach.size();
                        System.out.println("Giá trung bình của các sản phẩm: " + trungBinh);
                    }
                    break;

                case 5:
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Vui lòng chọn từ 1 đến 5.");
            }
        } while (chon != 5);
    }

   private static class SanPham {
    private String ten;
    private Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    public String getTen() {
        return ten;
    }

    public Double getDonGia() {
        return donGia;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: " + ten + ", Giá: " + donGia;
    }
}
}
