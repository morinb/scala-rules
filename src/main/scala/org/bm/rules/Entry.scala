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

import org.apache.commons.lang.StringUtils

/**
 * .
 * @author Baptiste Morin
 */
trait Entry {
  val ABBREVIATE_SIZE = 30
  val content: String
  val metaDatas: Map[String, Object]

  override def toString: String = s"${getClass.getName} {${StringUtils.abbreviate(content, ABBREVIATE_SIZE)}}"
}
