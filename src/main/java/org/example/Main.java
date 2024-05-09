package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //init the MIPS processor
    private static final int REG_NUM = 32;
    private static final int MEM_SIZE = 0x1000;

    private int[] registers = new int[REG_NUM];
    private int[] mem = new int[MEM_SIZE];
    private int programCounter;


  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Two arugements are needed!");
      System.exit(1);
    }

    Main sim = new Main();
    sim.loadText(args[0]);
    sim.loadData(args[1]);
    sim.run();
  }

  private void loadText(String text) {
    try (BufferedReader read = new BufferedReader(new FileReader(text))) {
      String line;
      int address = 0x00400000;
      while ((line = read.readLine()) != null) {
        int instruction = Integer.parseInt(line, 16);
        mem[address] = instruction;
        address += 4;
      }
      programCounter = 0x00400000;
    } catch (IOException e) {
        throw new RuntimeException();
    }
  }

  private void loadData(String data) {
    try (BufferedReader read = new BufferedReader(new FileReader(data))) {
      String line;
      int address = 0x10010000;
      while ((line = read.readLine()) != null) {
        int dataActual = Integer.parseInt(line, 16);
        mem[address] = dataActual;
        address += 4;
      }
      programCounter = 0x00400000;
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  private void run() {
    Executor execute = new Executor(registers , mem);
    while (true) {
      int instruction = mem[programCounter];
      if (instruction == 0) {
        System.out.println("done");
        break;
      }
      //call executor class
      execute.executeInstruction(instruction);
      programCounter += 4;
  }


    //Im not sure if these need to be commmented out but its one more thing to keep track of.
//    String result = Controller.process(args);
//    System.out.println(result);

  }
}