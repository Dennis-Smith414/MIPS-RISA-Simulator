package org.example;

/*
 * A class representing a syscall instruction.
 */
public class Syscall extends AbstractInstruction {
  public Syscall() {
  }

  /*
   * Converts syscall instruction into hexadecimal machine code.
   */
  @Override
  public void toMachine(String[] argz) { word = binToHex(word = "00000000000000000000000000001100"); }

  /*
   * Disassembles syscall hex instruction and displays mnemonic, relevant values.
   */
  @Override
  public void toDisassembled() { word = "syscall {opcode: 00, code: 000000, funct: 0c}"; }
}
