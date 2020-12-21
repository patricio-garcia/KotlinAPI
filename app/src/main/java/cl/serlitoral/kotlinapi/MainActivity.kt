package cl.serlitoral.kotlinapi

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import cl.serlitoral.kotlinapi.adapter.MovieAdapter
import cl.serlitoral.kotlinapi.api.iRetrofitService
import cl.serlitoral.kotlinapi.common.Common
import cl.serlitoral.kotlinapi.model.Movie
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mService : iRetrofitService
    lateinit var layoutManager : LinearLayoutManager
    lateinit var adapter : MovieAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retroService

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            })
    }
}