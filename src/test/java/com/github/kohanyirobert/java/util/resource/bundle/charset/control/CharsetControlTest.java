package com.github.kohanyirobert.java.util.resource.bundle.charset.control;

import org.junit.After;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ResourceBundle;

import junit.framework.Assert;

public final class CharsetControlTest {

  private static final String BASE_NAME = CharsetControlTest.class.getName();

  private static final Charset US_ASCII = Charset.forName("US-ASCII");
  private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  private static final Charset UTF_8 = Charset.forName("UTF-8");

  private static final String EN = "hello world";
  private static final String HU = "helló világ";
  private static final String JA = "こんにちは世界";

  public CharsetControlTest() {}

  @After
  public void tearDown() {
    ResourceBundle.clearCache();
  }

  @Test
  public void us_Ascii_Charset() {
    ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, new CharsetControl(US_ASCII));
    Assert.assertTrue(EN.equals(bundle.getString("en")));
    Assert.assertFalse(HU.equals(bundle.getString("hu")));
    Assert.assertFalse(JA.equals(bundle.getString("ja")));
  }

  @Test
  public void iso_8859_1_Charset() {
    ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, new CharsetControl(ISO_8859_1));
    Assert.assertTrue(EN.equals(bundle.getString("en")));
    Assert.assertFalse(HU.equals(bundle.getString("hu")));
    Assert.assertFalse(JA.equals(bundle.getString("ja")));
  }

  @Test
  public void utf_8_Charset() {
    ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, new CharsetControl(UTF_8));
    Assert.assertTrue(EN.equals(bundle.getString("en")));
    Assert.assertTrue(HU.equals(bundle.getString("hu")));
    Assert.assertTrue(JA.equals(bundle.getString("ja")));
  }
}
