import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLimitedAssembler {

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

  // SYSCALL TESTS
  @Test
  public void test00() {
    Main.main(new String[]{"syscall"});
    assertEquals("0000000c\n", outContent.toString());
  }

  @Test
  public void test01() {
    Main.main(new String[]{"syscall     "});
    assertEquals("0000000c\n", outContent.toString());
  }

  @Test
  public void test02() {
    Main.main(new String[]{"       syscall"});
    assertEquals("0000000c\n", outContent.toString());
  }

  @Test
  public void test03() {
    Main.main(new String[]{"     syscall     "});
    assertEquals("0000000c\n", outContent.toString());
  }

  @Test
  public void test04() {
    Main.main(new String[]{"  syscall# Comment"});
    assertEquals("0000000c\n", outContent.toString());
  }


  // J-TYPE TESTS

  // tests of j
  @Test
  public void test05() {
    Main.main(new String[]{"j 0xc5"});
    assertEquals("080000c5\n", outContent.toString());
  }

  @Test
  public void test06() {
    Main.main(new String[]{"j 0x48"});
    assertEquals("08000048\n", outContent.toString());
  }

  @Test
  public void test07() {
    Main.main(new String[]{"j 0x15"});
    assertEquals("08000015\n", outContent.toString());
  }

  @Test
  public void test08() {
    Main.main(new String[]{"j 0x53# Comment"});
    assertEquals("08000053\n", outContent.toString());
  }

  @Test
  public void test09() {
    Main.main(new String[]{"  j    0x2d      #Comment"});
    assertEquals("0800002d\n", outContent.toString());
  }


  // R-TYPE tests

  // tests of add

  @Test
  public void test10() {
    Main.main(new String[]{"add $t2, $s6, $s4"});
    assertEquals("02d45020\n", outContent.toString());
  }

  @Test
  public void test11() {
    Main.main(new String[]{"add $at, $a2, $s2"});
    assertEquals("00d20820\n", outContent.toString());
  }

  @Test
  public void test12() {
    Main.main(new String[]{"add $t7, $t6, $sp"});
    assertEquals("01dd7820\n", outContent.toString());
  }

  @Test
  public void test13() {
    Main.main(new String[]{"  add   $k0,  $at,  $s4"});
    assertEquals("0034d020\n", outContent.toString());
  }

  @Test
  public void test14() {
    Main.main(new String[]{"add $t3, $t2, $t0#Comment"});
    assertEquals("01485820\n", outContent.toString());
  }

  // tests of and
  @Test
  public void test15() {
    Main.main(new String[]{"and $t8, $a3, $a2"});
    assertEquals("00e6c024\n", outContent.toString());
  }

  @Test
  public void test16() {
    Main.main(new String[]{"  and   $s6, $s1, $s5         #Comment"});
    assertEquals("0235b024\n", outContent.toString());
  }

  @Test
  public void test17() {
    Main.main(new String[]{"and $t5, $v0, $gp"});
    assertEquals("005c6824\n", outContent.toString());
  }

  @Test
  public void test18() {
    Main.main(new String[]{"and $s6, $gp, $ra"});
    assertEquals("039fb024\n", outContent.toString());
  }

  @Test
  public void test19() {
    Main.main(new String[]{"and $s2, $sp,         $t3         "});
    assertEquals("03ab9024\n", outContent.toString());
  }

  // tests of or

  @Test
  public void test20() {
    Main.main(new String[]{"or $t0, $t2, $t0"});
    assertEquals("01484025\n", outContent.toString());
  }

  @Test
  public void test21() {
    Main.main(new String[]{"  or    $zero, $s4, $a0# Comment"});
    assertEquals("02840025\n", outContent.toString());
  }

  @Test
  public void test22() {
    Main.main(new String[]{"or $t1, $t9, $t7"});
    assertEquals("032f4825\n", outContent.toString());
  }

  @Test
  public void test23() {
    Main.main(new String[]{"or $v1, $t8, $t8#"});
    assertEquals("03181825\n", outContent.toString());
  }

  @Test
  public void test24() {
    Main.main(new String[]{"or $k0, $fp, $t0"});
    assertEquals("03c8d025\n", outContent.toString());
  }

  // tests of slt

  @Test
  public void test25() {
    Main.main(new String[]{"slt $t0, $t5, $gp"});
    assertEquals("01bc402a\n", outContent.toString());
  }

  @Test
  public void test26() {
    Main.main(new String[]{"slt $a1, $a0, $fp#"});
    assertEquals("009e282a\n", outContent.toString());
  }

  @Test
  public void test27() {
    Main.main(new String[]{"  slt $v1, $gp, $t3   #Comment"});
    assertEquals("038b182a\n", outContent.toString());
  }

  @Test
  public void test28() {
    Main.main(new String[]{"slt $zero, $zero, $s1       #Comment"});
    assertEquals("0011002a\n", outContent.toString());
  }

  @Test
  public void test29() {
    Main.main(new String[]{"slt $k0,        $sp, $t1"});
    assertEquals("03a9d02a\n", outContent.toString());
  }

  // tests of sub

  @Test
  public void test30() {
    Main.main(new String[]{"sub $s5, $at, $sp"});
    assertEquals("003da822\n", outContent.toString());
  }

  @Test
  public void test31() {
    Main.main(new String[]{"sub $sp, $t2, $t8# Comment"});
    assertEquals("0158e822\n", outContent.toString());
  }

  @Test
  public void test32() {
    Main.main(new String[]{"  sub $s4, $sp, $a0#"});
    assertEquals("03a4a022\n", outContent.toString());
  }

  @Test
  public void test33() {
    Main.main(new String[]{"sub $a1, $s5, $t7#Comment"});
    assertEquals("02af2822\n", outContent.toString());
  }

  @Test
  public void test34() {
    Main.main(new String[]{"sub $s7,      $s3, $s7"});
    assertEquals("0277b822\n", outContent.toString());
  }

  // I-TYPE tests

  // tests of addiu

  @Test
  public void test35() {
    Main.main(new String[]{"addiu $s0, $s3, 0x6e"});
    assertEquals("2670006e\n", outContent.toString());
  }

  @Test
  public void test36() {
    Main.main(new String[]{"addiu $t8,        $zero, 0x74#Comment"});
    assertEquals("24180074\n", outContent.toString());
  }

  @Test
  public void test37() {
    Main.main(new String[]{"      addiu $t3, $t2, 0x32      "});
    assertEquals("254b0032\n", outContent.toString());
  }

  @Test
  public void test38() {
    Main.main(new String[]{"addiu $k0, $v1, 0xffc8"});
    assertEquals("247affc8\n", outContent.toString());
  }

  @Test
  public void test39() {
    Main.main(new String[]{"addiu $fp, $k0, 11    "});
    assertEquals("275e000b\n", outContent.toString());
  }

  // tests of andi

  @Test
  public void test40() {
    Main.main(new String[]{"andi $t4, $s2, 103    "});
    assertEquals("324c0067\n", outContent.toString());
  }

  @Test
  public void test41() {
    Main.main(new String[]{"    andi $fp, $s7, -149"});
    assertEquals("32feff6b\n", outContent.toString());
  }

  @Test
  public void test42() {
    Main.main(new String[]{"andi $s0, $t7, 0xffa9   #Comment"});
    assertEquals("31f0ffa9\n", outContent.toString());
  }

  @Test
  public void test43() {
    Main.main(new String[]{"andi  $s2,  $s5,  221"});
    assertEquals("32b200dd\n", outContent.toString());
  }

  @Test
  public void test44() {
    Main.main(new String[]{"andi $v1, $a0, 0xff8a#comment"});
    assertEquals("3083ff8a\n", outContent.toString());
  }

  // tests of beq

  @Test
  public void test45() {
    Main.main(new String[]{"beq $s2, $a2, 187#Comment"});
    assertEquals("124600bb\n", outContent.toString());
  }

  @Test
  public void test46() {
    Main.main(new String[]{"beq $at, $a2, -113"});
    assertEquals("1026ff8f\n", outContent.toString());
  }

  @Test
  public void test47() {
    Main.main(new String[]{"      beq $v1, $t7, 253"});
    assertEquals("106f00fd\n", outContent.toString());
  }

  @Test
  public void test48() {
    Main.main(new String[]{"beq $t6, $t1, 0x26# Comment"});
    assertEquals("11c90026\n", outContent.toString());
  }

  @Test
  public void test49() {
    Main.main(new String[]{"  beq $t7, $s0, 0x90  "});
    assertEquals("11f00090\n", outContent.toString());
  }

  // tests of bne

  @Test
  public void test50() {
    Main.main(new String[]{"  bne $s0, $s0, 0x28  "});
    assertEquals("16100028\n", outContent.toString());
  }

  @Test
  public void test51() {
    Main.main(new String[]{"bne $s2, $t3, 0xa0# Comment  "});
    assertEquals("164b00a0\n", outContent.toString());
  }

  @Test
  public void test52() {
    Main.main(new String[]{"  bne $at, $t4, 0xffb9  "});
    assertEquals("142cffb9\n", outContent.toString());
  }

  @Test
  public void test53() {
    Main.main(new String[]{" bne $t3, $s7, 0x60  "});
    assertEquals("15770060\n", outContent.toString());
  }

  @Test
  public void test54() {
    Main.main(new String[]{" bne $a0, $s2, 0xff67 "});
    assertEquals("1492ff67\n", outContent.toString());
  }

  // tests of lui

  @Test
  public void test55() {
    Main.main(new String[]{" lui $v1, 0xd3"});
    assertEquals("3c0300d3\n", outContent.toString());
  }

  @Test
  public void test56() {
    Main.main(new String[]{" lui $t6, 0x85#comment "});
    assertEquals("3c0e0085\n", outContent.toString());
  }

  @Test
  public void test57() {
    Main.main(new String[]{"lui $t2, 0xc7 "});
    assertEquals("3c0a00c7\n", outContent.toString());
  }

  @Test
  public void test58() {
    Main.main(new String[]{"lui $s7, 0xd2   "});
    assertEquals("3c1700d2\n", outContent.toString());
  }

  @Test
  public void test59() {
    Main.main(new String[]{"lui $s3, 0x49"});
    assertEquals("3c130049\n", outContent.toString());
  }

  // tests of lw

  @Test
  public void test60() {
    Main.main(new String[]{"lw $a0, 133($t9)"});
    assertEquals("8f240085\n", outContent.toString());
  }

  @Test
  public void test61() {
    Main.main(new String[]{"lw $t3, 43($k0)# Comment"});
    assertEquals("8f4b002b\n", outContent.toString());
  }

  @Test
  public void test62() {
    Main.main(new String[]{" lw $v0, ($s6)"});
    assertEquals("8ec20000\n", outContent.toString());
  }

  @Test
  public void test63() {
    Main.main(new String[]{"lw $t3,   ($a1) "});
    assertEquals("8cab0000\n", outContent.toString());
  }

  @Test
  public void test64() {
    Main.main(new String[]{"lw $k0, -118($ra)"});
    assertEquals("8ffaff8a\n", outContent.toString());
  }

  // tests of ori

  @Test
  public void test65() {
    Main.main(new String[]{"ori $a3, $t8, 0x5b"});
    assertEquals("3707005b\n", outContent.toString());
  }

  @Test
  public void test66() {
    Main.main(new String[]{"ori $s7, $s6, -233  "});
    assertEquals("36d7ff17\n", outContent.toString());
  }

  @Test
  public void test67() {
    Main.main(new String[]{"ori $t2, $gp, 60#Comment"});
    assertEquals("378a003c\n", outContent.toString());
  }

  @Test
  public void test68() {
    Main.main(new String[]{" ori $fp, $t6, 0xff23"});
    assertEquals("35deff23\n", outContent.toString());
  }

  @Test
  public void test69() {
    Main.main(new String[]{" ori $zero,  $fp,  0xffb5"});
    assertEquals("37c0ffb5\n", outContent.toString());
  }

  // tests of sw

  @Test
  public void test70() {
    Main.main(new String[]{"sw $t6, ($s2) "});
    assertEquals("ae4e0000\n", outContent.toString());
  }

  @Test
  public void test71() {
    Main.main(new String[]{" sw $s2, ($t6)"});
    assertEquals("add20000\n", outContent.toString());
  }

  @Test
  public void test72() {
    Main.main(new String[]{" sw $t5, ($fp)"});
    assertEquals("afcd0000\n", outContent.toString());
  }

  @Test
  public void test73() {
    Main.main(new String[]{"sw $at, 39($zero)# Comment"});
    assertEquals("ac010027\n", outContent.toString());
  }

  @Test
  public void test74() {
    Main.main(new String[]{"sw $t5, -179($t3)"});
    assertEquals("ad6dff4d\n", outContent.toString());
  }
}
