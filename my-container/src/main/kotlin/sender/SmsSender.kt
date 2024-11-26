package com.kopring.studylogs.sender

class SmsSender: Sender {
    override fun send(message: String) {
        println("[SMS] sending message.. $message")
    }
}