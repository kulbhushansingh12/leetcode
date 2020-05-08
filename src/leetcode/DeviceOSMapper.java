package leetcode;

import java.util.Arrays;

import static java.util.Locale.ENGLISH;

public enum DeviceOSMapper {
   ABC("Abc");

   public String name;
   private String[] alternateNames;

   DeviceOSMapper(String name, String... alternateNames) {
      this.name = name;
      this.alternateNames = alternateNames;
   }

   /**
    * Returns OS name by matching name & alternate names
    * If not found in list it returns the platform passed
    *
    * @param platform
    * @return String - os name
    */
   public static String getOS(String platform) {
      if (platform != null && !platform.isEmpty()) {
         String osString = null;
         for (DeviceOSMapper deviceOS : DeviceOSMapper.values()) {
            if (deviceOS.alternateNames != null) {
               osString = (deviceOS.name + Arrays.toString(deviceOS.alternateNames))
                       .toLowerCase(ENGLISH);
            } else {
               osString = deviceOS.name;
            }
            //Check if the platform is a sub-string in OS string
            if (osString.contains(platform.trim().toLowerCase(ENGLISH))) {
               return deviceOS.name;
            }
         }
      }
      return platform;
   }

   public static void main(String[] args) {
      DeviceOSMapper.getOS("Abc");
   }
}

