package KhachSan.themHD;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import KhachSan.HDGio;
	import KhachSan.HDNgay;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

public class FormThemHDGUI extends JFrame {

		private JLabel lblMaHD, lblNgayHD, lblTenKH,
		lblMaPhong, lblDonGia, lblSoNgayThue, lblSoGioThue,lblLoaiHD, lblEmpty; 
		private JTextField txtMaHD, txtNgayHD, txtTenKH,
		txtMaPhong, txtDonGia, txtSoNgayThue, txtSoGioThue ;
		private JComboBox<String> cboLoaiHD;
		private JButton btnLuu;
		
		public FormThemHDGUI() {
			setTitle("Thêm mới chuyến xe");
			setSize(400, 400);
			setLocationRelativeTo(null);
			GridLayout gridLayout = new 
					GridLayout(10, 2, 5, 5);
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(gridLayout);
			initComponents();
			//bó sát
			pack();
			setVisible(true);
		}
		
		private void initComponents() {
			lblMaHD = new JLabel("Mã HD");
			txtMaHD = new JTextField(20);
			add(lblMaHD);
			add(txtMaHD);
			lblNgayHD = new JLabel("Ngày HD");
			txtNgayHD = new JTextField(20);
			add(lblNgayHD);
			add(txtNgayHD);
			lblTenKH = new JLabel("Tên KH");
			txtTenKH = new JTextField(20);
			add(lblTenKH);
			add(txtTenKH); 
			lblMaPhong = new JLabel("Mã Phòng");
			txtMaPhong = new JTextField(20);
			add(lblMaPhong);
			add(txtMaPhong);
			lblDonGia = new JLabel("Giá");
			txtDonGia = new JTextField(20);
			add(lblDonGia);
			add(txtDonGia);
			lblLoaiHD = new JLabel("Loại HD");
			cboLoaiHD = new JComboBox<String>(
					new String[] {"HD Giờ", "HD Ngày"}
					);
			add(lblLoaiHD);
			add(cboLoaiHD);
			//HD Giờ
			lblSoGioThue = new JLabel("Số Giờ Thuê");
			txtSoGioThue = new JTextField(20);
			add(lblSoGioThue);
			add(txtSoGioThue);
			//HD Ngày
			lblSoNgayThue = new JLabel("Số Ngày Thuê");
			txtSoNgayThue = new JTextField(20);
			add(lblSoNgayThue);
			add(txtSoNgayThue);
			//nút
			lblEmpty = new JLabel("");
			btnLuu = new JButton("Lưu");
			ActionListener luuCXListener = null;
			luuCXListener = new LuuHDListener();
			btnLuu.addActionListener(luuCXListener);
			add(lblEmpty);
			add(btnLuu);
		}		
		private class LuuHDListener implements ActionListener{
		    @Override
		    public void actionPerformed(ActionEvent e) {		     
		        try { 
		            //gửi thông điệp đến đối tượng Control
		            ThemHDControl themHDControl = null;
		            ThemHDDAO themHDDAO = null;
		            themHDDAO = new MemoryThemHDDAO();
		            //themCXDAO = new FileThemCXDAO("cx.db");
		            ThemHDResultDialogGUI resultDialogGUI = new ThemHDResultDialogGUI();
		            ReqData request = new ReqData();		    
		            request.maHD = Integer.parseInt(txtMaHD.getText());		            		            
		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		            request.ngayHD = LocalDate.parse(txtNgayHD.getText(), formatter);
		            
		            request.tenKH = txtTenKH.getText();
		            request.maPhong = txtMaPhong.getText();
		            request.donGia = Double.parseDouble(txtDonGia.getText());
		            
		            String loaiHD = cboLoaiHD.getSelectedItem().toString();
		            request.loaiHD = loaiHD;
		            
		            if(loaiHD.equalsIgnoreCase("HD Giờ")) {
		                request.soGioThue = Double.parseDouble(txtSoGioThue.getText());
		                themHDControl = new ThemHDControlGio(resultDialogGUI, themHDDAO);
		                
		            }
		            
		            if(loaiHD.equalsIgnoreCase("HD Ngày")) {
		                request.soNgayThue = Double.parseDouble(txtSoNgayThue.getText());		              
		                themHDControl = new ThemHDControlNgay(resultDialogGUI, themHDDAO); 
		            }		         
		            if (themHDControl != null) {
		                themHDControl.control(request);
		            } else {
		                 resultDialogGUI.show(new ResData(
		                    new String[]{"Lỗi: Vui lòng chọn loại Hóa đơn."}));
		            }
		            
		        } catch (NumberFormatException ex) {
		            ThemHDResultDialogGUI errorDialog = new ThemHDResultDialogGUI();
		            errorDialog.show(new ResData(
		                new String[]{"Lỗi nhập liệu: Mã HD, Giá, Số giờ/ngày phải là số hợp lệ."}));
		        } catch (java.time.format.DateTimeParseException ex) {
		            ThemHDResultDialogGUI errorDialog = new ThemHDResultDialogGUI();
		            errorDialog.show(new ResData(
		                new String[]{"Lỗi nhập liệu: Ngày HD không hợp lệ (Dùng DD/MM/YYYY)."}));
		        }
		    }
		}
		}
			



