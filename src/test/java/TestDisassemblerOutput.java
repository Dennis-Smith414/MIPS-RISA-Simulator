import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ALL")
public class TestDisassemblerOutput {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void test0() {
    Main.main(new String[]{"02b4e822"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 14, rd: 1d, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test1() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test2() {
    Main.main(new String[]{"027b4822"});
    assertEquals("sub {opcode: 00, rs: 13, rt: 1b, rd: 09, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test3() {
    Main.main(new String[]{"3413ff20"});
    assertEquals("ori {opcode: 0d, rs(base): 00, rt: 13, immediate(offset): ff20}\n", outContent.toString());
  }

  @Test
  public void test4() {
    Main.main(new String[]{"117e00df"});
    assertEquals("beq {opcode: 04, rs(base): 0b, rt: 1e, immediate(offset): 00df}\n", outContent.toString());
  }

  @Test
  public void test5() {
    Main.main(new String[]{"030a0820"});
    assertEquals("add {opcode: 00, rs: 18, rt: 0a, rd: 01, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test6() {
    Main.main(new String[]{"136affae"});
    assertEquals("beq {opcode: 04, rs(base): 1b, rt: 0a, immediate(offset): ffae}\n", outContent.toString());
  }

  @Test
  public void test7() {
    Main.main(new String[]{"10440017"});
    assertEquals("beq {opcode: 04, rs(base): 02, rt: 04, immediate(offset): 0017}\n", outContent.toString());
  }

  @Test
  public void test8() {
    Main.main(new String[]{"080000cd"});
    assertEquals("j {opcode: 02, index: 00000cd}\n", outContent.toString());
  }

  @Test
  public void test9() {
    Main.main(new String[]{"ae940000"});
    assertEquals("sw {opcode: 2b, rs(base): 14, rt: 14, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test10() {
    Main.main(new String[]{"375300ae"});
    assertEquals("ori {opcode: 0d, rs(base): 1a, rt: 13, immediate(offset): 00ae}\n", outContent.toString());
  }

  @Test
  public void test11() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test12() {
    Main.main(new String[]{"00dfe02a"});
    assertEquals("slt {opcode: 00, rs: 06, rt: 1f, rd: 1c, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test13() {
    Main.main(new String[]{"0800008c"});
    assertEquals("j {opcode: 02, index: 000008c}\n", outContent.toString());
  }

  @Test
  public void test14() {
    Main.main(new String[]{"1273ffe7"});
    assertEquals("beq {opcode: 04, rs(base): 13, rt: 13, immediate(offset): ffe7}\n", outContent.toString());
  }

  @Test
  public void test15() {
    Main.main(new String[]{"03dc0025"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 1c, rd: 00, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test16() {
    Main.main(new String[]{"10c900cd"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 09, immediate(offset): 00cd}\n", outContent.toString());
  }

  @Test
  public void test17() {
    Main.main(new String[]{"274700c3"});
    assertEquals("addiu {opcode: 09, rs(base): 1a, rt: 07, immediate(offset): 00c3}\n", outContent.toString());
  }

  @Test
  public void test18() {
    Main.main(new String[]{"02f43824"});
    assertEquals("and {opcode: 00, rs: 17, rt: 14, rd: 07, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test19() {
    Main.main(new String[]{"aeed0000"});
    assertEquals("sw {opcode: 2b, rs(base): 17, rt: 0d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test20() {
    Main.main(new String[]{"16cb00aa"});
    assertEquals("bne {opcode: 05, rs(base): 16, rt: 0b, immediate(offset): 00aa}\n", outContent.toString());
  }

  @Test
  public void test21() {
    Main.main(new String[]{"0103b824"});
    assertEquals("and {opcode: 00, rs: 08, rt: 03, rd: 17, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test22() {
    Main.main(new String[]{"3c1d0071"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1d, immediate(offset): 0071}\n", outContent.toString());
  }

  @Test
  public void test23() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test24() {
    Main.main(new String[]{"25c6004d"});
    assertEquals("addiu {opcode: 09, rs(base): 0e, rt: 06, immediate(offset): 004d}\n", outContent.toString());
  }

  @Test
  public void test25() {
    Main.main(new String[]{"32110039"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 11, immediate(offset): 0039}\n", outContent.toString());
  }

  @Test
  public void test26() {
    Main.main(new String[]{"0161c822"});
    assertEquals("sub {opcode: 00, rs: 0b, rt: 01, rd: 19, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test27() {
    Main.main(new String[]{"03bad020"});
    assertEquals("add {opcode: 00, rs: 1d, rt: 1a, rd: 1a, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test28() {
    Main.main(new String[]{"33b9ff27"});
    assertEquals("andi {opcode: 0c, rs(base): 1d, rt: 19, immediate(offset): ff27}\n", outContent.toString());
  }

  @Test
  public void test29() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test30() {
    Main.main(new String[]{"0800002e"});
    assertEquals("j {opcode: 02, index: 000002e}\n", outContent.toString());
  }

  @Test
  public void test31() {
    Main.main(new String[]{"3c08004f"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 08, immediate(offset): 004f}\n", outContent.toString());
  }

  @Test
  public void test32() {
    Main.main(new String[]{"038b2024"});
    assertEquals("and {opcode: 00, rs: 1c, rt: 0b, rd: 04, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test33() {
    Main.main(new String[]{"0398802a"});
    assertEquals("slt {opcode: 00, rs: 1c, rt: 18, rd: 10, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test34() {
    Main.main(new String[]{"25fe0085"});
    assertEquals("addiu {opcode: 09, rs(base): 0f, rt: 1e, immediate(offset): 0085}\n", outContent.toString());
  }

  @Test
  public void test35() {
    Main.main(new String[]{"24e900d4"});
    assertEquals("addiu {opcode: 09, rs(base): 07, rt: 09, immediate(offset): 00d4}\n", outContent.toString());
  }

  @Test
  public void test36() {
    Main.main(new String[]{"080000ef"});
    assertEquals("j {opcode: 02, index: 00000ef}\n", outContent.toString());
  }

  @Test
  public void test37() {
    Main.main(new String[]{"3c030054"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 03, immediate(offset): 0054}\n", outContent.toString());
  }

  @Test
  public void test38() {
    Main.main(new String[]{"271500d5"});
    assertEquals("addiu {opcode: 09, rs(base): 18, rt: 15, immediate(offset): 00d5}\n", outContent.toString());
  }

  @Test
  public void test39() {
    Main.main(new String[]{"3134fffe"});
    assertEquals("andi {opcode: 0c, rs(base): 09, rt: 14, immediate(offset): fffe}\n", outContent.toString());
  }

  @Test
  public void test40() {
    Main.main(new String[]{"309d00ea"});
    assertEquals("andi {opcode: 0c, rs(base): 04, rt: 1d, immediate(offset): 00ea}\n", outContent.toString());
  }

  @Test
  public void test41() {
    Main.main(new String[]{"0140a820"});
    assertEquals("add {opcode: 00, rs: 0a, rt: 00, rd: 15, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test42() {
    Main.main(new String[]{"01082020"});
    assertEquals("add {opcode: 00, rs: 08, rt: 08, rd: 04, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test43() {
    Main.main(new String[]{"035ca020"});
    assertEquals("add {opcode: 00, rs: 1a, rt: 1c, rd: 14, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test44() {
    Main.main(new String[]{"ac0d0000"});
    assertEquals("sw {opcode: 2b, rs(base): 00, rt: 0d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test45() {
    Main.main(new String[]{"03a40020"});
    assertEquals("add {opcode: 00, rs: 1d, rt: 04, rd: 00, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test46() {
    Main.main(new String[]{"8fb20000"});
    assertEquals("lw {opcode: 23, rs(base): 1d, rt: 12, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test47() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test48() {
    Main.main(new String[]{"03918824"});
    assertEquals("and {opcode: 00, rs: 1c, rt: 11, rd: 11, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test49() {
    Main.main(new String[]{"3c01003d"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 01, immediate(offset): 003d}\n", outContent.toString());
  }

  @Test
  public void test50() {
    Main.main(new String[]{"00a7f82a"});
    assertEquals("slt {opcode: 00, rs: 05, rt: 07, rd: 1f, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test51() {
    Main.main(new String[]{"03518025"});
    assertEquals("or {opcode: 00, rs: 1a, rt: 11, rd: 10, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test52() {
    Main.main(new String[]{"3c1400af"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 14, immediate(offset): 00af}\n", outContent.toString());
  }

  @Test
  public void test53() {
    Main.main(new String[]{"0143b022"});
    assertEquals("sub {opcode: 00, rs: 0a, rt: 03, rd: 16, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test54() {
    Main.main(new String[]{"0800006c"});
    assertEquals("j {opcode: 02, index: 000006c}\n", outContent.toString());
  }

  @Test
  public void test55() {
    Main.main(new String[]{"35fdff2c"});
    assertEquals("ori {opcode: 0d, rs(base): 0f, rt: 1d, immediate(offset): ff2c}\n", outContent.toString());
  }

  @Test
  public void test56() {
    Main.main(new String[]{"080000ff"});
    assertEquals("j {opcode: 02, index: 00000ff}\n", outContent.toString());
  }

  @Test
  public void test57() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test58() {
    Main.main(new String[]{"0245b824"});
    assertEquals("and {opcode: 00, rs: 12, rt: 05, rd: 17, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test59() {
    Main.main(new String[]{"3c14000d"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 14, immediate(offset): 000d}\n", outContent.toString());
  }

  @Test
  public void test60() {
    Main.main(new String[]{"3610ff4d"});
    assertEquals("ori {opcode: 0d, rs(base): 10, rt: 10, immediate(offset): ff4d}\n", outContent.toString());
  }

  @Test
  public void test61() {
    Main.main(new String[]{"245a00cf"});
    assertEquals("addiu {opcode: 09, rs(base): 02, rt: 1a, immediate(offset): 00cf}\n", outContent.toString());
  }

  @Test
  public void test62() {
    Main.main(new String[]{"027e0020"});
    assertEquals("add {opcode: 00, rs: 13, rt: 1e, rd: 00, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test63() {
    Main.main(new String[]{"34e2ff24"});
    assertEquals("ori {opcode: 0d, rs(base): 07, rt: 02, immediate(offset): ff24}\n", outContent.toString());
  }

  @Test
  public void test64() {
    Main.main(new String[]{"0260f024"});
    assertEquals("and {opcode: 00, rs: 13, rt: 00, rd: 1e, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test65() {
    Main.main(new String[]{"001c1820"});
    assertEquals("add {opcode: 00, rs: 00, rt: 1c, rd: 03, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test66() {
    Main.main(new String[]{"080000e4"});
    assertEquals("j {opcode: 02, index: 00000e4}\n", outContent.toString());
  }

  @Test
  public void test67() {
    Main.main(new String[]{"ad6f0000"});
    assertEquals("sw {opcode: 2b, rs(base): 0b, rt: 0f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test68() {
    Main.main(new String[]{"02bfc820"});
    assertEquals("add {opcode: 00, rs: 15, rt: 1f, rd: 19, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test69() {
    Main.main(new String[]{"080000a0"});
    assertEquals("j {opcode: 02, index: 00000a0}\n", outContent.toString());
  }

  @Test
  public void test70() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test71() {
    Main.main(new String[]{"12d3ff02"});
    assertEquals("beq {opcode: 04, rs(base): 16, rt: 13, immediate(offset): ff02}\n", outContent.toString());
  }

  @Test
  public void test72() {
    Main.main(new String[]{"27770089"});
    assertEquals("addiu {opcode: 09, rs(base): 1b, rt: 17, immediate(offset): 0089}\n", outContent.toString());
  }

  @Test
  public void test73() {
    Main.main(new String[]{"03ec782a"});
    assertEquals("slt {opcode: 00, rs: 1f, rt: 0c, rd: 0f, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test74() {
    Main.main(new String[]{"3c180093"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 18, immediate(offset): 0093}\n", outContent.toString());
  }

  @Test
  public void test75() {
    Main.main(new String[]{"12ecff0e"});
    assertEquals("beq {opcode: 04, rs(base): 17, rt: 0c, immediate(offset): ff0e}\n", outContent.toString());
  }

  @Test
  public void test76() {
    Main.main(new String[]{"33630001"});
    assertEquals("andi {opcode: 0c, rs(base): 1b, rt: 03, immediate(offset): 0001}\n", outContent.toString());
  }

  @Test
  public void test77() {
    Main.main(new String[]{"0398c022"});
    assertEquals("sub {opcode: 00, rs: 1c, rt: 18, rd: 18, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test78() {
    Main.main(new String[]{"25e40023"});
    assertEquals("addiu {opcode: 09, rs(base): 0f, rt: 04, immediate(offset): 0023}\n", outContent.toString());
  }

  @Test
  public void test79() {
    Main.main(new String[]{"03d90822"});
    assertEquals("sub {opcode: 00, rs: 1e, rt: 19, rd: 01, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test80() {
    Main.main(new String[]{"136900bc"});
    assertEquals("beq {opcode: 04, rs(base): 1b, rt: 09, immediate(offset): 00bc}\n", outContent.toString());
  }

  @Test
  public void test81() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test82() {
    Main.main(new String[]{"03a91024"});
    assertEquals("and {opcode: 00, rs: 1d, rt: 09, rd: 02, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test83() {
    Main.main(new String[]{"0179b825"});
    assertEquals("or {opcode: 00, rs: 0b, rt: 19, rd: 17, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test84() {
    Main.main(new String[]{"02d5282a"});
    assertEquals("slt {opcode: 00, rs: 16, rt: 15, rd: 05, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test85() {
    Main.main(new String[]{"0800005e"});
    assertEquals("j {opcode: 02, index: 000005e}\n", outContent.toString());
  }

  @Test
  public void test86() {
    Main.main(new String[]{"024da025"});
    assertEquals("or {opcode: 00, rs: 12, rt: 0d, rd: 14, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test87() {
    Main.main(new String[]{"03353022"});
    assertEquals("sub {opcode: 00, rs: 19, rt: 15, rd: 06, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test88() {
    Main.main(new String[]{"ac270000"});
    assertEquals("sw {opcode: 2b, rs(base): 01, rt: 07, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test89() {
    Main.main(new String[]{"1004ffb1"});
    assertEquals("beq {opcode: 04, rs(base): 00, rt: 04, immediate(offset): ffb1}\n", outContent.toString());
  }

  @Test
  public void test90() {
    Main.main(new String[]{"aec50000"});
    assertEquals("sw {opcode: 2b, rs(base): 16, rt: 05, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test91() {
    Main.main(new String[]{"10fdffaf"});
    assertEquals("beq {opcode: 04, rs(base): 07, rt: 1d, immediate(offset): ffaf}\n", outContent.toString());
  }

  @Test
  public void test92() {
    Main.main(new String[]{"114300a4"});
    assertEquals("beq {opcode: 04, rs(base): 0a, rt: 03, immediate(offset): 00a4}\n", outContent.toString());
  }

  @Test
  public void test93() {
    Main.main(new String[]{"34c3ff64"});
    assertEquals("ori {opcode: 0d, rs(base): 06, rt: 03, immediate(offset): ff64}\n", outContent.toString());
  }

  @Test
  public void test94() {
    Main.main(new String[]{"27b7000d"});
    assertEquals("addiu {opcode: 09, rs(base): 1d, rt: 17, immediate(offset): 000d}\n", outContent.toString());
  }

  @Test
  public void test95() {
    Main.main(new String[]{"26fa0064"});
    assertEquals("addiu {opcode: 09, rs(base): 17, rt: 1a, immediate(offset): 0064}\n", outContent.toString());
  }

  @Test
  public void test96() {
    Main.main(new String[]{"156bffd9"});
    assertEquals("bne {opcode: 05, rs(base): 0b, rt: 0b, immediate(offset): ffd9}\n", outContent.toString());
  }

  @Test
  public void test97() {
    Main.main(new String[]{"3c150045"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 15, immediate(offset): 0045}\n", outContent.toString());
  }

  @Test
  public void test98() {
    Main.main(new String[]{"0036602a"});
    assertEquals("slt {opcode: 00, rs: 01, rt: 16, rd: 0c, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test99() {
    Main.main(new String[]{"34e9ff9e"});
    assertEquals("ori {opcode: 0d, rs(base): 07, rt: 09, immediate(offset): ff9e}\n", outContent.toString());
  }

  @Test
  public void test100() {
    Main.main(new String[]{"31aaffee"});
    assertEquals("andi {opcode: 0c, rs(base): 0d, rt: 0a, immediate(offset): ffee}\n", outContent.toString());
  }

  @Test
  public void test101() {
    Main.main(new String[]{"026e5024"});
    assertEquals("and {opcode: 00, rs: 13, rt: 0e, rd: 0a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test102() {
    Main.main(new String[]{"0800007a"});
    assertEquals("j {opcode: 02, index: 000007a}\n", outContent.toString());
  }

  @Test
  public void test103() {
    Main.main(new String[]{"0175a824"});
    assertEquals("and {opcode: 00, rs: 0b, rt: 15, rd: 15, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test104() {
    Main.main(new String[]{"3703ffa6"});
    assertEquals("ori {opcode: 0d, rs(base): 18, rt: 03, immediate(offset): ffa6}\n", outContent.toString());
  }

  @Test
  public void test105() {
    Main.main(new String[]{"37340077"});
    assertEquals("ori {opcode: 0d, rs(base): 19, rt: 14, immediate(offset): 0077}\n", outContent.toString());
  }

  @Test
  public void test106() {
    Main.main(new String[]{"03144025"});
    assertEquals("or {opcode: 00, rs: 18, rt: 14, rd: 08, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test107() {
    Main.main(new String[]{"02c2b025"});
    assertEquals("or {opcode: 00, rs: 16, rt: 02, rd: 16, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test108() {
    Main.main(new String[]{"3c150060"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 15, immediate(offset): 0060}\n", outContent.toString());
  }

  @Test
  public void test109() {
    Main.main(new String[]{"130c00d2"});
    assertEquals("beq {opcode: 04, rs(base): 18, rt: 0c, immediate(offset): 00d2}\n", outContent.toString());
  }

  @Test
  public void test110() {
    Main.main(new String[]{"8edd0000"});
    assertEquals("lw {opcode: 23, rs(base): 16, rt: 1d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test111() {
    Main.main(new String[]{"ae240000"});
    assertEquals("sw {opcode: 2b, rs(base): 11, rt: 04, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test112() {
    Main.main(new String[]{"8ddf0000"});
    assertEquals("lw {opcode: 23, rs(base): 0e, rt: 1f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test113() {
    Main.main(new String[]{"0264a825"});
    assertEquals("or {opcode: 00, rs: 13, rt: 04, rd: 15, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test114() {
    Main.main(new String[]{"007dc025"});
    assertEquals("or {opcode: 00, rs: 03, rt: 1d, rd: 18, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test115() {
    Main.main(new String[]{"329affc0"});
    assertEquals("andi {opcode: 0c, rs(base): 14, rt: 1a, immediate(offset): ffc0}\n", outContent.toString());
  }

  @Test
  public void test116() {
    Main.main(new String[]{"105aff45"});
    assertEquals("beq {opcode: 04, rs(base): 02, rt: 1a, immediate(offset): ff45}\n", outContent.toString());
  }

  @Test
  public void test117() {
    Main.main(new String[]{"36de0071"});
    assertEquals("ori {opcode: 0d, rs(base): 16, rt: 1e, immediate(offset): 0071}\n", outContent.toString());
  }

  @Test
  public void test118() {
    Main.main(new String[]{"31b900f0"});
    assertEquals("andi {opcode: 0c, rs(base): 0d, rt: 19, immediate(offset): 00f0}\n", outContent.toString());
  }

  @Test
  public void test119() {
    Main.main(new String[]{"026df822"});
    assertEquals("sub {opcode: 00, rs: 13, rt: 0d, rd: 1f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test120() {
    Main.main(new String[]{"0367102a"});
    assertEquals("slt {opcode: 00, rs: 1b, rt: 07, rd: 02, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test121() {
    Main.main(new String[]{"ac690000"});
    assertEquals("sw {opcode: 2b, rs(base): 03, rt: 09, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test122() {
    Main.main(new String[]{"01c40822"});
    assertEquals("sub {opcode: 00, rs: 0e, rt: 04, rd: 01, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test123() {
    Main.main(new String[]{"01695020"});
    assertEquals("add {opcode: 00, rs: 0b, rt: 09, rd: 0a, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test124() {
    Main.main(new String[]{"3c11006a"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 006a}\n", outContent.toString());
  }

  @Test
  public void test125() {
    Main.main(new String[]{"acf20000"});
    assertEquals("sw {opcode: 2b, rs(base): 07, rt: 12, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test126() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test127() {
    Main.main(new String[]{"01408022"});
    assertEquals("sub {opcode: 00, rs: 0a, rt: 00, rd: 10, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test128() {
    Main.main(new String[]{"00a40024"});
    assertEquals("and {opcode: 00, rs: 05, rt: 04, rd: 00, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test129() {
    Main.main(new String[]{"00f8a825"});
    assertEquals("or {opcode: 00, rs: 07, rt: 18, rd: 15, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test130() {
    Main.main(new String[]{"0158182a"});
    assertEquals("slt {opcode: 00, rs: 0a, rt: 18, rd: 03, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test131() {
    Main.main(new String[]{"3c010081"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 01, immediate(offset): 0081}\n", outContent.toString());
  }

  @Test
  public void test132() {
    Main.main(new String[]{"323400f6"});
    assertEquals("andi {opcode: 0c, rs(base): 11, rt: 14, immediate(offset): 00f6}\n", outContent.toString());
  }

  @Test
  public void test133() {
    Main.main(new String[]{"3c16000a"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 16, immediate(offset): 000a}\n", outContent.toString());
  }

  @Test
  public void test134() {
    Main.main(new String[]{"009ed024"});
    assertEquals("and {opcode: 00, rs: 04, rt: 1e, rd: 1a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test135() {
    Main.main(new String[]{"08000030"});
    assertEquals("j {opcode: 02, index: 0000030}\n", outContent.toString());
  }

  @Test
  public void test136() {
    Main.main(new String[]{"08000029"});
    assertEquals("j {opcode: 02, index: 0000029}\n", outContent.toString());
  }

  @Test
  public void test137() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test138() {
    Main.main(new String[]{"000ab820"});
    assertEquals("add {opcode: 00, rs: 00, rt: 0a, rd: 17, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test139() {
    Main.main(new String[]{"ae85ff94"});
    assertEquals("sw {opcode: 2b, rs(base): 14, rt: 05, immediate(offset): ff94}\n", outContent.toString());
  }

  @Test
  public void test140() {
    Main.main(new String[]{"8e0b00bc"});
    assertEquals("lw {opcode: 23, rs(base): 10, rt: 0b, immediate(offset): 00bc}\n", outContent.toString());
  }

  @Test
  public void test141() {
    Main.main(new String[]{"00101024"});
    assertEquals("and {opcode: 00, rs: 00, rt: 10, rd: 02, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test142() {
    Main.main(new String[]{"0311d824"});
    assertEquals("and {opcode: 00, rs: 18, rt: 11, rd: 1b, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test143() {
    Main.main(new String[]{"af9a0000"});
    assertEquals("sw {opcode: 2b, rs(base): 1c, rt: 1a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test144() {
    Main.main(new String[]{"027dd82a"});
    assertEquals("slt {opcode: 00, rs: 13, rt: 1d, rd: 1b, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test145() {
    Main.main(new String[]{"359f00bb"});
    assertEquals("ori {opcode: 0d, rs(base): 0c, rt: 1f, immediate(offset): 00bb}\n", outContent.toString());
  }

  @Test
  public void test146() {
    Main.main(new String[]{"00118022"});
    assertEquals("sub {opcode: 00, rs: 00, rt: 11, rd: 10, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test147() {
    Main.main(new String[]{"8c930000"});
    assertEquals("lw {opcode: 23, rs(base): 04, rt: 13, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test148() {
    Main.main(new String[]{"34750072"});
    assertEquals("ori {opcode: 0d, rs(base): 03, rt: 15, immediate(offset): 0072}\n", outContent.toString());
  }

  @Test
  public void test149() {
    Main.main(new String[]{"08000002"});
    assertEquals("j {opcode: 02, index: 0000002}\n", outContent.toString());
  }

  @Test
  public void test150() {
    Main.main(new String[]{"3c0e0070"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 0070}\n", outContent.toString());
  }

  @Test
  public void test151() {
    Main.main(new String[]{"030a9824"});
    assertEquals("and {opcode: 00, rs: 18, rt: 0a, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test152() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test153() {
    Main.main(new String[]{"02068020"});
    assertEquals("add {opcode: 00, rs: 10, rt: 06, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test154() {
    Main.main(new String[]{"02864820"});
    assertEquals("add {opcode: 00, rs: 14, rt: 06, rd: 09, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test155() {
    Main.main(new String[]{"307c0071"});
    assertEquals("andi {opcode: 0c, rs(base): 03, rt: 1c, immediate(offset): 0071}\n", outContent.toString());
  }

  @Test
  public void test156() {
    Main.main(new String[]{"03de4825"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 1e, rd: 09, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test157() {
    Main.main(new String[]{"02a1e822"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 01, rd: 1d, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test158() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test159() {
    Main.main(new String[]{"ad9dff58"});
    assertEquals("sw {opcode: 2b, rs(base): 0c, rt: 1d, immediate(offset): ff58}\n", outContent.toString());
  }

  @Test
  public void test160() {
    Main.main(new String[]{"3577ff30"});
    assertEquals("ori {opcode: 0d, rs(base): 0b, rt: 17, immediate(offset): ff30}\n", outContent.toString());
  }

  @Test
  public void test161() {
    Main.main(new String[]{"02375020"});
    assertEquals("add {opcode: 00, rs: 11, rt: 17, rd: 0a, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test162() {
    Main.main(new String[]{"8d81ff91"});
    assertEquals("lw {opcode: 23, rs(base): 0c, rt: 01, immediate(offset): ff91}\n", outContent.toString());
  }

  @Test
  public void test163() {
    Main.main(new String[]{"8c760000"});
    assertEquals("lw {opcode: 23, rs(base): 03, rt: 16, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test164() {
    Main.main(new String[]{"af700000"});
    assertEquals("sw {opcode: 2b, rs(base): 1b, rt: 10, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test165() {
    Main.main(new String[]{"0130c022"});
    assertEquals("sub {opcode: 00, rs: 09, rt: 10, rd: 18, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test166() {
    Main.main(new String[]{"0268f020"});
    assertEquals("add {opcode: 00, rs: 13, rt: 08, rd: 1e, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test167() {
    Main.main(new String[]{"ae2000c8"});
    assertEquals("sw {opcode: 2b, rs(base): 11, rt: 00, immediate(offset): 00c8}\n", outContent.toString());
  }

  @Test
  public void test168() {
    Main.main(new String[]{"316cff18"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 0c, immediate(offset): ff18}\n", outContent.toString());
  }

  @Test
  public void test169() {
    Main.main(new String[]{"0271982a"});
    assertEquals("slt {opcode: 00, rs: 13, rt: 11, rd: 13, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test170() {
    Main.main(new String[]{"080000f5"});
    assertEquals("j {opcode: 02, index: 00000f5}\n", outContent.toString());
  }

  @Test
  public void test171() {
    Main.main(new String[]{"03144025"});
    assertEquals("or {opcode: 00, rs: 18, rt: 14, rd: 08, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test172() {
    Main.main(new String[]{"3c0e0053"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 0053}\n", outContent.toString());
  }

  @Test
  public void test173() {
    Main.main(new String[]{"30870057"});
    assertEquals("andi {opcode: 0c, rs(base): 04, rt: 07, immediate(offset): 0057}\n", outContent.toString());
  }

  @Test
  public void test174() {
    Main.main(new String[]{"8c08ff81"});
    assertEquals("lw {opcode: 23, rs(base): 00, rt: 08, immediate(offset): ff81}\n", outContent.toString());
  }

  @Test
  public void test175() {
    Main.main(new String[]{"2641005c"});
    assertEquals("addiu {opcode: 09, rs(base): 12, rt: 01, immediate(offset): 005c}\n", outContent.toString());
  }

  @Test
  public void test176() {
    Main.main(new String[]{"080000b7"});
    assertEquals("j {opcode: 02, index: 00000b7}\n", outContent.toString());
  }

  @Test
  public void test177() {
    Main.main(new String[]{"00353025"});
    assertEquals("or {opcode: 00, rs: 01, rt: 15, rd: 06, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test178() {
    Main.main(new String[]{"3378ff76"});
    assertEquals("andi {opcode: 0c, rs(base): 1b, rt: 18, immediate(offset): ff76}\n", outContent.toString());
  }

  @Test
  public void test179() {
    Main.main(new String[]{"005a9024"});
    assertEquals("and {opcode: 00, rs: 02, rt: 1a, rd: 12, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test180() {
    Main.main(new String[]{"003d682a"});
    assertEquals("slt {opcode: 00, rs: 01, rt: 1d, rd: 0d, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test181() {
    Main.main(new String[]{"02cfd824"});
    assertEquals("and {opcode: 00, rs: 16, rt: 0f, rd: 1b, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test182() {
    Main.main(new String[]{"028e1824"});
    assertEquals("and {opcode: 00, rs: 14, rt: 0e, rd: 03, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test183() {
    Main.main(new String[]{"35b8ff04"});
    assertEquals("ori {opcode: 0d, rs(base): 0d, rt: 18, immediate(offset): ff04}\n", outContent.toString());
  }

  @Test
  public void test184() {
    Main.main(new String[]{"02776822"});
    assertEquals("sub {opcode: 00, rs: 13, rt: 17, rd: 0d, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test185() {
    Main.main(new String[]{"023b6020"});
    assertEquals("add {opcode: 00, rs: 11, rt: 1b, rd: 0c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test186() {
    Main.main(new String[]{"313b0021"});
    assertEquals("andi {opcode: 0c, rs(base): 09, rt: 1b, immediate(offset): 0021}\n", outContent.toString());
  }

  @Test
  public void test187() {
    Main.main(new String[]{"3748ffe0"});
    assertEquals("ori {opcode: 0d, rs(base): 1a, rt: 08, immediate(offset): ffe0}\n", outContent.toString());
  }

  @Test
  public void test188() {
    Main.main(new String[]{"08000044"});
    assertEquals("j {opcode: 02, index: 0000044}\n", outContent.toString());
  }

  @Test
  public void test189() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test190() {
    Main.main(new String[]{"24d20060"});
    assertEquals("addiu {opcode: 09, rs(base): 06, rt: 12, immediate(offset): 0060}\n", outContent.toString());
  }

  @Test
  public void test191() {
    Main.main(new String[]{"0800005e"});
    assertEquals("j {opcode: 02, index: 000005e}\n", outContent.toString());
  }

  @Test
  public void test192() {
    Main.main(new String[]{"024fa822"});
    assertEquals("sub {opcode: 00, rs: 12, rt: 0f, rd: 15, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test193() {
    Main.main(new String[]{"0800002a"});
    assertEquals("j {opcode: 02, index: 000002a}\n", outContent.toString());
  }

  @Test
  public void test194() {
    Main.main(new String[]{"3004ffa1"});
    assertEquals("andi {opcode: 0c, rs(base): 00, rt: 04, immediate(offset): ffa1}\n", outContent.toString());
  }

  @Test
  public void test195() {
    Main.main(new String[]{"037b8820"});
    assertEquals("add {opcode: 00, rs: 1b, rt: 1b, rd: 11, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test196() {
    Main.main(new String[]{"3640008c"});
    assertEquals("ori {opcode: 0d, rs(base): 12, rt: 00, immediate(offset): 008c}\n", outContent.toString());
  }

  @Test
  public void test197() {
    Main.main(new String[]{"3c0200ed"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 02, immediate(offset): 00ed}\n", outContent.toString());
  }

  @Test
  public void test198() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test199() {
    Main.main(new String[]{"018b8020"});
    assertEquals("add {opcode: 00, rs: 0c, rt: 0b, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test200() {
    Main.main(new String[]{"36da0060"});
    assertEquals("ori {opcode: 0d, rs(base): 16, rt: 1a, immediate(offset): 0060}\n", outContent.toString());
  }

  @Test
  public void test201() {
    Main.main(new String[]{"033a7820"});
    assertEquals("add {opcode: 00, rs: 19, rt: 1a, rd: 0f, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test202() {
    Main.main(new String[]{"3c1f00f3"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1f, immediate(offset): 00f3}\n", outContent.toString());
  }

  @Test
  public void test203() {
    Main.main(new String[]{"03394025"});
    assertEquals("or {opcode: 00, rs: 19, rt: 19, rd: 08, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test204() {
    Main.main(new String[]{"01359824"});
    assertEquals("and {opcode: 00, rs: 09, rt: 15, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test205() {
    Main.main(new String[]{"1429000b"});
    assertEquals("bne {opcode: 05, rs(base): 01, rt: 09, immediate(offset): 000b}\n", outContent.toString());
  }

  @Test
  public void test206() {
    Main.main(new String[]{"34d6008e"});
    assertEquals("ori {opcode: 0d, rs(base): 06, rt: 16, immediate(offset): 008e}\n", outContent.toString());
  }

  @Test
  public void test207() {
    Main.main(new String[]{"277e0088"});
    assertEquals("addiu {opcode: 09, rs(base): 1b, rt: 1e, immediate(offset): 0088}\n", outContent.toString());
  }

  @Test
  public void test208() {
    Main.main(new String[]{"00ad1822"});
    assertEquals("sub {opcode: 00, rs: 05, rt: 0d, rd: 03, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test209() {
    Main.main(new String[]{"272300d4"});
    assertEquals("addiu {opcode: 09, rs(base): 19, rt: 03, immediate(offset): 00d4}\n", outContent.toString());
  }

  @Test
  public void test210() {
    Main.main(new String[]{"08000088"});
    assertEquals("j {opcode: 02, index: 0000088}\n", outContent.toString());
  }

  @Test
  public void test211() {
    Main.main(new String[]{"006e7820"});
    assertEquals("add {opcode: 00, rs: 03, rt: 0e, rd: 0f, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test212() {
    Main.main(new String[]{"8f310000"});
    assertEquals("lw {opcode: 23, rs(base): 19, rt: 11, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test213() {
    Main.main(new String[]{"afbf0000"});
    assertEquals("sw {opcode: 2b, rs(base): 1d, rt: 1f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test214() {
    Main.main(new String[]{"adec0000"});
    assertEquals("sw {opcode: 2b, rs(base): 0f, rt: 0c, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test215() {
    Main.main(new String[]{"8ca60058"});
    assertEquals("lw {opcode: 23, rs(base): 05, rt: 06, immediate(offset): 0058}\n", outContent.toString());
  }

  @Test
  public void test216() {
    Main.main(new String[]{"017e4824"});
    assertEquals("and {opcode: 00, rs: 0b, rt: 1e, rd: 09, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test217() {
    Main.main(new String[]{"0335c02a"});
    assertEquals("slt {opcode: 00, rs: 19, rt: 15, rd: 18, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test218() {
    Main.main(new String[]{"10700015"});
    assertEquals("beq {opcode: 04, rs(base): 03, rt: 10, immediate(offset): 0015}\n", outContent.toString());
  }

  @Test
  public void test219() {
    Main.main(new String[]{"020ba020"});
    assertEquals("add {opcode: 00, rs: 10, rt: 0b, rd: 14, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test220() {
    Main.main(new String[]{"3c1100a9"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 00a9}\n", outContent.toString());
  }

  @Test
  public void test221() {
    Main.main(new String[]{"08000078"});
    assertEquals("j {opcode: 02, index: 0000078}\n", outContent.toString());
  }

  @Test
  public void test222() {
    Main.main(new String[]{"0083502a"});
    assertEquals("slt {opcode: 00, rs: 04, rt: 03, rd: 0a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test223() {
    Main.main(new String[]{"00cda025"});
    assertEquals("or {opcode: 00, rs: 06, rt: 0d, rd: 14, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test224() {
    Main.main(new String[]{"10c100b9"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 01, immediate(offset): 00b9}\n", outContent.toString());
  }

  @Test
  public void test225() {
    Main.main(new String[]{"12adff60"});
    assertEquals("beq {opcode: 04, rs(base): 15, rt: 0d, immediate(offset): ff60}\n", outContent.toString());
  }

  @Test
  public void test226() {
    Main.main(new String[]{"8cb80000"});
    assertEquals("lw {opcode: 23, rs(base): 05, rt: 18, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test227() {
    Main.main(new String[]{"02800824"});
    assertEquals("and {opcode: 00, rs: 14, rt: 00, rd: 01, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test228() {
    Main.main(new String[]{"ade50000"});
    assertEquals("sw {opcode: 2b, rs(base): 0f, rt: 05, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test229() {
    Main.main(new String[]{"02c4d820"});
    assertEquals("add {opcode: 00, rs: 16, rt: 04, rd: 1b, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test230() {
    Main.main(new String[]{"0800007c"});
    assertEquals("j {opcode: 02, index: 000007c}\n", outContent.toString());
  }

  @Test
  public void test231() {
    Main.main(new String[]{"0111c820"});
    assertEquals("add {opcode: 00, rs: 08, rt: 11, rd: 19, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test232() {
    Main.main(new String[]{"3219ff29"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 19, immediate(offset): ff29}\n", outContent.toString());
  }

  @Test
  public void test233() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test234() {
    Main.main(new String[]{"31de002a"});
    assertEquals("andi {opcode: 0c, rs(base): 0e, rt: 1e, immediate(offset): 002a}\n", outContent.toString());
  }

  @Test
  public void test235() {
    Main.main(new String[]{"ae9b0000"});
    assertEquals("sw {opcode: 2b, rs(base): 14, rt: 1b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test236() {
    Main.main(new String[]{"02df6020"});
    assertEquals("add {opcode: 00, rs: 16, rt: 1f, rd: 0c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test237() {
    Main.main(new String[]{"3202ffa8"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 02, immediate(offset): ffa8}\n", outContent.toString());
  }

  @Test
  public void test238() {
    Main.main(new String[]{"010c0025"});
    assertEquals("or {opcode: 00, rs: 08, rt: 0c, rd: 00, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test239() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test240() {
    Main.main(new String[]{"03e3b822"});
    assertEquals("sub {opcode: 00, rs: 1f, rt: 03, rd: 17, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test241() {
    Main.main(new String[]{"01071825"});
    assertEquals("or {opcode: 00, rs: 08, rt: 07, rd: 03, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test242() {
    Main.main(new String[]{"003e4820"});
    assertEquals("add {opcode: 00, rs: 01, rt: 1e, rd: 09, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test243() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test244() {
    Main.main(new String[]{"0031e022"});
    assertEquals("sub {opcode: 00, rs: 01, rt: 11, rd: 1c, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test245() {
    Main.main(new String[]{"af7b0000"});
    assertEquals("sw {opcode: 2b, rs(base): 1b, rt: 1b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test246() {
    Main.main(new String[]{"32a8ffba"});
    assertEquals("andi {opcode: 0c, rs(base): 15, rt: 08, immediate(offset): ffba}\n", outContent.toString());
  }

  @Test
  public void test247() {
    Main.main(new String[]{"3c1b0020"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1b, immediate(offset): 0020}\n", outContent.toString());
  }

  @Test
  public void test248() {
    Main.main(new String[]{"8f1f00f3"});
    assertEquals("lw {opcode: 23, rs(base): 18, rt: 1f, immediate(offset): 00f3}\n", outContent.toString());
  }

  @Test
  public void test249() {
    Main.main(new String[]{"3c07009c"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 07, immediate(offset): 009c}\n", outContent.toString());
  }

  @Test
  public void test250() {
    Main.main(new String[]{"02eb0025"});
    assertEquals("or {opcode: 00, rs: 17, rt: 0b, rd: 00, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test251() {
    Main.main(new String[]{"13feff3a"});
    assertEquals("beq {opcode: 04, rs(base): 1f, rt: 1e, immediate(offset): ff3a}\n", outContent.toString());
  }

  @Test
  public void test252() {
    Main.main(new String[]{"018df024"});
    assertEquals("and {opcode: 00, rs: 0c, rt: 0d, rd: 1e, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test253() {
    Main.main(new String[]{"023ed02a"});
    assertEquals("slt {opcode: 00, rs: 11, rt: 1e, rd: 1a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test254() {
    Main.main(new String[]{"ac810000"});
    assertEquals("sw {opcode: 2b, rs(base): 04, rt: 01, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test255() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test256() {
    Main.main(new String[]{"3c1f00e3"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1f, immediate(offset): 00e3}\n", outContent.toString());
  }

  @Test
  public void test257() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test258() {
    Main.main(new String[]{"1217ff64"});
    assertEquals("beq {opcode: 04, rs(base): 10, rt: 17, immediate(offset): ff64}\n", outContent.toString());
  }

  @Test
  public void test259() {
    Main.main(new String[]{"1517ff00"});
    assertEquals("bne {opcode: 05, rs(base): 08, rt: 17, immediate(offset): ff00}\n", outContent.toString());
  }

  @Test
  public void test260() {
    Main.main(new String[]{"36a8ffb1"});
    assertEquals("ori {opcode: 0d, rs(base): 15, rt: 08, immediate(offset): ffb1}\n", outContent.toString());
  }

  @Test
  public void test261() {
    Main.main(new String[]{"08000059"});
    assertEquals("j {opcode: 02, index: 0000059}\n", outContent.toString());
  }

  @Test
  public void test262() {
    Main.main(new String[]{"00761822"});
    assertEquals("sub {opcode: 00, rs: 03, rt: 16, rd: 03, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test263() {
    Main.main(new String[]{"00fc602a"});
    assertEquals("slt {opcode: 00, rs: 07, rt: 1c, rd: 0c, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test264() {
    Main.main(new String[]{"8f6a0090"});
    assertEquals("lw {opcode: 23, rs(base): 1b, rt: 0a, immediate(offset): 0090}\n", outContent.toString());
  }

  @Test
  public void test265() {
    Main.main(new String[]{"12dc00ac"});
    assertEquals("beq {opcode: 04, rs(base): 16, rt: 1c, immediate(offset): 00ac}\n", outContent.toString());
  }

  @Test
  public void test266() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test267() {
    Main.main(new String[]{"ac4d0000"});
    assertEquals("sw {opcode: 2b, rs(base): 02, rt: 0d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test268() {
    Main.main(new String[]{"3c1d0005"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1d, immediate(offset): 0005}\n", outContent.toString());
  }

  @Test
  public void test269() {
    Main.main(new String[]{"00a22820"});
    assertEquals("add {opcode: 00, rs: 05, rt: 02, rd: 05, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test270() {
    Main.main(new String[]{"1585ff6c"});
    assertEquals("bne {opcode: 05, rs(base): 0c, rt: 05, immediate(offset): ff6c}\n", outContent.toString());
  }

  @Test
  public void test271() {
    Main.main(new String[]{"34c600b7"});
    assertEquals("ori {opcode: 0d, rs(base): 06, rt: 06, immediate(offset): 00b7}\n", outContent.toString());
  }

  @Test
  public void test272() {
    Main.main(new String[]{"01bd882a"});
    assertEquals("slt {opcode: 00, rs: 0d, rt: 1d, rd: 11, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test273() {
    Main.main(new String[]{"307cffca"});
    assertEquals("andi {opcode: 0c, rs(base): 03, rt: 1c, immediate(offset): ffca}\n", outContent.toString());
  }

  @Test
  public void test274() {
    Main.main(new String[]{"080000be"});
    assertEquals("j {opcode: 02, index: 00000be}\n", outContent.toString());
  }

  @Test
  public void test275() {
    Main.main(new String[]{"ac220000"});
    assertEquals("sw {opcode: 2b, rs(base): 01, rt: 02, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test276() {
    Main.main(new String[]{"080000c7"});
    assertEquals("j {opcode: 02, index: 00000c7}\n", outContent.toString());
  }

  @Test
  public void test277() {
    Main.main(new String[]{"17f7ffca"});
    assertEquals("bne {opcode: 05, rs(base): 1f, rt: 17, immediate(offset): ffca}\n", outContent.toString());
  }

  @Test
  public void test278() {
    Main.main(new String[]{"0062f824"});
    assertEquals("and {opcode: 00, rs: 03, rt: 02, rd: 1f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test279() {
    Main.main(new String[]{"00de0824"});
    assertEquals("and {opcode: 00, rs: 06, rt: 1e, rd: 01, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test280() {
    Main.main(new String[]{"03aad020"});
    assertEquals("add {opcode: 00, rs: 1d, rt: 0a, rd: 1a, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test281() {
    Main.main(new String[]{"02044822"});
    assertEquals("sub {opcode: 00, rs: 10, rt: 04, rd: 09, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test282() {
    Main.main(new String[]{"023e0820"});
    assertEquals("add {opcode: 00, rs: 11, rt: 1e, rd: 01, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test283() {
    Main.main(new String[]{"30d80031"});
    assertEquals("andi {opcode: 0c, rs(base): 06, rt: 18, immediate(offset): 0031}\n", outContent.toString());
  }

  @Test
  public void test284() {
    Main.main(new String[]{"1482ff3f"});
    assertEquals("bne {opcode: 05, rs(base): 04, rt: 02, immediate(offset): ff3f}\n", outContent.toString());
  }

  @Test
  public void test285() {
    Main.main(new String[]{"022dd824"});
    assertEquals("and {opcode: 00, rs: 11, rt: 0d, rd: 1b, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test286() {
    Main.main(new String[]{"accf0000"});
    assertEquals("sw {opcode: 2b, rs(base): 06, rt: 0f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test287() {
    Main.main(new String[]{"356400c4"});
    assertEquals("ori {opcode: 0d, rs(base): 0b, rt: 04, immediate(offset): 00c4}\n", outContent.toString());
  }

  @Test
  public void test288() {
    Main.main(new String[]{"178c00bb"});
    assertEquals("bne {opcode: 05, rs(base): 1c, rt: 0c, immediate(offset): 00bb}\n", outContent.toString());
  }

  @Test
  public void test289() {
    Main.main(new String[]{"317800d0"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 18, immediate(offset): 00d0}\n", outContent.toString());
  }

  @Test
  public void test290() {
    Main.main(new String[]{"15040040"});
    assertEquals("bne {opcode: 05, rs(base): 08, rt: 04, immediate(offset): 0040}\n", outContent.toString());
  }

  @Test
  public void test291() {
    Main.main(new String[]{"8cd10000"});
    assertEquals("lw {opcode: 23, rs(base): 06, rt: 11, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test292() {
    Main.main(new String[]{"3c160078"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 16, immediate(offset): 0078}\n", outContent.toString());
  }

  @Test
  public void test293() {
    Main.main(new String[]{"03b0482a"});
    assertEquals("slt {opcode: 00, rs: 1d, rt: 10, rd: 09, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test294() {
    Main.main(new String[]{"273a001b"});
    assertEquals("addiu {opcode: 09, rs(base): 19, rt: 1a, immediate(offset): 001b}\n", outContent.toString());
  }

  @Test
  public void test295() {
    Main.main(new String[]{"8e9b0000"});
    assertEquals("lw {opcode: 23, rs(base): 14, rt: 1b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test296() {
    Main.main(new String[]{"14cb0001"});
    assertEquals("bne {opcode: 05, rs(base): 06, rt: 0b, immediate(offset): 0001}\n", outContent.toString());
  }

  @Test
  public void test297() {
    Main.main(new String[]{"3598fff7"});
    assertEquals("ori {opcode: 0d, rs(base): 0c, rt: 18, immediate(offset): fff7}\n", outContent.toString());
  }

  @Test
  public void test298() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test299() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test300() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test301() {
    Main.main(new String[]{"01e59820"});
    assertEquals("add {opcode: 00, rs: 0f, rt: 05, rd: 13, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test302() {
    Main.main(new String[]{"0397c824"});
    assertEquals("and {opcode: 00, rs: 1c, rt: 17, rd: 19, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test303() {
    Main.main(new String[]{"01aa2822"});
    assertEquals("sub {opcode: 00, rs: 0d, rt: 0a, rd: 05, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test304() {
    Main.main(new String[]{"26e60029"});
    assertEquals("addiu {opcode: 09, rs(base): 17, rt: 06, immediate(offset): 0029}\n", outContent.toString());
  }

  @Test
  public void test305() {
    Main.main(new String[]{"37a0ff2d"});
    assertEquals("ori {opcode: 0d, rs(base): 1d, rt: 00, immediate(offset): ff2d}\n", outContent.toString());
  }

  @Test
  public void test306() {
    Main.main(new String[]{"11c2001f"});
    assertEquals("beq {opcode: 04, rs(base): 0e, rt: 02, immediate(offset): 001f}\n", outContent.toString());
  }

  @Test
  public void test307() {
    Main.main(new String[]{"25be0019"});
    assertEquals("addiu {opcode: 09, rs(base): 0d, rt: 1e, immediate(offset): 0019}\n", outContent.toString());
  }

  @Test
  public void test308() {
    Main.main(new String[]{"af200000"});
    assertEquals("sw {opcode: 2b, rs(base): 19, rt: 00, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test309() {
    Main.main(new String[]{"00a20824"});
    assertEquals("and {opcode: 00, rs: 05, rt: 02, rd: 01, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test310() {
    Main.main(new String[]{"267300b9"});
    assertEquals("addiu {opcode: 09, rs(base): 13, rt: 13, immediate(offset): 00b9}\n", outContent.toString());
  }

  @Test
  public void test311() {
    Main.main(new String[]{"acb30018"});
    assertEquals("sw {opcode: 2b, rs(base): 05, rt: 13, immediate(offset): 0018}\n", outContent.toString());
  }

  @Test
  public void test312() {
    Main.main(new String[]{"356f0026"});
    assertEquals("ori {opcode: 0d, rs(base): 0b, rt: 0f, immediate(offset): 0026}\n", outContent.toString());
  }

  @Test
  public void test313() {
    Main.main(new String[]{"1130006d"});
    assertEquals("beq {opcode: 04, rs(base): 09, rt: 10, immediate(offset): 006d}\n", outContent.toString());
  }

  @Test
  public void test314() {
    Main.main(new String[]{"3321ff82"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 01, immediate(offset): ff82}\n", outContent.toString());
  }

  @Test
  public void test315() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test316() {
    Main.main(new String[]{"013f8024"});
    assertEquals("and {opcode: 00, rs: 09, rt: 1f, rd: 10, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test317() {
    Main.main(new String[]{"1025002b"});
    assertEquals("beq {opcode: 04, rs(base): 01, rt: 05, immediate(offset): 002b}\n", outContent.toString());
  }

  @Test
  public void test318() {
    Main.main(new String[]{"0351f822"});
    assertEquals("sub {opcode: 00, rs: 1a, rt: 11, rd: 1f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test319() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test320() {
    Main.main(new String[]{"00148020"});
    assertEquals("add {opcode: 00, rs: 00, rt: 14, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test321() {
    Main.main(new String[]{"03371824"});
    assertEquals("and {opcode: 00, rs: 19, rt: 17, rd: 03, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test322() {
    Main.main(new String[]{"347dff6e"});
    assertEquals("ori {opcode: 0d, rs(base): 03, rt: 1d, immediate(offset): ff6e}\n", outContent.toString());
  }

  @Test
  public void test323() {
    Main.main(new String[]{"167300cf"});
    assertEquals("bne {opcode: 05, rs(base): 13, rt: 13, immediate(offset): 00cf}\n", outContent.toString());
  }

  @Test
  public void test324() {
    Main.main(new String[]{"02d0c02a"});
    assertEquals("slt {opcode: 00, rs: 16, rt: 10, rd: 18, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test325() {
    Main.main(new String[]{"370affc5"});
    assertEquals("ori {opcode: 0d, rs(base): 18, rt: 0a, immediate(offset): ffc5}\n", outContent.toString());
  }

  @Test
  public void test326() {
    Main.main(new String[]{"31b1ff39"});
    assertEquals("andi {opcode: 0c, rs(base): 0d, rt: 11, immediate(offset): ff39}\n", outContent.toString());
  }

  @Test
  public void test327() {
    Main.main(new String[]{"00fe382a"});
    assertEquals("slt {opcode: 00, rs: 07, rt: 1e, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test328() {
    Main.main(new String[]{"3110fffb"});
    assertEquals("andi {opcode: 0c, rs(base): 08, rt: 10, immediate(offset): fffb}\n", outContent.toString());
  }

  @Test
  public void test329() {
    Main.main(new String[]{"3c130095"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 13, immediate(offset): 0095}\n", outContent.toString());
  }

  @Test
  public void test330() {
    Main.main(new String[]{"03696824"});
    assertEquals("and {opcode: 00, rs: 1b, rt: 09, rd: 0d, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test331() {
    Main.main(new String[]{"01b35822"});
    assertEquals("sub {opcode: 00, rs: 0d, rt: 13, rd: 0b, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test332() {
    Main.main(new String[]{"8cd3ff5b"});
    assertEquals("lw {opcode: 23, rs(base): 06, rt: 13, immediate(offset): ff5b}\n", outContent.toString());
  }

  @Test
  public void test333() {
    Main.main(new String[]{"02fa9824"});
    assertEquals("and {opcode: 00, rs: 17, rt: 1a, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test334() {
    Main.main(new String[]{"02ad502a"});
    assertEquals("slt {opcode: 00, rs: 15, rt: 0d, rd: 0a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test335() {
    Main.main(new String[]{"131a00e4"});
    assertEquals("beq {opcode: 04, rs(base): 18, rt: 1a, immediate(offset): 00e4}\n", outContent.toString());
  }

  @Test
  public void test336() {
    Main.main(new String[]{"00ac1822"});
    assertEquals("sub {opcode: 00, rs: 05, rt: 0c, rd: 03, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test337() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test338() {
    Main.main(new String[]{"16ec0089"});
    assertEquals("bne {opcode: 05, rs(base): 17, rt: 0c, immediate(offset): 0089}\n", outContent.toString());
  }

  @Test
  public void test339() {
    Main.main(new String[]{"3c1c0000"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1c, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test340() {
    Main.main(new String[]{"010ea822"});
    assertEquals("sub {opcode: 00, rs: 08, rt: 0e, rd: 15, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test341() {
    Main.main(new String[]{"31cc0024"});
    assertEquals("andi {opcode: 0c, rs(base): 0e, rt: 0c, immediate(offset): 0024}\n", outContent.toString());
  }

  @Test
  public void test342() {
    Main.main(new String[]{"3172ff4c"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 12, immediate(offset): ff4c}\n", outContent.toString());
  }

  @Test
  public void test343() {
    Main.main(new String[]{"0800008f"});
    assertEquals("j {opcode: 02, index: 000008f}\n", outContent.toString());
  }

  @Test
  public void test344() {
    Main.main(new String[]{"002b3022"});
    assertEquals("sub {opcode: 00, rs: 01, rt: 0b, rd: 06, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test345() {
    Main.main(new String[]{"02d1e02a"});
    assertEquals("slt {opcode: 00, rs: 16, rt: 11, rd: 1c, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test346() {
    Main.main(new String[]{"8dadff45"});
    assertEquals("lw {opcode: 23, rs(base): 0d, rt: 0d, immediate(offset): ff45}\n", outContent.toString());
  }

  @Test
  public void test347() {
    Main.main(new String[]{"361a00a1"});
    assertEquals("ori {opcode: 0d, rs(base): 10, rt: 1a, immediate(offset): 00a1}\n", outContent.toString());
  }

  @Test
  public void test348() {
    Main.main(new String[]{"35200006"});
    assertEquals("ori {opcode: 0d, rs(base): 09, rt: 00, immediate(offset): 0006}\n", outContent.toString());
  }

  @Test
  public void test349() {
    Main.main(new String[]{"3c1400e6"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 14, immediate(offset): 00e6}\n", outContent.toString());
  }

  @Test
  public void test350() {
    Main.main(new String[]{"01829824"});
    assertEquals("and {opcode: 00, rs: 0c, rt: 02, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test351() {
    Main.main(new String[]{"165aff05"});
    assertEquals("bne {opcode: 05, rs(base): 12, rt: 1a, immediate(offset): ff05}\n", outContent.toString());
  }

  @Test
  public void test352() {
    Main.main(new String[]{"0179f820"});
    assertEquals("add {opcode: 00, rs: 0b, rt: 19, rd: 1f, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test353() {
    Main.main(new String[]{"0800000f"});
    assertEquals("j {opcode: 02, index: 000000f}\n", outContent.toString());
  }

  @Test
  public void test354() {
    Main.main(new String[]{"03a59822"});
    assertEquals("sub {opcode: 00, rs: 1d, rt: 05, rd: 13, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test355() {
    Main.main(new String[]{"00ac182a"});
    assertEquals("slt {opcode: 00, rs: 05, rt: 0c, rd: 03, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test356() {
    Main.main(new String[]{"3217ff0d"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 17, immediate(offset): ff0d}\n", outContent.toString());
  }

  @Test
  public void test357() {
    Main.main(new String[]{"af170089"});
    assertEquals("sw {opcode: 2b, rs(base): 18, rt: 17, immediate(offset): 0089}\n", outContent.toString());
  }

  @Test
  public void test358() {
    Main.main(new String[]{"012c4025"});
    assertEquals("or {opcode: 00, rs: 09, rt: 0c, rd: 08, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test359() {
    Main.main(new String[]{"008f2024"});
    assertEquals("and {opcode: 00, rs: 04, rt: 0f, rd: 04, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test360() {
    Main.main(new String[]{"03fbb020"});
    assertEquals("add {opcode: 00, rs: 1f, rt: 1b, rd: 16, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test361() {
    Main.main(new String[]{"001e4020"});
    assertEquals("add {opcode: 00, rs: 00, rt: 1e, rd: 08, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test362() {
    Main.main(new String[]{"01b4e020"});
    assertEquals("add {opcode: 00, rs: 0d, rt: 14, rd: 1c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test363() {
    Main.main(new String[]{"080000ef"});
    assertEquals("j {opcode: 02, index: 00000ef}\n", outContent.toString());
  }

  @Test
  public void test364() {
    Main.main(new String[]{"00fa5820"});
    assertEquals("add {opcode: 00, rs: 07, rt: 1a, rd: 0b, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test365() {
    Main.main(new String[]{"00257822"});
    assertEquals("sub {opcode: 00, rs: 01, rt: 05, rd: 0f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test366() {
    Main.main(new String[]{"3c0e00a8"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 00a8}\n", outContent.toString());
  }

  @Test
  public void test367() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test368() {
    Main.main(new String[]{"249300dc"});
    assertEquals("addiu {opcode: 09, rs(base): 04, rt: 13, immediate(offset): 00dc}\n", outContent.toString());
  }

  @Test
  public void test369() {
    Main.main(new String[]{"258b0020"});
    assertEquals("addiu {opcode: 09, rs(base): 0c, rt: 0b, immediate(offset): 0020}\n", outContent.toString());
  }

  @Test
  public void test370() {
    Main.main(new String[]{"3071ff2f"});
    assertEquals("andi {opcode: 0c, rs(base): 03, rt: 11, immediate(offset): ff2f}\n", outContent.toString());
  }

  @Test
  public void test371() {
    Main.main(new String[]{"0065e02a"});
    assertEquals("slt {opcode: 00, rs: 03, rt: 05, rd: 1c, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test372() {
    Main.main(new String[]{"009b5820"});
    assertEquals("add {opcode: 00, rs: 04, rt: 1b, rd: 0b, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test373() {
    Main.main(new String[]{"08000049"});
    assertEquals("j {opcode: 02, index: 0000049}\n", outContent.toString());
  }

  @Test
  public void test374() {
    Main.main(new String[]{"109fff47"});
    assertEquals("beq {opcode: 04, rs(base): 04, rt: 1f, immediate(offset): ff47}\n", outContent.toString());
  }

  @Test
  public void test375() {
    Main.main(new String[]{"8fa40000"});
    assertEquals("lw {opcode: 23, rs(base): 1d, rt: 04, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test376() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test377() {
    Main.main(new String[]{"0800003a"});
    assertEquals("j {opcode: 02, index: 000003a}\n", outContent.toString());
  }

  @Test
  public void test378() {
    Main.main(new String[]{"0258c024"});
    assertEquals("and {opcode: 00, rs: 12, rt: 18, rd: 18, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test379() {
    Main.main(new String[]{"ae2b0000"});
    assertEquals("sw {opcode: 2b, rs(base): 11, rt: 0b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test380() {
    Main.main(new String[]{"02c0b025"});
    assertEquals("or {opcode: 00, rs: 16, rt: 00, rd: 16, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test381() {
    Main.main(new String[]{"339bff1b"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 1b, immediate(offset): ff1b}\n", outContent.toString());
  }

  @Test
  public void test382() {
    Main.main(new String[]{"08000070"});
    assertEquals("j {opcode: 02, index: 0000070}\n", outContent.toString());
  }

  @Test
  public void test383() {
    Main.main(new String[]{"01859022"});
    assertEquals("sub {opcode: 00, rs: 0c, rt: 05, rd: 12, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test384() {
    Main.main(new String[]{"aff70000"});
    assertEquals("sw {opcode: 2b, rs(base): 1f, rt: 17, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test385() {
    Main.main(new String[]{"33a100ff"});
    assertEquals("andi {opcode: 0c, rs(base): 1d, rt: 01, immediate(offset): 00ff}\n", outContent.toString());
  }

  @Test
  public void test386() {
    Main.main(new String[]{"afb6ff92"});
    assertEquals("sw {opcode: 2b, rs(base): 1d, rt: 16, immediate(offset): ff92}\n", outContent.toString());
  }

  @Test
  public void test387() {
    Main.main(new String[]{"304b0072"});
    assertEquals("andi {opcode: 0c, rs(base): 02, rt: 0b, immediate(offset): 0072}\n", outContent.toString());
  }

  @Test
  public void test388() {
    Main.main(new String[]{"01e7282a"});
    assertEquals("slt {opcode: 00, rs: 0f, rt: 07, rd: 05, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test389() {
    Main.main(new String[]{"aff1009e"});
    assertEquals("sw {opcode: 2b, rs(base): 1f, rt: 11, immediate(offset): 009e}\n", outContent.toString());
  }

  @Test
  public void test390() {
    Main.main(new String[]{"0039a82a"});
    assertEquals("slt {opcode: 00, rs: 01, rt: 19, rd: 15, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test391() {
    Main.main(new String[]{"038b6822"});
    assertEquals("sub {opcode: 00, rs: 1c, rt: 0b, rd: 0d, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test392() {
    Main.main(new String[]{"01d29022"});
    assertEquals("sub {opcode: 00, rs: 0e, rt: 12, rd: 12, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test393() {
    Main.main(new String[]{"0376f824"});
    assertEquals("and {opcode: 00, rs: 1b, rt: 16, rd: 1f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test394() {
    Main.main(new String[]{"14c900b2"});
    assertEquals("bne {opcode: 05, rs(base): 06, rt: 09, immediate(offset): 00b2}\n", outContent.toString());
  }

  @Test
  public void test395() {
    Main.main(new String[]{"15860032"});
    assertEquals("bne {opcode: 05, rs(base): 0c, rt: 06, immediate(offset): 0032}\n", outContent.toString());
  }

  @Test
  public void test396() {
    Main.main(new String[]{"01847824"});
    assertEquals("and {opcode: 00, rs: 0c, rt: 04, rd: 0f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test397() {
    Main.main(new String[]{"002d6820"});
    assertEquals("add {opcode: 00, rs: 01, rt: 0d, rd: 0d, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test398() {
    Main.main(new String[]{"152b0048"});
    assertEquals("bne {opcode: 05, rs(base): 09, rt: 0b, immediate(offset): 0048}\n", outContent.toString());
  }

  @Test
  public void test399() {
    Main.main(new String[]{"ad5100fa"});
    assertEquals("sw {opcode: 2b, rs(base): 0a, rt: 11, immediate(offset): 00fa}\n", outContent.toString());
  }

  @Test
  public void test400() {
    Main.main(new String[]{"3c1c0093"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1c, immediate(offset): 0093}\n", outContent.toString());
  }

  @Test
  public void test401() {
    Main.main(new String[]{"00e46024"});
    assertEquals("and {opcode: 00, rs: 07, rt: 04, rd: 0c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test402() {
    Main.main(new String[]{"143000bb"});
    assertEquals("bne {opcode: 05, rs(base): 01, rt: 10, immediate(offset): 00bb}\n", outContent.toString());
  }

  @Test
  public void test403() {
    Main.main(new String[]{"025e502a"});
    assertEquals("slt {opcode: 00, rs: 12, rt: 1e, rd: 0a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test404() {
    Main.main(new String[]{"8e080000"});
    assertEquals("lw {opcode: 23, rs(base): 10, rt: 08, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test405() {
    Main.main(new String[]{"01009820"});
    assertEquals("add {opcode: 00, rs: 08, rt: 00, rd: 13, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test406() {
    Main.main(new String[]{"af7f0000"});
    assertEquals("sw {opcode: 2b, rs(base): 1b, rt: 1f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test407() {
    Main.main(new String[]{"135b002a"});
    assertEquals("beq {opcode: 04, rs(base): 1a, rt: 1b, immediate(offset): 002a}\n", outContent.toString());
  }

  @Test
  public void test408() {
    Main.main(new String[]{"24610047"});
    assertEquals("addiu {opcode: 09, rs(base): 03, rt: 01, immediate(offset): 0047}\n", outContent.toString());
  }

  @Test
  public void test409() {
    Main.main(new String[]{"0800006f"});
    assertEquals("j {opcode: 02, index: 000006f}\n", outContent.toString());
  }

  @Test
  public void test410() {
    Main.main(new String[]{"03cd8022"});
    assertEquals("sub {opcode: 00, rs: 1e, rt: 0d, rd: 10, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test411() {
    Main.main(new String[]{"266d00ac"});
    assertEquals("addiu {opcode: 09, rs(base): 13, rt: 0d, immediate(offset): 00ac}\n", outContent.toString());
  }

  @Test
  public void test412() {
    Main.main(new String[]{"340eff39"});
    assertEquals("ori {opcode: 0d, rs(base): 00, rt: 0e, immediate(offset): ff39}\n", outContent.toString());
  }

  @Test
  public void test413() {
    Main.main(new String[]{"10f300c5"});
    assertEquals("beq {opcode: 04, rs(base): 07, rt: 13, immediate(offset): 00c5}\n", outContent.toString());
  }

  @Test
  public void test414() {
    Main.main(new String[]{"24910095"});
    assertEquals("addiu {opcode: 09, rs(base): 04, rt: 11, immediate(offset): 0095}\n", outContent.toString());
  }

  @Test
  public void test415() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test416() {
    Main.main(new String[]{"3160ffe4"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 00, immediate(offset): ffe4}\n", outContent.toString());
  }

  @Test
  public void test417() {
    Main.main(new String[]{"263600f7"});
    assertEquals("addiu {opcode: 09, rs(base): 11, rt: 16, immediate(offset): 00f7}\n", outContent.toString());
  }

  @Test
  public void test418() {
    Main.main(new String[]{"00856825"});
    assertEquals("or {opcode: 00, rs: 04, rt: 05, rd: 0d, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test419() {
    Main.main(new String[]{"13cfffbd"});
    assertEquals("beq {opcode: 04, rs(base): 1e, rt: 0f, immediate(offset): ffbd}\n", outContent.toString());
  }

  @Test
  public void test420() {
    Main.main(new String[]{"3c1c0031"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1c, immediate(offset): 0031}\n", outContent.toString());
  }

  @Test
  public void test421() {
    Main.main(new String[]{"3c0c0004"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0c, immediate(offset): 0004}\n", outContent.toString());
  }

  @Test
  public void test422() {
    Main.main(new String[]{"322200d7"});
    assertEquals("andi {opcode: 0c, rs(base): 11, rt: 02, immediate(offset): 00d7}\n", outContent.toString());
  }

  @Test
  public void test423() {
    Main.main(new String[]{"327600a2"});
    assertEquals("andi {opcode: 0c, rs(base): 13, rt: 16, immediate(offset): 00a2}\n", outContent.toString());
  }

  @Test
  public void test424() {
    Main.main(new String[]{"8e770000"});
    assertEquals("lw {opcode: 23, rs(base): 13, rt: 17, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test425() {
    Main.main(new String[]{"8fa600f8"});
    assertEquals("lw {opcode: 23, rs(base): 1d, rt: 06, immediate(offset): 00f8}\n", outContent.toString());
  }

  @Test
  public void test426() {
    Main.main(new String[]{"ae840000"});
    assertEquals("sw {opcode: 2b, rs(base): 14, rt: 04, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test427() {
    Main.main(new String[]{"02d8e020"});
    assertEquals("add {opcode: 00, rs: 16, rt: 18, rd: 1c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test428() {
    Main.main(new String[]{"32e8ffca"});
    assertEquals("andi {opcode: 0c, rs(base): 17, rt: 08, immediate(offset): ffca}\n", outContent.toString());
  }

  @Test
  public void test429() {
    Main.main(new String[]{"3266ff6b"});
    assertEquals("andi {opcode: 0c, rs(base): 13, rt: 06, immediate(offset): ff6b}\n", outContent.toString());
  }

  @Test
  public void test430() {
    Main.main(new String[]{"01f28020"});
    assertEquals("add {opcode: 00, rs: 0f, rt: 12, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test431() {
    Main.main(new String[]{"00e14020"});
    assertEquals("add {opcode: 00, rs: 07, rt: 01, rd: 08, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test432() {
    Main.main(new String[]{"103cff29"});
    assertEquals("beq {opcode: 04, rs(base): 01, rt: 1c, immediate(offset): ff29}\n", outContent.toString());
  }

  @Test
  public void test433() {
    Main.main(new String[]{"080000f7"});
    assertEquals("j {opcode: 02, index: 00000f7}\n", outContent.toString());
  }

  @Test
  public void test434() {
    Main.main(new String[]{"1510005c"});
    assertEquals("bne {opcode: 05, rs(base): 08, rt: 10, immediate(offset): 005c}\n", outContent.toString());
  }

  @Test
  public void test435() {
    Main.main(new String[]{"32f0ff75"});
    assertEquals("andi {opcode: 0c, rs(base): 17, rt: 10, immediate(offset): ff75}\n", outContent.toString());
  }

  @Test
  public void test436() {
    Main.main(new String[]{"0282a025"});
    assertEquals("or {opcode: 00, rs: 14, rt: 02, rd: 14, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test437() {
    Main.main(new String[]{"1175ffbd"});
    assertEquals("beq {opcode: 04, rs(base): 0b, rt: 15, immediate(offset): ffbd}\n", outContent.toString());
  }

  @Test
  public void test438() {
    Main.main(new String[]{"37ec0064"});
    assertEquals("ori {opcode: 0d, rs(base): 1f, rt: 0c, immediate(offset): 0064}\n", outContent.toString());
  }

  @Test
  public void test439() {
    Main.main(new String[]{"3c090051"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 09, immediate(offset): 0051}\n", outContent.toString());
  }

  @Test
  public void test440() {
    Main.main(new String[]{"adac0000"});
    assertEquals("sw {opcode: 2b, rs(base): 0d, rt: 0c, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test441() {
    Main.main(new String[]{"35230093"});
    assertEquals("ori {opcode: 0d, rs(base): 09, rt: 03, immediate(offset): 0093}\n", outContent.toString());
  }

  @Test
  public void test442() {
    Main.main(new String[]{"0023c825"});
    assertEquals("or {opcode: 00, rs: 01, rt: 03, rd: 19, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test443() {
    Main.main(new String[]{"130bffe0"});
    assertEquals("beq {opcode: 04, rs(base): 18, rt: 0b, immediate(offset): ffe0}\n", outContent.toString());
  }

  @Test
  public void test444() {
    Main.main(new String[]{"0383c822"});
    assertEquals("sub {opcode: 00, rs: 1c, rt: 03, rd: 19, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test445() {
    Main.main(new String[]{"352b0048"});
    assertEquals("ori {opcode: 0d, rs(base): 09, rt: 0b, immediate(offset): 0048}\n", outContent.toString());
  }

  @Test
  public void test446() {
    Main.main(new String[]{"3c0e00d7"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 00d7}\n", outContent.toString());
  }

  @Test
  public void test447() {
    Main.main(new String[]{"ae720000"});
    assertEquals("sw {opcode: 2b, rs(base): 13, rt: 12, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test448() {
    Main.main(new String[]{"0800000b"});
    assertEquals("j {opcode: 02, index: 000000b}\n", outContent.toString());
  }

  @Test
  public void test449() {
    Main.main(new String[]{"2786009a"});
    assertEquals("addiu {opcode: 09, rs(base): 1c, rt: 06, immediate(offset): 009a}\n", outContent.toString());
  }

  @Test
  public void test450() {
    Main.main(new String[]{"372f0006"});
    assertEquals("ori {opcode: 0d, rs(base): 19, rt: 0f, immediate(offset): 0006}\n", outContent.toString());
  }

  @Test
  public void test451() {
    Main.main(new String[]{"08000050"});
    assertEquals("j {opcode: 02, index: 0000050}\n", outContent.toString());
  }

  @Test
  public void test452() {
    Main.main(new String[]{"3208004b"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 08, immediate(offset): 004b}\n", outContent.toString());
  }

  @Test
  public void test453() {
    Main.main(new String[]{"03596020"});
    assertEquals("add {opcode: 00, rs: 1a, rt: 19, rd: 0c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test454() {
    Main.main(new String[]{"002a8025"});
    assertEquals("or {opcode: 00, rs: 01, rt: 0a, rd: 10, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test455() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test456() {
    Main.main(new String[]{"0008e82a"});
    assertEquals("slt {opcode: 00, rs: 00, rt: 08, rd: 1d, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test457() {
    Main.main(new String[]{"036f3025"});
    assertEquals("or {opcode: 00, rs: 1b, rt: 0f, rd: 06, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test458() {
    Main.main(new String[]{"8cfc0037"});
    assertEquals("lw {opcode: 23, rs(base): 07, rt: 1c, immediate(offset): 0037}\n", outContent.toString());
  }

  @Test
  public void test459() {
    Main.main(new String[]{"0017b820"});
    assertEquals("add {opcode: 00, rs: 00, rt: 17, rd: 17, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test460() {
    Main.main(new String[]{"24ab00cc"});
    assertEquals("addiu {opcode: 09, rs(base): 05, rt: 0b, immediate(offset): 00cc}\n", outContent.toString());
  }

  @Test
  public void test461() {
    Main.main(new String[]{"10d40037"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 14, immediate(offset): 0037}\n", outContent.toString());
  }

  @Test
  public void test462() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test463() {
    Main.main(new String[]{"02ff9825"});
    assertEquals("or {opcode: 00, rs: 17, rt: 1f, rd: 13, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test464() {
    Main.main(new String[]{"12bcffcc"});
    assertEquals("beq {opcode: 04, rs(base): 15, rt: 1c, immediate(offset): ffcc}\n", outContent.toString());
  }

  @Test
  public void test465() {
    Main.main(new String[]{"8c0b0000"});
    assertEquals("lw {opcode: 23, rs(base): 00, rt: 0b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test466() {
    Main.main(new String[]{"0800002e"});
    assertEquals("j {opcode: 02, index: 000002e}\n", outContent.toString());
  }

  @Test
  public void test467() {
    Main.main(new String[]{"019d5825"});
    assertEquals("or {opcode: 00, rs: 0c, rt: 1d, rd: 0b, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test468() {
    Main.main(new String[]{"25de0088"});
    assertEquals("addiu {opcode: 09, rs(base): 0e, rt: 1e, immediate(offset): 0088}\n", outContent.toString());
  }

  @Test
  public void test469() {
    Main.main(new String[]{"0262402a"});
    assertEquals("slt {opcode: 00, rs: 13, rt: 02, rd: 08, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test470() {
    Main.main(new String[]{"325cff89"});
    assertEquals("andi {opcode: 0c, rs(base): 12, rt: 1c, immediate(offset): ff89}\n", outContent.toString());
  }

  @Test
  public void test471() {
    Main.main(new String[]{"00016024"});
    assertEquals("and {opcode: 00, rs: 00, rt: 01, rd: 0c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test472() {
    Main.main(new String[]{"3c0b0024"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0b, immediate(offset): 0024}\n", outContent.toString());
  }

  @Test
  public void test473() {
    Main.main(new String[]{"2414004e"});
    assertEquals("addiu {opcode: 09, rs(base): 00, rt: 14, immediate(offset): 004e}\n", outContent.toString());
  }

  @Test
  public void test474() {
    Main.main(new String[]{"154900ce"});
    assertEquals("bne {opcode: 05, rs(base): 0a, rt: 09, immediate(offset): 00ce}\n", outContent.toString());
  }

  @Test
  public void test475() {
    Main.main(new String[]{"8f710000"});
    assertEquals("lw {opcode: 23, rs(base): 1b, rt: 11, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test476() {
    Main.main(new String[]{"3483ffc0"});
    assertEquals("ori {opcode: 0d, rs(base): 04, rt: 03, immediate(offset): ffc0}\n", outContent.toString());
  }

  @Test
  public void test477() {
    Main.main(new String[]{"8f300000"});
    assertEquals("lw {opcode: 23, rs(base): 19, rt: 10, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test478() {
    Main.main(new String[]{"24ae00d4"});
    assertEquals("addiu {opcode: 09, rs(base): 05, rt: 0e, immediate(offset): 00d4}\n", outContent.toString());
  }

  @Test
  public void test479() {
    Main.main(new String[]{"1013ff4c"});
    assertEquals("beq {opcode: 04, rs(base): 00, rt: 13, immediate(offset): ff4c}\n", outContent.toString());
  }

  @Test
  public void test480() {
    Main.main(new String[]{"37d9ffc3"});
    assertEquals("ori {opcode: 0d, rs(base): 1e, rt: 19, immediate(offset): ffc3}\n", outContent.toString());
  }

  @Test
  public void test481() {
    Main.main(new String[]{"002b382a"});
    assertEquals("slt {opcode: 00, rs: 01, rt: 0b, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test482() {
    Main.main(new String[]{"8d100000"});
    assertEquals("lw {opcode: 23, rs(base): 08, rt: 10, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test483() {
    Main.main(new String[]{"08000024"});
    assertEquals("j {opcode: 02, index: 0000024}\n", outContent.toString());
  }

  @Test
  public void test484() {
    Main.main(new String[]{"148affd4"});
    assertEquals("bne {opcode: 05, rs(base): 04, rt: 0a, immediate(offset): ffd4}\n", outContent.toString());
  }

  @Test
  public void test485() {
    Main.main(new String[]{"08000019"});
    assertEquals("j {opcode: 02, index: 0000019}\n", outContent.toString());
  }

  @Test
  public void test486() {
    Main.main(new String[]{"08000039"});
    assertEquals("j {opcode: 02, index: 0000039}\n", outContent.toString());
  }

  @Test
  public void test487() {
    Main.main(new String[]{"03a8d022"});
    assertEquals("sub {opcode: 00, rs: 1d, rt: 08, rd: 1a, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test488() {
    Main.main(new String[]{"13b50024"});
    assertEquals("beq {opcode: 04, rs(base): 1d, rt: 15, immediate(offset): 0024}\n", outContent.toString());
  }

  @Test
  public void test489() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test490() {
    Main.main(new String[]{"03d5e025"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 15, rd: 1c, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test491() {
    Main.main(new String[]{"3c1f0095"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1f, immediate(offset): 0095}\n", outContent.toString());
  }

  @Test
  public void test492() {
    Main.main(new String[]{"ac7f0095"});
    assertEquals("sw {opcode: 2b, rs(base): 03, rt: 1f, immediate(offset): 0095}\n", outContent.toString());
  }

  @Test
  public void test493() {
    Main.main(new String[]{"27d300a7"});
    assertEquals("addiu {opcode: 09, rs(base): 1e, rt: 13, immediate(offset): 00a7}\n", outContent.toString());
  }

  @Test
  public void test494() {
    Main.main(new String[]{"080000e2"});
    assertEquals("j {opcode: 02, index: 00000e2}\n", outContent.toString());
  }

  @Test
  public void test495() {
    Main.main(new String[]{"ac9f001b"});
    assertEquals("sw {opcode: 2b, rs(base): 04, rt: 1f, immediate(offset): 001b}\n", outContent.toString());
  }

  @Test
  public void test496() {
    Main.main(new String[]{"10a0ff0a"});
    assertEquals("beq {opcode: 04, rs(base): 05, rt: 00, immediate(offset): ff0a}\n", outContent.toString());
  }

  @Test
  public void test497() {
    Main.main(new String[]{"0800004f"});
    assertEquals("j {opcode: 02, index: 000004f}\n", outContent.toString());
  }

  @Test
  public void test498() {
    Main.main(new String[]{"3029fff1"});
    assertEquals("andi {opcode: 0c, rs(base): 01, rt: 09, immediate(offset): fff1}\n", outContent.toString());
  }

  @Test
  public void test499() {
    Main.main(new String[]{"02d89825"});
    assertEquals("or {opcode: 00, rs: 16, rt: 18, rd: 13, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test500() {
    Main.main(new String[]{"10c6ffbf"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 06, immediate(offset): ffbf}\n", outContent.toString());
  }

  @Test
  public void test501() {
    Main.main(new String[]{"8d250000"});
    assertEquals("lw {opcode: 23, rs(base): 09, rt: 05, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test502() {
    Main.main(new String[]{"adc40000"});
    assertEquals("sw {opcode: 2b, rs(base): 0e, rt: 04, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test503() {
    Main.main(new String[]{"080000a8"});
    assertEquals("j {opcode: 02, index: 00000a8}\n", outContent.toString());
  }

  @Test
  public void test504() {
    Main.main(new String[]{"026a3824"});
    assertEquals("and {opcode: 00, rs: 13, rt: 0a, rd: 07, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test505() {
    Main.main(new String[]{"01408024"});
    assertEquals("and {opcode: 00, rs: 0a, rt: 00, rd: 10, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test506() {
    Main.main(new String[]{"3c130067"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 13, immediate(offset): 0067}\n", outContent.toString());
  }

  @Test
  public void test507() {
    Main.main(new String[]{"026e3024"});
    assertEquals("and {opcode: 00, rs: 13, rt: 0e, rd: 06, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test508() {
    Main.main(new String[]{"005d1025"});
    assertEquals("or {opcode: 00, rs: 02, rt: 1d, rd: 02, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test509() {
    Main.main(new String[]{"ac620000"});
    assertEquals("sw {opcode: 2b, rs(base): 03, rt: 02, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test510() {
    Main.main(new String[]{"02a29822"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 02, rd: 13, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test511() {
    Main.main(new String[]{"1752ffdc"});
    assertEquals("bne {opcode: 05, rs(base): 1a, rt: 12, immediate(offset): ffdc}\n", outContent.toString());
  }

  @Test
  public void test512() {
    Main.main(new String[]{"080000e4"});
    assertEquals("j {opcode: 02, index: 00000e4}\n", outContent.toString());
  }

  @Test
  public void test513() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test514() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test515() {
    Main.main(new String[]{"3738ffd0"});
    assertEquals("ori {opcode: 0d, rs(base): 19, rt: 18, immediate(offset): ffd0}\n", outContent.toString());
  }

  @Test
  public void test516() {
    Main.main(new String[]{"0154b025"});
    assertEquals("or {opcode: 00, rs: 0a, rt: 14, rd: 16, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test517() {
    Main.main(new String[]{"3c0b001f"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0b, immediate(offset): 001f}\n", outContent.toString());
  }

  @Test
  public void test518() {
    Main.main(new String[]{"af1100cb"});
    assertEquals("sw {opcode: 2b, rs(base): 18, rt: 11, immediate(offset): 00cb}\n", outContent.toString());
  }

  @Test
  public void test519() {
    Main.main(new String[]{"329c0035"});
    assertEquals("andi {opcode: 0c, rs(base): 14, rt: 1c, immediate(offset): 0035}\n", outContent.toString());
  }

  @Test
  public void test520() {
    Main.main(new String[]{"031b182a"});
    assertEquals("slt {opcode: 00, rs: 18, rt: 1b, rd: 03, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test521() {
    Main.main(new String[]{"8c5f0000"});
    assertEquals("lw {opcode: 23, rs(base): 02, rt: 1f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test522() {
    Main.main(new String[]{"33b7ff98"});
    assertEquals("andi {opcode: 0c, rs(base): 1d, rt: 17, immediate(offset): ff98}\n", outContent.toString());
  }

  @Test
  public void test523() {
    Main.main(new String[]{"3c0e0081"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 0081}\n", outContent.toString());
  }

  @Test
  public void test524() {
    Main.main(new String[]{"371e002f"});
    assertEquals("ori {opcode: 0d, rs(base): 18, rt: 1e, immediate(offset): 002f}\n", outContent.toString());
  }

  @Test
  public void test525() {
    Main.main(new String[]{"3285ffbf"});
    assertEquals("andi {opcode: 0c, rs(base): 14, rt: 05, immediate(offset): ffbf}\n", outContent.toString());
  }

  @Test
  public void test526() {
    Main.main(new String[]{"339affb8"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 1a, immediate(offset): ffb8}\n", outContent.toString());
  }

  @Test
  public void test527() {
    Main.main(new String[]{"0800004d"});
    assertEquals("j {opcode: 02, index: 000004d}\n", outContent.toString());
  }

  @Test
  public void test528() {
    Main.main(new String[]{"00b2b022"});
    assertEquals("sub {opcode: 00, rs: 05, rt: 12, rd: 16, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test529() {
    Main.main(new String[]{"3218ffa3"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 18, immediate(offset): ffa3}\n", outContent.toString());
  }

  @Test
  public void test530() {
    Main.main(new String[]{"14d700b3"});
    assertEquals("bne {opcode: 05, rs(base): 06, rt: 17, immediate(offset): 00b3}\n", outContent.toString());
  }

  @Test
  public void test531() {
    Main.main(new String[]{"13bcfffd"});
    assertEquals("beq {opcode: 04, rs(base): 1d, rt: 1c, immediate(offset): fffd}\n", outContent.toString());
  }

  @Test
  public void test532() {
    Main.main(new String[]{"37b900dd"});
    assertEquals("ori {opcode: 0d, rs(base): 1d, rt: 19, immediate(offset): 00dd}\n", outContent.toString());
  }

  @Test
  public void test533() {
    Main.main(new String[]{"00d5402a"});
    assertEquals("slt {opcode: 00, rs: 06, rt: 15, rd: 08, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test534() {
    Main.main(new String[]{"256f00aa"});
    assertEquals("addiu {opcode: 09, rs(base): 0b, rt: 0f, immediate(offset): 00aa}\n", outContent.toString());
  }

  @Test
  public void test535() {
    Main.main(new String[]{"25410067"});
    assertEquals("addiu {opcode: 09, rs(base): 0a, rt: 01, immediate(offset): 0067}\n", outContent.toString());
  }

  @Test
  public void test536() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test537() {
    Main.main(new String[]{"347400da"});
    assertEquals("ori {opcode: 0d, rs(base): 03, rt: 14, immediate(offset): 00da}\n", outContent.toString());
  }

  @Test
  public void test538() {
    Main.main(new String[]{"147f00f7"});
    assertEquals("bne {opcode: 05, rs(base): 03, rt: 1f, immediate(offset): 00f7}\n", outContent.toString());
  }

  @Test
  public void test539() {
    Main.main(new String[]{"1348ff5e"});
    assertEquals("beq {opcode: 04, rs(base): 1a, rt: 08, immediate(offset): ff5e}\n", outContent.toString());
  }

  @Test
  public void test540() {
    Main.main(new String[]{"8d200000"});
    assertEquals("lw {opcode: 23, rs(base): 09, rt: 00, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test541() {
    Main.main(new String[]{"02723825"});
    assertEquals("or {opcode: 00, rs: 13, rt: 12, rd: 07, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test542() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test543() {
    Main.main(new String[]{"02dce825"});
    assertEquals("or {opcode: 00, rs: 16, rt: 1c, rd: 1d, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test544() {
    Main.main(new String[]{"0146682a"});
    assertEquals("slt {opcode: 00, rs: 0a, rt: 06, rd: 0d, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test545() {
    Main.main(new String[]{"08000060"});
    assertEquals("j {opcode: 02, index: 0000060}\n", outContent.toString());
  }

  @Test
  public void test546() {
    Main.main(new String[]{"080000dd"});
    assertEquals("j {opcode: 02, index: 00000dd}\n", outContent.toString());
  }

  @Test
  public void test547() {
    Main.main(new String[]{"321eff28"});
    assertEquals("andi {opcode: 0c, rs(base): 10, rt: 1e, immediate(offset): ff28}\n", outContent.toString());
  }

  @Test
  public void test548() {
    Main.main(new String[]{"0129802a"});
    assertEquals("slt {opcode: 00, rs: 09, rt: 09, rd: 10, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test549() {
    Main.main(new String[]{"12a600ee"});
    assertEquals("beq {opcode: 04, rs(base): 15, rt: 06, immediate(offset): 00ee}\n", outContent.toString());
  }

  @Test
  public void test550() {
    Main.main(new String[]{"02756820"});
    assertEquals("add {opcode: 00, rs: 13, rt: 15, rd: 0d, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test551() {
    Main.main(new String[]{"8cf80000"});
    assertEquals("lw {opcode: 23, rs(base): 07, rt: 18, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test552() {
    Main.main(new String[]{"25470080"});
    assertEquals("addiu {opcode: 09, rs(base): 0a, rt: 07, immediate(offset): 0080}\n", outContent.toString());
  }

  @Test
  public void test553() {
    Main.main(new String[]{"338600bb"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 06, immediate(offset): 00bb}\n", outContent.toString());
  }

  @Test
  public void test554() {
    Main.main(new String[]{"3c1a00f2"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1a, immediate(offset): 00f2}\n", outContent.toString());
  }

  @Test
  public void test555() {
    Main.main(new String[]{"3c0c0063"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0c, immediate(offset): 0063}\n", outContent.toString());
  }

  @Test
  public void test556() {
    Main.main(new String[]{"03a3202a"});
    assertEquals("slt {opcode: 00, rs: 1d, rt: 03, rd: 04, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test557() {
    Main.main(new String[]{"8f37ffe2"});
    assertEquals("lw {opcode: 23, rs(base): 19, rt: 17, immediate(offset): ffe2}\n", outContent.toString());
  }

  @Test
  public void test558() {
    Main.main(new String[]{"0800003c"});
    assertEquals("j {opcode: 02, index: 000003c}\n", outContent.toString());
  }

  @Test
  public void test559() {
    Main.main(new String[]{"102000dd"});
    assertEquals("beq {opcode: 04, rs(base): 01, rt: 00, immediate(offset): 00dd}\n", outContent.toString());
  }

  @Test
  public void test560() {
    Main.main(new String[]{"30b3ffcf"});
    assertEquals("andi {opcode: 0c, rs(base): 05, rt: 13, immediate(offset): ffcf}\n", outContent.toString());
  }

  @Test
  public void test561() {
    Main.main(new String[]{"03d68825"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 16, rd: 11, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test562() {
    Main.main(new String[]{"3c1100fb"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 00fb}\n", outContent.toString());
  }

  @Test
  public void test563() {
    Main.main(new String[]{"03317825"});
    assertEquals("or {opcode: 00, rs: 19, rt: 11, rd: 0f, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test564() {
    Main.main(new String[]{"080000a4"});
    assertEquals("j {opcode: 02, index: 00000a4}\n", outContent.toString());
  }

  @Test
  public void test565() {
    Main.main(new String[]{"08000044"});
    assertEquals("j {opcode: 02, index: 0000044}\n", outContent.toString());
  }

  @Test
  public void test566() {
    Main.main(new String[]{"080000e0"});
    assertEquals("j {opcode: 02, index: 00000e0}\n", outContent.toString());
  }

  @Test
  public void test567() {
    Main.main(new String[]{"3c03006e"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 03, immediate(offset): 006e}\n", outContent.toString());
  }

  @Test
  public void test568() {
    Main.main(new String[]{"25ef00ce"});
    assertEquals("addiu {opcode: 09, rs(base): 0f, rt: 0f, immediate(offset): 00ce}\n", outContent.toString());
  }

  @Test
  public void test569() {
    Main.main(new String[]{"3c1300ac"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 13, immediate(offset): 00ac}\n", outContent.toString());
  }

  @Test
  public void test570() {
    Main.main(new String[]{"3c1100d3"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 00d3}\n", outContent.toString());
  }

  @Test
  public void test571() {
    Main.main(new String[]{"16dfff2c"});
    assertEquals("bne {opcode: 05, rs(base): 16, rt: 1f, immediate(offset): ff2c}\n", outContent.toString());
  }

  @Test
  public void test572() {
    Main.main(new String[]{"018ec02a"});
    assertEquals("slt {opcode: 00, rs: 0c, rt: 0e, rd: 18, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test573() {
    Main.main(new String[]{"142600b1"});
    assertEquals("bne {opcode: 05, rs(base): 01, rt: 06, immediate(offset): 00b1}\n", outContent.toString());
  }

  @Test
  public void test574() {
    Main.main(new String[]{"133a0076"});
    assertEquals("beq {opcode: 04, rs(base): 19, rt: 1a, immediate(offset): 0076}\n", outContent.toString());
  }

  @Test
  public void test575() {
    Main.main(new String[]{"ae0f0000"});
    assertEquals("sw {opcode: 2b, rs(base): 10, rt: 0f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test576() {
    Main.main(new String[]{"371d00ca"});
    assertEquals("ori {opcode: 0d, rs(base): 18, rt: 1d, immediate(offset): 00ca}\n", outContent.toString());
  }

  @Test
  public void test577() {
    Main.main(new String[]{"02f57020"});
    assertEquals("add {opcode: 00, rs: 17, rt: 15, rd: 0e, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test578() {
    Main.main(new String[]{"02e8a02a"});
    assertEquals("slt {opcode: 00, rs: 17, rt: 08, rd: 14, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test579() {
    Main.main(new String[]{"0095d020"});
    assertEquals("add {opcode: 00, rs: 04, rt: 15, rd: 1a, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test580() {
    Main.main(new String[]{"10c90082"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 09, immediate(offset): 0082}\n", outContent.toString());
  }

  @Test
  public void test581() {
    Main.main(new String[]{"0257f02a"});
    assertEquals("slt {opcode: 00, rs: 12, rt: 17, rd: 1e, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test582() {
    Main.main(new String[]{"00a1a024"});
    assertEquals("and {opcode: 00, rs: 05, rt: 01, rd: 14, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test583() {
    Main.main(new String[]{"02db502a"});
    assertEquals("slt {opcode: 00, rs: 16, rt: 1b, rd: 0a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test584() {
    Main.main(new String[]{"080000a6"});
    assertEquals("j {opcode: 02, index: 00000a6}\n", outContent.toString());
  }

  @Test
  public void test585() {
    Main.main(new String[]{"00489022"});
    assertEquals("sub {opcode: 00, rs: 02, rt: 08, rd: 12, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test586() {
    Main.main(new String[]{"31e5ff68"});
    assertEquals("andi {opcode: 0c, rs(base): 0f, rt: 05, immediate(offset): ff68}\n", outContent.toString());
  }

  @Test
  public void test587() {
    Main.main(new String[]{"146b00b0"});
    assertEquals("bne {opcode: 05, rs(base): 03, rt: 0b, immediate(offset): 00b0}\n", outContent.toString());
  }

  @Test
  public void test588() {
    Main.main(new String[]{"34d2009b"});
    assertEquals("ori {opcode: 0d, rs(base): 06, rt: 12, immediate(offset): 009b}\n", outContent.toString());
  }

  @Test
  public void test589() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test590() {
    Main.main(new String[]{"176600cf"});
    assertEquals("bne {opcode: 05, rs(base): 1b, rt: 06, immediate(offset): 00cf}\n", outContent.toString());
  }

  @Test
  public void test591() {
    Main.main(new String[]{"01691024"});
    assertEquals("and {opcode: 00, rs: 0b, rt: 09, rd: 02, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test592() {
    Main.main(new String[]{"0145f822"});
    assertEquals("sub {opcode: 00, rs: 0a, rt: 05, rd: 1f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test593() {
    Main.main(new String[]{"16ce0033"});
    assertEquals("bne {opcode: 05, rs(base): 16, rt: 0e, immediate(offset): 0033}\n", outContent.toString());
  }

  @Test
  public void test594() {
    Main.main(new String[]{"8d970000"});
    assertEquals("lw {opcode: 23, rs(base): 0c, rt: 17, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test595() {
    Main.main(new String[]{"25020088"});
    assertEquals("addiu {opcode: 09, rs(base): 08, rt: 02, immediate(offset): 0088}\n", outContent.toString());
  }

  @Test
  public void test596() {
    Main.main(new String[]{"00959025"});
    assertEquals("or {opcode: 00, rs: 04, rt: 15, rd: 12, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test597() {
    Main.main(new String[]{"1340ff0a"});
    assertEquals("beq {opcode: 04, rs(base): 1a, rt: 00, immediate(offset): ff0a}\n", outContent.toString());
  }

  @Test
  public void test598() {
    Main.main(new String[]{"accb0000"});
    assertEquals("sw {opcode: 2b, rs(base): 06, rt: 0b, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test599() {
    Main.main(new String[]{"00168020"});
    assertEquals("add {opcode: 00, rs: 00, rt: 16, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test600() {
    Main.main(new String[]{"8df60000"});
    assertEquals("lw {opcode: 23, rs(base): 0f, rt: 16, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test601() {
    Main.main(new String[]{"35fd0007"});
    assertEquals("ori {opcode: 0d, rs(base): 0f, rt: 1d, immediate(offset): 0007}\n", outContent.toString());
  }

  @Test
  public void test602() {
    Main.main(new String[]{"24520058"});
    assertEquals("addiu {opcode: 09, rs(base): 02, rt: 12, immediate(offset): 0058}\n", outContent.toString());
  }

  @Test
  public void test603() {
    Main.main(new String[]{"169200eb"});
    assertEquals("bne {opcode: 05, rs(base): 14, rt: 12, immediate(offset): 00eb}\n", outContent.toString());
  }

  @Test
  public void test604() {
    Main.main(new String[]{"ae5efffd"});
    assertEquals("sw {opcode: 2b, rs(base): 12, rt: 1e, immediate(offset): fffd}\n", outContent.toString());
  }

  @Test
  public void test605() {
    Main.main(new String[]{"24a50082"});
    assertEquals("addiu {opcode: 09, rs(base): 05, rt: 05, immediate(offset): 0082}\n", outContent.toString());
  }

  @Test
  public void test606() {
    Main.main(new String[]{"004f0024"});
    assertEquals("and {opcode: 00, rs: 02, rt: 0f, rd: 00, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test607() {
    Main.main(new String[]{"379c0049"});
    assertEquals("ori {opcode: 0d, rs(base): 1c, rt: 1c, immediate(offset): 0049}\n", outContent.toString());
  }

  @Test
  public void test608() {
    Main.main(new String[]{"1681003d"});
    assertEquals("bne {opcode: 05, rs(base): 14, rt: 01, immediate(offset): 003d}\n", outContent.toString());
  }

  @Test
  public void test609() {
    Main.main(new String[]{"aeb20000"});
    assertEquals("sw {opcode: 2b, rs(base): 15, rt: 12, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test610() {
    Main.main(new String[]{"318e00ce"});
    assertEquals("andi {opcode: 0c, rs(base): 0c, rt: 0e, immediate(offset): 00ce}\n", outContent.toString());
  }

  @Test
  public void test611() {
    Main.main(new String[]{"14dcfff1"});
    assertEquals("bne {opcode: 05, rs(base): 06, rt: 1c, immediate(offset): fff1}\n", outContent.toString());
  }

  @Test
  public void test612() {
    Main.main(new String[]{"ad9d0000"});
    assertEquals("sw {opcode: 2b, rs(base): 0c, rt: 1d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test613() {
    Main.main(new String[]{"10d7ffcb"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 17, immediate(offset): ffcb}\n", outContent.toString());
  }

  @Test
  public void test614() {
    Main.main(new String[]{"37a90043"});
    assertEquals("ori {opcode: 0d, rs(base): 1d, rt: 09, immediate(offset): 0043}\n", outContent.toString());
  }

  @Test
  public void test615() {
    Main.main(new String[]{"8e68ff83"});
    assertEquals("lw {opcode: 23, rs(base): 13, rt: 08, immediate(offset): ff83}\n", outContent.toString());
  }

  @Test
  public void test616() {
    Main.main(new String[]{"3c040098"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 04, immediate(offset): 0098}\n", outContent.toString());
  }

  @Test
  public void test617() {
    Main.main(new String[]{"8e9000b7"});
    assertEquals("lw {opcode: 23, rs(base): 14, rt: 10, immediate(offset): 00b7}\n", outContent.toString());
  }

  @Test
  public void test618() {
    Main.main(new String[]{"01619025"});
    assertEquals("or {opcode: 00, rs: 0b, rt: 01, rd: 12, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test619() {
    Main.main(new String[]{"24c50039"});
    assertEquals("addiu {opcode: 09, rs(base): 06, rt: 05, immediate(offset): 0039}\n", outContent.toString());
  }

  @Test
  public void test620() {
    Main.main(new String[]{"8f8d00fe"});
    assertEquals("lw {opcode: 23, rs(base): 1c, rt: 0d, immediate(offset): 00fe}\n", outContent.toString());
  }

  @Test
  public void test621() {
    Main.main(new String[]{"33adffe1"});
    assertEquals("andi {opcode: 0c, rs(base): 1d, rt: 0d, immediate(offset): ffe1}\n", outContent.toString());
  }

  @Test
  public void test622() {
    Main.main(new String[]{"1106ffb2"});
    assertEquals("beq {opcode: 04, rs(base): 08, rt: 06, immediate(offset): ffb2}\n", outContent.toString());
  }

  @Test
  public void test623() {
    Main.main(new String[]{"038be022"});
    assertEquals("sub {opcode: 00, rs: 1c, rt: 0b, rd: 1c, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test624() {
    Main.main(new String[]{"34df004c"});
    assertEquals("ori {opcode: 0d, rs(base): 06, rt: 1f, immediate(offset): 004c}\n", outContent.toString());
  }

  @Test
  public void test625() {
    Main.main(new String[]{"03b33022"});
    assertEquals("sub {opcode: 00, rs: 1d, rt: 13, rd: 06, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test626() {
    Main.main(new String[]{"8d2e0000"});
    assertEquals("lw {opcode: 23, rs(base): 09, rt: 0e, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test627() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test628() {
    Main.main(new String[]{"11090041"});
    assertEquals("beq {opcode: 04, rs(base): 08, rt: 09, immediate(offset): 0041}\n", outContent.toString());
  }

  @Test
  public void test629() {
    Main.main(new String[]{"01664020"});
    assertEquals("add {opcode: 00, rs: 0b, rt: 06, rd: 08, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test630() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test631() {
    Main.main(new String[]{"37e4004b"});
    assertEquals("ori {opcode: 0d, rs(base): 1f, rt: 04, immediate(offset): 004b}\n", outContent.toString());
  }

  @Test
  public void test632() {
    Main.main(new String[]{"acaffffd"});
    assertEquals("sw {opcode: 2b, rs(base): 05, rt: 0f, immediate(offset): fffd}\n", outContent.toString());
  }

  @Test
  public void test633() {
    Main.main(new String[]{"03b9e022"});
    assertEquals("sub {opcode: 00, rs: 1d, rt: 19, rd: 1c, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test634() {
    Main.main(new String[]{"01b60824"});
    assertEquals("and {opcode: 00, rs: 0d, rt: 16, rd: 01, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test635() {
    Main.main(new String[]{"8d720000"});
    assertEquals("lw {opcode: 23, rs(base): 0b, rt: 12, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test636() {
    Main.main(new String[]{"03030822"});
    assertEquals("sub {opcode: 00, rs: 18, rt: 03, rd: 01, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test637() {
    Main.main(new String[]{"afd30001"});
    assertEquals("sw {opcode: 2b, rs(base): 1e, rt: 13, immediate(offset): 0001}\n", outContent.toString());
  }

  @Test
  public void test638() {
    Main.main(new String[]{"8ec30000"});
    assertEquals("lw {opcode: 23, rs(base): 16, rt: 03, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test639() {
    Main.main(new String[]{"3c10009f"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 10, immediate(offset): 009f}\n", outContent.toString());
  }

  @Test
  public void test640() {
    Main.main(new String[]{"333c00a1"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 1c, immediate(offset): 00a1}\n", outContent.toString());
  }

  @Test
  public void test641() {
    Main.main(new String[]{"3c1c0056"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1c, immediate(offset): 0056}\n", outContent.toString());
  }

  @Test
  public void test642() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test643() {
    Main.main(new String[]{"178b0041"});
    assertEquals("bne {opcode: 05, rs(base): 1c, rt: 0b, immediate(offset): 0041}\n", outContent.toString());
  }

  @Test
  public void test644() {
    Main.main(new String[]{"ae200000"});
    assertEquals("sw {opcode: 2b, rs(base): 11, rt: 00, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test645() {
    Main.main(new String[]{"11ae0098"});
    assertEquals("beq {opcode: 04, rs(base): 0d, rt: 0e, immediate(offset): 0098}\n", outContent.toString());
  }

  @Test
  public void test646() {
    Main.main(new String[]{"02e3182a"});
    assertEquals("slt {opcode: 00, rs: 17, rt: 03, rd: 03, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test647() {
    Main.main(new String[]{"10e6008e"});
    assertEquals("beq {opcode: 04, rs(base): 07, rt: 06, immediate(offset): 008e}\n", outContent.toString());
  }

  @Test
  public void test648() {
    Main.main(new String[]{"13c2ff8d"});
    assertEquals("beq {opcode: 04, rs(base): 1e, rt: 02, immediate(offset): ff8d}\n", outContent.toString());
  }

  @Test
  public void test649() {
    Main.main(new String[]{"11550052"});
    assertEquals("beq {opcode: 04, rs(base): 0a, rt: 15, immediate(offset): 0052}\n", outContent.toString());
  }

  @Test
  public void test650() {
    Main.main(new String[]{"af87ff21"});
    assertEquals("sw {opcode: 2b, rs(base): 1c, rt: 07, immediate(offset): ff21}\n", outContent.toString());
  }

  @Test
  public void test651() {
    Main.main(new String[]{"01695024"});
    assertEquals("and {opcode: 00, rs: 0b, rt: 09, rd: 0a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test652() {
    Main.main(new String[]{"8dac0000"});
    assertEquals("lw {opcode: 23, rs(base): 0d, rt: 0c, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test653() {
    Main.main(new String[]{"012d1025"});
    assertEquals("or {opcode: 00, rs: 09, rt: 0d, rd: 02, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test654() {
    Main.main(new String[]{"3569ff01"});
    assertEquals("ori {opcode: 0d, rs(base): 0b, rt: 09, immediate(offset): ff01}\n", outContent.toString());
  }

  @Test
  public void test655() {
    Main.main(new String[]{"08000006"});
    assertEquals("j {opcode: 02, index: 0000006}\n", outContent.toString());
  }

  @Test
  public void test656() {
    Main.main(new String[]{"34e5ff9b"});
    assertEquals("ori {opcode: 0d, rs(base): 07, rt: 05, immediate(offset): ff9b}\n", outContent.toString());
  }

  @Test
  public void test657() {
    Main.main(new String[]{"0800004c"});
    assertEquals("j {opcode: 02, index: 000004c}\n", outContent.toString());
  }

  @Test
  public void test658() {
    Main.main(new String[]{"142600e8"});
    assertEquals("bne {opcode: 05, rs(base): 01, rt: 06, immediate(offset): 00e8}\n", outContent.toString());
  }

  @Test
  public void test659() {
    Main.main(new String[]{"1400ff55"});
    assertEquals("bne {opcode: 05, rs(base): 00, rt: 00, immediate(offset): ff55}\n", outContent.toString());
  }

  @Test
  public void test660() {
    Main.main(new String[]{"01cee024"});
    assertEquals("and {opcode: 00, rs: 0e, rt: 0e, rd: 1c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test661() {
    Main.main(new String[]{"3235ffb9"});
    assertEquals("andi {opcode: 0c, rs(base): 11, rt: 15, immediate(offset): ffb9}\n", outContent.toString());
  }

  @Test
  public void test662() {
    Main.main(new String[]{"1208005e"});
    assertEquals("beq {opcode: 04, rs(base): 10, rt: 08, immediate(offset): 005e}\n", outContent.toString());
  }

  @Test
  public void test663() {
    Main.main(new String[]{"10770042"});
    assertEquals("beq {opcode: 04, rs(base): 03, rt: 17, immediate(offset): 0042}\n", outContent.toString());
  }

  @Test
  public void test664() {
    Main.main(new String[]{"aca2ffee"});
    assertEquals("sw {opcode: 2b, rs(base): 05, rt: 02, immediate(offset): ffee}\n", outContent.toString());
  }

  @Test
  public void test665() {
    Main.main(new String[]{"3090ff4d"});
    assertEquals("andi {opcode: 0c, rs(base): 04, rt: 10, immediate(offset): ff4d}\n", outContent.toString());
  }

  @Test
  public void test666() {
    Main.main(new String[]{"00724824"});
    assertEquals("and {opcode: 00, rs: 03, rt: 12, rd: 09, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test667() {
    Main.main(new String[]{"3554ffa2"});
    assertEquals("ori {opcode: 0d, rs(base): 0a, rt: 14, immediate(offset): ffa2}\n", outContent.toString());
  }

  @Test
  public void test668() {
    Main.main(new String[]{"3c020062"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 02, immediate(offset): 0062}\n", outContent.toString());
  }

  @Test
  public void test669() {
    Main.main(new String[]{"13590092"});
    assertEquals("beq {opcode: 04, rs(base): 1a, rt: 19, immediate(offset): 0092}\n", outContent.toString());
  }

  @Test
  public void test670() {
    Main.main(new String[]{"114800fa"});
    assertEquals("beq {opcode: 04, rs(base): 0a, rt: 08, immediate(offset): 00fa}\n", outContent.toString());
  }

  @Test
  public void test671() {
    Main.main(new String[]{"0344202a"});
    assertEquals("slt {opcode: 00, rs: 1a, rt: 04, rd: 04, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test672() {
    Main.main(new String[]{"02b2682a"});
    assertEquals("slt {opcode: 00, rs: 15, rt: 12, rd: 0d, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test673() {
    Main.main(new String[]{"27e3007f"});
    assertEquals("addiu {opcode: 09, rs(base): 1f, rt: 03, immediate(offset): 007f}\n", outContent.toString());
  }

  @Test
  public void test674() {
    Main.main(new String[]{"00958025"});
    assertEquals("or {opcode: 00, rs: 04, rt: 15, rd: 10, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test675() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test676() {
    Main.main(new String[]{"0357702a"});
    assertEquals("slt {opcode: 00, rs: 1a, rt: 17, rd: 0e, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test677() {
    Main.main(new String[]{"0207b02a"});
    assertEquals("slt {opcode: 00, rs: 10, rt: 07, rd: 16, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test678() {
    Main.main(new String[]{"02664822"});
    assertEquals("sub {opcode: 00, rs: 13, rt: 06, rd: 09, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test679() {
    Main.main(new String[]{"37aa0004"});
    assertEquals("ori {opcode: 0d, rs(base): 1d, rt: 0a, immediate(offset): 0004}\n", outContent.toString());
  }

  @Test
  public void test680() {
    Main.main(new String[]{"0336f025"});
    assertEquals("or {opcode: 00, rs: 19, rt: 16, rd: 1e, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test681() {
    Main.main(new String[]{"144cff60"});
    assertEquals("bne {opcode: 05, rs(base): 02, rt: 0c, immediate(offset): ff60}\n", outContent.toString());
  }

  @Test
  public void test682() {
    Main.main(new String[]{"14bb0004"});
    assertEquals("bne {opcode: 05, rs(base): 05, rt: 1b, immediate(offset): 0004}\n", outContent.toString());
  }

  @Test
  public void test683() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test684() {
    Main.main(new String[]{"136c00b6"});
    assertEquals("beq {opcode: 04, rs(base): 1b, rt: 0c, immediate(offset): 00b6}\n", outContent.toString());
  }

  @Test
  public void test685() {
    Main.main(new String[]{"27cd0035"});
    assertEquals("addiu {opcode: 09, rs(base): 1e, rt: 0d, immediate(offset): 0035}\n", outContent.toString());
  }

  @Test
  public void test686() {
    Main.main(new String[]{"ac7d0000"});
    assertEquals("sw {opcode: 2b, rs(base): 03, rt: 1d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test687() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test688() {
    Main.main(new String[]{"3c0f0058"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0f, immediate(offset): 0058}\n", outContent.toString());
  }

  @Test
  public void test689() {
    Main.main(new String[]{"acd00000"});
    assertEquals("sw {opcode: 2b, rs(base): 06, rt: 10, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test690() {
    Main.main(new String[]{"af600077"});
    assertEquals("sw {opcode: 2b, rs(base): 1b, rt: 00, immediate(offset): 0077}\n", outContent.toString());
  }

  @Test
  public void test691() {
    Main.main(new String[]{"3c0900ec"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 09, immediate(offset): 00ec}\n", outContent.toString());
  }

  @Test
  public void test692() {
    Main.main(new String[]{"01ad582a"});
    assertEquals("slt {opcode: 00, rs: 0d, rt: 0d, rd: 0b, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test693() {
    Main.main(new String[]{"080000e1"});
    assertEquals("j {opcode: 02, index: 00000e1}\n", outContent.toString());
  }

  @Test
  public void test694() {
    Main.main(new String[]{"8c2e003f"});
    assertEquals("lw {opcode: 23, rs(base): 01, rt: 0e, immediate(offset): 003f}\n", outContent.toString());
  }

  @Test
  public void test695() {
    Main.main(new String[]{"10f700e3"});
    assertEquals("beq {opcode: 04, rs(base): 07, rt: 17, immediate(offset): 00e3}\n", outContent.toString());
  }

  @Test
  public void test696() {
    Main.main(new String[]{"03f51025"});
    assertEquals("or {opcode: 00, rs: 1f, rt: 15, rd: 02, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test697() {
    Main.main(new String[]{"317900af"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 19, immediate(offset): 00af}\n", outContent.toString());
  }

  @Test
  public void test698() {
    Main.main(new String[]{"26fd007c"});
    assertEquals("addiu {opcode: 09, rs(base): 17, rt: 1d, immediate(offset): 007c}\n", outContent.toString());
  }

  @Test
  public void test699() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test700() {
    Main.main(new String[]{"8fe7ffb6"});
    assertEquals("lw {opcode: 23, rs(base): 1f, rt: 07, immediate(offset): ffb6}\n", outContent.toString());
  }

  @Test
  public void test701() {
    Main.main(new String[]{"02cf5025"});
    assertEquals("or {opcode: 00, rs: 16, rt: 0f, rd: 0a, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test702() {
    Main.main(new String[]{"080000e2"});
    assertEquals("j {opcode: 02, index: 00000e2}\n", outContent.toString());
  }

  @Test
  public void test703() {
    Main.main(new String[]{"3c040030"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 04, immediate(offset): 0030}\n", outContent.toString());
  }

  @Test
  public void test704() {
    Main.main(new String[]{"3005002c"});
    assertEquals("andi {opcode: 0c, rs(base): 00, rt: 05, immediate(offset): 002c}\n", outContent.toString());
  }

  @Test
  public void test705() {
    Main.main(new String[]{"03e99820"});
    assertEquals("add {opcode: 00, rs: 1f, rt: 09, rd: 13, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test706() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test707() {
    Main.main(new String[]{"3703ff45"});
    assertEquals("ori {opcode: 0d, rs(base): 18, rt: 03, immediate(offset): ff45}\n", outContent.toString());
  }

  @Test
  public void test708() {
    Main.main(new String[]{"2776008f"});
    assertEquals("addiu {opcode: 09, rs(base): 1b, rt: 16, immediate(offset): 008f}\n", outContent.toString());
  }

  @Test
  public void test709() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test710() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test711() {
    Main.main(new String[]{"3173ffa8"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 13, immediate(offset): ffa8}\n", outContent.toString());
  }

  @Test
  public void test712() {
    Main.main(new String[]{"1422ff98"});
    assertEquals("bne {opcode: 05, rs(base): 01, rt: 02, immediate(offset): ff98}\n", outContent.toString());
  }

  @Test
  public void test713() {
    Main.main(new String[]{"3790ff41"});
    assertEquals("ori {opcode: 0d, rs(base): 1c, rt: 10, immediate(offset): ff41}\n", outContent.toString());
  }

  @Test
  public void test714() {
    Main.main(new String[]{"080000e9"});
    assertEquals("j {opcode: 02, index: 00000e9}\n", outContent.toString());
  }

  @Test
  public void test715() {
    Main.main(new String[]{"373bff4c"});
    assertEquals("ori {opcode: 0d, rs(base): 19, rt: 1b, immediate(offset): ff4c}\n", outContent.toString());
  }

  @Test
  public void test716() {
    Main.main(new String[]{"01f8e020"});
    assertEquals("add {opcode: 00, rs: 0f, rt: 18, rd: 1c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test717() {
    Main.main(new String[]{"025a9022"});
    assertEquals("sub {opcode: 00, rs: 12, rt: 1a, rd: 12, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test718() {
    Main.main(new String[]{"260f00ae"});
    assertEquals("addiu {opcode: 09, rs(base): 10, rt: 0f, immediate(offset): 00ae}\n", outContent.toString());
  }

  @Test
  public void test719() {
    Main.main(new String[]{"0210902a"});
    assertEquals("slt {opcode: 00, rs: 10, rt: 10, rd: 12, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test720() {
    Main.main(new String[]{"02c99824"});
    assertEquals("and {opcode: 00, rs: 16, rt: 09, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test721() {
    Main.main(new String[]{"02331822"});
    assertEquals("sub {opcode: 00, rs: 11, rt: 13, rd: 03, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test722() {
    Main.main(new String[]{"10500049"});
    assertEquals("beq {opcode: 04, rs(base): 02, rt: 10, immediate(offset): 0049}\n", outContent.toString());
  }

  @Test
  public void test723() {
    Main.main(new String[]{"aead0000"});
    assertEquals("sw {opcode: 2b, rs(base): 15, rt: 0d, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test724() {
    Main.main(new String[]{"02315822"});
    assertEquals("sub {opcode: 00, rs: 11, rt: 11, rd: 0b, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test725() {
    Main.main(new String[]{"039b1822"});
    assertEquals("sub {opcode: 00, rs: 1c, rt: 1b, rd: 03, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test726() {
    Main.main(new String[]{"11ca00bb"});
    assertEquals("beq {opcode: 04, rs(base): 0e, rt: 0a, immediate(offset): 00bb}\n", outContent.toString());
  }

  @Test
  public void test727() {
    Main.main(new String[]{"03f9d022"});
    assertEquals("sub {opcode: 00, rs: 1f, rt: 19, rd: 1a, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test728() {
    Main.main(new String[]{"02bad022"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 1a, rd: 1a, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test729() {
    Main.main(new String[]{"3473ff4f"});
    assertEquals("ori {opcode: 0d, rs(base): 03, rt: 13, immediate(offset): ff4f}\n", outContent.toString());
  }

  @Test
  public void test730() {
    Main.main(new String[]{"1051ffbb"});
    assertEquals("beq {opcode: 04, rs(base): 02, rt: 11, immediate(offset): ffbb}\n", outContent.toString());
  }

  @Test
  public void test731() {
    Main.main(new String[]{"02034822"});
    assertEquals("sub {opcode: 00, rs: 10, rt: 03, rd: 09, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test732() {
    Main.main(new String[]{"1480006c"});
    assertEquals("bne {opcode: 05, rs(base): 04, rt: 00, immediate(offset): 006c}\n", outContent.toString());
  }

  @Test
  public void test733() {
    Main.main(new String[]{"039fd024"});
    assertEquals("and {opcode: 00, rs: 1c, rt: 1f, rd: 1a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test734() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test735() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test736() {
    Main.main(new String[]{"3c0b007a"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0b, immediate(offset): 007a}\n", outContent.toString());
  }

  @Test
  public void test737() {
    Main.main(new String[]{"3c1a004e"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1a, immediate(offset): 004e}\n", outContent.toString());
  }

  @Test
  public void test738() {
    Main.main(new String[]{"00463820"});
    assertEquals("add {opcode: 00, rs: 02, rt: 06, rd: 07, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test739() {
    Main.main(new String[]{"134dff98"});
    assertEquals("beq {opcode: 04, rs(base): 1a, rt: 0d, immediate(offset): ff98}\n", outContent.toString());
  }

  @Test
  public void test740() {
    Main.main(new String[]{"037c482a"});
    assertEquals("slt {opcode: 00, rs: 1b, rt: 1c, rd: 09, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test741() {
    Main.main(new String[]{"378dff77"});
    assertEquals("ori {opcode: 0d, rs(base): 1c, rt: 0d, immediate(offset): ff77}\n", outContent.toString());
  }

  @Test
  public void test742() {
    Main.main(new String[]{"37aa00a6"});
    assertEquals("ori {opcode: 0d, rs(base): 1d, rt: 0a, immediate(offset): 00a6}\n", outContent.toString());
  }

  @Test
  public void test743() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test744() {
    Main.main(new String[]{"14f2fffd"});
    assertEquals("bne {opcode: 05, rs(base): 07, rt: 12, immediate(offset): fffd}\n", outContent.toString());
  }

  @Test
  public void test745() {
    Main.main(new String[]{"3285ffc4"});
    assertEquals("andi {opcode: 0c, rs(base): 14, rt: 05, immediate(offset): ffc4}\n", outContent.toString());
  }

  @Test
  public void test746() {
    Main.main(new String[]{"01372020"});
    assertEquals("add {opcode: 00, rs: 09, rt: 17, rd: 04, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test747() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test748() {
    Main.main(new String[]{"8d9a0000"});
    assertEquals("lw {opcode: 23, rs(base): 0c, rt: 1a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test749() {
    Main.main(new String[]{"03e8c020"});
    assertEquals("add {opcode: 00, rs: 1f, rt: 08, rd: 18, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test750() {
    Main.main(new String[]{"01c21820"});
    assertEquals("add {opcode: 00, rs: 0e, rt: 02, rd: 03, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test751() {
    Main.main(new String[]{"00e3e025"});
    assertEquals("or {opcode: 00, rs: 07, rt: 03, rd: 1c, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test752() {
    Main.main(new String[]{"aefc0052"});
    assertEquals("sw {opcode: 2b, rs(base): 17, rt: 1c, immediate(offset): 0052}\n", outContent.toString());
  }

  @Test
  public void test753() {
    Main.main(new String[]{"325f001c"});
    assertEquals("andi {opcode: 0c, rs(base): 12, rt: 1f, immediate(offset): 001c}\n", outContent.toString());
  }

  @Test
  public void test754() {
    Main.main(new String[]{"0251f824"});
    assertEquals("and {opcode: 00, rs: 12, rt: 11, rd: 1f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test755() {
    Main.main(new String[]{"34eb0003"});
    assertEquals("ori {opcode: 0d, rs(base): 07, rt: 0b, immediate(offset): 0003}\n", outContent.toString());
  }

  @Test
  public void test756() {
    Main.main(new String[]{"11c5ff06"});
    assertEquals("beq {opcode: 04, rs(base): 0e, rt: 05, immediate(offset): ff06}\n", outContent.toString());
  }

  @Test
  public void test757() {
    Main.main(new String[]{"10caffbd"});
    assertEquals("beq {opcode: 04, rs(base): 06, rt: 0a, immediate(offset): ffbd}\n", outContent.toString());
  }

  @Test
  public void test758() {
    Main.main(new String[]{"301a0081"});
    assertEquals("andi {opcode: 0c, rs(base): 00, rt: 1a, immediate(offset): 0081}\n", outContent.toString());
  }

  @Test
  public void test759() {
    Main.main(new String[]{"02e1982a"});
    assertEquals("slt {opcode: 00, rs: 17, rt: 01, rd: 13, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test760() {
    Main.main(new String[]{"01549020"});
    assertEquals("add {opcode: 00, rs: 0a, rt: 14, rd: 12, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test761() {
    Main.main(new String[]{"02188822"});
    assertEquals("sub {opcode: 00, rs: 10, rt: 18, rd: 11, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test762() {
    Main.main(new String[]{"ad5dff47"});
    assertEquals("sw {opcode: 2b, rs(base): 0a, rt: 1d, immediate(offset): ff47}\n", outContent.toString());
  }

  @Test
  public void test763() {
    Main.main(new String[]{"319aff74"});
    assertEquals("andi {opcode: 0c, rs(base): 0c, rt: 1a, immediate(offset): ff74}\n", outContent.toString());
  }

  @Test
  public void test764() {
    Main.main(new String[]{"3614ff08"});
    assertEquals("ori {opcode: 0d, rs(base): 10, rt: 14, immediate(offset): ff08}\n", outContent.toString());
  }

  @Test
  public void test765() {
    Main.main(new String[]{"8c460000"});
    assertEquals("lw {opcode: 23, rs(base): 02, rt: 06, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test766() {
    Main.main(new String[]{"018a3024"});
    assertEquals("and {opcode: 00, rs: 0c, rt: 0a, rd: 06, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test767() {
    Main.main(new String[]{"35730084"});
    assertEquals("ori {opcode: 0d, rs(base): 0b, rt: 13, immediate(offset): 0084}\n", outContent.toString());
  }

  @Test
  public void test768() {
    Main.main(new String[]{"af47ffa0"});
    assertEquals("sw {opcode: 2b, rs(base): 1a, rt: 07, immediate(offset): ffa0}\n", outContent.toString());
  }

  @Test
  public void test769() {
    Main.main(new String[]{"0086d822"});
    assertEquals("sub {opcode: 00, rs: 04, rt: 06, rd: 1b, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test770() {
    Main.main(new String[]{"26350035"});
    assertEquals("addiu {opcode: 09, rs(base): 11, rt: 15, immediate(offset): 0035}\n", outContent.toString());
  }

  @Test
  public void test771() {
    Main.main(new String[]{"ad590000"});
    assertEquals("sw {opcode: 2b, rs(base): 0a, rt: 19, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test772() {
    Main.main(new String[]{"333000d3"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 10, immediate(offset): 00d3}\n", outContent.toString());
  }

  @Test
  public void test773() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test774() {
    Main.main(new String[]{"32c5ffcc"});
    assertEquals("andi {opcode: 0c, rs(base): 16, rt: 05, immediate(offset): ffcc}\n", outContent.toString());
  }

  @Test
  public void test775() {
    Main.main(new String[]{"01c25024"});
    assertEquals("and {opcode: 00, rs: 0e, rt: 02, rd: 0a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test776() {
    Main.main(new String[]{"31770000"});
    assertEquals("andi {opcode: 0c, rs(base): 0b, rt: 17, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test777() {
    Main.main(new String[]{"af510000"});
    assertEquals("sw {opcode: 2b, rs(base): 1a, rt: 11, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test778() {
    Main.main(new String[]{"ac710000"});
    assertEquals("sw {opcode: 2b, rs(base): 03, rt: 11, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test779() {
    Main.main(new String[]{"3326006c"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 06, immediate(offset): 006c}\n", outContent.toString());
  }

  @Test
  public void test780() {
    Main.main(new String[]{"8c200000"});
    assertEquals("lw {opcode: 23, rs(base): 01, rt: 00, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test781() {
    Main.main(new String[]{"264d0007"});
    assertEquals("addiu {opcode: 09, rs(base): 12, rt: 0d, immediate(offset): 0007}\n", outContent.toString());
  }

  @Test
  public void test782() {
    Main.main(new String[]{"af150097"});
    assertEquals("sw {opcode: 2b, rs(base): 18, rt: 15, immediate(offset): 0097}\n", outContent.toString());
  }

  @Test
  public void test783() {
    Main.main(new String[]{"03145825"});
    assertEquals("or {opcode: 00, rs: 18, rt: 14, rd: 0b, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test784() {
    Main.main(new String[]{"32acffab"});
    assertEquals("andi {opcode: 0c, rs(base): 15, rt: 0c, immediate(offset): ffab}\n", outContent.toString());
  }

  @Test
  public void test785() {
    Main.main(new String[]{"37c70053"});
    assertEquals("ori {opcode: 0d, rs(base): 1e, rt: 07, immediate(offset): 0053}\n", outContent.toString());
  }

  @Test
  public void test786() {
    Main.main(new String[]{"261e0066"});
    assertEquals("addiu {opcode: 09, rs(base): 10, rt: 1e, immediate(offset): 0066}\n", outContent.toString());
  }

  @Test
  public void test787() {
    Main.main(new String[]{"000e382a"});
    assertEquals("slt {opcode: 00, rs: 00, rt: 0e, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test788() {
    Main.main(new String[]{"01e9e022"});
    assertEquals("sub {opcode: 00, rs: 0f, rt: 09, rd: 1c, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test789() {
    Main.main(new String[]{"ad580000"});
    assertEquals("sw {opcode: 2b, rs(base): 0a, rt: 18, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test790() {
    Main.main(new String[]{"080000af"});
    assertEquals("j {opcode: 02, index: 00000af}\n", outContent.toString());
  }

  @Test
  public void test791() {
    Main.main(new String[]{"03b25025"});
    assertEquals("or {opcode: 00, rs: 1d, rt: 12, rd: 0a, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test792() {
    Main.main(new String[]{"8e440062"});
    assertEquals("lw {opcode: 23, rs(base): 12, rt: 04, immediate(offset): 0062}\n", outContent.toString());
  }

  @Test
  public void test793() {
    Main.main(new String[]{"144effe4"});
    assertEquals("bne {opcode: 05, rs(base): 02, rt: 0e, immediate(offset): ffe4}\n", outContent.toString());
  }

  @Test
  public void test794() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test795() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test796() {
    Main.main(new String[]{"012f2022"});
    assertEquals("sub {opcode: 00, rs: 09, rt: 0f, rd: 04, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test797() {
    Main.main(new String[]{"03aa2024"});
    assertEquals("and {opcode: 00, rs: 1d, rt: 0a, rd: 04, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test798() {
    Main.main(new String[]{"02204820"});
    assertEquals("add {opcode: 00, rs: 11, rt: 00, rd: 09, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test799() {
    Main.main(new String[]{"080000fd"});
    assertEquals("j {opcode: 02, index: 00000fd}\n", outContent.toString());
  }

  @Test
  public void test800() {
    Main.main(new String[]{"01c91025"});
    assertEquals("or {opcode: 00, rs: 0e, rt: 09, rd: 02, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test801() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test802() {
    Main.main(new String[]{"24f1000b"});
    assertEquals("addiu {opcode: 09, rs(base): 07, rt: 11, immediate(offset): 000b}\n", outContent.toString());
  }

  @Test
  public void test803() {
    Main.main(new String[]{"02b3002a"});
    assertEquals("slt {opcode: 00, rs: 15, rt: 13, rd: 00, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test804() {
    Main.main(new String[]{"3745ffd0"});
    assertEquals("ori {opcode: 0d, rs(base): 1a, rt: 05, immediate(offset): ffd0}\n", outContent.toString());
  }

  @Test
  public void test805() {
    Main.main(new String[]{"03d98020"});
    assertEquals("add {opcode: 00, rs: 1e, rt: 19, rd: 10, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test806() {
    Main.main(new String[]{"3c1100fc"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 00fc}\n", outContent.toString());
  }

  @Test
  public void test807() {
    Main.main(new String[]{"0800004e"});
    assertEquals("j {opcode: 02, index: 000004e}\n", outContent.toString());
  }

  @Test
  public void test808() {
    Main.main(new String[]{"32e7ffcb"});
    assertEquals("andi {opcode: 0c, rs(base): 17, rt: 07, immediate(offset): ffcb}\n", outContent.toString());
  }

  @Test
  public void test809() {
    Main.main(new String[]{"01b80025"});
    assertEquals("or {opcode: 00, rs: 0d, rt: 18, rd: 00, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test810() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test811() {
    Main.main(new String[]{"2733002e"});
    assertEquals("addiu {opcode: 09, rs(base): 19, rt: 13, immediate(offset): 002e}\n", outContent.toString());
  }

  @Test
  public void test812() {
    Main.main(new String[]{"8f82ffd3"});
    assertEquals("lw {opcode: 23, rs(base): 1c, rt: 02, immediate(offset): ffd3}\n", outContent.toString());
  }

  @Test
  public void test813() {
    Main.main(new String[]{"01a02022"});
    assertEquals("sub {opcode: 00, rs: 0d, rt: 00, rd: 04, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test814() {
    Main.main(new String[]{"035b382a"});
    assertEquals("slt {opcode: 00, rs: 1a, rt: 1b, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test815() {
    Main.main(new String[]{"08000059"});
    assertEquals("j {opcode: 02, index: 0000059}\n", outContent.toString());
  }

  @Test
  public void test816() {
    Main.main(new String[]{"01d5c824"});
    assertEquals("and {opcode: 00, rs: 0e, rt: 15, rd: 19, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test817() {
    Main.main(new String[]{"8c00000f"});
    assertEquals("lw {opcode: 23, rs(base): 00, rt: 00, immediate(offset): 000f}\n", outContent.toString());
  }

  @Test
  public void test818() {
    Main.main(new String[]{"30c3009f"});
    assertEquals("andi {opcode: 0c, rs(base): 06, rt: 03, immediate(offset): 009f}\n", outContent.toString());
  }

  @Test
  public void test819() {
    Main.main(new String[]{"109800e2"});
    assertEquals("beq {opcode: 04, rs(base): 04, rt: 18, immediate(offset): 00e2}\n", outContent.toString());
  }

  @Test
  public void test820() {
    Main.main(new String[]{"24e200fc"});
    assertEquals("addiu {opcode: 09, rs(base): 07, rt: 02, immediate(offset): 00fc}\n", outContent.toString());
  }

  @Test
  public void test821() {
    Main.main(new String[]{"af990000"});
    assertEquals("sw {opcode: 2b, rs(base): 1c, rt: 19, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test822() {
    Main.main(new String[]{"0021a020"});
    assertEquals("add {opcode: 00, rs: 01, rt: 01, rd: 14, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test823() {
    Main.main(new String[]{"039f9824"});
    assertEquals("and {opcode: 00, rs: 1c, rt: 1f, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test824() {
    Main.main(new String[]{"080000c1"});
    assertEquals("j {opcode: 02, index: 00000c1}\n", outContent.toString());
  }

  @Test
  public void test825() {
    Main.main(new String[]{"adf60000"});
    assertEquals("sw {opcode: 2b, rs(base): 0f, rt: 16, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test826() {
    Main.main(new String[]{"02b6b82a"});
    assertEquals("slt {opcode: 00, rs: 15, rt: 16, rd: 17, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test827() {
    Main.main(new String[]{"246f00f6"});
    assertEquals("addiu {opcode: 09, rs(base): 03, rt: 0f, immediate(offset): 00f6}\n", outContent.toString());
  }

  @Test
  public void test828() {
    Main.main(new String[]{"8ea30000"});
    assertEquals("lw {opcode: 23, rs(base): 15, rt: 03, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test829() {
    Main.main(new String[]{"33940080"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 14, immediate(offset): 0080}\n", outContent.toString());
  }

  @Test
  public void test830() {
    Main.main(new String[]{"2449005e"});
    assertEquals("addiu {opcode: 09, rs(base): 02, rt: 09, immediate(offset): 005e}\n", outContent.toString());
  }

  @Test
  public void test831() {
    Main.main(new String[]{"034b6024"});
    assertEquals("and {opcode: 00, rs: 1a, rt: 0b, rd: 0c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test832() {
    Main.main(new String[]{"02f55822"});
    assertEquals("sub {opcode: 00, rs: 17, rt: 15, rd: 0b, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test833() {
    Main.main(new String[]{"001cf820"});
    assertEquals("add {opcode: 00, rs: 00, rt: 1c, rd: 1f, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test834() {
    Main.main(new String[]{"024a6024"});
    assertEquals("and {opcode: 00, rs: 12, rt: 0a, rd: 0c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test835() {
    Main.main(new String[]{"14d8ffa2"});
    assertEquals("bne {opcode: 05, rs(base): 06, rt: 18, immediate(offset): ffa2}\n", outContent.toString());
  }

  @Test
  public void test836() {
    Main.main(new String[]{"11b1ff05"});
    assertEquals("beq {opcode: 04, rs(base): 0d, rt: 11, immediate(offset): ff05}\n", outContent.toString());
  }

  @Test
  public void test837() {
    Main.main(new String[]{"34f70034"});
    assertEquals("ori {opcode: 0d, rs(base): 07, rt: 17, immediate(offset): 0034}\n", outContent.toString());
  }

  @Test
  public void test838() {
    Main.main(new String[]{"360c0042"});
    assertEquals("ori {opcode: 0d, rs(base): 10, rt: 0c, immediate(offset): 0042}\n", outContent.toString());
  }

  @Test
  public void test839() {
    Main.main(new String[]{"01c31022"});
    assertEquals("sub {opcode: 00, rs: 0e, rt: 03, rd: 02, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test840() {
    Main.main(new String[]{"31a9ffa9"});
    assertEquals("andi {opcode: 0c, rs(base): 0d, rt: 09, immediate(offset): ffa9}\n", outContent.toString());
  }

  @Test
  public void test841() {
    Main.main(new String[]{"151e0006"});
    assertEquals("bne {opcode: 05, rs(base): 08, rt: 1e, immediate(offset): 0006}\n", outContent.toString());
  }

  @Test
  public void test842() {
    Main.main(new String[]{"afc3ffeb"});
    assertEquals("sw {opcode: 2b, rs(base): 1e, rt: 03, immediate(offset): ffeb}\n", outContent.toString());
  }

  @Test
  public void test843() {
    Main.main(new String[]{"080000a4"});
    assertEquals("j {opcode: 02, index: 00000a4}\n", outContent.toString());
  }

  @Test
  public void test844() {
    Main.main(new String[]{"33310091"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 11, immediate(offset): 0091}\n", outContent.toString());
  }

  @Test
  public void test845() {
    Main.main(new String[]{"02c16824"});
    assertEquals("and {opcode: 00, rs: 16, rt: 01, rd: 0d, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test846() {
    Main.main(new String[]{"ac930000"});
    assertEquals("sw {opcode: 2b, rs(base): 04, rt: 13, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test847() {
    Main.main(new String[]{"01d3e825"});
    assertEquals("or {opcode: 00, rs: 0e, rt: 13, rd: 1d, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test848() {
    Main.main(new String[]{"080000b5"});
    assertEquals("j {opcode: 02, index: 00000b5}\n", outContent.toString());
  }

  @Test
  public void test849() {
    Main.main(new String[]{"8ffe003e"});
    assertEquals("lw {opcode: 23, rs(base): 1f, rt: 1e, immediate(offset): 003e}\n", outContent.toString());
  }

  @Test
  public void test850() {
    Main.main(new String[]{"3c09006b"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 09, immediate(offset): 006b}\n", outContent.toString());
  }

  @Test
  public void test851() {
    Main.main(new String[]{"15c1ffa2"});
    assertEquals("bne {opcode: 05, rs(base): 0e, rt: 01, immediate(offset): ffa2}\n", outContent.toString());
  }

  @Test
  public void test852() {
    Main.main(new String[]{"039d482a"});
    assertEquals("slt {opcode: 00, rs: 1c, rt: 1d, rd: 09, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test853() {
    Main.main(new String[]{"15dcff3a"});
    assertEquals("bne {opcode: 05, rs(base): 0e, rt: 1c, immediate(offset): ff3a}\n", outContent.toString());
  }

  @Test
  public void test854() {
    Main.main(new String[]{"0078b024"});
    assertEquals("and {opcode: 00, rs: 03, rt: 18, rd: 16, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test855() {
    Main.main(new String[]{"010a8820"});
    assertEquals("add {opcode: 00, rs: 08, rt: 0a, rd: 11, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test856() {
    Main.main(new String[]{"8f860000"});
    assertEquals("lw {opcode: 23, rs(base): 1c, rt: 06, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test857() {
    Main.main(new String[]{"0082582a"});
    assertEquals("slt {opcode: 00, rs: 04, rt: 02, rd: 0b, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test858() {
    Main.main(new String[]{"0800008a"});
    assertEquals("j {opcode: 02, index: 000008a}\n", outContent.toString());
  }

  @Test
  public void test859() {
    Main.main(new String[]{"3c05008a"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 05, immediate(offset): 008a}\n", outContent.toString());
  }

  @Test
  public void test860() {
    Main.main(new String[]{"adb4ffe0"});
    assertEquals("sw {opcode: 2b, rs(base): 0d, rt: 14, immediate(offset): ffe0}\n", outContent.toString());
  }

  @Test
  public void test861() {
    Main.main(new String[]{"266a0025"});
    assertEquals("addiu {opcode: 09, rs(base): 13, rt: 0a, immediate(offset): 0025}\n", outContent.toString());
  }

  @Test
  public void test862() {
    Main.main(new String[]{"3740ff13"});
    assertEquals("ori {opcode: 0d, rs(base): 1a, rt: 00, immediate(offset): ff13}\n", outContent.toString());
  }

  @Test
  public void test863() {
    Main.main(new String[]{"0217b82a"});
    assertEquals("slt {opcode: 00, rs: 10, rt: 17, rd: 17, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test864() {
    Main.main(new String[]{"3c0f002b"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0f, immediate(offset): 002b}\n", outContent.toString());
  }

  @Test
  public void test865() {
    Main.main(new String[]{"8ebd00ac"});
    assertEquals("lw {opcode: 23, rs(base): 15, rt: 1d, immediate(offset): 00ac}\n", outContent.toString());
  }

  @Test
  public void test866() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test867() {
    Main.main(new String[]{"02628820"});
    assertEquals("add {opcode: 00, rs: 13, rt: 02, rd: 11, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test868() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test869() {
    Main.main(new String[]{"8d550000"});
    assertEquals("lw {opcode: 23, rs(base): 0a, rt: 15, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test870() {
    Main.main(new String[]{"126dffc2"});
    assertEquals("beq {opcode: 04, rs(base): 13, rt: 0d, immediate(offset): ffc2}\n", outContent.toString());
  }

  @Test
  public void test871() {
    Main.main(new String[]{"00b6f025"});
    assertEquals("or {opcode: 00, rs: 05, rt: 16, rd: 1e, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test872() {
    Main.main(new String[]{"35ca0027"});
    assertEquals("ori {opcode: 0d, rs(base): 0e, rt: 0a, immediate(offset): 0027}\n", outContent.toString());
  }

  @Test
  public void test873() {
    Main.main(new String[]{"35aeffa8"});
    assertEquals("ori {opcode: 0d, rs(base): 0d, rt: 0e, immediate(offset): ffa8}\n", outContent.toString());
  }

  @Test
  public void test874() {
    Main.main(new String[]{"af2bff38"});
    assertEquals("sw {opcode: 2b, rs(base): 19, rt: 0b, immediate(offset): ff38}\n", outContent.toString());
  }

  @Test
  public void test875() {
    Main.main(new String[]{"addeffd2"});
    assertEquals("sw {opcode: 2b, rs(base): 0e, rt: 1e, immediate(offset): ffd2}\n", outContent.toString());
  }

  @Test
  public void test876() {
    Main.main(new String[]{"0015382a"});
    assertEquals("slt {opcode: 00, rs: 00, rt: 15, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test877() {
    Main.main(new String[]{"8f5a0000"});
    assertEquals("lw {opcode: 23, rs(base): 1a, rt: 1a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test878() {
    Main.main(new String[]{"0077e024"});
    assertEquals("and {opcode: 00, rs: 03, rt: 17, rd: 1c, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test879() {
    Main.main(new String[]{"080000a9"});
    assertEquals("j {opcode: 02, index: 00000a9}\n", outContent.toString());
  }

  @Test
  public void test880() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test881() {
    Main.main(new String[]{"00ddf025"});
    assertEquals("or {opcode: 00, rs: 06, rt: 1d, rd: 1e, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test882() {
    Main.main(new String[]{"02b42022"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 14, rd: 04, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test883() {
    Main.main(new String[]{"12fdffcf"});
    assertEquals("beq {opcode: 04, rs(base): 17, rt: 1d, immediate(offset): ffcf}\n", outContent.toString());
  }

  @Test
  public void test884() {
    Main.main(new String[]{"02bd7822"});
    assertEquals("sub {opcode: 00, rs: 15, rt: 1d, rd: 0f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test885() {
    Main.main(new String[]{"3c0a00ed"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0a, immediate(offset): 00ed}\n", outContent.toString());
  }

  @Test
  public void test886() {
    Main.main(new String[]{"8d7f0000"});
    assertEquals("lw {opcode: 23, rs(base): 0b, rt: 1f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test887() {
    Main.main(new String[]{"03df182a"});
    assertEquals("slt {opcode: 00, rs: 1e, rt: 1f, rd: 03, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test888() {
    Main.main(new String[]{"34a7009b"});
    assertEquals("ori {opcode: 0d, rs(base): 05, rt: 07, immediate(offset): 009b}\n", outContent.toString());
  }

  @Test
  public void test889() {
    Main.main(new String[]{"368900c7"});
    assertEquals("ori {opcode: 0d, rs(base): 14, rt: 09, immediate(offset): 00c7}\n", outContent.toString());
  }

  @Test
  public void test890() {
    Main.main(new String[]{"33d20023"});
    assertEquals("andi {opcode: 0c, rs(base): 1e, rt: 12, immediate(offset): 0023}\n", outContent.toString());
  }

  @Test
  public void test891() {
    Main.main(new String[]{"0232c82a"});
    assertEquals("slt {opcode: 00, rs: 11, rt: 12, rd: 19, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test892() {
    Main.main(new String[]{"aff4ff4e"});
    assertEquals("sw {opcode: 2b, rs(base): 1f, rt: 14, immediate(offset): ff4e}\n", outContent.toString());
  }

  @Test
  public void test893() {
    Main.main(new String[]{"0121f022"});
    assertEquals("sub {opcode: 00, rs: 09, rt: 01, rd: 1e, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test894() {
    Main.main(new String[]{"01bf2022"});
    assertEquals("sub {opcode: 00, rs: 0d, rt: 1f, rd: 04, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test895() {
    Main.main(new String[]{"031ae020"});
    assertEquals("add {opcode: 00, rs: 18, rt: 1a, rd: 1c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test896() {
    Main.main(new String[]{"00a0a024"});
    assertEquals("and {opcode: 00, rs: 05, rt: 00, rd: 14, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test897() {
    Main.main(new String[]{"3c0d00bd"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0d, immediate(offset): 00bd}\n", outContent.toString());
  }

  @Test
  public void test898() {
    Main.main(new String[]{"3c1700a1"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 17, immediate(offset): 00a1}\n", outContent.toString());
  }

  @Test
  public void test899() {
    Main.main(new String[]{"374b0033"});
    assertEquals("ori {opcode: 0d, rs(base): 1a, rt: 0b, immediate(offset): 0033}\n", outContent.toString());
  }

  @Test
  public void test900() {
    Main.main(new String[]{"8e4cffd4"});
    assertEquals("lw {opcode: 23, rs(base): 12, rt: 0c, immediate(offset): ffd4}\n", outContent.toString());
  }

  @Test
  public void test901() {
    Main.main(new String[]{"3c0400c5"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 04, immediate(offset): 00c5}\n", outContent.toString());
  }

  @Test
  public void test902() {
    Main.main(new String[]{"03a67822"});
    assertEquals("sub {opcode: 00, rs: 1d, rt: 06, rd: 0f, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test903() {
    Main.main(new String[]{"3266ff37"});
    assertEquals("andi {opcode: 0c, rs(base): 13, rt: 06, immediate(offset): ff37}\n", outContent.toString());
  }

  @Test
  public void test904() {
    Main.main(new String[]{"3c09003c"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 09, immediate(offset): 003c}\n", outContent.toString());
  }

  @Test
  public void test905() {
    Main.main(new String[]{"01424025"});
    assertEquals("or {opcode: 00, rs: 0a, rt: 02, rd: 08, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test906() {
    Main.main(new String[]{"33f80042"});
    assertEquals("andi {opcode: 0c, rs(base): 1f, rt: 18, immediate(offset): 0042}\n", outContent.toString());
  }

  @Test
  public void test907() {
    Main.main(new String[]{"34150046"});
    assertEquals("ori {opcode: 0d, rs(base): 00, rt: 15, immediate(offset): 0046}\n", outContent.toString());
  }

  @Test
  public void test908() {
    Main.main(new String[]{"110fff9c"});
    assertEquals("beq {opcode: 04, rs(base): 08, rt: 0f, immediate(offset): ff9c}\n", outContent.toString());
  }

  @Test
  public void test909() {
    Main.main(new String[]{"8cba0000"});
    assertEquals("lw {opcode: 23, rs(base): 05, rt: 1a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test910() {
    Main.main(new String[]{"ad010000"});
    assertEquals("sw {opcode: 2b, rs(base): 08, rt: 01, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test911() {
    Main.main(new String[]{"1327ffd0"});
    assertEquals("beq {opcode: 04, rs(base): 19, rt: 07, immediate(offset): ffd0}\n", outContent.toString());
  }

  @Test
  public void test912() {
    Main.main(new String[]{"029bf824"});
    assertEquals("and {opcode: 00, rs: 14, rt: 1b, rd: 1f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test913() {
    Main.main(new String[]{"08000050"});
    assertEquals("j {opcode: 02, index: 0000050}\n", outContent.toString());
  }

  @Test
  public void test914() {
    Main.main(new String[]{"3c1c008a"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1c, immediate(offset): 008a}\n", outContent.toString());
  }

  @Test
  public void test915() {
    Main.main(new String[]{"307bffba"});
    assertEquals("andi {opcode: 0c, rs(base): 03, rt: 1b, immediate(offset): ffba}\n", outContent.toString());
  }

  @Test
  public void test916() {
    Main.main(new String[]{"26500012"});
    assertEquals("addiu {opcode: 09, rs(base): 12, rt: 10, immediate(offset): 0012}\n", outContent.toString());
  }

  @Test
  public void test917() {
    Main.main(new String[]{"0800004d"});
    assertEquals("j {opcode: 02, index: 000004d}\n", outContent.toString());
  }

  @Test
  public void test918() {
    Main.main(new String[]{"02f83024"});
    assertEquals("and {opcode: 00, rs: 17, rt: 18, rd: 06, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test919() {
    Main.main(new String[]{"8cda0000"});
    assertEquals("lw {opcode: 23, rs(base): 06, rt: 1a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test920() {
    Main.main(new String[]{"03a57020"});
    assertEquals("add {opcode: 00, rs: 1d, rt: 05, rd: 0e, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test921() {
    Main.main(new String[]{"03c01025"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 00, rd: 02, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test922() {
    Main.main(new String[]{"12e100ec"});
    assertEquals("beq {opcode: 04, rs(base): 17, rt: 01, immediate(offset): 00ec}\n", outContent.toString());
  }

  @Test
  public void test923() {
    Main.main(new String[]{"8d41ff43"});
    assertEquals("lw {opcode: 23, rs(base): 0a, rt: 01, immediate(offset): ff43}\n", outContent.toString());
  }

  @Test
  public void test924() {
    Main.main(new String[]{"03674824"});
    assertEquals("and {opcode: 00, rs: 1b, rt: 07, rd: 09, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test925() {
    Main.main(new String[]{"256500e4"});
    assertEquals("addiu {opcode: 09, rs(base): 0b, rt: 05, immediate(offset): 00e4}\n", outContent.toString());
  }

  @Test
  public void test926() {
    Main.main(new String[]{"3192ff63"});
    assertEquals("andi {opcode: 0c, rs(base): 0c, rt: 12, immediate(offset): ff63}\n", outContent.toString());
  }

  @Test
  public void test927() {
    Main.main(new String[]{"1682ff18"});
    assertEquals("bne {opcode: 05, rs(base): 14, rt: 02, immediate(offset): ff18}\n", outContent.toString());
  }

  @Test
  public void test928() {
    Main.main(new String[]{"15bc0023"});
    assertEquals("bne {opcode: 05, rs(base): 0d, rt: 1c, immediate(offset): 0023}\n", outContent.toString());
  }

  @Test
  public void test929() {
    Main.main(new String[]{"03db0024"});
    assertEquals("and {opcode: 00, rs: 1e, rt: 1b, rd: 00, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test930() {
    Main.main(new String[]{"ae3f0011"});
    assertEquals("sw {opcode: 2b, rs(base): 11, rt: 1f, immediate(offset): 0011}\n", outContent.toString());
  }

  @Test
  public void test931() {
    Main.main(new String[]{"08000040"});
    assertEquals("j {opcode: 02, index: 0000040}\n", outContent.toString());
  }

  @Test
  public void test932() {
    Main.main(new String[]{"110cff63"});
    assertEquals("beq {opcode: 04, rs(base): 08, rt: 0c, immediate(offset): ff63}\n", outContent.toString());
  }

  @Test
  public void test933() {
    Main.main(new String[]{"08000038"});
    assertEquals("j {opcode: 02, index: 0000038}\n", outContent.toString());
  }

  @Test
  public void test934() {
    Main.main(new String[]{"338a0070"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 0a, immediate(offset): 0070}\n", outContent.toString());
  }

  @Test
  public void test935() {
    Main.main(new String[]{"015be020"});
    assertEquals("add {opcode: 00, rs: 0a, rt: 1b, rd: 1c, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test936() {
    Main.main(new String[]{"3c0700a2"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 07, immediate(offset): 00a2}\n", outContent.toString());
  }

  @Test
  public void test937() {
    Main.main(new String[]{"03518024"});
    assertEquals("and {opcode: 00, rs: 1a, rt: 11, rd: 10, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test938() {
    Main.main(new String[]{"00a2402a"});
    assertEquals("slt {opcode: 00, rs: 05, rt: 02, rd: 08, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test939() {
    Main.main(new String[]{"361f00a7"});
    assertEquals("ori {opcode: 0d, rs(base): 10, rt: 1f, immediate(offset): 00a7}\n", outContent.toString());
  }

  @Test
  public void test940() {
    Main.main(new String[]{"03cd882a"});
    assertEquals("slt {opcode: 00, rs: 1e, rt: 0d, rd: 11, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test941() {
    Main.main(new String[]{"0255a822"});
    assertEquals("sub {opcode: 00, rs: 12, rt: 15, rd: 15, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test942() {
    Main.main(new String[]{"3389ff81"});
    assertEquals("andi {opcode: 0c, rs(base): 1c, rt: 09, immediate(offset): ff81}\n", outContent.toString());
  }

  @Test
  public void test943() {
    Main.main(new String[]{"107bffbc"});
    assertEquals("beq {opcode: 04, rs(base): 03, rt: 1b, immediate(offset): ffbc}\n", outContent.toString());
  }

  @Test
  public void test944() {
    Main.main(new String[]{"3074ff4f"});
    assertEquals("andi {opcode: 0c, rs(base): 03, rt: 14, immediate(offset): ff4f}\n", outContent.toString());
  }

  @Test
  public void test945() {
    Main.main(new String[]{"3c0e0073"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 0e, immediate(offset): 0073}\n", outContent.toString());
  }

  @Test
  public void test946() {
    Main.main(new String[]{"0800000d"});
    assertEquals("j {opcode: 02, index: 000000d}\n", outContent.toString());
  }

  @Test
  public void test947() {
    Main.main(new String[]{"26290049"});
    assertEquals("addiu {opcode: 09, rs(base): 11, rt: 09, immediate(offset): 0049}\n", outContent.toString());
  }

  @Test
  public void test948() {
    Main.main(new String[]{"02964024"});
    assertEquals("and {opcode: 00, rs: 14, rt: 16, rd: 08, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test949() {
    Main.main(new String[]{"8c110098"});
    assertEquals("lw {opcode: 23, rs(base): 00, rt: 11, immediate(offset): 0098}\n", outContent.toString());
  }

  @Test
  public void test950() {
    Main.main(new String[]{"01201022"});
    assertEquals("sub {opcode: 00, rs: 09, rt: 00, rd: 02, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test951() {
    Main.main(new String[]{"08000096"});
    assertEquals("j {opcode: 02, index: 0000096}\n", outContent.toString());
  }

  @Test
  public void test952() {
    Main.main(new String[]{"080000e5"});
    assertEquals("j {opcode: 02, index: 00000e5}\n", outContent.toString());
  }

  @Test
  public void test953() {
    Main.main(new String[]{"161300ad"});
    assertEquals("bne {opcode: 05, rs(base): 10, rt: 13, immediate(offset): 00ad}\n", outContent.toString());
  }

  @Test
  public void test954() {
    Main.main(new String[]{"333d00f3"});
    assertEquals("andi {opcode: 0c, rs(base): 19, rt: 1d, immediate(offset): 00f3}\n", outContent.toString());
  }

  @Test
  public void test955() {
    Main.main(new String[]{"31dd0048"});
    assertEquals("andi {opcode: 0c, rs(base): 0e, rt: 1d, immediate(offset): 0048}\n", outContent.toString());
  }

  @Test
  public void test956() {
    Main.main(new String[]{"17200024"});
    assertEquals("bne {opcode: 05, rs(base): 19, rt: 00, immediate(offset): 0024}\n", outContent.toString());
  }

  @Test
  public void test957() {
    Main.main(new String[]{"0104282a"});
    assertEquals("slt {opcode: 00, rs: 08, rt: 04, rd: 05, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test958() {
    Main.main(new String[]{"af000000"});
    assertEquals("sw {opcode: 2b, rs(base): 18, rt: 00, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test959() {
    Main.main(new String[]{"30f1ffc2"});
    assertEquals("andi {opcode: 0c, rs(base): 07, rt: 11, immediate(offset): ffc2}\n", outContent.toString());
  }

  @Test
  public void test960() {
    Main.main(new String[]{"03ca2825"});
    assertEquals("or {opcode: 00, rs: 1e, rt: 0a, rd: 05, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test961() {
    Main.main(new String[]{"1450ff3e"});
    assertEquals("bne {opcode: 05, rs(base): 02, rt: 10, immediate(offset): ff3e}\n", outContent.toString());
  }

  @Test
  public void test962() {
    Main.main(new String[]{"ad0a0000"});
    assertEquals("sw {opcode: 2b, rs(base): 08, rt: 0a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test963() {
    Main.main(new String[]{"0072d02a"});
    assertEquals("slt {opcode: 00, rs: 03, rt: 12, rd: 1a, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test964() {
    Main.main(new String[]{"038f0025"});
    assertEquals("or {opcode: 00, rs: 1c, rt: 0f, rd: 00, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test965() {
    Main.main(new String[]{"025a5825"});
    assertEquals("or {opcode: 00, rs: 12, rt: 1a, rd: 0b, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test966() {
    Main.main(new String[]{"01d14822"});
    assertEquals("sub {opcode: 00, rs: 0e, rt: 11, rd: 09, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test967() {
    Main.main(new String[]{"3467ffeb"});
    assertEquals("ori {opcode: 0d, rs(base): 03, rt: 07, immediate(offset): ffeb}\n", outContent.toString());
  }

  @Test
  public void test968() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test969() {
    Main.main(new String[]{"2547004d"});
    assertEquals("addiu {opcode: 09, rs(base): 0a, rt: 07, immediate(offset): 004d}\n", outContent.toString());
  }

  @Test
  public void test970() {
    Main.main(new String[]{"8fca0000"});
    assertEquals("lw {opcode: 23, rs(base): 1e, rt: 0a, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test971() {
    Main.main(new String[]{"3c1e0082"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 1e, immediate(offset): 0082}\n", outContent.toString());
  }

  @Test
  public void test972() {
    Main.main(new String[]{"03329824"});
    assertEquals("and {opcode: 00, rs: 19, rt: 12, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test973() {
    Main.main(new String[]{"035ee825"});
    assertEquals("or {opcode: 00, rs: 1a, rt: 1e, rd: 1d, shmt: 00, funct: 25}\n", outContent.toString());
  }

  @Test
  public void test974() {
    Main.main(new String[]{"3c1100f9"});
    assertEquals("lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 00f9}\n", outContent.toString());
  }

  @Test
  public void test975() {
    Main.main(new String[]{"25a300a1"});
    assertEquals("addiu {opcode: 09, rs(base): 0d, rt: 03, immediate(offset): 00a1}\n", outContent.toString());
  }

  @Test
  public void test976() {
    Main.main(new String[]{"16a5ff2f"});
    assertEquals("bne {opcode: 05, rs(base): 15, rt: 05, immediate(offset): ff2f}\n", outContent.toString());
  }

  @Test
  public void test977() {
    Main.main(new String[]{"24b00071"});
    assertEquals("addiu {opcode: 09, rs(base): 05, rt: 10, immediate(offset): 0071}\n", outContent.toString());
  }

  @Test
  public void test978() {
    Main.main(new String[]{"080000bd"});
    assertEquals("j {opcode: 02, index: 00000bd}\n", outContent.toString());
  }

  @Test
  public void test979() {
    Main.main(new String[]{"01dcb020"});
    assertEquals("add {opcode: 00, rs: 0e, rt: 1c, rd: 16, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test980() {
    Main.main(new String[]{"02fd5024"});
    assertEquals("and {opcode: 00, rs: 17, rt: 1d, rd: 0a, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test981() {
    Main.main(new String[]{"0800001a"});
    assertEquals("j {opcode: 02, index: 000001a}\n", outContent.toString());
  }

  @Test
  public void test982() {
    Main.main(new String[]{"31ac007b"});
    assertEquals("andi {opcode: 0c, rs(base): 0d, rt: 0c, immediate(offset): 007b}\n", outContent.toString());
  }

  @Test
  public void test983() {
    Main.main(new String[]{"32feffed"});
    assertEquals("andi {opcode: 0c, rs(base): 17, rt: 1e, immediate(offset): ffed}\n", outContent.toString());
  }

  @Test
  public void test984() {
    Main.main(new String[]{"00491820"});
    assertEquals("add {opcode: 00, rs: 02, rt: 09, rd: 03, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test985() {
    Main.main(new String[]{"32c9ff05"});
    assertEquals("andi {opcode: 0c, rs(base): 16, rt: 09, immediate(offset): ff05}\n", outContent.toString());
  }

  @Test
  public void test986() {
    Main.main(new String[]{"8fcf0000"});
    assertEquals("lw {opcode: 23, rs(base): 1e, rt: 0f, immediate(offset): 0000}\n", outContent.toString());
  }

  @Test
  public void test987() {
    Main.main(new String[]{"32a80039"});
    assertEquals("andi {opcode: 0c, rs(base): 15, rt: 08, immediate(offset): 0039}\n", outContent.toString());
  }

  @Test
  public void test988() {
    Main.main(new String[]{"02723822"});
    assertEquals("sub {opcode: 00, rs: 13, rt: 12, rd: 07, shmt: 00, funct: 22}\n", outContent.toString());
  }

  @Test
  public void test989() {
    Main.main(new String[]{"03d49824"});
    assertEquals("and {opcode: 00, rs: 1e, rt: 14, rd: 13, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test990() {
    Main.main(new String[]{"8e6e0020"});
    assertEquals("lw {opcode: 23, rs(base): 13, rt: 0e, immediate(offset): 0020}\n", outContent.toString());
  }

  @Test
  public void test991() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test992() {
    Main.main(new String[]{"25f20002"});
    assertEquals("addiu {opcode: 09, rs(base): 0f, rt: 12, immediate(offset): 0002}\n", outContent.toString());
  }

  @Test
  public void test993() {
    Main.main(new String[]{"0361302a"});
    assertEquals("slt {opcode: 00, rs: 1b, rt: 01, rd: 06, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test994() {
    Main.main(new String[]{"0140c020"});
    assertEquals("add {opcode: 00, rs: 0a, rt: 00, rd: 18, shmt: 00, funct: 20}\n", outContent.toString());
  }

  @Test
  public void test995() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test996() {
    Main.main(new String[]{"00fc7824"});
    assertEquals("and {opcode: 00, rs: 07, rt: 1c, rd: 0f, shmt: 00, funct: 24}\n", outContent.toString());
  }

  @Test
  public void test997() {
    Main.main(new String[]{"0394382a"});
    assertEquals("slt {opcode: 00, rs: 1c, rt: 14, rd: 07, shmt: 00, funct: 2a}\n", outContent.toString());
  }

  @Test
  public void test998() {
    Main.main(new String[]{"0000000c"});
    assertEquals("syscall {opcode: 00, code: 000000, funct: 0c}\n", outContent.toString());
  }

  @Test
  public void test999() {
    Main.main(new String[]{"adfe0000"});
    assertEquals("sw {opcode: 2b, rs(base): 0f, rt: 1e, immediate(offset): 0000}\n", outContent.toString());
  }
}