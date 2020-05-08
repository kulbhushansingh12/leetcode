import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Will Store Key, Attribute and value associated.
 *
 */
public class KeyStore {
   // Assuming key is always String
   private Map<String, Map<? extends Object, ? extends Object>> keyAttrValStore;
   private Map<Object, List<Object>> attrKeyMap;
   private Map<Object, Object> valAttrMap;

   public KeyStore() {
      this.keyAttrValStore = new HashMap<>();
   }

   public void addData(String key, Object attribute,  Object value) {
      Map<Object, Object> attributeMap = (Map<Object, Object>) keyAttrValStore.getOrDefault(key, new HashMap<>());
      attributeMap.put(attribute, value);
      keyAttrValStore.put(key, attributeMap);
   }

   public Object getValue(String key, String attribute) {
      if (keyAttrValStore.get(key) != null)
         return keyAttrValStore.get(key).get(attribute);

      return null;
   }

   public void deleteKey(String key) {
      keyAttrValStore.remove(key);
   }
   //Key, <Attr, val>
   public void performAttributeIndexing(Object attribute) {
      for (Map.Entry<String, Map<?, ?>> entrySet : keyAttrValStore.entrySet()) {
         Object value = entrySet.getValue().get(attribute);
         if (value != null) {
            attrKeyMap = attrKeyMap == null ? new HashMap<>() : attrKeyMap;
            List<Object> keys = attrKeyMap.getOrDefault(attribute, new ArrayList<>());
            keys.add(entrySet.getKey());
            attrKeyMap.put(attribute, keys);
            valAttrMap = valAttrMap == null ? new HashMap<>() : valAttrMap;
            valAttrMap.put(value, attribute);
         }
      }
   }

   public Pair getKeyAttrForValue(Object value) {
      //To check if anything is indexed
      if (attrKeyMap != null) {
         Object attr = valAttrMap.get(value);
         if (attr != null) {
            Object key = attrKeyMap.get(attr).get(0);
            return new Pair(key, attr);
         }
      }
      return null;
   }

   public List<Object> getKeyForValue(Object value) {
      if(attrKeyMap != null) {
         Object attr = valAttrMap.get(value);
         if (attr != null) {
            List<Object> keys = attrKeyMap.get(attr);
            return keys;
         }
      }
      return null;
   }

   class Pair {
      Object key;
      Object attr;

      public Pair(Object key, Object value) {
         this.key = key;
         this.attr = value;
      }
   }


   public static void main(String[] args) {
      KeyStore keyStore = new KeyStore();
      keyStore.addData("jakarta", "lat", -6.0);
      keyStore.addData("blore", "lat", 12.94);
      keyStore.addData("delhi", "population", "11M");

      System.out.println(keyStore.getValue("jakarta", "lat"));

      keyStore.performAttributeIndexing("lat");
      Pair pair = keyStore.getKeyAttrForValue(-6.0);
      System.out.println(pair.key +", "+pair.attr);
      keyStore.addData("crocin", "manufacturer", "gsk");
      keyStore.addData("pcm", "manufacturer", "gsk");
      keyStore.performAttributeIndexing("manufacturer");
      List<Object> keys = keyStore.getKeyForValue("gsk");

   }

}
