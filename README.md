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
