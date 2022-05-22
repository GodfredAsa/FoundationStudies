package com.company.Smooth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TraderTest {

    private Trader underTest;

    @BeforeEach
            void setup(){
        this.underTest = new Trader(1, "Fred", 20);
    }


    @org.junit.jupiter.api.Test
    void makeDeposit() {
        Assertions.assertAll(
                () -> assertTrue(this.underTest.makeDeposit(200), "deposit successful"),
                () -> assertFalse(this.underTest.makeDeposit(-1), " fails deposit")
        );
    }


    @org.junit.jupiter.api.Test
    void makeWithdrawal() {
      Assertions.assertAll(
              () ->  assertFalse(this.underTest.makeWithdrawal(200), "Withdrawal Unsuccessful"),
              () ->  assertTrue(this.underTest.makeWithdrawal(19), "Withdrawal Successful")
      );
    }

    @org.junit.jupiter.api.Test
    void shouldCheckBalance() {
        int expected = 20;
        int actual =  underTest.checkBalance();
        assertEquals(expected, actual, "Balance the same ");
    }
}