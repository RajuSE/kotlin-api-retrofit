package com.example.kotlin_api_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_user_search.*

class UserSearchActivity : AppCompatActivity(), CallApi.ISub {

    lateinit var listAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_search)

        callApi = CallApi(this)

        searchBtn.setOnClickListener {
            if (nameEditText.text.toString().isNotEmpty()) {
                if (BuildConfig.IS_MOCK) {
                    val root = Gson().fromJson<Root>(getMock(), Root::class.java)
                    handleResponse(root)
                } else {
                    callServer(nameEditText.text.toString())
                }
            }
        }
    }

    private fun handleResponse(root: Root) {
        with(recyclerViewGithubUsers) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@UserSearchActivity)
            listAdapter = MyAdapter(root.items)
            recyclerViewGithubUsers.adapter = listAdapter
        }
    }

    fun getMock(): String {//Mocked
        val s = "{\"total_count\":9,\"incomplete_results\":false,\"items\":[{\"login\":\"RajuSE\",\"id\":10866662,\"avatar_url\":\"https://avatars1.githubusercontent.com/u/10866662?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/RajuSE\",\"html_url\":\"https://github.com/RajuSE\",\"followers_url\":\"https://api.github.com/users/RajuSE/followers\",\"following_url\":\"https://api.github.com/users/RajuSE/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/RajuSE/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/RajuSE/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/RajuSE/subscriptions\",\"organizations_url\":\"https://api.github.com/users/RajuSE/orgs\",\"repos_url\":\"https://api.github.com/users/RajuSE/repos\",\"events_url\":\"https://api.github.com/users/RajuSE/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/RajuSE/received_events\",\"type\":\"User\",\"site_admin\":false,\"score\":44.896065},{\"login\":\"rajusem\",\"id\":369290,\"avatar_url\":\"https://avatars0.githubusercontent.com/u/369290?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/rajusem\",\"html_url\":\"https://github.com/rajusem\",\"followers_url\":\"https://api.github.com/users/rajusem/followers\",\"following_url\":\"https://api.github.com/users/rajusem/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/rajusem/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/rajusem/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/rajusem/subscriptions\",\"organizations_url\":\"https://api.github.com/users/rajusem/orgs\",\"repos_url\":\"https://api.github.com/users/rajusem/repos\",\"events_url\":\"https://api.github.com/users/rajusem/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/rajusem/received_events\",\"type\":\"User\",\"site_admin\":false,\"score\":7.6162734}]}"
        return s;
    }


    lateinit var callApi: CallApi
    private fun callServer(keyword: String) {
        callApi.callSearch(keyword)
    }

    override fun onResponse(root: Root) {
        LogUtil.printObject(root)
        handleResponse(root)
    }

    override fun onError(error: Throwable) {
        LogUtil.printObject(error)
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        callApi.disposable?.dispose()
    }
}

