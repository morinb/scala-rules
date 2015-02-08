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
case class KeyPair[First, Second](first: First, second: Second) {
  require(first != null, "First must not be null")
  require(second != null, "Second must not be null")

  override def equals(that: scala.Any): Boolean = {
    if (that == null || getClass != that.getClass) {
      return false
    }

    val keyPair: KeyPair[First, Second] = that.asInstanceOf[KeyPair[First, Second]]
    if (this eq keyPair) {
      return true
    }

    if (!first.equals(keyPair.first)) {
      return false
    }
    if (!second.equals(keyPair.second)) {
      return false
    }

    true

  }

  override def hashCode(): Int = 31 * first.hashCode() + second.hashCode()
}
