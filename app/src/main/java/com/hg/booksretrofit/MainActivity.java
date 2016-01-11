package com.hg.booksretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hg.booksretrofit.adapter.BooksAdapter;
import com.hg.booksretrofit.api.IBooks;
import com.hg.booksretrofit.constants.Constants;
import com.hg.booksretrofit.model.BooksModel;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BooksAdapter mAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        // log level brings logcat output
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        IBooks iBooks = restAdapter.create(IBooks.class);
        iBooks.getBooks(new Callback<List<BooksModel>>() {
            @Override
            public void success(List<BooksModel> booksModels, Response response) {

                dismissDialog();

                 /*for (int i = 0; i < booksModels.size(); i++) {
                    BooksModel booksModel = booksModels.get(i);
                    Log.i("Info 33333333333333333", booksModel.getName() + " " + booksModel.getBookId()
                            + " " + booksModel.getInStock() + " " + booksModel.getPrice());
                }*/

                mAdapter = new BooksAdapter(booksModels, R.layout.row, getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        dismissDialog();
    }

    public void dismissDialog(){
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }
}
