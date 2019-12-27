package com.example.demo.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qianchen
 * @date 2019/12/27 10:51
 */
public class checkUtils {
  private static final String NAME =
      "[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";

  public static boolean NameValid(String name) {
    return valid(name, NAME);
  }

  public static boolean SexValid(String sex) {
    return valid1(sex);
  }

  public static boolean AgeValid(Integer age) {
    return valid2(age);
  }

  private static boolean valid2(Integer age) {
    if (age >= 0 && age < 130) {
      return true;
    }
    return false;
  }

  private static boolean valid(final String code, final String reg) {
    Pattern regex = Pattern.compile(reg);
    Matcher matcher = regex.matcher(code);
    return matcher.find();
  }

  private static boolean valid1(String sex) {
    if (sex.equals("男") || sex.equals("女")) {
      return true;
    }
    return false;
  }
}
