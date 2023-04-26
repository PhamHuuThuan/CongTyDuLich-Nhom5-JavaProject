package Entity;

public class PhuongTien {
	private String maPT;
	private String tenPT;
	
	public PhuongTien(String maPT) {
		this.maPT = maPT;
	}
	public PhuongTien(String maPT, String tenPT) {
		super();
		this.maPT = maPT;
		this.tenPT = tenPT;
	}
	public PhuongTien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaPT() {
		return maPT;
	}
	public void setMaPT(String maPT) {
		this.maPT = maPT;
	}
	public String getTenPT() {
		return tenPT;
	}
	public void setTenPT(String tenPT) {
		this.tenPT = tenPT;
	}
	
	
}
