package Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class TourDuLich {
	private String maTour;
	private String tenTour;
	private String moTa;
	private int soCho;
	private String phuongTien;
	private Date ngayDi;
	private Date ngayKetThuc;
	private String diemKH;
	private String diemDen;
	private String khachSan;
	private double gia;
	
	
	public TourDuLich() {
		ArrayList<String >danhSachAnh =new ArrayList<>();
	}


	public TourDuLich(String maTour, String tenTour, String moTa, int soCho, String phuongTien, Date ngayDi,
			Date ngayKetThuc, String diemKH, String diemDen, String khachSan, double gia) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.moTa = moTa;
		this.soCho = soCho;
		this.phuongTien = phuongTien;
		this.ngayDi = ngayDi;
		this.ngayKetThuc = ngayKetThuc;
		this.diemKH = diemKH;
		this.diemDen = diemDen;
		this.khachSan = khachSan;
		this.gia = gia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(diemDen, diemKH, gia, khachSan, maTour, moTa, ngayDi, ngayKetThuc, phuongTien, soCho,
				tenTour);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourDuLich other = (TourDuLich) obj;
		return Objects.equals(diemDen, other.diemDen) && Objects.equals(diemKH, other.diemKH)
				&& Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(khachSan, other.khachSan) && Objects.equals(maTour, other.maTour)
				&& Objects.equals(moTa, other.moTa) && Objects.equals(ngayDi, other.ngayDi)
				&& Objects.equals(ngayKetThuc, other.ngayKetThuc) && Objects.equals(phuongTien, other.phuongTien)
				&& soCho == other.soCho && Objects.equals(tenTour, other.tenTour);
	}


	public String getMaTour() {
		return maTour;
	}


	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}


	public String getTenTour() {
		return tenTour;
	}


	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public int getSoCho() {
		return soCho;
	}


	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}


	public String getPhuongTien() {
		return phuongTien;
	}


	public void setPhuongTien(String phuongTien) {
		this.phuongTien = phuongTien;
	}


	public Date getNgayDi() {
		return ngayDi;
	}


	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}


	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}


	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}


	public String getDiemKH() {
		return diemKH;
	}


	public void setDiemKH(String diemKH) {
		this.diemKH = diemKH;
	}


	public String getDiemDen() {
		return diemDen;
	}


	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}


	public String getKhachSan() {
		return khachSan;
	}


	public void setKhachSan(String khachSan) {
		this.khachSan = khachSan;
	}


	public double getGia() {
		return gia;
	}


	public void setGia(double gia) {
		this.gia = gia;
	}
	
}
