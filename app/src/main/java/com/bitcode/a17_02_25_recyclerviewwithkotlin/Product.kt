package com.bitcode.a17_02_25_recyclerviewwithkotlin

import java.io.Serializable

data class Product(
    var id : Int,
    var title : String,
    var price : Int
) : Serializable{
    override fun toString(): String {
        return "title $title"
    }
}
