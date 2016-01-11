package com.hg.booksretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BooksModel {

    @SerializedName("bookId")
    @Expose
    private String bookId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("inStock")
    @Expose
    private String inStock;

    /**
     *
     * @return
     * The bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     *
     * @param bookId
     * The bookId
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The inStock
     */
    public String getInStock() {
        return inStock;
    }

    /**
     *
     * @param inStock
     * The inStock
     */
    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

}
