package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.SinhVien;

public class SinhVienDAO implements DAOInterface<SinhVien> {
	public static SinhVienDAO getInstance() {
		return new SinhVienDAO();
	}

	@Override
	public int insert(SinhVien t) {
		int kq = 0;
		try {
			// Tao connection
			Connection con = DBConnection.getConnection();

			// Thuc thi cau lenh
			String sqlInsert = "MERGE INTO ThongTin target "
	                 + "USING (SELECT ? AS MaSV, ? AS HoDem, ? AS Ten, ? AS GioiTinh, ? AS NganhHoc, ? AS DiemTB) source "
	                 + "ON target.MaSV = source.MaSV "
	                 + "WHEN NOT MATCHED THEN "
	                 + "INSERT (MaSV, HoDem, Ten, GioiTinh, NganhHoc, DiemTB) "
	                 + "VALUES (source.MaSV, source.HoDem, source.Ten, source.GioiTinh, source.NganhHoc, source.DiemTB);";
			// Tao statement
			PreparedStatement pst = con.prepareStatement(sqlInsert);

			pst.setInt(1, t.getMaSV());
			pst.setString(2, t.getHoDem());
			pst.setString(3, t.getTen());
			pst.setString(4, t.getGioiTinh());
			pst.setString(5, t.getNganhHoc());
			pst.setFloat(6, t.getDiemTB());

			System.out.println("Bạn đã thực thi " + sqlInsert);
			kq = pst.executeUpdate();
			
			System.out.println("Có " + kq + " dòng bị thay đổi");

			// Ngat ket noi (QUAN TRONG)
			DBConnection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(SinhVien t) {
		int kq = 0;
		try {
			// Tao connection
			Connection con = DBConnection.getConnection();

			// Thuc thi cau lenh
			String sqlUpdate = "UPDATE ThongTin " + "SET " + "HoDem = ?, " + "Ten = ?" + ", GioiTinh = ?"
					+ ", NganhHoc = ?" + ", DiemTB = ?" + " WHERE MaSV = ?";
			// Tao statement
			PreparedStatement pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, t.getHoDem());
			pst.setString(2, t.getTen());
			pst.setString(3, t.getGioiTinh());
			pst.setString(4, t.getNganhHoc());
			pst.setFloat(5, t.getDiemTB());
			pst.setInt(6, t.getMaSV());
			System.out.println(sqlUpdate);
			System.out.println("Bạn đã thực thi " + sqlUpdate);
			kq = pst.executeUpdate();

			System.out.println("Có " + kq + " dòng bị thay đổi");

			// Ngat ket noi (QUAN TRONG)
			DBConnection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(SinhVien t) {
		int kq = 0;
		try {
			//Tao connection
			Connection con = DBConnection.getConnection();
			
			//Thuc thi cau lenh
			String query = "DELETE from ThongTin " +
					" WHERE MaSV = ?";
			//Tao statement
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, t.getMaSV());
			System.out.println(query);
			System.out.println("Bạn đã thực thi " + query);
			kq = pst.executeUpdate();
			
			System.out.println("Có " + kq + " dòng bị thay đổi");
			
			//Ngat ket noi (QUAN TRONG)
			DBConnection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<SinhVien> selectAll() {
		ArrayList<SinhVien> ketQua = new ArrayList<SinhVien>();
		try {
			//Tao connection
			Connection con = DBConnection.getConnection();
			
			//Thuc thi cau lenh
			String query = "Select * from ThongTin";
			System.out.println(query);
			
			//Tao statement
			PreparedStatement pst = con.prepareStatement(query);
			
			System.out.println("Bạn đã thực thi " + query);
			ResultSet rs = pst.executeQuery();
			
			//Thuc thi
			while(rs.next()) {
				int maSV = rs.getInt("MaSV");
				String hoDem = rs.getString("HoDem");
				String ten = rs.getString("Ten");
				String gioiTinh = rs.getString("GioiTinh");
				String nganhHoc = rs.getString("NganhHoc");
				Float diemTB = rs.getFloat("DiemTB");
				SinhVien sv = new SinhVien(maSV, hoDem, ten, gioiTinh, nganhHoc, diemTB);
				ketQua.add(sv);
			}
			
			//Ngat ket noi (QUAN TRONG)
			DBConnection.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public SinhVien selectById(SinhVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SinhVien> selectbyCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
