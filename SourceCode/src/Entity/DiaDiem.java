package Entity;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(maDiaDiem);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaDiem other = (DiaDiem) obj;
		return Objects.equals(maDiaDiem, other.maDiaDiem);
	}
	@Override
	public String toString() {
		return tenDiaDiem;
	}
	 
}
