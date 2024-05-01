package org.example;

public class Executor {
    private int[] registers;
    private int[] memory;

    public Executor(int[] registers, int[] memory) {
        this.registers = registers;
        this.memory = memory;
    }
    //determine which instruction to execute
    private void executeInstruction(int instruction) {
        int opcode = instruction >>> 26;
        switch (opcode) {
            case 0x00:
                doRType(instruction);
                break;
            case 0x23:
                doLw(instruction);
                break;
            case 0x2B:
                doSw(instruction);
                break;
            case 0x0F:
                doLui(instruction);
                break;
            case 0x0C:
                doSyscall(instruction);
                break;
            default:
                System.out.println("invaild");
        }
    }

    private void doRType(int instruction) {

    }
    private void doLw(int instruction) {

    }
    private void doSw(int instruction) {

    }
    private void doLui(int instruction) {

    }
    private void doSyscall(int instruction) {

    }

    //support all the required instuctions r, l, lw, ect...
    //handle syscall
    //use the classes


}
