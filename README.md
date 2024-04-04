# MIPS-RISA-Simulator

A Java program with the purpose of furthering understanding of the functional relationships between various MIPS processor components, and how instructions are used to modify them. The program takes MIPS machine code instructions and simulates the internal workings of a MIPS processor using a single-cycle datapath.

The program supports limited instructions:

-    add
-    addiu
-    and
-    andi
-    beq
-    bne
-    j
-    lui
-    lw
-    or
-    ori
-    slt
-    sub
-    sw
-    syscall

Usage: run the jar file with a single 8-digit hexadecimal number (without preceeding 0x) representing an instruction. The program will then print relevant values.

Output:

  R-Types:
  
    mnemonic {opcode: XX, rs: XX, rt: XX, rd: XX, shmt: XX, funct: XX}
    
    ex:
    
      input: 0140a820 
      
      output: add {opcode: 00, rs: 0a, rt: 00, rd: 15, shmt: 00, funct: 20}
      

  I-Types:
  
    mnemonic {opcode: XX, rs(base): XX, rt: XX, immediate(offset): XXXX}
    
    ex:
    
      input: 274700c3 
      
      output: addiu {opcode: 09, rs(base): 1a, rt: 07, immediate(offset): 00c3}
      

  J-Types:
  
    mnemonic {opcode: XX, index: XXXXXXX}
    
    ex:
    
      input: 0800008c 
      
      output: j {opcode: 02, index: 000008c}
      

  Syscall:
    mnemonic {opcode: XX, code: 000000, funct: XX}
    ex:
      input: 0000000c 
      output: syscall {opcode: 00, code: 000000, funct: 0c}
