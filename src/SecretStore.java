
public interface SecretStore {
    /**
     * accepts key and  secret and return the key
     *  -> Key <= 20 chars
     *
     * @param key
     * @param secret
     * @return
     */
    String put(String key, String secret);
}
