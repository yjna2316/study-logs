package com.kopring.studylogs.sender

class ChatSender: Sender {
    override fun send(message: String) {
        println("[CHAT] sending message.. $message")
    }
}