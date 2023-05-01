package Util;

import BUS.KhachHang_Bus;
import BUS.DiaDiem_Bus;
import BUS.HoaDon_Bus;
import BUS.PhuongTien_Bus;
import BUS.ThanhVien_Bus;
import BUS.Tour_Bus;

public class CodeGenerator {
	private Tour_Bus tourBus = new Tour_Bus();
	private KhachHang_Bus khBus = new KhachHang_Bus();
	private DiaDiem_Bus ddBus = new DiaDiem_Bus();
	private HoaDon_Bus hdBus = new HoaDon_Bus();
	private PhuongTien_Bus ptBus = new PhuongTien_Bus();
	private ThanhVien_Bus tvBus = new ThanhVien_Bus();
	public String sinhMaTour() {
		String maNew = "T";
		String maPre = tourBus.getMaTourMax();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(1)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String sinhMaKH(){
		String maNew = "KH";
		String maPre = khBus.getMaKHMax();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(2)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String sinhMaHD(){
		String maNew = "HD";
		String maPre = hdBus.getMaHoaDonMax();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(2)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String sinhMaTV(){
		String maNew = "TV";
		String maPre = tvBus.getMaTVMax();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(2)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String generateMaDiaDiemKH() {
		String maNew = "DKH";
		String maPre = ddBus.getMaDDMaxKH();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(3)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String generateMaDiaDiemDL() {
		String maNew = "DDL";
		String maPre = ddBus.getMaDDMaxDL();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(3)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
	public String generateMaPTien() {
		String maNew = "PT";
		String maPre = ptBus.getMaPTMax();
		if (maPre == null || maPre.isEmpty()) {
		    maNew += "01";
		}else {
		 	int ma = Integer.parseInt(maPre.substring(2)) + 1;
		 	maNew += String.format("%02d", ma);
		}
		return maNew;
	}
}
