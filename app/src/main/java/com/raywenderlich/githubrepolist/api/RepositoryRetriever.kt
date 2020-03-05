package com.raywenderlich.githubrepolist.api

import com.raywenderlich.githubrepolist.data.RepoResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private val service: GitHubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        //Creating a retrofit object
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                //Uses GSON for its JSON deserialization
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //Generates and implementation of the GitHubService interface using the retrofit object
        service = retrofit.create(GitHubService::class.java)
    }

    fun getRepositories(callback: Callback<RepoResult>) {
        val call = service.searchRepositories()
        //Performs the network call off the main thread
        call.enqueue(callback)
    }
}