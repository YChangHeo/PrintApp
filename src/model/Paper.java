package model;

public class Paper {
	private String PaperID;
	private String PaperName;
	private double Width;
	private double Height;
	private int Price;
	private String SupplyName;
	
	public String getPaperID() {
		return PaperID;
	}
	public void setPaperID(String paperID) {
		PaperID = paperID;
	}	
	public String getPaperName() {
		return PaperName;
	}
	public void setPaperName(String paperName) {
		PaperName = paperName;
	}
	public double getWidth() {
		return Width;
	}
	public void setWidth(double width) {
		Width = width;
	}
	public double getHeight() {
		return Height;
	}
	public void setHeight(double height) {
		Height = height;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getSupplyName() {
		return SupplyName;
	}
	public void setSupplyName(String supplyName) {
		SupplyName = supplyName;
	}
	
}
