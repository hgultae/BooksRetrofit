package com.hg.booksretrofit.api;

import com.hg.booksretrofit.model.BooksModel;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Hurman on 17/12/2015.
 */
public interface IBooks {

    @GET("/RetrofitExample/books.json")
    public void getBooks(Callback<List<BooksModel>> response);


}
