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

import java.io.{File, FileFilter}

import groovy.lang.GroovyClassLoader
import org.bm.rules.{Rule, RuleLoader}


/**
 * .
 * @author Baptiste Morin
 */
class GroovyRuleLoader(groovyClassDirectories: List[File]) extends RuleLoader {


  override def load: List[Rule] = {
    val groovyClassLoader = new GroovyClassLoader(getClass.getClassLoader)
    for {
      groovyClassDirectory <- groovyClassDirectories
      groovyScript <- groovyClassDirectory.listFiles(new FileFilter {
        override def accept(pathname: File): Boolean = pathname != null && pathname.isFile && pathname.getName.endsWith(".groovy")
      }).toList
      groovyClass = groovyClassLoader.parseClass(groovyScript).newInstance()
      if (groovyClass match {
        case r: Rule => true;
        case _ => false
      })
    } yield groovyClass match {
      case r: Rule => r
      case _ => throw new ClassCastException(s"${groovyClass.getClass.getName} is not an instance of Rule") // Should never happen thanks to the if filter
    }
  }

}
