package dto;

import dao.ClienteDAO;
import dao.VendedorDAO;

public class Produto {
 private String nomeProd;
 private int idProd;
 private String tamanhoProd;
 private String densidadeProd;
 private String materialProd;
 private double precoProd;
 
 public Produto(String nomeProd, int idProd, String tamanhoProd, String densidadeProd, String materialProd,
		double precoProd) {
	super();
	this.nomeProd = nomeProd;
	this.idProd = idProd;
	this.tamanhoProd = tamanhoProd;
	this.densidadeProd = densidadeProd;
	this.materialProd = materialProd;
	this.precoProd = precoProd;
	
}


public String getNomeProd() {
	return nomeProd;
}
public void setNomeProd(String nomeProd) {
	this.nomeProd = nomeProd;
}
public int getIdProd() {
	return idProd;
}
public void setIdProd(int idProd) {
	this.idProd = idProd;
}
public String getTamanhoProd() {
	return tamanhoProd;
}
public void setTamanhoProd(String tamanhoProd) {
	this.tamanhoProd = tamanhoProd;
}
public String getDensidadeProd() {
	return densidadeProd;
}
public void setDensidadeProd(String densidadeProd) {
	this.densidadeProd = densidadeProd;
}
public String getMaterialProd() {
	return materialProd;
}
public void setMaterialProd(String materialProd) {
	this.materialProd = materialProd;
}
public double getPrecoProd() {
	return precoProd;
}
public void setPrecoProd(double precoProd) {
	this.precoProd = precoProd;
}
}
