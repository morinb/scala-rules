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

import org.bm.rules._

/**
 * .
 * @author Baptiste Morin
 */
class ProceduralEngine extends Engine {
  override def process(entries: List[Entry], rules: List[Rule]): List[(KeyPair[Entry, Rule], Result)] =
    for {
      entry <- entries
      rule <- rules.sorted
      if !(skipEmptyLines && entry.content.isEmpty)
    } yield {
      KeyPair[Entry, Rule](entry, rule) -> rule(entry)
    }


  override def skipEmptyLines: Boolean = true
}
