package Entity;

import java.sql.Date;

public class HoaDon extends KhachHang{
	private String soHoaDon;
	private Date ngayTaoHD;
	public HoaDon(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh, String email,
			String diaChi, String soHoaDon, Date ngayTaoHD) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh, email, diaChi);
		this.soHoaDon = soHoaDon;
		this.ngayTaoHD = ngayTaoHD;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh, String email,
			String diaChi) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh, email, diaChi);
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh);
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maND) {
		super(maND);
		// TODO Auto-generated constructor stub
	}
	
	
}
