package Entity;

import java.sql.Date;
import java.util.Objects;


public class ThanhVien {
	private String maTV;
	private String tenTV;
	private boolean gioiTinh;
	private Date ngaySinh;
	private boolean luaTuoi;
	public String getMaTV() {
		return maTV;
	}
	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}
	public String getTenTV() {
		return tenTV;
	}
	public void setTenTV(String tenTV) {
		this.tenTV = tenTV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isLuaTuoi() {
		return luaTuoi;
	}
	public void setLuaTuoi(boolean luaTuoi) {
		this.luaTuoi = luaTuoi;
	}
	public ThanhVien(String maTV, String tenTV, boolean gioiTinh, Date ngaySinh, boolean luaTuoi) {
		super();
		this.maTV = maTV;
		this.tenTV = tenTV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.luaTuoi = luaTuoi;
	}
	public ThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThanhVien(String maTV) {
		super();
		this.maTV = maTV;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maTV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThanhVien other = (ThanhVien) obj;
		return Objects.equals(maTV, other.maTV);
	}
	
	
}