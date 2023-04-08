package Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon{
	private String soHoaDon;
	private Date ngayTaoHD;
	ArrayList<ThanhVien> dsTV;
	private TourDuLich tour;
	private KhachHang kh;
	private final float VAT = 0.1f;
	
	public double tinhThanhTien() {
		return dsTV.size()*tour.getGia()*VAT;
	}
	public HoaDon(String soHoaDon, Date ngayTaoHD, ArrayList<ThanhVien> dsTV, TourDuLich tour, KhachHang kh) {
		super();
		this.soHoaDon = soHoaDon;
		this.ngayTaoHD = ngayTaoHD;
		this.dsTV = dsTV;
		this.tour = tour;
		this.kh = kh;
	}
	public HoaDon(String soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	
	public HoaDon(String soHoaDon,Date ngayTaoHD) {
		this.soHoaDon = soHoaDon;
		this.ngayTaoHD = ngayTaoHD;
	}
	
	public HoaDon() {
		
	}
	public String getSoHoaDon() {
		return soHoaDon;
	}
	public void setSoHoaDon(String soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public Date getNgayTaoHD() {
		return ngayTaoHD;
	}
	public void setNgayTaoHD(Date ngayTaoHD) {
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
