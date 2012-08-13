/**
 *  Copyright 2012 Douglas Campos, and individual contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.dynjs.runtime.builtins;

import org.dynjs.runtime.AbstractNativeFunction;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.LexicalEnvironment;
import org.dynjs.runtime.Reference;
import org.dynjs.runtime.Types;

public class Eval extends AbstractNativeFunction {

    public Eval(LexicalEnvironment scope, boolean strict) {
        super( scope, strict, "code" );
    }

    @Override
    public Object call(ExecutionContext context, Object self, Object... args) {
        Reference codeRef = context.resolve(  "code"  );
        Object code = codeRef.getValue( context );
        if ( code != Types.UNDEFINED ) {
            return context.getGlobalObject().getEngine().evaluate( code.toString() );
        }
        return Types.UNDEFINED;
    }


}
