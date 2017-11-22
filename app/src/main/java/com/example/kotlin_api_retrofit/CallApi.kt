package com.example.kotlin_api_retrofit;

import com.elyeproj.wikisearchcount.IGitApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CallApi(iSub: ISub) {

    var iSub: ISub
    init {
        this.iSub = iSub
    }

    var disposable: Disposable? = null
    val iGitApi by lazy {
        IGitApi.create()
    }

    fun callSearch(keyword: String) {
        disposable = iGitApi.searchUser(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { root ->
                            iSub.onResponse(root)
                        },
                        { error ->
                            iSub.onError(error)
                        }
                )
    }


    interface ISub {
        fun onResponse(root: Root)
        fun onError(error: Throwable)
    }

}