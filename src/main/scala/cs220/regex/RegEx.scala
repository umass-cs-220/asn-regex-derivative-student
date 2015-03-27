package cs220.regex

/**
 * The RegEx trait represents a regular expression.
 *
 * A RegEx represents one of the following possible regular expressions:
 * {{{
 * 1. Empty                - the re that matches anything
 * 2. Null                 - the re that matches nothing
 * 3. Character(c)         - the re that matches a single character c
 * 4. Sequence(re1,re2)    - the re that matches a sequence of re1 followed by re2
 * 5. Alternative(re1,re2) - the re that matches an alternative or re1 OR re2
 * 6. Closure(re)          - the re that matches 0 or more of re
 * }}}
 */
trait RegEx {
  /**
   * delta defines the "delta" of this regular expression.
   *
   * The delta of a regular expression returns either Empty or Null based on
   * the rules covered for taking the delta of a regular expression.
   */
  protected [regex] def delta: RegEx

  /**
   * Returns true if this regular expression is Empty.
   */
  protected [regex] def isEmpty: Boolean

  /**
   * The derivative of this regular expression with respect to the character c.
   *
   * The derivative of a regular expression returns a new regular expression with
   * the character c "removed" from that regular expression based on the rules
   * covered for taking the derivative of a regular expression.
   */
  protected [regex] def derivative(c: Char): RegEx

  /**
   * The normalization of a regular expression.
   *
   * The normalization of a regular expression occurs during the matching process
   * of this regular expression with respect to its derivative. This process is
   * implicit with respect to the theoretical coverage of regular expression
   * derivatives. In particular, after the derivative is taken of a regular expression
   * it is normalized to take into account Null and Empty. Here are the rules with respect
   * to this regular expression re:
   *
   * {{{
   * 1.  Empty, if the re is Empty
   * 2.  Null, if the re is Null
   * 3.  Character(c), if the re is a Character
   * 4.  Null, if the re is Sequence(_, Null) OR Sequence(Null, _)
   * 5.  re1.normalize, if Sequence(re1, Empty)
   * 6.  re2.normalize, if Sequence(Empty, re2)
   * 7.  Sequence(re1.normalize, re2.normalize), if re2 and re1 are both not Empty OR not Null
   * 8.  re1.normalize, if Alternative(re1, Null)
   * 9.  re2.normalize, if Alternative(Null, re2)
   * 10. Alternative(re1.normalize, re2.normalize), if re2 and re1 are both not Null
   * }}} 
   */
  protected [regex] def normalize: RegEx

  /**
   * matches returns true if the regular expression matches the list of Char.
   *
   * This method matches each character in turn to the derivative of this regular
   * expression. If the list of characters is empty and the delta of this regular
   * expression is Empty then matches returns true. If the list of characters is empty
   * and the regular expression is non empty the match fails.
   *
   * We have provided the main "loop" for the matching process invoking "derivative",
   * "normalize", and "matches" along the way. You need not invoke "normalize" in any
   * of the code you provide.
   */
  private [regex] def matches(cc: List[Char]): Boolean =
    cc match {
      case Nil     => delta.isEmpty
      case c :: cc => derivative(c).normalize matches cc
    }

  /**
   * This is the only public method exported by this trait. It accepts a String to
   * match against this regular expression. It converts it to a list an passes it
   * off the proper matches method above.
   */
  def matches(s: String): Boolean = matches(s.toList)
}

/**
 * The RegExLanguage trait exports methods that are publically accessible to the client
 * code. Each method below returns a RegEx object that represents the "regular expression"
 * for Empty, Character, Sequence, Alternative, String, and Closure. Note: "str" is a
 * meta-regular expression representing a sequence of characters.
 */
trait RegExLanguage {
  /**
   * empty returns the Empty regular expression.
   */
  def empty: RegEx

  /**
   * char returns the Character(c) regular expression.
   */
  def char(c: Char): RegEx

  /**
   * seq returns the Sequence regular expression of re1 and re2.
   */
  def seq(re1: RegEx, re2: RegEx): RegEx

  /**
   * alt returns the Alternative regular expression of re1 and re2.
   */
  def alt(re1: RegEx, re2: RegEx): RegEx

  /**
   * str returns the Sequence regular expression of the Character regular
   * expressions in s.
   */
  def str(s: String): RegEx

  /**
   * closure returns the Closure regular expression of re.
   */
  def closure(re: RegEx): RegEx
}
