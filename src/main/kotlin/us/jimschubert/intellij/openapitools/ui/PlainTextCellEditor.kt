/*
 * Copyright (c) 2020 Jim Schubert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package us.jimschubert.intellij.openapitools.ui

import com.intellij.util.ui.AbstractTableCellEditor
import java.awt.Component
import javax.swing.JTable
import javax.swing.JTextField

internal class PlainTextCellEditor : AbstractTableCellEditor() {
    private var component: JTextField

    init {
        component = JTextField()
    }

    override fun getTableCellEditorComponent(
        table: JTable?,
        value: Any?,
        isSelected: Boolean,
        row: Int,
        column: Int
    ): Component? {
        component = JTextField()
        component.text = value?.toString() ?: ""
        return component
    }

    override fun getCellEditorValue(): Any? = component.text
}