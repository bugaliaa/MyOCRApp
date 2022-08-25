package com.example.core.serialization

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.io.StringReader

class JsonParser {

    private val sGson: Gson = Gson()

    fun <T : Any> getClassFromJson(jsonString: String?, clazz: Class<T>): T? {
        if (jsonString.isNullOrEmpty()) return null
        return try {
            sGson.fromJson(jsonString, clazz)
        } catch (exception: Exception) {
            null
        }
    }

    fun <T : Any> getClassFromJson(jsonObject: JSONObject?, clazz: Class<T>): T? {
        if (jsonObject == null) return null
        return getClassFromJson(jsonObject.toString(), clazz)
    }

    fun <T : Any> getListFromJson(jsonString: String?, clazz: Class<T>): List<T>? {
        if (jsonString.isNullOrEmpty()) return null
        return try {
            val classType = TypeToken.getParameterized(List::class.java, clazz).type
            sGson.fromJson(StringReader(jsonString), classType)
        } catch (exception: Exception) {
            null
        }
    }

    fun toJsonString(data: Any?): String? {
        if (data == null) return null
        return try {
            sGson.toJson(data, data.javaClass)
        } catch (exception: Exception) {
            null
        }
    }

    fun <T : Any> getListFromJson(jsonArray: JSONArray?, clazz: Class<T>): List<T>? {
        if (jsonArray == null) return null
        return getListFromJson(jsonArray.toString(), clazz)
    }

    fun toJsonObject(jsonString: String?): JSONObject? {
        if (jsonString.isNullOrEmpty()) return null
        return try {
            JSONObject(jsonString)
        } catch (exception: Exception) {
            null
        }
    }

    fun toJsonArray(jsonString: String?): JSONArray? {
        if (jsonString.isNullOrEmpty()) return null
        return try {
            JSONArray(jsonString)
        } catch (exception: Exception) {
            null
        }
    }

    fun <T : Any> getCopy(clazz: Class<T>, data: T): T? {
        val jsonString = sGson.toJson(data)
        return getClassFromJson(jsonString, clazz)
    }
}