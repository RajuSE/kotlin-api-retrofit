package com.example.kotlin_api_retrofit

import android.util.Log
import com.google.gson.Gson


object LogUtil {
    fun info(Tag: String, message: String) {
        if (BuildConfig.BUILD_TYPE.equals("release"))
            return
        Log.d(Tag, message)
    }

    fun printObject(obj: Any) {
        if (BuildConfig.BUILD_TYPE.equals("release"))
            return
        val string = Gson().toJson(obj)
        LogUtil.info(obj.javaClass.simpleName, string)
    }
}