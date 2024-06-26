package org.example;


/*
 * A class representing an R-TYPE instruction.
 */
public class RegisterType extends AbstractInstruction {
  private final static String ZEROS = "00000";
  String rd, rs, rt, funct;
  public RegisterType(String funct) {
    this.funct = funct;
    op = "000000";
  }

  /*
   * Converts R-TYPE instruction, specifying function, and registers into hexadecimal machine code.
   */
  @Override
  public void toMachine(String[] argz) {
    StringBuilder sb = new StringBuilder("000000");

    rd = decToBin(registers(argFinder(argz, 1)), 5);
    rs = decToBin(registers(argFinder(argz, 2)), 5);
    rt = decToBin(registers(argFinder(argz, 3)), 5);
    sb.append(rs);
    sb.append(rt);
    sb.append(rd);
    sb.append(ZEROS);
    sb.append(funct);

    word = binToHex(sb.toString());
  }

  @Override
  public void toDisassembled() {
    String instr = funct;
    // debug
    System.out.println("funct:" + funct);
    System.out.println("rd:" + rd);
    System.out.println("rs:" + rs);
    System.out.println("rt:" + rt);


    funct = instr.substring(26);
    String mnemonic = mnemonic(funct);
    funct = binToHex(funct).substring(6);
    rs = binToHex(instr.substring(6, 11)).substring(6);
    rt = binToHex(instr.substring(11, 16)).substring(6);
    rd = binToHex(instr.substring(16, 21)).substring(6);
    word = mnemonic + " {opcode: 00, rs: " + rs + ", rt: " + rt + ", rd: " + rd + ", shmt: 00, funct: " + funct + "}";
  }

}
