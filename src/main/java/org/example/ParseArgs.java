package org.example;

public class ParseArgs {

  /*
   * Parses args for the instruction or hexadecimal instruction.
   */
  public static String findOp(String[] argz) {
    String op = null;
    for (String s : argz) {
      if (s == null || s.isEmpty()) continue;
      op = s;
      break;
    }

    assert op != null;
    op = op.split("#")[0];
    return op;
  }

}
