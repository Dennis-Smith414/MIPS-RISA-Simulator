package org.example;

public class Controller {

  public static String process(String[] args) {
    String result;
    String[] argz = args[0].split(" ");
    String op = ParseArgs.findOp(argz);
    if (op.matches("[a-z]+")) {
      Instruction in = initOp(op);
      in.toMachine(argz);
      result = in.toString();
    } else {
      // TODO milestone 2
      result = Conversions.hexToBin(op, 32);
      System.out.println(result);
      result = null;
    }

    return result;
  }

  /*
   * Initializes an instruction based on opcode.
   */
  private static AbstractInstruction initOp(String op) {
    return switch (op) {
      // R-TYPES:
      case "add" -> new RegisterType("100000");
      case "and" -> new RegisterType("100100");
      case "or" -> new RegisterType("100101");
      case "slt" -> new RegisterType("101010");
      case "sub" -> new RegisterType("100010");
      // I-TYPES:
      case "addiu" -> new ImmediateType("001001");
      case "andi" -> new ImmediateType("001100");
      case "beq" -> new ImmediateType("000100");
      case "bne" -> new ImmediateType("000101");
      case "lui" -> new ImmediateType("001111");
      case "lw" -> new ImmediateType("100011");
      case "ori" -> new ImmediateType("001101");
      case "sw" -> new ImmediateType("101011");
      // J-TYPE:
      case "j" -> new JumpType();
      // SYSCALL:
      case "syscall" -> new Syscall();
      default -> null;
    };
  }
}
