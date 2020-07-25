# SnakeYAML, Extended #
[API Simulator's](https://apisimulator.io) DSL (Domain-Specific Language) is based on a small subset of YAML: key/value pairs, lists, and maps.

A problem we often times observe with users writing API simlets with the DSL is the YAML-imposed requirement for multi-line text to be properly indented after a [chomping indicator](https://yaml.org/spec/1.1/#chomping/).

So, we decided to introduce backtick `` ` `` surrounded multi-line text to the API Simulator's DSL - end of lines inside the backtick characters do not need to be escaped and they are included in the text. For example:

```
response:
  from: stub
  headers:
    - "Content-Type: application/json"
  body: `
{
 "status": "OK"
}
`
```

More details:

* Any whitespace characters at the beginning of the lines surrounded by a pair of backtick characters will be part of the text. 
* The text surrounded by backtick characters must start on a new line right after the opening backtick character.
* The closing backtick character can be on a new line or on the same line where the text ends depending on whether you want the text to end with a line break on not.
* A backtick character inside the text can be escaped by a `\` like in `` \` `` .

That is not compliant with the YAML standard. Therefore, this repo was born to "extend" SnakeYAML with support for text surrounded with triple double quotes that doesn't have to be indented; the text between the quotes is taken verbatim.

2020-07-25 Update
----
There inital implementation used triple double quotes which now were replaced by the backtick character. The support for triple double quotes will be removed in the future.

The starting codebase is a _copy_ (not a fork or mirror) of snakeyaml-1.26.

Everything below the line is the original README.

---

***The art of simplicity is a puzzle of complexity.***

## Overview ##
[YAML](http://yaml.org) is a data serialization format designed for human readability and interaction with scripting languages.

SnakeYAML is a YAML 1.1 processor for the Java Virtual Machine version 7.
For YAML 1.2 (which is a superset of JSON) you may have a look at [SnakeYAML Engine](https://bitbucket.org/asomov/snakeyaml-engine)

## SnakeYAML features ##

* a **complete** [YAML 1.1 processor](http://yaml.org/spec/1.1/current.html). (If you need YAML **1.2** support have a look [here](https://bitbucket.org/asomov/snakeyaml-engine)). In particular, SnakeYAML can parse all examples from the specification.
* Unicode support including UTF-8/UTF-16 input/output.
* high-level API for serializing and deserializing native Java objects.
* support for all types from the [YAML types repository](http://yaml.org/type/index.html).
* relatively sensible error messages.

## Info ##
 * [Changes](https://bitbucket.org/asomov/snakeyaml/wiki/Changes)
 * [Documentation](https://bitbucket.org/asomov/snakeyaml/wiki/Documentation)

## Contribute ##
* Mercurial DVCS is used to dance with the [source code](https://bitbucket.org/asomov/snakeyaml/src).
* If you find a bug in SnakeYAML, please [file a bug report](https://bitbucket.org/asomov/snakeyaml/issues?status=new&status=open).
* You may discuss SnakeYAML at
[the mailing list](http://groups.google.com/group/snakeyaml-core).
* Telegram group is removed because of the spam
