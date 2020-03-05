package com.raywenderlich.githubrepolist.data

data class RepoResult(val items: List<Item>)

data class Item(
        val id: Long?,
        val name: String?,
        val full_name: String?,
        val owner: Owner,
        val private: Boolean,
        val html_url: String?,
        val description: String?)

data class Owner(val login: String?, val id: Long?, val avatar_url: String?)
