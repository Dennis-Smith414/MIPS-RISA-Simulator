package org.example;

/*
 * A class representing a J-TYPE instruction.
 */

public class JumpType extends AbstractInstruction {
  String instrIndex;
  String label;
  public JumpType() {
    op = "000010";
  }
  public JumpType(String binOp) {
    op = binOp;
  }

  /*
   * Converts jump instruction and index into hexadecimal machine code.
   */
  @Override
  public void toMachine(String[] argz) {
    if (argz.length > 1)
      setInstrIndex(argz);

    StringBuilder sb = new StringBuilder(op);
    StringBuilder sbInd = new StringBuilder(instrIndex);

    while (sbInd.length() < 26) sbInd.insert(0, 0);    // add needed leading 0's
    while (sbInd.length() > 26) sbInd.deleteCharAt(0);    // remove extra leading 0's

    sb.append(sbInd);                                           // form the instruction's machine code in binary
    word = binToHex(sb.toString());                             // converts binary -> decimal -> hexadecimal
  }

  @Override
  public void toDisassembled() {
    word = "j {opcode: 02, index: " + Conversions.binToHex(op.substring(6)).substring(1) + "}";
  }

  /*
   * Removes extra characters and converts the instruction index from hex to binary.
   */
  private void setInstrIndex(String[] argz) {
    for (String s : argz) {
      if (s == null || s.isEmpty() || s.equals("j")) continue;
      instrIndex = s;
      break;
    }
    instrIndex = hexToBin(instrIndex.split("x")[1].split("#")[0], 26);
  }
}
