package v1

import com.kopring.studylogs.v1.BeanContainer
import com.kopring.studylogs.v1.MessagingService
import com.kopring.studylogs.sender.SmsSender
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class BeanContainerTest {

    @Test
    fun `register and init beans`() {
        // given
        val beanContainer = BeanContainer()

        // when
        beanContainer.registerBean(SmsSender::class.java)
        beanContainer.registerBean(MessagingService::class.java)

        beanContainer.initializeBeans()

        // then
        val messagingService = beanContainer.getBean(MessagingService::class.java)
        assertNotNull(messagingService)

        val smsSender = beanContainer.getBean(SmsSender::class.java)
        assertNotNull(smsSender)

        messagingService.send("HELLO, This is a test message.")
    }
}
