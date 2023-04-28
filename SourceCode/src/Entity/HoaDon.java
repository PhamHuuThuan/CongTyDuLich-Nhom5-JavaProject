package Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon{
	private String soHoaDon;
	private java.sql.Timestamp ngayTaoHD;
	ArrayList<ThanhVien> dsTV;
	private TourDuLich tour;
	private KhachHang kh;
	private NhanVien nv;
	private final float VAT = 1.1f;
	
	public double tinhThanhTien() {
		return Math.round(dsTV.size()*tour.getGia()*VAT);
	}
	public HoaDon(String soHoaDon, java.sql.Timestamp ngayTaoHD, ArrayList<ThanhVien> dsTV, TourDuLich tour, KhachHang kh, NhanVien nv) {
		super();
		this.soHoaDon = soHoaDon;
		this.ngayTaoHD = ngayTaoHD;
		this.dsTV = dsTV;
		this.tour = tour;
		this.kh = kh;
		this.nv = nv;
	}
	public HoaDon() {
		
	}
	public HoaDon(String soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public HoaDon(String soHoaDon,java.sql.Timestamp ngayTaoHD, TourDuLich tour,NhanVien nv) {
		this.soHoaDon = soHoaDon;
		this.ngayTaoHD = ngayTaoHD;
		this.tour = tour;
		this.nv = nv;
	}
	public String getSoHoaDon() {
		return soHoaDon;
	}
	public void setSoHoaDon(String soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public java.sql.Timestamp getNgayTaoHD() {
		return ngayTaoHD;
	}
	public void setNgayTaoHD(java.sql.Timestamp ngayTaoHD) {
		this.ngayTaoHD = ngayTaoHD;
	}
	public ArrayList<ThanhVien> getDsTV() {
		return dsTV;
	}
	public void setDsTV(ArrayList<ThanhVien> dsTV) {
		this.dsTV = dsTV;
	}
	public TourDuLich getTour() {
		return tour;
	}
	public void setTour(TourDuLich tour) {
		this.tour = tour;
	}
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	@Override
	public int hashCode() {
		return Objects.hash(soHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(soHoaDon, other.soHoaDon);
	}
}
