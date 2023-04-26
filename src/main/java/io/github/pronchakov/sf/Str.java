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
     * String in result: "I use Java since 1995."
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
