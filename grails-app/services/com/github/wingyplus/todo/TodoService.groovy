package com.github.wingyplus.todo

class TodoService {

    def saveTask(task) {
		def domain = new Task(task)
		return domain.save()
    }
}
