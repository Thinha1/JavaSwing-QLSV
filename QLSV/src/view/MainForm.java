package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import dao.DBConnection;
import dao.SinhVienDAO;
import model.DSSV;
import model.SinhVien;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {
	public JTextField textFieldMaSV;
	public JTextField textFieldHoDem;
	public JTextField textFieldTen;
	public JTextField textFieldNganh;
	public JTextField textFieldDiemTB;
	public JTable table;
	public DSSV model;
	public JRadioButton radioButtonNam;
	public JRadioButton radioButtonNu;
	private ButtonGroup buttonGioiTinh;

	public MainForm() {
		this.model = new DSSV();
		setTitle("Quản lý sinh viên");
		setSize(894, 669);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Tạo giao diện cơ bản
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);

		ActionListener act = new QLSVController(this);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		Timer timer = new Timer(300, e -> {
			// Tạo màu RGB ngẫu nhiên
			Random random = new Random();
			int r = random.nextInt(256);
			int g = random.nextInt(256);
			int b = random.nextInt(256);

			// Áp dụng màu ngẫu nhiên cho nền và chữ
			lblNewLabel.setBackground(new Color(r, g, b));
			lblNewLabel.setForeground(new Color(255 - r, 255 - g, 255 - b)); // Màu chữ đối lập
		});

		timer.start(); // Bắt đầu Timer
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 10, 597, 61);
		panel.add(lblNewLabel);
		String[] columnNames = { "Mã sinh viên", "Họ tên", "Tên", "Giới tính", "Ngành học", "Điểm trung bình" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 362, 66, 221);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã SV");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 1, 66, 66);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Họ đệm ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 85, 66, 51);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("Tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 169, 66, 42);
		panel_2.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 81, 860, 10);
		panel.add(separator);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(73, 362, 152, 221);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);

		textFieldMaSV = new JTextField();
		textFieldMaSV.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaSV.setBounds(0, 1, 152, 56);
		panel_2_1.add(textFieldMaSV);
		textFieldMaSV.setColumns(10);

		textFieldHoDem = new JTextField();
		textFieldHoDem.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldHoDem.setColumns(10);
		textFieldHoDem.setBounds(0, 83, 152, 56);
		panel_2_1.add(textFieldHoDem);

		textFieldTen = new JTextField();
		textFieldTen.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTen.setColumns(10);
		textFieldTen.setBounds(0, 162, 152, 56);
		panel_2_1.add(textFieldTen);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(235, 362, 66, 221);
		panel.add(panel_2_2);

		JLabel lblNewLabel_2_1 = new JLabel("Giới tính");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(0, 0, 66, 66);
		panel_2_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Ngành");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(0, 85, 66, 51);
		panel_2_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_1 = new JLabel("Điểm TB");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 169, 66, 42);
		panel_2_2.add(lblNewLabel_1_1);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(298, 362, 152, 221);
		panel.add(panel_2_1_1);

		textFieldNganh = new JTextField();
		textFieldNganh.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNganh.setColumns(10);
		textFieldNganh.setBounds(0, 83, 152, 56);
		panel_2_1_1.add(textFieldNganh);

		textFieldDiemTB = new JTextField();
		textFieldDiemTB.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDiemTB.setColumns(10);
		textFieldDiemTB.setBounds(0, 162, 152, 56);
		panel_2_1_1.add(textFieldDiemTB);

		radioButtonNam = new JRadioButton("Nam");
		radioButtonNam.setHorizontalAlignment(SwingConstants.LEFT);
		radioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButtonNam.setBounds(32, 8, 73, 21);
		panel_2_1_1.add(radioButtonNam);

		radioButtonNu = new JRadioButton("Nữ");
		radioButtonNu.setHorizontalAlignment(SwingConstants.LEFT);
		radioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioButtonNu.setBounds(32, 31, 73, 21);
		panel_2_1_1.add(radioButtonNu);
		buttonGioiTinh = new ButtonGroup();
		buttonGioiTinh.add(radioButtonNu);
		buttonGioiTinh.add(radioButtonNam);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(497, 362, 342, 221);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton buttonThem = new JButton("Thêm");
		buttonThem.addActionListener(act);
		buttonThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonThem.setBounds(27, 10, 136, 36);
		buttonThem.setBackground(UIManager.getColor("Button.background"));
		panel_3.add(buttonThem);

		JButton buttonSua = new JButton("Sửa");
		buttonSua.addActionListener(act);
		buttonSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonSua.setBackground(UIManager.getColor("Button.background"));
		buttonSua.setBounds(27, 66, 136, 36);
		panel_3.add(buttonSua);

		JButton buttonXoa = new JButton("Xóa");
		buttonXoa.addActionListener(act);
		buttonXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonXoa.setBackground(UIManager.getColor("Button.background"));
		buttonXoa.setBounds(27, 120, 136, 36);
		panel_3.add(buttonXoa);

		JButton buttonLuu = new JButton("Lưu");
		buttonLuu.addActionListener(act);
		buttonLuu.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonLuu.setBackground(UIManager.getColor("Button.background"));
		buttonLuu.setBounds(27, 175, 136, 36);
		panel_3.add(buttonLuu);

		JButton buttonLuuVaoDB = new JButton("<html><div style='text-align: center;'>Lưu vào<br>cơ sở dữ liệu</html>");
		buttonLuuVaoDB.setActionCommand("Lưu vào cơ sở dữ liệu");
		buttonLuuVaoDB.addActionListener(act);
		buttonLuuVaoDB.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonLuuVaoDB.setBackground(UIManager.getColor("Button.background"));
		buttonLuuVaoDB.setBounds(196, 10, 136, 90);
		panel_3.add(buttonLuuVaoDB);

		JButton buttonXoaKhoiDB = new JButton(
				"<html><div style='text-align: center;'>Xóa khỏi<br>cơ sở dữ liệu</html>");
		buttonXoaKhoiDB.setActionCommand("Xóa khỏi cơ sở dữ liệu");
		buttonXoaKhoiDB.addActionListener(act);
		buttonXoaKhoiDB.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonXoaKhoiDB.setBackground(UIManager.getColor("Button.background"));
		buttonXoaKhoiDB.setBounds(196, 121, 136, 90);
		panel_3.add(buttonXoaKhoiDB);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 351, 860, 2);
		panel.add(separator_1);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 sinh vi\u00EAn", "H\u1ECD \u0111\u1EC7m", "T\u00EAn", "Gi\u1EDBi t\u00EDnh",
						"Ng\u00E0nh h\u1ECDc", "\u0110i\u1EC3m trung b\u00ECnh" }));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 98, 860, 243);
		panel.add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuDatabase = new JMenu("Database");
		menuBar.add(menuDatabase);

		JSeparator separator_2 = new JSeparator();
		menuDatabase.add(separator_2);

		JMenuItem menuLoadDatabase = new JMenuItem("Load database");
		menuLoadDatabase.addActionListener(act);
		menuDatabase.add(menuLoadDatabase);

		JSeparator separator_3 = new JSeparator();
		menuDatabase.add(separator_3);

	}

	public void insertSinhVien() {
		try {
			int msv = Integer.parseInt(textFieldMaSV.getText().trim());
			String hoDem = textFieldHoDem.getText().trim();
			String ten = textFieldTen.getText().trim();

			if (hoDem.isEmpty() || ten.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Họ đệm và tên không được để trống!");
				return;
			}

			String gioiTinh = "";
			if (radioButtonNam.isSelected()) {
				gioiTinh = "Nam";
			} else if (radioButtonNu.isSelected()) {
				gioiTinh = "Nữ";
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính!");
				return;
			}

			String nganh = textFieldNganh.getText().trim();
			if (nganh.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ngành học không được để trống!");
				return;
			}

			float diemTB = Float.parseFloat(textFieldDiemTB.getText().trim());
			SinhVien sv = new SinhVien(msv, hoDem, ten, gioiTinh, nganh, diemTB);
			if (!model.kiemTraTonTai(sv)) {
				JOptionPane.showMessageDialog(this, "Mã sinh viên trùng lặp!");
				return;
			}
			printToTable(sv);
			model.insert(sv);
			model.printDSSV();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ: " + e.getMessage());
			return;
		}
		clearTextFields();
	}

	public void clearTextFields() {
		// Xóa tất cả nội dung trong các TextField
		textFieldMaSV.setText("");
		textFieldHoDem.setText("");
		textFieldTen.setText("");
		
		buttonGioiTinh.clearSelection();
		textFieldNganh.setText("");
		textFieldDiemTB.setText("");
	}

	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		if (i_row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một sinh viên để cập nhật.");
			return null;
		}
		int maSV = (int) model_table.getValueAt(i_row, 0);
		String hoDem = (String) model_table.getValueAt(i_row, 1);
		String ten = (String) model_table.getValueAt(i_row, 2);
		String gioiTinh = (String) model_table.getValueAt(i_row, 3);
		String nganhHoc = (String) model_table.getValueAt(i_row, 4);
		float diemTB = (float) model_table.getValueAt(i_row, 5);
		SinhVien sv = new SinhVien(maSV, hoDem, ten, gioiTinh, nganhHoc, diemTB);
		return sv;
	}

	public SinhVien getSinhVienTheoHang(int row) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một sinh viên để cập nhật.");
			return null;
		}
		int maSV = (int) model_table.getValueAt(row, 0);
		String hoDem = (String) model_table.getValueAt(row, 1);
		String ten = (String) model_table.getValueAt(row, 2);
		String gioiTinh = (String) model_table.getValueAt(row, 3);
		String nganhHoc = (String) model_table.getValueAt(row, 4);
		float diemTB = (float) model_table.getValueAt(row, 5);
		SinhVien sv = new SinhVien(maSV, hoDem, ten, gioiTinh, nganhHoc, diemTB);
		return sv;
	}

	public void getFromTableToTextField() {
		SinhVien sv = getSinhVienDangChon();
		textFieldMaSV.setText(sv.getMaSV() + "");
		textFieldHoDem.setText(sv.getHoDem());
		textFieldTen.setText(sv.getTen());
		textFieldNganh.setText(sv.getNganhHoc());
		if (sv.getGioiTinh().equals("Nam")) {
			radioButtonNam.setSelected(true);
		} else
			radioButtonNu.setSelected(true);
		textFieldDiemTB.setText(sv.getDiemTB() + "");
	}

	public void printToTable(SinhVien sv) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { sv.getMaSV(), sv.getHoDem(), sv.getTen(), sv.getGioiTinh(), sv.getNganhHoc(),
				sv.getDiemTB() });
	}

	public void updateSinhVien() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một sinh viên để cập nhật.");
			return;
		}
		// Lấy từ textfield
		int maSV = Integer.parseInt(textFieldMaSV.getText());
		String hoDem = textFieldHoDem.getText();
		String ten = textFieldTen.getText();
		String gioiTinh = radioButtonNam.isSelected() ? "Nam" : "Nữ";
		String nganhHoc = textFieldNganh.getText();
		float diemTB = Float.parseFloat(textFieldDiemTB.getText());

		// Tạo mới sv
		SinhVien sv = new SinhVien(maSV, hoDem, ten, gioiTinh, nganhHoc, diemTB);

		// Cập nhật lại
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setValueAt(sv.getHoDem(), selectedRow, 1);
		model_table.setValueAt(sv.getTen(), selectedRow, 2);
		model_table.setValueAt(sv.getGioiTinh(), selectedRow, 3);
		model_table.setValueAt(sv.getNganhHoc(), selectedRow, 4);
		model_table.setValueAt(sv.getDiemTB(), selectedRow, 5);

		JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thành công!");
		clearTextFields();
	}

	public void xoaSinhVien() {
		// TODO Auto-generated method stub
		SinhVien sv = getSinhVienDangChon();
		model.remove(sv);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			model_table.removeRow(selectedRow);
		} else
			JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để xóa");
	}

	public void insertIntoDB() {
		SinhVienDAO db = new SinhVienDAO();
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int count = model_table.getRowCount();
		if (count < 1) {
			JOptionPane.showMessageDialog(null, "Vui lòng thêm dữ liệu vào!");
		}
		for (int i = 0; i < count; i++) {
			SinhVien sv = getSinhVienTheoHang(i);
			db.insert(sv);

		}
		JOptionPane.showMessageDialog(this, "Bạn đã thực hiện lưu vào cơ sở dữ liệu thành công!");
		clearTextFields();
	}

	public void loadDB() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
		// TODO Auto-generated method stub
		for (SinhVien i : SinhVienDAO.getInstance().selectAll()) {
			printToTable(i);
		}
		JOptionPane.showMessageDialog(this, "Đưa dữ liệu từ database lên thành công");
		clearTextFields();
	}

	public void deleteFromDB() {
		// TODO Auto-generated method stub
		SinhVien sv = getSinhVienDangChon();
		SinhVienDAO.getInstance().delete(sv);
		if (SinhVienDAO.getInstance().delete(sv) != 0) {
			JOptionPane.showMessageDialog(this, "Xóa thành công!");
			xoaSinhVien();
		}else {
			JOptionPane.showMessageDialog(this, "Xóa không thành công!");
		}
		clearTextFields();
	}
}
