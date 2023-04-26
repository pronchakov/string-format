/*
Copyright 2023 Artem Pronchakov

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the “Software”), to deal in
the Software without restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
*/
package io.github.pronchakov.sf;

/**
* io.github.pronchakov.sf.Str is a class used to format strings.
 * @author Artem Pronchakov
*/
public class Str {

    /**
     * Format String using {} as a placeholders and arguments as a values
     * Supported data types for arguments:
     * <ul>
     *     <li>Java primitive types</li>
     *     <li>Java wrappers for primitive types</li>
     *     <li>Collections</li>
     * </ul>
     *
     * Usage example:
     * <i>String result = Str.fmt("I use {} since {}.", "Java", 1995);</i>
     * String result: "I use Java since 1995."
     *
     * @param string Is a string that you want to format with {} brackets in place
     * @param arguments Zero or more arguments to format the string with
     * @return Formatted string
     */
    public static String fmt(final String string, Object... arguments) {

        if (arguments == null || arguments.length == 0) {
            return string;
        }

        if (!(arguments.getClass().equals(Object[].class))) {
            final var forSwap = arguments;
            arguments = new Object[1];
            arguments[0] = forSwap;
        }

        final var sb = new StringBuilder();

        final var chars = string.toCharArray();
        var copyFromPos = 0;
        var curIdx = 0;
        for (int curPos = 0; curPos < chars.length - 1; curPos++) {
            if (chars[curPos] == '{' && chars[curPos + 1] == '}') {
                for (int j = copyFromPos; j < curPos; j++) {
                    sb.append(chars[j]);
                }
                var curArg = arguments[curIdx];

                sb.append(curArg.toString());

                curIdx++;

                curPos += 2;
                copyFromPos = curPos;

                if (curIdx == arguments.length) {
                    break;
                }
            }
        }
        if (copyFromPos != chars.length - 1) {
            for (int j = copyFromPos; j < chars.length; j++) {
                sb.append(chars[j]);
            }
        }

        return sb.toString();
    }

}
