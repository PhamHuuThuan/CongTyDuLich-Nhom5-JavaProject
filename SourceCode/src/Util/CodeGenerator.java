package Util;

import BUS.KhachHang_Bus;
import BUS.DiaDiem_Bus;
import BUS.Tour_Bus;

public class CodeGenerator {
	Tour_Bus tourBus = new Tour_Bus();
	KhachHang_Bus khBus = new KhachHang_Bus();
	DiaDiem_Bus ddBus = new DiaDiem_Bus();
	public String sinhMaTour() {
		String maNew = "T";
		String maPre = tourBus.getMaTourMax();
		if(maPre==null||maPre.trim().length()==0)
			return "T001";
		int ma = Integer.parseInt(maPre.substring(1));
		int i = 100;
		while(ma<i && i>0) {
			maNew+='0';
			i/=10;
		}
		if((ma+1)%10==0)
			maNew = maNew.substring(0, maNew.length()-1);
		maNew += String.valueOf(ma+1);
		return maNew;
	}
	public String sinhMaKH(){
		String maNew = "KH";
		String maPre = khBus.getMaKHMax();
		if(maPre==null||maPre.trim().length()==0)
			return "KH001";
		int ma = Integer.parseInt(maPre.substring(2));
		int i = 100;
		while(ma<i && i>0) {
			maNew+='0';
			i/=10;
		}
		if((ma+1)%10==0)
			maNew = maNew.substring(0, maNew.length()-1);
		maNew += String.valueOf(ma+1);
		return maNew;
	}
	public String generateMaDiaDiemKH() {
		String maNew = "DKH";
		String maPre = ddBus.getMaDDMax();
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
		String maPre = ddBus.getMaDDMax();
		 if (maPre == null || maPre.isEmpty()) {
		        maNew += "001";
		    } else {
		        int ma = Integer.parseInt(maPre.substring(3)) + 1;
		        maNew += String.format("%03d", ma);
		    }
		    return maNew;
	}
}
