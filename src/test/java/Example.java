import static org.instancio.Select.field;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import test.UserDto;

public class Example {

  @Test
  public void test() {
    UserDto user = Instancio.of(UserDto.class)
        .generate(field("phoneNumbers"), gen -> gen.text().pattern("#d#d#d#d- #d#d#d#d - #d#d"))
        .generate(field("id"), gen -> gen.ints().range(1, 100000))

        .create();
    System.out.println(user);

    Map<Integer, UserDto> customerMap = Instancio.stream(UserDto.class)
        .limit(5)
        .collect(Collectors.toMap(UserDto::getId, Function.identity()));
    System.out.println(customerMap);
  }

  // https://github.com/instancio/instancio
}
