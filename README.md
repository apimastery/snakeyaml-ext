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

2025-08-02 Update
----
Version 2.4-ext


The starting codebase is a _copy_ (not a fork or mirror) of snakeyaml-1.26.

Everything below the line is the original README.

---

***The art of simplicity is a puzzle of complexity.***

## CVE ##

When you are here because of some vulnerability report please be 
aware that it is most probably a **false positive**.

When you use SnakeYAML 
[to configure your application](https://bitbucket.org/snakeyaml/snakeyaml/wiki/CVE-2022-1471) 
you are totally safe.

### When a low quality tooling is complaining ###

1. Go to the issue tracker of your low quality tooling and file a bug report about a false positive. You will be impressed with the amount of bugs already created and ignored (this makes the tool low quality - the bugs are created but ignored). The big amount of already reported issues should not stop you - they must be aware of the stream of false positives they produce.
2. Go to your manager or security specialist and present this information. If you pay for the low quality tooling they cannot leave it unattended.
3. Develop further and be happy !

## Overview ##
[YAML](http://yaml.org) is a data serialization format designed for human readability and interaction with scripting languages.

SnakeYAML is a YAML 1.1 processor for the Java Virtual Machine version 8+.
For YAML 1.2 (which is a superset of JSON) you may have a look at [SnakeYAML Engine](https://bitbucket.org/snakeyaml/snakeyaml-engine)

## SnakeYAML features ##

* a **complete** [YAML 1.1 processor](http://yaml.org/spec/1.1/current.html). (If you need YAML **1.2** support have a look [here](https://bitbucket.org/snakeyaml/snakeyaml-engine)). In particular, SnakeYAML can parse all examples from the specification.
* Unicode support including UTF-8/UTF-16 input/output.
* high-level API for serializing and deserializing native Java objects.
* support for all types from the [YAML types repository](http://yaml.org/type/index.html).
* relatively sensible error messages.
* when you plan to feed the parser with untrusted data please study the settings which allow to restrict incoming data.


## Info ##
 * [Changes](https://bitbucket.org/snakeyaml/snakeyaml/wiki/Changes)
 * [Documentation](https://bitbucket.org/snakeyaml/snakeyaml/wiki/Documentation)
 * [CVE and untrusted data](https://bitbucket.org/snakeyaml/snakeyaml/wiki/CVE%20&%20NIST.md)

## Contribute ##
* GIT [is now used](https://bitbucket.org/snakeyaml/snakeyaml/wiki/Migration%20to%20Git) to dance with the [source code](https://bitbucket.org/snakeyaml/snakeyaml/src).
* If you find a bug in SnakeYAML, please [file a bug report](https://bitbucket.org/snakeyaml/snakeyaml/issues?status=new&status=open&is_spam=!spam).
* You may discuss SnakeYAML at
[the mailing list](http://groups.google.com/group/snakeyaml-core).
* [Slack workspace](https://app.slack.com/client/T26CKL7FU/D02URJSL2KS)
* Telegram group is removed because of the spam
* [YAML community](https://matrix.to/#/%23chat:yaml.io)

## JMH microbenchmarks ##

To execute the [JMH](https://github.com/openjdk/jmh) microbenchmarks locally via Maven:

```shell
./mvnw jmh:benchmark
```
This will produce console results such as the following, as well as a `./jmh-result.json` that can be
visualized via https://jmh.morethan.io/ .

```text
Benchmark                    (entries)  Mode  Cnt    Score     Error  Units
EmitterBenchmark.emitScalar        N/A  avgt    3    0.299 ±   0.047  us/op
ParseBenchmark.load               1000  avgt    3    1.388 ±   0.103  ms/op
ParseBenchmark.load             100000  avgt    3  258.281 ± 367.009  ms/op
ParseBenchmark.parse              1000  avgt    3    0.886 ±   0.163  ms/op
ParseBenchmark.parse            100000  avgt    3   94.930 ±   3.995  ms/op
```
