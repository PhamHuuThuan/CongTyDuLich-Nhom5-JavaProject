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
	private DiaDiem diemKH;
	private DiaDiem diemDen;
	private String khachSan;
	private double gia;
	private ArrayList<String> dsAnh = new ArrayList<String>();
	
	public TourDuLich() {
		
	}
	public TourDuLich(String maTour) {
		this.maTour = maTour;
	}
	public TourDuLich(String maTour, String tenTour, String moTa, int soCho, String phuongTien, Date ngayDi,
			Date ngayKetThuc, DiaDiem diemKH, DiaDiem diemDen, String khachSan, double gia, ArrayList<String> dsAnh) {
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
		this.dsAnh = dsAnh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTour);
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
		return Objects.equals(maTour, other.maTour);
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


	public DiaDiem getDiemKH() {
		return diemKH;
	}


	public void setDiemKH(DiaDiem diemKH) {
		this.diemKH = diemKH;
	}


	public DiaDiem getDiemDen() {
		return diemDen;
	}


	public void setDiemDen(DiaDiem diemDen) {
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
