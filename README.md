# SnakeYAML, Extended #
[API Simulator's](https://apisimulator.io) DSL (Domain-Specific Language) is based on a small subset of YAML: key/value pairs, lists, and maps.

A problem we often times observe with users writing API simlets with the DSL is the YAML-imposed requirement for multi-line text to be properly indented after a [chomping indicator](https://yaml.org/spec/1.1/#chomping/).

Some programming languages, like Python, have support for text surrounded in a pair of matching triple double quotes `"""`; end of lines inside the triple quotes do not need to be escaped and they are included in the text. So, we decided to introduce triple double quotes surrounded text to the API Simulator's DSL. For example:

```
response:
  from: stub
  headers:
    - "Content-Type: application/json"
  body: """
{
 "status": "OK"
}
"""
```

That is not compliant with the YAML standard. Therefore, this repo was born to "extend" SnakeYAML with support for text surrounded with triple double quotes that doesn't have to be indented; the text between the quotes is taken verbatim.

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
