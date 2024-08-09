package com.kopring.autoconfiguration.conditional.config

import io.kotest.core.spec.style.StringSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.support.GenericApplicationContext

// TODO: 왜 Kotest run test 버튼이 안 보일까?
// 버전 호환성.. gradle, kotlin, jdk, java 버전 ....
@SpringBootTest
class ConditionalOnClassConfigTestNotWorking(
    private val applicationContext: GenericApplicationContext
): StringSpec() {
    init {
        "datasourceA 클래스가 존재할때만 databaseConditionalOnClass 빈이 존재한다" {
            if (isClassPresent("com.kopring.autoconfiguration.conditional.service.DataSourceA")) {
                applicationContext.containsBean("databaseConditionalOnClass")
            }
        }
        "datasourceB 클래스가 존재하지않으면 databaseConditionalOnClass 빈은 존재하지 않는다" {
            if (isClassPresent("com.kopring.autoconfiguration.conditional.service.DataSourceB")) {
                applicationContext.containsBean("databaseConditionalOnClass")
            }
        }
    }

    private fun isClassPresent(className: String): Boolean {
        return try {
            Class.forName(className)
            true
        } catch (e: ClassNotFoundException) {
            false
        }
    }
}