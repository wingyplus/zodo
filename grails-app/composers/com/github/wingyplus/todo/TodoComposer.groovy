package com.github.wingyplus.todo

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.event.Event
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class TodoComposer extends GrailsComposer {
    def afterCompose = { window ->
        // initialize components here

        def tasks = Task.list()
        if (tasks.size() > 0) {
            tasks.each { task ->
                addTaskToList(task)
            }
        }
    }

    def addTaskToList(task) {
        // TODO: create databinding when subject change domain class will change it too.
        $('#taskList').append {
            window(id: "task_${task.id}", title: 'TODO', border: 'normal', closable: true, zclass: 'z-window-overlapped') {
                textbox(id: "subject_${task.id}", value: task.subject, inplace: true)
            }
        }

        $("#task_${task.id}").on('close', {
            task.delete()
        })
    }

    @Listen('onClick = button#createTask')
    def createTask(Event event) {
        def subject = $('#subject').text()
        def task = new Task(subject: subject).save()

        addTaskToList(task)
    }
}
