package rules

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

import org.bm.rules.Entry
import org.bm.rules.KeyPair
import org.bm.rules.Result
import org.bm.rules.Rule
import org.bm.rules.Status
import org.bm.rules.impl.DefaultResult
import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import scala.None
import scala.Option

/**
 *
 * @author Baptiste Morin
 */
class SimpleRule implements Rule {

    @Override
    Result apply(Entry entry) {
        DefaultResult result = new DefaultResult( new Status() {

            @Override
            int severity() {
                return 0
            }

            @Override
            Option<String> possibleResolution() {
                return new None<String>()
            }
            @Override
            boolean isErrorStatus() {
                return false
            }

            @Override
            Option<String> description() {
                return "No problemo groovy rule"
            }

            @Override
            String code() {
                return "STATUS_OK"
            }
        }, new KeyPair<Entry, Rule>(entry, this))


        return result
    }

    @Override
    int compare(Rule that) {
        return super.compare(that)
    }


    String getDescription() {
        return "Rule that does nothing"
    }

    long getPriority() {
        return 0
    }

    @Override
    public String toString() {
        return getClass().getName();
    }

    @Override
    int compareTo(Rule o) {
        // something is always greater than null.
        if (o == null) {
            return 1
        }

        if (this == o) {
            return 0
        }

        return this.priority.compareTo(o.priority());
    }

    @Override
    boolean $less(Rule that) {
        return super.$less(that)
    }

    @Override
    boolean $greater(Rule that) {
        return super.$greater(that)
    }

    @Override
    String description() {
        return null
    }

    @Override
    boolean $less$eq(Rule that) {
        return super.$less$eq(that)
    }

    @Override
    int priority() {
        return 0
    }

    @Override
    boolean $greater$eq(Rule that) {
        return super.$greater$eq(that)
    }
}