package org.dynjs.runtime.builtins.types.date.prototype;

import org.dynjs.runtime.AbstractNativeFunction;
import org.dynjs.runtime.ExecutionContext;
import org.dynjs.runtime.GlobalObject;
import org.dynjs.runtime.builtins.types.date.DynDate;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public class ToDateString extends AbstractNativeFunction {
    public ToDateString(GlobalObject globalObject) {
        super(globalObject);
    }

    @Override
    public Object call(ExecutionContext context, Object self, Object... args) {
        return new DateTime((Long) ((DynDate) self).getPrimitiveValue()).toString("EEE MMM dd YYYY");
    }
}
