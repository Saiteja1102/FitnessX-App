package com.example.fitnessx

class Message(val message: String, val sentBy: String) {

    companion object {
        const val SENT_BY_ME = "me"
        const val SENT_BY_BOT = "bot"
    }

//    fun getMessage(): String {
//        return message
//    }
//
//    fun getSentBy(): String {
//        return sentBy
//    }
}

