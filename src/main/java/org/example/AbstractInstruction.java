package org.example;

/*
 * An abstract class representing an instruction. Implements methods that would be useful
 * for different types of instructions such as I-TYPE, R-TYPE, J-TYPE, and Syscall including
 * numerical conversions, register number lookups and argument parsing.
 */
public abstract class AbstractInstruction implements Instruction {
  String word, op;

  /*
   * Converts a hexadecimal number to binary.
   */
  @Override
  public String hexToBin(String hex, int bits) {
    return Conversions.hexToBin(hex, bits);
  }

  /*
   * Converts a binary number to hexadecimal.
   */
  @Override
  public String binToHex(String bin) {
    return Conversions.binToHex(bin);
  }

  /*
   * Converts a decimal integer to a bit string of specified length.
   */
  @Override
  public String decToBin(String dec, int bits) {
    return Conversions.decToBin(dec, bits);
  }

  /*
   * Returns a string representing the decimal value of a register number.
   */
  @Override
  public String registers(String reg) {
    switch (reg) {
      case "$zero" : return "0";
      case "$at" : return "1";
      case "$gp" : return "28";
      case "$sp" : return "29";
      case "$fp" : return "30";
      case "$ra" : return "31";
      case "$t8" : return "24";
      case "$t9" : return "25";
      default : break;
    }

    char let = reg.charAt(1);
    int num = Character.getNumericValue(reg.charAt(2));
    StringBuilder numString = new StringBuilder();
    return switch (let) {
      case 'v' -> numString.append(2 + num).toString();
      case 'a' -> numString.append(4 + num).toString();
      case 't' -> numString.append(8 + num).toString();
      case 's' -> numString.append(16 + num).toString();
      case 'k' -> numString.append(26 + num).toString();
      default -> null;
    };
  }

  /*
   * Finds an argument from args based on the given index.
   * Ignores nulls or empty strings.
   */
  @Override
  public String argFinder(String[] argz, int index) {
    String arg = null;
    for (String s : argz) {
      if (s == null || s.isEmpty()) continue;
      if (index-- == 0) {
        arg = s;
        break;
      }
    }

    try {
      arg = arg.split(",")[0].split("#")[0];
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return arg;
  }

  @Override
  public String toString() {
    return word;
  }
}