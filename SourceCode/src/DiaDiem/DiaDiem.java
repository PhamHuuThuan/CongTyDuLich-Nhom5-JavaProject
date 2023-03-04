package DiaDiem;

import java.util.Objects;

public class DiaDiem {
	private String maDD;
	private String tenDD;
	private String diaChi;
	private String moTa;
	private String linkH1;
	private String linkH2;
	private String linkH3;
	private String linkH4;
	private String linkH5;
	public DiaDiem(String maDD, String tenDD, String diaChi, String moTa, String linkH1) {
		super();
		this.maDD = maDD;
		this.tenDD = tenDD;
		this.diaChi = diaChi;
		this.moTa = moTa;
		this.linkH1 = linkH1;
	}
	public DiaDiem(String maDD, String tenDD, String diaChi, String moTa, String linkH1, String linkH2, String linkH3,
			String linkH4, String linkH5) {
		super();
		this.maDD = maDD;
		this.tenDD = tenDD;
		this.diaChi = diaChi;
		this.moTa = moTa;
		this.linkH1 = linkH1;
		this.linkH2 = linkH2;
		this.linkH3 = linkH3;
		this.linkH4 = linkH4;
		this.linkH5 = linkH5;
	}
	public DiaDiem(String maDD) {
		super();
		this.maDD = maDD;
	}
	public DiaDiem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDD() {
		return maDD;
	}
	public void setMaDD(String maDD) {
		this.maDD = maDD;
	}
	public String getTenDD() {
		return tenDD;
	}
	public void setTenDD(String tenDD) {
		this.tenDD = tenDD;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getLinkH1() {
		return linkH1;
	}
	public void setLinkH1(String linkH1) {
		this.linkH1 = linkH1;
	}
	public String getLinkH2() {
		return linkH2;
	}
	public void setLinkH2(String linkH2) {
		this.linkH2 = linkH2;
	}
	public String getLinkH3() {
		return linkH3;
	}
	public void setLinkH3(String linkH3) {
		this.linkH3 = linkH3;
	}
	public String getLinkH4() {
		return linkH4;
	}
	public void setLinkH4(String linkH4) {
		this.linkH4 = linkH4;
	}
	public String getLinkH5() {
		return linkH5;
	}
	public void setLinkH5(String linkH5) {
		this.linkH5 = linkH5;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDD);
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
		return Objects.equals(maDD, other.maDD);
	}
}
