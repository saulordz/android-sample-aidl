// AidlTest.aidl
package com.virtroop.aidlservicetest;

// Declare any non-default types here with import statements
import com.virtroop.aidlservicetest.PojoTest;

interface AidlTest {
    boolean returnTrue();
    PojoTest getTestPojo();
}
