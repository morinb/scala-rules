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
trait Status {
  val severity: Int
  val code: String
  val description: Option[String]
  val possibleResolution: Option[String]
  val isErrorStatus: Boolean

  override def toString: String = Map("code" -> code, "severity" -> severity, "description" -> description.getOrElse("No description"), "possibleResolution" -> possibleResolution.getOrElse("Nothing")).mkString("{", ", ", "}")

}
