package cl.serlitoral.kotlinapi.common

import cl.serlitoral.kotlinapi.api.RetrofitClient
import cl.serlitoral.kotlinapi.api.iRetrofitService

object Common {
    private const val BASE_URL = "https://simplifiedcoding.net/demos/"
    val retroService : iRetrofitService
       get() = RetrofitClient.getClient(BASE_URL).create(iRetrofitService::class.java)
}