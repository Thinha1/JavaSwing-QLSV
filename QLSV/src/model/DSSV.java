package model;

import java.util.ArrayList;

public class DSSV {
	private ArrayList<SinhVien> danhSachSinhVien;

	public DSSV() {
		this.danhSachSinhVien = new ArrayList<SinhVien>();
	}

	public DSSV(ArrayList<SinhVien> danhSachSinhVien) {
		this.danhSachSinhVien = danhSachSinhVien;
	}

	public ArrayList<SinhVien> getDanhSachSinhVien() {
		return danhSachSinhVien;
	}

	public void setDanhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
		this.danhSachSinhVien = danhSachSinhVien;
	}

	public void insert(SinhVien sv) {
		this.danhSachSinhVien.add(sv);
	}

	public void remove(SinhVien sv) {
		this.danhSachSinhVien.remove(sv);
	}

	public void update(SinhVien sv) {
		this.danhSachSinhVien.remove(sv);
		this.danhSachSinhVien.add(sv);
	}

	public void printDSSV() {
		for (SinhVien sv : danhSachSinhVien) {
			System.out.println(sv);
		}
	}
	public boolean kiemTraTonTai(SinhVien sv) {
		for(SinhVien i : danhSachSinhVien) {
			if(sv.getMaSV() == i.getMaSV())
				return false;
		}
		return true;
	}
}
