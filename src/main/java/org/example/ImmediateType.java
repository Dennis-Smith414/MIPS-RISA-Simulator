package org.example;

import java.math.BigInteger;

/*
 * A class representing an I-TYPE instruction.
 */
public class ImmediateType extends AbstractInstruction {
  String rt, rs, immediate, base, offset;
  public ImmediateType(String op) {
    this.op = op;
  }

  /*
   * Converts I-TYPE instruction into correct hexadecimal machine code.
   */
  @Override
  public void toMachine(String[] argz) {
    // lw, sw, or lui
    switch (op) {
      case "101011", "100011" -> {
        storeWordLoadWord(argz);
        return;
      }
      case "001111" -> {
        loadUpperImmediate(argz);
        return;
      }
      case "000100", "000101" -> {
        branch(argz);
        return;
      }
    }
    // normal I-TYPES
    rt = decToBin(registers(argFinder(argz, 1)),5);
    rs = decToBin(registers(argFinder(argz, 2)), 5);
    immediate = argFinder(argz, 3);
    immediate = (immediate.charAt(0) == '-') ? twosComplement(immediate) : decOrHex(immediate);
    String sb = op + rs +
            rt +
            immediate;
    word = binToHex(sb);
  }

  @Override
  public void toDisassembled() {
    String opcode = op.substring(0, 6);
    String mnemonic = mnemonic(opcode);
    opcode = binToHex(opcode).substring(6);
    base = binToHex(op.substring(6, 11)).substring(6);
    rt = binToHex(op.substring(11, 16)).substring(6);
    offset = binToHex(op.substring(16)).substring(4);
    word = mnemonic + " {opcode: " + opcode + ", rs(base): " + base + ", rt: " + rt + ", immediate(offset): " + offset + "}";
  }

  private void branch(String[] argz) {
    rs = decToBin(registers(argFinder(argz, 1)),5);
    rt = decToBin(registers(argFinder(argz, 2)), 5);
    immediate = argFinder(argz, 3);
    immediate = (immediate.charAt(0) == '-') ? twosComplement(immediate) : decOrHex(immediate);
    String sb = op + rs +
            rt +
            immediate;
    word = binToHex(sb);
  }

  /*
   * Special method that handles toMachines responsibilities for lw and sw.
   */
  private void storeWordLoadWord(String[] argz) {
    rt = decToBin(registers(argFinder(argz, 1)), 5);
    base = decToBin(registers(argFinder(argz, 2).split("\\(")[1].split("\\)")[0]), 5);
    offset = argFinder(argz, 2).split("\\(")[0];
    if (offset.isEmpty()) offset = "0000000000000000";
    else offset = (offset.charAt(0) == '-') ? twosComplement(offset) : decOrHex(offset);
    String sb = op + base +
            rt +
            offset;
    word = new BigInteger(sb, 2).toString(16);
  }

  /*
   * Special method that handles toMachines responsibilities for lui.
   */
  private void loadUpperImmediate(String[] argz) {
    rt = decToBin(registers(argFinder(argz, 1)), 5);
    immediate = argFinder(argz, 2);
    immediate = (immediate.charAt(0) == '-') ? twosComplement(immediate) : decOrHex(immediate);
    String sb = op + "00000" +
            rt +
            immediate;
    word = binToHex(sb);
  }

  /*
   * Determines the appropriate conversion method to call based on given number.
   */
  private String decOrHex(String dig) {
    return (dig.contains("x")) ? hexToBin(dig.split("x")[1], 16) : decToBin(dig, 16);
  }

  /*
   * Converts a negative-signed binary digit to two's complement representation.
   */
  private String twosComplement(String dig) {
    dig = decToBin(dig.split("-")[1], 16);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dig.length(); ++i) {
      sb.append((dig.charAt(i) == '0') ? 1 : 0);
    }

    String one = "1";
    int num0 = Integer.parseInt(sb.toString(), 2);
    int num1 = Integer.parseInt(one, 2);
    dig = Integer.toBinaryString(num0 + num1);

    return dig;
  }
}
