package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import dao.SinhVienDAO;
import model.SinhVien;
import view.MainForm;

public class QLSVController implements ActionListener {
	public MainForm view;
	public ArrayList<SinhVien> dssv;
	public SinhVienDAO db;

	public QLSVController(MainForm view) {
		this.view = view;
	}

	public MainForm getView() {
		return view;
	}

	public void setView(MainForm view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println("Command: " + command);
		if (command.equals("Thêm")) {
			view.insertSinhVien();
		} else if (command.equals("Sửa")) {
			view.getFromTableToTextField();
		}else if (command.equals("Lưu")) {
			view.updateSinhVien();
		}else if(command.equals("Xóa")) {
			view.xoaSinhVien();
		}else if(command.equals("Lưu vào cơ sở dữ liệu")) {
			view.insertIntoDB();
		}else if(command.equals("Load database")) {
			view.loadDB();
		}else if(command.equals("Xóa khỏi cơ sở dữ liệu")) {
			view.deleteFromDB();
		}
	}

}
