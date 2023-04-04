package Entity;

import java.sql.Date;

public class KhachHang extends NguoiDung{
	private String email;
	private String diaChi;
	
	public KhachHang(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh,
			String email, String diaChi) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh);
		this.email = email;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh);
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maND) {
		super(maND);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
