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

  }
}
