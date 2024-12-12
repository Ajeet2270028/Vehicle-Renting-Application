package com.example.vra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int imageid;
private String contentType;
@Lob
private byte[] imageBytes;
public int getImageid() {
	return imageid;
}
public void setImageid(int imageid) {
	this.imageid = imageid;
}
public String getContentType() {
	return contentType;
}
public void setContentType(String contentType) {
	this.contentType = contentType;
}
public byte[] getImageBytes() {
	return imageBytes;
}
public void setImageBytes(byte[] imageBytes) {
	this.imageBytes = imageBytes;
}
//
}
