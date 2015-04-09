# Expression Evaluator Rubric

## Overview

Each criteria for the assignment will be either objective or
subjective. The objective criteria will be based on facts about the
assignment that are identifiable in the submission and can be given a
score by observation. The subjective criteria are based on the
grader's understanding of the submission and the score is determined
by the reviewer alone.

A `feedback.md` file will be provided in the student's git repository
folder. No comment is required if the student achieves a perfect score
on any of the criteria below. A comment will be put inside the
`feedback.md` file if a perfect score is not achieved. The comment
will consists of a copy of the text for the criteria and a brief
explanation of why the points were lost. The final score will be
placed in the `feedback.md` file at the top:

```
Score: X
```

Where `X` is replaced with the student's score.

**The assignment has a total of 491 points.**

## Objective Criteria

**O1 (5 points):** Does the submission compile with the `sbt compile`
command. If it does the student receives 5 points. If it does not
the student receives 0 points. If the problem is simple then it
should be corrected by the reviewer and graded according to the rest
of the rubric. If the problem is complicated or unclear the
submission receives a 0.

### Task 1: Create Regular Expression Classes

**02 (12 points):** Does the submission provide a class or object for
each of the six regular expression types: null, empty, character,
sequence, and alternative? Each class or object is worth 2 points.
This does not include the implementation - we are simply looking to
see if the classes or objects exist. If the submission implements
string as a regular expression then 2 points should be deducted as
the documentation explicitly states not to do this.

**O3 (6 points):** Does the submission provide an override for the
`toString` method in each of the regular expression classes or
objects? 1 point for each class that provides an implementation.

**O4 (6 points):** Does the submission make each of the regular
expression classes or objects private to the `regex` package? 1 point
for each class that is private to the `regex` package.

### Task 2: Extend RegExLanguage Trait

**O5 (5 points):** Does the submission provide an implementation of
the `RegExLanguage` trait. 5 points if it does; 0 otherwise.

**O6 (12 points):** Does the submission provide an implementation for
each of the abstract methods in the `RegExLanguage` trait? 2 points
for each implementation.

**O7 (5 points):** Does the submission provide an implementation of
the `str` method that builds a sequence of character regular
expressions from the given string. 5 points if it does, 0 if it uses
a string regular expression (explicit in the documentation).

### Task 3: Implement Regular Expression Classes

**O8 (275 points):** Does the submission pass all of the provided
public tests (55 in total). Each test that passes receives 5 points.

**O9 (125 points):** Does the submission pass all of the provided
private tests. Each  test that passes receives 5 points.

### Style and Git

**O21 (10 points):** Run ScalaStyle in `sbt`:

```scala
$ sbt scalastyle
```

Subtract 1 point for each error found in their submission. Provide a
comment in the feedback file explaining the problem (or a copy of the
output).

**O22 (10 points):** Did the submission provide at least 10 `git`
commits? If there was only a single commit make a note in the
feedback file for the student to contact course staff to determine
if it was a git issue.

## Subjective Criteria

**S1 (10 points):** Did the submission demonstrate good Scala coding
practices? 10 points if it did; otherwise a sensible number of
points and comments in the student's `feedback.md` file explaining
any issues.

**S2 (10 points):** Did the submission demonstrate good ScalaDoc
comments? 10 points if it did; otherwise a sensible number of points
and comments in the student's `feedback.md` file explaining any
issues.
