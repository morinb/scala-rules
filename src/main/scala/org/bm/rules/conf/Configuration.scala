/*
 * Copyright 2015 Baptiste
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.bm.rules.conf

import java.io.File

import org.bm.rules._
import org.bm.rules.impl.{GroovyRuleLoader, DefaultResult, StringEntry, ProceduralEngine}
import org.springframework.scala.context.function.FunctionalConfiguration

/**
 * .
 * @author Baptiste Morin
 */
class Configuration extends FunctionalConfiguration{

  val engine = singleton("engine") {
    new ProceduralEngine
  }

  val testEntry = singleton("test-Entry") {
    new StringEntry("Bonjour, je suis une phrase de test !")
  }

  val okStatus = singleton("ok-status") {
    new Status {
      override val severity: Int = 0
      override val possibleResolution: Option[String] = None
      override val isErrorStatus: Boolean = false
      override val description: Option[String] = Some("No problemo rule")
      override val code: String = "STATUS_OK"
    }
  }

  val testRule = singleton("test-Rule") {
    new Rule {
      override def apply(entry: Entry): Result = new DefaultResult(okStatus(), KeyPair(entry, this))
      override val description: String = "Rule that does nothing"
      override val priority: Int = 0
    }
  }

  val groovyClassDirectories = singleton("groovyClassDirectories") {
    List(new File("src/test/resources/rules"))
  }

  val testRuleLoader = singleton("test-RuleLoader") {
    new GroovyRuleLoader(groovyClassDirectories())
  }

}
