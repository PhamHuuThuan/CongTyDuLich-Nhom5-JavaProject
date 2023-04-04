package Entity;

import java.sql.Date;
import java.util.Objects;

public class NguoiDung {
	private String maND;
	private String soDT;
	private String matKhau;
	private String tenND;
	private Date ngaySinh;
	private Boolean gioiTinh;
	public String getMaND() {
		return maND;
	}
	public void setMaND(String maND) {
		this.maND = maND;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getTenND() {
		return tenND;
	}
	public void setTenND(String tenND) {
		this.tenND = tenND;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maND);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof NguoiDung)) {
			return false;
		}
		NguoiDung other = (NguoiDung) obj;
		return Objects.equals(maND, other.maND);
	}
	public NguoiDung(String maND, String soDT, String matKhau, String tenND, Date ngaySinh, Boolean gioiTinh) {
		super();
		this.maND = maND;
		this.soDT = soDT;
		this.matKhau = matKhau;
		this.tenND = tenND;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public NguoiDung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NguoiDung(String maND) {
		this.maND = maND;
	}
}
