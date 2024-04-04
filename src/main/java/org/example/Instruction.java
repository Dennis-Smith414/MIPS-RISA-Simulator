package org.example;
/*
 * An interface to allow for easily transferable common methods between
 * different instruction types.
 */
public interface Instruction {
  String decToBin(String dec, int bits);
  void toMachine(String[] argz);
  String hexToBin(String hex, int bits);
  String binToHex(String bin);

  String registers(String reg);
  String argFinder(String[] argz, int index);
}
