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

import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JPanel
import javax.swing.JRadioButton

internal class JTrueFalseRadioPanel(
    defaultValue: Boolean,
    trueText: String = "True",
    falseText: String = "False"
) : JPanel(GridBagLayout()) {
    @Suppress("PrivatePropertyName")
    private val TRUE = "TRUE"

    @Suppress("PrivatePropertyName")
    private val FALSE = "FALSE"
    private val trueButton: JRadioButton = JRadioButton(trueText)
    private val falseButton: JRadioButton = JRadioButton(falseText)

    init {
        val group = us.jimschubert.intellij.openapitools.ui.ActionButtonGroup()

        trueButton.actionCommand = TRUE
        falseButton.actionCommand = FALSE

        trueButton.isSelected = defaultValue
        falseButton.isSelected = !trueButton.isSelected

        group.add(trueButton)
        group.add(falseButton)

        val gridConstraintTrue = GridBagConstraints()
        gridConstraintTrue.weightx = 0.5
        gridConstraintTrue.gridx = 0
        gridConstraintTrue.gridy = 0
        gridConstraintTrue.fill = GridBagConstraints.HORIZONTAL
        val gridConstraintFalse = gridConstraintTrue.clone() as GridBagConstraints
        gridConstraintFalse.gridx = 1

        add(trueButton, gridConstraintTrue)
        add(falseButton, gridConstraintFalse)

        group.addActionListener { e -> trueButton.isSelected = e?.actionCommand.equals(TRUE) }
    }

    val value: Boolean
        get() = trueButton.isSelected
}