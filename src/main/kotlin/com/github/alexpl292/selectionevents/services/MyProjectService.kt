package com.github.alexpl292.selectionevents.services

import com.intellij.openapi.project.Project
import com.github.alexpl292.selectionevents.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
