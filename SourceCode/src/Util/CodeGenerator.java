package Util;

import BUS.KhachHang_Bus;
import BUS.Tour_Bus;

public class CodeGenerator {
	Tour_Bus tourBus = new Tour_Bus();
	KhachHang_Bus khBus = new KhachHang_Bus();
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
	public String sinhMaKH(){
		String maNew = "KH";
		String maPre = khBus.getMaKHMax();
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
}
