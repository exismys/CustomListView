package com.example.customlistview

class Writer(var name: String, var description: String, var image: Int) {

    companion object {
        val writerList = arrayOf(
            Writer("Alan Watts", "He was someone", R.drawable.alanwatts),
            Writer("Ted Chiang", "He was someone", R.drawable.tedchiange))
    }
}