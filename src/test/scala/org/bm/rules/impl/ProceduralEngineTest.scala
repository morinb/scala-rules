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

package org.bm.rules.impl

import org.bm.rules.conf.Configuration
import org.bm.rules._
import org.springframework.scala.context.function.FunctionalConfigApplicationContext

/**
 * .
 * @author Baptiste Morin
 */
class ProceduralEngineTest extends org.scalatest.FunSuite {
  val ctx = FunctionalConfigApplicationContext(classOf[Configuration])

  val engine = ctx.getBean("engine", classOf[Engine])

  val sampleEntry = ctx.getBean("test-Entry", classOf[Entry])

  val sampleRule = ctx.getBean("test-Rule", classOf[Rule])


  test("All is wired by Spring") {
    assert(engine !== null)
    assert(ctx !== null)
    assert(sampleEntry !== null)
    assert(sampleRule !== null)
  }

  test("KeyPairs") {
    val key1 = KeyPair[String, String]("first", "second")
    val key2 = KeyPair[String, String]("first", "second")

    assert(key1 === key2)
    assert("first" === key1.first)
    assert("second" === key1.second)

  }

  test("Engine") {

    val results = engine.process(List(sampleEntry), List(sampleRule))

    assert(results !== null)
    assert(results.nonEmpty)

    val (keypair, result) = results.head
    assert(keypair.first === sampleEntry, "Keypair.first must be the sample entry")
    assert(keypair.second === sampleRule, "Keypair.second must be the sample rule")
    assert(result !== null, "Result must not be null")
    assert(0 === result.status.severity, "Result status severity should equals 0")

    println(result)

  }

  test("engine with groovy rule") {
    val ruleLoader = ctx.getBean("test-RuleLoader", classOf[RuleLoader])

    val rules = ruleLoader.load

    assert(rules.nonEmpty, "Rules are defined")

    val results = engine.process(List(sampleEntry), rules)

    results.foreach{r => println(r._2)}

  }
}
