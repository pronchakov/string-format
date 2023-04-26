
### string-format

This small library is for formatting strings

#### Maven dependency

    <dependency>
        <groupId>io.github.pronchakov</groupId>
        <artifactId>string-format</artifactId>
        <version>1-SNAPSHOT</version>
    </dependency>

#### Supported data types for arguments:

* Java primitive types
* Java wrappers for primitive types
* Collections
* Every class with properly implemented `toString()` method

#### Not supported yet

* Arrays

#### Example:

    String result = Str.fmt("I use {} since {}.", "Java", 1995);

String result: "I use Java since 1995."
