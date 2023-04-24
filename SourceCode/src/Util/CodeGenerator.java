package Util;

import BUS.DiaDiem_Bus;
import BUS.Tour_Bus;

public class CodeGenerator {
	Tour_Bus tourBus = new Tour_Bus();
	DiaDiem_Bus ddBus = new DiaDiem_Bus();
	public String sinhMaTour() {
		String maNew = "T";
		String maPre = tourBus.getMaTourMax();
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
