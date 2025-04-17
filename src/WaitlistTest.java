import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Set;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
  void reduceAllMyDuplicateTestCodeHelper(int capacity, String[] expectedList, Set<String> removeSet) 
  {
    String[]startingList = {"123abc", "234bcd", "345cde", "456def", "567efg", "678fgh", "789ghi", "890hij"};
    Waitlist waitlist = new Waitlist(startingList, capacity);
    waitlist.removeStudents(removeSet);
    assertArrayEquals(expectedList, waitlist.getWaitlist());
  }

  @Test
  void waitlistTestInvalidCapacityValueEntered()
  {
    String[]startingList = {"123abc", "234bcd", "345cde"};
    assertThrows(IllegalArgumentException.class, () -> {
      new Waitlist(startingList, -2); 
    });
  };

  @Test
  void waitlistTestIncreaseStudentIdsCapacityRemoveSomeStudents()
  {
    Set<String> removeSet = Set.of("234bcd", "345cde", "456def", "678fgh" );
    String[]endingList = {"123abc", "567efg","789ghi", "890hij", null, null, null, null, null, null, null, null, null, null};
    reduceAllMyDuplicateTestCodeHelper(14, endingList, removeSet);
  };

  @Test
  void waitlistTestDoNotIncreaseStudentIdsCapacityRemoveSomeStudents()
  {
    Set<String> removeSet = Set.of("234bcd", "345cde", "456def", "678fgh" );
    String[]endingList = {"123abc", "567efg","789ghi", "890hij", null, null, null, null};
    reduceAllMyDuplicateTestCodeHelper(8, endingList, removeSet);
  };

  @Test
  void waitlistTestIncreaseStudentIdsCapacityRemoveNoStudents()
  {
    Set<String> removeSet = Set.of();
    String[]endingList = {"123abc", "234bcd", "345cde", "456def", "567efg", "678fgh", "789ghi", "890hij", null, null};
    reduceAllMyDuplicateTestCodeHelper(10, endingList, removeSet);
  };

  @Test
  void waitlistTestDoNotIncreaseStudentIdsCapacityRemoveNoStudents()
  {
    Set<String> removeSet = Set.of();
    String[]endingList = {"123abc", "234bcd", "345cde", "456def", "567efg", "678fgh", "789ghi", "890hij"};
    reduceAllMyDuplicateTestCodeHelper(8, endingList, removeSet);
  };

  @Test
  void waitlistTestIncreaseStudentIdsCapacityRemoveAllStudents()
  {
    Set<String> removeSet = Set.of("123abc", "234bcd", "345cde", "456def", "567efg", "678fgh", "789ghi", "890hij");
    String[]endingList = {null, null, null, null, null, null, null, null, null, null, null, null};
    reduceAllMyDuplicateTestCodeHelper(12, endingList, removeSet);
  };
  
  @Test
  void waitlistTestDoNotIncreaseStudentIdsCapacityRemoveAllStudents()
  {
    Set<String> removeSet = Set.of("123abc", "234bcd", "345cde", "456def", "567efg", "678fgh", "789ghi", "890hij");
    String[]endingList = {null, null, null, null, null, null, null, null};
    reduceAllMyDuplicateTestCodeHelper(8, endingList, removeSet);
  };
    
}