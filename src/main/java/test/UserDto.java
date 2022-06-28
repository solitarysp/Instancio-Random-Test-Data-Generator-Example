package test;

import lombok.Data;

@Data
public class UserDto {

  private Integer id;
  private String name;
  private String phoneNumbers;
  private String ngaySinh;
  private Sex sex;

  public static enum Sex {
    NAM, NU
  }
}
