package com.github.alexpl292.selectionevents.listeners

import com.intellij.openapi.editor.event.EditorFactoryEvent
import com.intellij.openapi.editor.event.EditorFactoryListener
import com.intellij.openapi.editor.event.EditorMouseEvent
import com.intellij.openapi.editor.event.EditorMouseMotionListener
import com.intellij.openapi.editor.event.SelectionEvent
import com.intellij.openapi.editor.event.SelectionListener
import com.intellij.openapi.editor.impl.EditorComponentImpl
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class MyListener : EditorFactoryListener {
    override fun editorCreated(event: EditorFactoryEvent) {
        event.editor.contentComponent.addMouseListener(MyAdapter())
        event.editor.addEditorMouseMotionListener(MyMouseListener())
        event.editor.selectionModel.addSelectionListener(MySelectionListener())
    }
}

class MyAdapter : MouseAdapter() {
    override fun mousePressed(e: MouseEvent?) {
        val editor = (e?.component as? EditorComponentImpl)?.editor ?: return
        val caret = editor.caretModel.primaryCaret
        caret.moveToOffset(caret.offset - 1)
    }
}

class MyMouseListener : EditorMouseMotionListener {
    override fun mouseDragged(e: EditorMouseEvent) {
        println("Mouse dragged")
    }
}

class MySelectionListener : SelectionListener {
    override fun selectionChanged(e: SelectionEvent) {
        println("Selection changed")
    }
}
