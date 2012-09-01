package com.github.wingyplus.todo

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(Task)
class TaskSpec extends spock.lang.Specification {

    def "task ต้องบันทึกได้"() {
        when:
		def task = new Task(subject: "create task")
	
		then:
		assertNotNull task.save()
    }
}
