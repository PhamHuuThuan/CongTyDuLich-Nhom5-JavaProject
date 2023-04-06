package Entity;

public class DiaDiem {
	private String maDiaDiem;
	private String tenDiaDiem;
	
	public DiaDiem(String maDiaDiem) {
		super();
		this.maDiaDiem = maDiaDiem;
	}
	public DiaDiem(String maDiaDiem, String tenDiaDiem) {
		super();
		this.maDiaDiem = maDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
	}
	
	public DiaDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaDiaDiem() {
		return maDiaDiem;
	}
	public void setMaDiaDiem(String maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}
	public String getTenDiaDiem() {
		return tenDiaDiem;
	}
	public void setTenDiaDiem(String tenDiaDiem) {
		this.tenDiaDiem = tenDiaDiem;
	}
	
}
