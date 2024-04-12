package org.example;

public class Controller {

  public static String process(String[] args) {
    String result;
    String[] argz = args[0].split(" ");
    String op = ParseArgs.findOp(argz);
    Instruction in;
    if (op.matches("[a-z]+")) {
      in = initOp(op, null);
      in.toMachine(argz);
      result = in.toString();
    } else {
      // TODO milestone 2
      result = Conversions.hexToBin(op, 32);
      in = initOp(result.substring(0, 6), result);
      in.toDisassembled();
      result = in.toString();
    }

    return result;
  }

  /*
   * Initializes an instruction based on opcode.
   */
  private static AbstractInstruction initOp(String op, String binOp) {
    return switch (op) {
      // TO MACHINE

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
      case "syscall", "000000" -> new Syscall();


      // DISASSEMBLE

      // R-TYPES:
      case "100000" -> new RegisterType(binOp);
      case "100100" -> new RegisterType(binOp);
      case "100101" -> new RegisterType(binOp);
      case "101010" -> new RegisterType(binOp);
      case "100010" -> new RegisterType(binOp);
      // I-TYPES:
      case "001001" -> new ImmediateType(binOp);
      case "001100" -> new ImmediateType(binOp);
      case "000100" -> new ImmediateType(binOp);
      case "000101" -> new ImmediateType(binOp);
      case "001111" -> new ImmediateType(binOp);
      case "100011" -> new ImmediateType(binOp);
      case "001101" -> new ImmediateType(binOp);
      case "101011" -> new ImmediateType(binOp);
      // J-TYPE:
      case "000010" -> new JumpType(binOp);
      default -> null;
    };
  }
}
