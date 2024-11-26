package com.kopring.studylogs.v1

import com.kopring.studylogs.sender.Sender

class MessagingService(private val sender: Sender) {

    constructor(type: String, sender: Sender): this(
        sender
    )

    fun send(message: String) {
        sender.send(message)
    }
}
