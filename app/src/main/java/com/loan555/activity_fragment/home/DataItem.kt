package com.loan555.activity_fragment.home

import android.media.Image

class Product(
    var name: String,
    var address: String,
    var time: String,
    var value1: String,
    var value2: String
) {

    override fun toString(): String {
        return "$name |$address |$time | $value1 | $value2 "
    }
}

class News(var img: Int, var title1: String, var contentTitle: String, var contentNews: String, var timeTitle: String)

class Object1(var image : Int,var txt:String)
class Object2(var txt:String)