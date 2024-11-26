package com.kopring.studylogs.v1

import java.lang.reflect.Constructor

class BeanContainer {
    private val beans: HashMap<Class<*>, Any?> = hashMapOf()

    /** Bean 등록 **/
    fun registerBean(clazz: Class<*>) {
        beans[clazz] = null
    }

    /** Bean 초기화 - 생성 및 의존성 주입 **/
    fun initializeBeans() {
        beans.toMap().forEach { (clazz, instance) ->
            if (instance == null) {
                beans[clazz] = createBean(clazz)
            }
        }
    }

    /** Bean 검색 **/
    fun <T> getBean(clazz: Class<T>): T {
        return clazz.cast(beans[clazz])
            ?: throw IllegalArgumentException("No bean found for class: ${clazz.name}")
    }

    private fun createBean(clazz: Class<*>): Any {
        return beans[clazz] ?: createAndRegisterBean(clazz)
    }

    /**
     * 메소드 설명 : clazz.getDeclaredConstructor()
     * - getDeclaredConstructor()는 매개변수가 없는 생성자(기본 생성자)를 찾는다.
     * - MessagingService는 기본 생성자를 정의하지 않았으므로 NoSuchMethodException이 발생한다.
     */
    private fun createAndRegisterBean(clazz: Class<*>): Any {
        val constructor: Constructor<*> = clazz.constructors[0] // 첫 번째 생성자 선택
        val dependencies = resolveDependencies(constructor.parameterTypes)
        beans[clazz] = constructor.newInstance(*dependencies) // 배열을 가변인자로 펼쳐서 각 파라미터에 매핑
        return beans[clazz]!!
    }

    private fun resolveDependencies(parameterTypes: Array<Class<*>>): Array<Any> {
        return parameterTypes.map { type ->
            beans[type] ?: createAndRegisterBean(resolveImplementation(type))
        }.toTypedArray()
    }

    private fun resolveImplementation(clazzType: Class<*>): Class<*> {
        if (!clazzType.isInterface) return clazzType
        return beans.keys.firstOrNull { key -> clazzType.isAssignableFrom(key) && !key.isInterface }
            ?: throw IllegalArgumentException("No implementation found for interface: ${clazzType.name}")
    }
}
