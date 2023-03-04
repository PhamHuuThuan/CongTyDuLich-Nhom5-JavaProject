package DiaDiem;

import java.util.ArrayList;

public class DiaDiem_Collection {
	ArrayList<DiaDiem> dsDD;

	public DiaDiem_Collection() {
		super();
		dsDD = new ArrayList<DiaDiem>();
	}
	public boolean themDiaDiem(DiaDiem dd) {
		if(dsDD.contains(dd)) {
			return false;
		}
		dsDD.add(dd);
		return true;
	}
	
	//delete
	public boolean deleteNV(String maDD) {
		DiaDiem dd = new DiaDiem(maDD);
		if(dsDD.contains(dd)) {
			dsDD.remove(dd);
			return true;
		}
		return false;
	}
	//tìm kiêm theo mã
	public DiaDiem timKiem(String maDD) {
		DiaDiem dd = new DiaDiem(maDD);
		if(dsDD.contains(dd)) {
			return dsDD.get(dsDD.indexOf(dd));
		}
		return null;
	}
	//lấy ds
	public ArrayList<DiaDiem> getDSDiaDiem(){
		return dsDD;
	}
	//gán ds
	public void setDSDiaDiem(ArrayList<DiaDiem> dsDD) {
		this.dsDD = dsDD;
	}
	//lấy 1 trong ds khi biết vị trí
	public DiaDiem getElement(int index) {
		if(index<0 || index>dsDD.size())
			return null;
		return dsDD.get(index);
	}
	//tong so dai diem trong ds
	public int soLuongDD() {
		return dsDD.size();
	}
	//sua
	public boolean suaNV(DiaDiem x) {
		if(dsDD.contains(x)) {
			DiaDiem sua = dsDD.get(dsDD.indexOf(x));
			sua.setTenDD(x.getTenDD());
			sua.setDiaChi(x.getDiaChi());
			sua.setMoTa(x.getMoTa());
			sua.setLinkH1(x.getLinkH1());
			sua.setLinkH2(x.getLinkH2());
			sua.setLinkH3(x.getLinkH3());
			sua.setLinkH4(x.getLinkH4());
			sua.setLinkH5(x.getLinkH5());
			return true;
		}
		return false;
	}
}
