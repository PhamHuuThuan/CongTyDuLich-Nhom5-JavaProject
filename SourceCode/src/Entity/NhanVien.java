package Entity;

import java.sql.Date;

public class NhanVien extends NguoiDung{
	private String cccd;
	private Date ngayVL;
	
	public NhanVien(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh,
			String cccd, Date ngayVL) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh);
		this.cccd = cccd;
		this.ngayVL = ngayVL;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh) {
		super(maND, soDT, matKhau, tenND, ngaySinh, gioiTinh);
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maND) {
		super(maND);
		// TODO Auto-generated constructor stub
	}
}	
