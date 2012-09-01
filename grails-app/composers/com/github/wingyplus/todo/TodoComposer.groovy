package com.github.wingyplus.todo

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.event.Event
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class TodoComposer extends GrailsComposer {
    def afterCompose = { window ->
        // initialize components here
    }

    @Listen('onClick = button#createTask')
    def createTask(Event event) {
        def subject = $('#subject').text()
        def task = new Task(subject: subject)

        $('#taskList').append {
            window(
                    title: "TODO", 
                    border: "normal", 
                    closable: true, 
                    zclass: "z-window-overlapped"
                  ) {
                textbox(
                        sclass: "taskEdit",
                        value: task.subject, 
                        inplace: true
                       )
            }
        } 
    }
}
