package com.example.kotlin_api_retrofit;

import java.util.*
import kotlin.collections.ArrayList

class Root() {
    val total_count: Int = 0 //9
    val incomplete_results: Boolean = false //false
    val items: List<Item> = ArrayList<Item>()

}

data class Item(
        val login: String, //RajuSE
        val id: Int, //10866662
        val avatar_url: String, //https://avatars1.githubusercontent.com/u/10866662?v=4
        val gravatar_id: String,
        val url: String, //https://api.github.com/users/RajuSE
        val html_url: String, //https://github.com/RajuSE
        val followers_url: String, //https://api.github.com/users/RajuSE/followers
        val following_url: String, //https://api.github.com/users/RajuSE/following{/other_user}
        val gists_url: String, //https://api.github.com/users/RajuSE/gists{/gist_id}
        val starred_url: String, //https://api.github.com/users/RajuSE/starred{/owner}{/repo}
        val subscriptions_url: String, //https://api.github.com/users/RajuSE/subscriptions
        val organizations_url: String, //https://api.github.com/users/RajuSE/orgs
        val repos_url: String, //https://api.github.com/users/RajuSE/repos
        val events_url: String, //https://api.github.com/users/RajuSE/events{/privacy}
        val received_events_url: String, //https://api.github.com/users/RajuSE/received_events
        val type: String, //User
        val site_admin: Boolean, //false
        val score: Double //44.896065
)