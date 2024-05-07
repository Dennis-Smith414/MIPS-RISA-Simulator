package org.example;

import java.util.Enumeration;

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
        String funct = Integer.toBinaryString(instruction & 0x3F);
        funct = String.format("%06d", Integer.parseInt(funct));
        RegisterType r = new RegisterType(funct);
        r.toDisassembled();

        int rd = Integer.parseInt(r.rd, 16);
        int rs = Integer.parseInt(r.rs, 16);
        int rt = Integer.parseInt(r.rt, 16);

        switch (funct) {
            case "100000":
                registers[rd] = registers[rs] + registers[rt];
                break;
            case "100010":
                registers[rd] = registers[rs] + registers[rt];
                break;
            case "100100":
                registers[rd] = registers[rs] + registers[rt];
                break;
            case "100101":
                registers[rd] = registers[rs] + registers[rt];
                break;
            case "101010":
                registers[rd] = registers[rs] + registers[rt];
                break;
            default:
                System.out.println("Invalid R type");
        }


    }
    private void doLw(int instruction) {
        ImmediateType I = new ImmediateType(Integer.toBinaryString(instruction >>> 26));
        I.toDisassembled();
        int rt = Integer.parseInt(I.rt, 16);
        int rs = Integer.parseInt(I.base, 16);
        int offset = Integer.parseInt(I.offset, 16);
        int address = registers[rs] + offset;
        registers[rt] = memory[address];

    }
    private void doSw(int instruction) {
        ImmediateType I = new ImmediateType(Integer.toBinaryString(instruction >>> 26));
        I.toDisassembled();
        int rt = Integer.parseInt(I.rt, 16);
        int rs = Integer.parseInt(I.base, 16);
        int offset = Integer.parseInt(I.offset, 16);
        int address = registers[rs] + offset;
        memory[address] = registers[rt];
    }
    private void doLui(int instruction) {
        ImmediateType iType = new ImmediateType(Integer.toBinaryString(instruction >>> 26));
        iType.toDisassembled();
        int rt = Integer.parseInt(iType.rt, 16);
        int immediate = Integer.parseInt(iType.offset, 16);
        registers[rt] = immediate << 16;
    }
    private void doSyscall(int instruction) {
        Syscall sys = new Syscall();
        String[] sysInstruction = sysHelper(instruction);
        sys.toMachine(sysInstruction);

        //figure out the rest

    }

    private String[] sysHelper(int instruction) {
        if (instruction == 0) return new String[] {"0"};
        StringBuilder convert = new StringBuilder();
        while (instruction > 0) {
            convert.append(instruction % 10);
            instruction /= 10;
        }
        String convertString = convert.toString();
        int num = convertString.length();
        String[] sysConvert = new String[num];
        for (int i = 0; i < num; i++) {
            sysConvert[i] = String.valueOf(convertString.charAt(i));
        }
        return sysConvert;
    }

    //support all the required instuctions r, l, lw, ect...
    //handle syscall
    //use the classes


}
