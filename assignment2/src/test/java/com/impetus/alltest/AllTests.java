package com.impetus.alltest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.impetus.innerclass.test.CallTest;
import com.impetus.matrix.test.MatrixTest;
import com.impetus.reflection.test.FindPrivateMemberTest;

/**
 * Class to run all test.
 * @author anand.tiwari
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ FindPrivateMemberTest.class, CallTest.class, MatrixTest.class })
public class AllTests {

}
