package com.kopring.studylogs.sender

class EmailSender: Sender {
    override fun send(message: String) {
        println("[EMAIL] sending message.. $message")
    }
}