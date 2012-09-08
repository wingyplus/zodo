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
            div(id: "task_${task.id}", sclass: 'task-card') {
                textbox(id: "subject_${task.id}", value: task.subject, inplace: true, instant: true)
            }
        }

        $("#task_${task.id}").on('close', {
            task.delete()
        })

        // databinding between task card and domain class.
        $("#task_${task.id}").link(task, [subject: "#subject_${task.id}"])

        $("#subject_${task.id}").on('change', {
            task.subject = $("#subject_${task.id}").text()
            task.save()
        })
    }

    @Listen('onClick = button#createTask')
    def createTask(Event event) {
        def subject = $('#subject').text()
        def task = new Task(subject: subject).save()

        addTaskToList(task)
    }
}
