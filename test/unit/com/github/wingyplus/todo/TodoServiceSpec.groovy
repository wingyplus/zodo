package com.github.wingyplus.todo

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.domain.DomainClassUnitTestMixin;
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification

@Mock(Task)
@TestFor(TodoService)
class TodoServiceSpec extends Specification {

    def "เซอร์วิสบันทึกหัวข้อ task"() {
		setup: "กำหนด object ของ TodoService"
		def todoService = new TodoService()
		and: "กำหนด properties ของ Task"
		def task = [subject: "create task"]
		
		when: "เมื่อทำการบันทึก task"
		def result = todoService.saveTask(task)
		
		then: "service ต้องคืนค่าเป็นจริงเมื่อบันทึก"
		result != null
	}
}
