package com.sociallibrary.domain;

public class Book{
   private String bookName;
   private String bookCategory;
   private int bookRating;
   private String bookImage;
   private String bookISBN;
   
   public Book(String bookName,String bookCategory, int bookRating, String bookISBN){
	   this.setBookName(bookName);
	   this.setBookCategory(bookCategory);
	   this.setBookRating(bookRating);
	   this.setBookISBN(bookISBN);
   }

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getBookCategory() {
	return bookCategory;
}

public void setBookCategory(String bookCategory) {
	this.bookCategory = bookCategory;
}

public int getBookRating() {
	return bookRating;
}

public void setBookRating(int bookRating) {
	this.bookRating = bookRating;
}

public String getBookImage() {
	return bookImage;
}

public void setBookImage(String bookImage) {
	this.bookImage = bookImage;
}

public String getBookISBN() {
	return bookISBN;
}

public void setBookISBN(String bookISBN) {
	this.bookISBN = bookISBN;
}
   
   
}
