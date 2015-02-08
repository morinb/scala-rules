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

package org.bm.rules

/**
 * .
 * @author Baptiste Morin
 */
trait Result {
  val status: Status
  val entryRuleKeyPair: KeyPair[Entry, Rule]
  val isError: Boolean

  override def toString: String =
    s"""Result for
       |  Entry(${entryRuleKeyPair.first}),
       |  Rule(${entryRuleKeyPair.second})
       |  Status: $status
     """.stripMargin

}
